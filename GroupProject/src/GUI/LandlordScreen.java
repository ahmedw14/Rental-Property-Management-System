/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     2.4
 * @since       1.0
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.EditListingController;
/**
 * This class is the GUI for the Landlord Screen. It interacts with the Edit Listing Controller to edit listings.
 * It also calls other screens' constructors such as the email screen and the register property screen for other features.
 */
public class LandlordScreen implements Component{
	/**
	 * Default constructor
	 * Calls draw() method
	 */
	public LandlordScreen() {
		draw();
	}
	/**
	 * The draw method that we override in every Screen. 
	 * Draws our Landlord screen and every GUI component on it, some buttons implement ActionListener to 
	 * get user input and 
	 */
	@Override
	public void draw() {
		/*
		 * Setting up frame decorations and initial settings such as size, location, layout and color.
		 */
		frame.setTitle("Landlord"); 
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
		frame.getContentPane().setLayout(null);
		
		/*
		 * Decorative bar for the title.
		 */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 486, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		/*
		 * label for the title
		 */
		JLabel landlordTitle = new JLabel("Logged in as Landlord");
		landlordTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		landlordTitle.setBounds(134, 0, 226, 41);
		landlordTitle.setForeground(new Color(255, 255, 255));
		panel.add(landlordTitle);
		
		
		EditListingController edit = new EditListingController(); //Controller that we use later in pay fee button.
		String[] Properties = edit.getProperties(); //We use edit listing controller to get properties that the landlord owns.
		/*
		 * Combo box that shows the properties that the landlord owns.
		 */
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Properties));
		comboBox.setBackground(new Color(0, 191, 255));
		comboBox.setMaximumRowCount(50);
		comboBox.setBounds(37, 112, 168, 21);
		comboBox.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(comboBox);
		
		/*
		 * A label to show that these are the properties the landlord owns.
		 */
		JLabel PropertySelector = new JLabel("My Properties");
		PropertySelector.setFont(new Font("SansSerif", Font.BOLD, 12));
		PropertySelector.setBounds(64, 92, 168, 13);
		frame.getContentPane().add(PropertySelector);
		
		/*
		 * A label to show that this is where you click to register a new property.
		 */
		JLabel RegisterFormLabel = new JLabel("Register a New Property");
		RegisterFormLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		RegisterFormLabel.setBounds(269, 92, 177, 13);
		frame.getContentPane().add(RegisterFormLabel);
		/*
		 * Button to register a new property.
		 * Has an action listener so that it responds to user input and then opens a new screen, Register Property Screen so that
		 * you can register properties.
		 */
		JButton RegisterFormButton = new JButton("Register a New Property");
		RegisterFormButton.setBackground(new Color(0, 191, 255));
		RegisterFormButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		RegisterFormButton.setBounds(249, 111, 179, 22);
		RegisterFormButton.setForeground(new Color(255, 255, 255));
		RegisterFormButton.addActionListener(new ActionListener() {
			/**
			 * @param the event that triggered the action
			 */
			public void actionPerformed(ActionEvent e) {
				Component c = new RegisterPropertyScreen();
			}
		});
		frame.getContentPane().add(RegisterFormButton);
		/*
		 * Button to pay fees, Implements action listener so that you can get user input.
		 * Uses JOptionPane as well to show some popups for various situations.
		 */
		JButton payFees = new JButton("Pay Fee");
		payFees.setBackground(new Color(0, 191, 255));
		payFees.setBounds(54, 202, 104, 34);
		payFees.setForeground(new Color(255, 255, 255));
		payFees.setFont(new Font("SansSerif", Font.BOLD, 16));
		frame.getContentPane().add(payFees);
		payFees.addActionListener(new ActionListener(){
			/**
			 * @param e The event that triggered the action
			 */
			public void actionPerformed(ActionEvent e) {
				// String new_state = String.valueOf(stateOfListing.getSelectedItem());
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to pay the fee of "+ edit.getFee(), "Close?",  JOptionPane.YES_NO_OPTION);
				if(confirmation == JOptionPane.YES_OPTION){
					int house_id = Integer.parseInt(String.valueOf(comboBox.getSelectedItem()));
					if(edit.payFee(house_id)){
						JOptionPane.showMessageDialog(frame, "Property is Now Active");
					}else{
						JOptionPane.showMessageDialog(frame, "Property Is Already Active");
					}
				}
				
			}
		});
		/**
		 * Combo box that shows the state of the listing.
		 */
		JComboBox stateOfListing = new JComboBox();
		stateOfListing.setBackground(new Color(0, 191, 255));
		stateOfListing.setFont(new Font("SansSerif", Font.BOLD, 12));
		stateOfListing.setModel(new DefaultComboBoxModel(new String[] {"RENTED", "CANCELLED", "SUSPENDED"}));
		stateOfListing.setBounds(249, 195, 152, 27);
		stateOfListing.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(stateOfListing);
		/*
		 * Button that you can use to update state.
		 * Has an action listener that can be used to get combo box selection to make decisions on if we will update state or not.
		 * Edit Listing Controller is also used to manipulate listings.
		 */
		JButton updateState = new JButton("Update State");
		updateState.setBackground(new Color(0, 191, 255));
		updateState.setFont(new Font("SansSerif", Font.BOLD, 12));
		updateState.setBounds(254, 232, 147, 21);
		updateState.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(updateState);
		updateState.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String new_state = String.valueOf(stateOfListing.getSelectedItem());
				int house_id = Integer.parseInt(String.valueOf(comboBox.getSelectedItem()));
				if(edit.changeStatus(house_id, new_state)){
					JOptionPane.showMessageDialog(frame, "Property Has been updated");
				}else{
					JOptionPane.showMessageDialog(frame, "Property Is Already in that State");
				}
			}
		});
		/*
		 * Button to log out, action listener action performed method just opens a main menu screen again.
		 */
		JButton LogoutButton = new JButton("Logout");
		LogoutButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		LogoutButton.setBackground(new Color(255, 0, 0));
		LogoutButton.setBounds(343, 51, 103, 21);
		LogoutButton.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(LogoutButton);
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new MainMenu();
			}
		});
		/*
		 * Button to view emails, actionPerformed opens the email screen.
		 */
		JButton emails = new JButton("Emails");
		emails.setBackground(new Color(0, 191, 255));
		emails.setFont(new Font("SansSerif", Font.BOLD, 12));
		emails.setBounds(54, 51, 91, 22);
		frame.getContentPane().add(emails);
		emails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new EmailSystemScreen();
			}
		});
		
		frame.setVisible(true); //making frame actually visible		
	}
}
