/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     2.60
 * @since       1.0
 */
package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.*;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
/**
 * The class for the Manager view. Default constructor calls draw method which draws the GUI components.
 * Uses various controllers to achieve manager functionality.
 */
public class ManagerScreen implements Component {
	/*
	 * Default constructor for ManagerScreen, calls draw method
	 */
	public ManagerScreen() {
		draw();
	}
	/*
	 * The method that draws all the GUI components 
	 */
	public void draw() {
		/*
		 * Frame setup such as title, position, size, background color and layout
		 */
		frame.setTitle("Manager"); //Title
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,300);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		/*
		 * Decorative title panel
		 */
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 486, 38);
		titlePanel.setBackground(new Color(0, 191, 255));
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		/*
		 * Decorative label for the title.
		 */
		JLabel managerTitle = new JLabel("Logged in as Manager");
		managerTitle.setForeground(new Color(255, 255, 255));
		managerTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		managerTitle.setBounds(101, 0, 244, 38);
		titlePanel.add(managerTitle);
		/*
		 * DVCViewController used to help view the properties in the database.
		 * used later in the actionPerformed of setFee to change period and fees.
		 */
		DBCViewController viewer = new DBCViewController();
		JTextField feeAmount = new JTextField();
		JTextField feePeriod = new JTextField();
		Object[] message = {
			"Amount:", feeAmount,
			"Period(in days):", feePeriod
		};
		/*
		 * setFee button used to change Fees
		 * implements actionListener to respond to user input for changing fees and periods.
		 */
		JButton setFee = new JButton("Change Fees");
		setFee.setForeground(new Color(255, 255, 255));
		setFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmation =JOptionPane.showConfirmDialog(null, message, "ChangeFees", JOptionPane.OK_CANCEL_OPTION);
				if(confirmation == JOptionPane.YES_OPTION){
					int amount = -1, period = -1;
					try{
						amount = Integer.parseInt(String.valueOf(feeAmount.getText()));
						period = Integer.parseInt(String.valueOf(feePeriod.getText()));
					}catch (Exception ex){

					}
					if(amount<0 || period <0){
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}else{
						viewer.changeFees(amount, period);
						JOptionPane.showMessageDialog(null, "Fees Have Been Changed");
					}
					
				}
			}
		});
		setFee.setFont(new Font("SansSerif", Font.BOLD, 12));
		setFee.setBackground(new Color(0, 191, 255));
		setFee.setBounds(20, 170, 130, 28);
		frame.getContentPane().add(setFee);
		
		/*
		 * Label for selecting the properties
		 * To show that this is where you can select properties.
		 */
		JLabel propertySelect = new JLabel("Select Property");
		propertySelect.setFont(new Font("SansSerif", Font.BOLD, 12));
		propertySelect.setBounds(25, 48, 111, 13);
		frame.getContentPane().add(propertySelect);
		EditListingController edit = new EditListingController(); //used to edit listings
		String[] Properties = edit.getAllProperties();
		/*
		 * ComboBox for viewing the properties.
		 */
		JComboBox propertiesComboBox = new JComboBox();
		propertiesComboBox.setModel(new DefaultComboBoxModel(Properties));
		propertiesComboBox.setBackground(new Color(0, 191, 255));
		propertiesComboBox.setMaximumRowCount(50);
		propertiesComboBox.setForeground(new Color(255, 255, 255));
		propertiesComboBox.setBounds(20, 71, 139, 21);
		frame.getContentPane().add(propertiesComboBox);
		/*
		 * Combo Box to view the state of listings.
		 */
		JComboBox stateOfListing = new JComboBox();
		stateOfListing.setBackground(new Color(0, 191, 255));
		stateOfListing.setFont(new Font("SansSerif", Font.BOLD, 12));
		stateOfListing.setModel(new DefaultComboBoxModel(new String[] {"ACTIVE","RENTED", "CANCELLED", "SUSPENDED"}));
		stateOfListing.setBounds(20, 100, 152, 27);
		stateOfListing.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(stateOfListing);
		/*
		 * Button used to change state of a property.
		 * Uses EditListingController to change state of a listing
		 * Gets user input inside ActionPerformed
		 */
		JButton updateState = new JButton("Update State");
		updateState.setBackground(new Color(0, 191, 255));
		updateState.setFont(new Font("SansSerif", Font.BOLD, 12));
		updateState.setBounds(20, 140, 147, 21);
		updateState.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(updateState);
		updateState.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String new_state = String.valueOf(stateOfListing.getSelectedItem());
				int house_id = Integer.parseInt(String.valueOf(propertiesComboBox.getSelectedItem()));
				if(edit.changeStatus(house_id, new_state)){
					JOptionPane.showMessageDialog(frame, "Property Has been updated");
				}else{
					JOptionPane.showMessageDialog(frame, "Property Is Already in that State");
				}
			}
		});
		/*
		 * Button to generate a report
		 * Uses DBCViewController to help generate reports inside actionPerformed method
		 * Has an actionListenerto get user input
		 */
		JButton generateSummary = new JButton("Periodical Summary Report");
		generateSummary.setForeground(Color.WHITE);
		generateSummary.setFont(new Font("SansSerif", Font.BOLD, 12));
		generateSummary.setBackground(new Color(0, 191, 255));
		generateSummary.setBounds(232, 69, 194, 28);
		frame.getContentPane().add(generateSummary);
		generateSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewer.createReport();
				JOptionPane.showMessageDialog(null, "Report Has Been Generated. Please Check Your Parent Folder.");
			}
		});
		/*
		 * Button to get renter information
		 * Uses DBCViewController to help get renter information
		 * Renter info displayed as a string on a JOptionPane
		 */
		JButton renterInfo = new JButton("Renter Information");
		renterInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> renterInfo = viewer.getRenterInfo();
				String renterInfoDisplay = new String();
				for (int i= 0; i < renterInfo.size(); i++)
				{
					renterInfoDisplay = renterInfoDisplay.concat("Renter Number " + i);
					renterInfoDisplay = renterInfoDisplay.concat(renterInfo.get(i));
					renterInfoDisplay = renterInfoDisplay.concat("\n");
				}
				JOptionPane.showMessageDialog(frame, renterInfoDisplay);
			}
		});
		renterInfo.setForeground(Color.WHITE);
		renterInfo.setFont(new Font("SansSerif", Font.BOLD, 12));
		renterInfo.setBackground(new Color(0, 191, 255));
		renterInfo.setBounds(232, 114, 194, 28);
		frame.getContentPane().add(renterInfo);
		/*
		 * Button to get landlord information
		 * Uses DBCViewController to help get Landlord information
		 * Landlord info displayed as a string on a JOptionPane
		 */
		JButton landlordInfo = new JButton("Landlord Information");
		landlordInfo.setForeground(Color.WHITE);
		landlordInfo.setFont(new Font("SansSerif", Font.BOLD, 12));
		landlordInfo.setBackground(new Color(0, 191, 255));
		landlordInfo.setBounds(232, 157, 194, 28);
		frame.getContentPane().add(landlordInfo);
		landlordInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> landlordInfo = viewer.getLandlordInfo();
				String landlordInfoDisplay = new String();
				for (int i= 0; i < landlordInfo.size(); i++)
				{
					landlordInfoDisplay = landlordInfoDisplay.concat("Landlord Number " + i + ": ");
					landlordInfoDisplay = landlordInfoDisplay.concat(landlordInfo.get(i));
					landlordInfoDisplay = landlordInfoDisplay.concat("\n");
				}
				JOptionPane.showMessageDialog(frame, landlordInfoDisplay);
			}
		});
		/*
		 * Button to get propertyInfo
		 * Uses DBCViewController to help get propertyInformation
		 * Shows property information on a table inside a JOptionPane
		 */
		JButton propertyInfo = new JButton("Property Information");
		propertyInfo.setForeground(Color.WHITE);
		propertyInfo.setFont(new Font("SansSerif", Font.BOLD, 12));
		propertyInfo.setBackground(new Color(0, 191, 255));
		propertyInfo.setBounds(232, 201, 194, 28);
		frame.getContentPane().add(propertyInfo);
		propertyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] propertyInfo = viewer.getPropertyInfo();
				String[] columns = {"PropertyStatus", "PropertyType", "NumBedrooms", "NumBathrooms", "Furnished", "Quadrant", "Address", "HouseIDNum", "Landlord Email"}; 
				JTable table = new JTable(propertyInfo, columns);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.getColumnModel().getColumn(2).setPreferredWidth(100);
				table.getColumnModel().getColumn(3).setPreferredWidth(100);
				table.getColumnModel().getColumn(4).setPreferredWidth(100);
				table.getColumnModel().getColumn(5).setPreferredWidth(100);
				table.getColumnModel().getColumn(6).setPreferredWidth(100);
				table.getColumnModel().getColumn(7).setPreferredWidth(100);
				table.getColumnModel().getColumn(8).setPreferredWidth(200);
				JScrollPane scrollableTable = new JScrollPane(table);
				scrollableTable.setPreferredSize(new Dimension(900,400));
				JOptionPane.showMessageDialog(frame, scrollableTable);
			}
		});
		/*
		 * Button to logout
		 * Has an action listener to check when user presses button.
		 */
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(20, 206, 169, 28);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new MainMenu();
			}
		});
		
		frame.setVisible(true);
	}
		
	}
