/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     7.03
 * @since       1.0
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import controller.NotificationController;
import controller.ViewSearchCriteria;
/**
 * This is the screen for any registered renter.
 * Has buttons that can open other screens, such as Email System and Notifications.
 * Opened when logged in as a renter.
 */
public class RegisteredRenterScreen implements Component{
	/*
	 * Default constructor, calls draw method.
	 */
	RegisteredRenterScreen() {
		draw();
	}
	/*
	 * Main draw method
	 * Used to draw all the GUI contents.
	 * Functionality for buttons inside actionListener actionPerformed method for buttons.
	 * Uses some controllers to help send user data.
	 */
	@SuppressWarnings("serial")
	@Override
	public void draw() {
		/*
		 * Setting up the frame, such as title, size, position, and layout.
		 */
		frame.setTitle("Registered Renter Screen");
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		/*
		 * ScrollPane so that future tables can be scrolled through.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 466, 215);
		frame.getContentPane().add(scrollPane);
		ViewSearchCriteria v = new ViewSearchCriteria();
		/*
		 * Table that we put inside ScrollPane
		 * This is a table for viewing all the properties.
		 * 6 columns: PropertyID, PropertyType, number of bedrooms, number of bathrooms, furnished, quadrant.
		 */
		JTable table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			v.getActiveProperties(),
			new String[] {
				"PropertyID", "Property Type", "#Bedrooms", "#Bathrooms", "Furnished", "Quadrant"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class,String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(52);
		scrollPane.setViewportView(table);
		
		/*
		 * Decorative panel
		 */
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 191, 255));
		titlePanel.setBounds(0, 0, 486, 82);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		/*
		 * Title for the decorative panel
		 */
		JLabel Title = new JLabel("Browse Properties");
		Title.setBounds(135, 20, 220, 32);
		Title.setForeground(new Color(255, 255, 255));
		titlePanel.add(Title);
		Title.setFont(new Font("SansSerif", Font.BOLD, 24));
		/*
		 * ComboBox to be able to select your preferred property type
		 */
		JComboBox PropertyType = new JComboBox();
		PropertyType.setModel(new DefaultComboBoxModel(new String[] {"APARTMENT", "TOWNHOUSE", "DUPLEX", "CONDO", "STUDIO", "BASEMENT"}));
		PropertyType.setBackground(new Color(0, 191, 255));
		PropertyType.setFont(new Font("SansSerif", Font.PLAIN, 12));
		PropertyType.setBounds(10, 192, 73, 21);
		PropertyType.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(PropertyType);
		/*
		 * Combo Box to be able to select your preferred number of bedrooms
		 */
		JComboBox NumBedrooms = new JComboBox();
		NumBedrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,7,8}));
		NumBedrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NumBedrooms.setBackground(new Color(0, 191, 255));
		NumBedrooms.setBounds(108, 192, 67, 21);
		NumBedrooms.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(NumBedrooms);
		/*
		 * Combo Box to select your preferred number of bathrooms
		 */
		JComboBox NumBathrooms = new JComboBox();
		NumBathrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8}));
		NumBathrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
		NumBathrooms.setBackground(new Color(0, 191, 255));
		NumBathrooms.setBounds(196, 192, 60, 21);
		NumBathrooms.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(NumBathrooms);
		/*
		 * Combo Box to select your preferred quadrant.
		 */
		JComboBox Quadrant = new JComboBox();
		Quadrant.setModel(new DefaultComboBoxModel(new String[] {"NW", "SW", "NE", "SE"}));
		Quadrant.setFont(new Font("SansSerif", Font.PLAIN, 12));
		Quadrant.setBackground(new Color(0, 191, 255));
		Quadrant.setBounds(374, 193, 88, 21);
		Quadrant.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Quadrant);
		/*
		 * Radio Button to select if you want a furnished or unfurnished property.
		 */
		JRadioButton Furnished = new JRadioButton("Furnished");
		Furnished.setBounds(280, 193, 88, 21);
		Furnished.setBackground(new Color(0, 191, 255));
		Furnished.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Furnished);
		/*
		 * Label to indicate that this is where you select property type.
		 */
		JLabel label1 = new JLabel("PropertyType");
		label1.setBounds(10, 168, 79, 13);
		frame.getContentPane().add(label1);
		/*
		 * Label to indicate that this is where you select number of bedrooms.
		 */
		JLabel label2 = new JLabel("#Bedrooms");
		label2.setBounds(108, 168, 67, 13);
		frame.getContentPane().add(label2);
		/*
		 * Label to indicate that this is where you select number of bathrooms
		 */
		JLabel label3 = new JLabel("#Bathrooms");
		label3.setBounds(200, 168, 73, 13);
		frame.getContentPane().add(label3);
		/*
		 * Label to indicate that this is where you select furnished or unfurnished
		 */
		JLabel label4 = new JLabel("Furnished?");
		label4.setBounds(293, 168, 67, 13);
		frame.getContentPane().add(label4);
		/*
		 * Label to indicate that this is where you indicate quadrant that you prefer.
		 */
		JLabel label5 = new JLabel("Quadrant");
		label5.setBounds(388, 168, 88, 13);
		frame.getContentPane().add(label5);
		/*
		 * Button to search for properties based on your criteria.
		 * actionPerformed in ActionListener gets input from combo boxes and radio buttons and makes an appropriate search.
		 * Returns matching results for user based on input.
		 */
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String propertyTypeInput = String.valueOf(PropertyType.getSelectedItem());
				int numBedroomsInput = Integer.valueOf(String.valueOf(NumBedrooms.getSelectedItem()));
				int numBathroomsInput = Integer.valueOf(String.valueOf(NumBathrooms.getSelectedItem()));
				String quadrantTypeInput = String.valueOf(Quadrant.getSelectedItem());
				String furnishedInput = "NO";
				if(Furnished.isSelected()){
					furnishedInput = "YES";
				}
				// v.getCriteriaProperties(propertyTypeInput, numBedroomsInput, numBathroomsInput, furnishedInput, quadrantTypeInput);
				/*
				 * New table with new data based on search
				 */
				JTable table = new JTable();
				table.setBackground(new Color(255, 255, 255));
				table.setModel(new DefaultTableModel(
					v.getCriteriaProperties(propertyTypeInput, numBedroomsInput, numBathroomsInput, furnishedInput, quadrantTypeInput),
					new String[] {
						"PropertyID", "Property Type", "#Bedrooms", "#Bathrooms", "Furnished", "Quadrant"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class,String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(65);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(63);
				table.getColumnModel().getColumn(3).setPreferredWidth(66);
				table.getColumnModel().getColumn(4).setPreferredWidth(55);
				table.getColumnModel().getColumn(5).setPreferredWidth(52);
				scrollPane.setViewportView(table);
			}
		});
		Search.setBackground(new Color(0, 191, 255));
		Search.setFont(new Font("SansSerif", Font.BOLD, 18));
		Search.setBounds(167, 88, 142, 44);
		Search.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Search);
		/*
		 * Button to unsubscribe from the service, removes registered renter from registered renters database.
		 * Has an actionListener that uses NotificationController to remove renter from registered users.
		 */
		JButton Unsubscribe = new JButton("Unsubscribe");
		Unsubscribe.setFont(new Font("SansSerif", Font.BOLD, 10));
		Unsubscribe.setBackground(new Color(0, 191, 255));
		Unsubscribe.setBounds(359, 92, 117, 21);
		Unsubscribe.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(Unsubscribe);
		NotificationController notification = new NotificationController();
		Unsubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notification.unsubscribe();
				JOptionPane.showMessageDialog(null, "You Have Been Unsubscribed");
				new MainMenu();
			}
		});
		/*
		 * Button to view notifications
		 * Inside actionPerformed method, opens a new NotificationScreen when button is clicked.
		 */
		JButton viewNotifications = new JButton("Notifications");
		viewNotifications.setFont(new Font("SansSerif", Font.BOLD, 10));
		viewNotifications.setBackground(new Color(0, 191, 255));
		viewNotifications.setBounds(10, 92, 115, 21);
		viewNotifications.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(viewNotifications);
		viewNotifications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new NotificationScreen();
			}
		});
		/*
		 * Button to open the email system.
		 * Once clicked using the actionPerformed method, opens EmailSystemScreen.
		 * Registered Renter can send emails to the landlord of any posting number.
		 */
		JButton emailButton = new JButton("Email Landlord");
		emailButton.setBackground(new Color(0, 191, 255));
		emailButton.setFont(new Font("SansSerif", Font.BOLD, 10));
		emailButton.setBounds(358, 123, 118, 21);
		emailButton.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(emailButton);
		emailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new EmailSystemScreen();
			}
		});
		/*
		 * Button to logout.
		 * Has an actionListener in which the actionPerformed method returns you to the main menu when button is clicked.
		 */
		JButton returnButton = new JButton("Logout");
		returnButton.setFont(new Font("SansSerif", Font.BOLD, 10));
		returnButton.setBackground(Color.RED);
		returnButton.setForeground(new Color(255, 255, 255));
		returnButton.setBounds(10, 123, 115, 21);
		frame.getContentPane().add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = new MainMenu();
			}
		});
		/*
		 * Button to save your search criteria based on filters.
		 * Has an actionPerformed method that listens for user input to check if button is clicked or not.
		 * Uses NotificationController to help save your search criteria in the database.
		 */
		JButton saveCriteria = new JButton("Save Filters");
		saveCriteria.setFont(new Font("SansSerif", Font.BOLD, 10));
		saveCriteria.setBackground(new Color(0, 191, 255));
		saveCriteria.setBounds(187, 142, 102, 21);
		saveCriteria.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(saveCriteria);
		saveCriteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String propertyTypeInput = String.valueOf(PropertyType.getSelectedItem());
				int numBedroomsInput = Integer.valueOf(String.valueOf(NumBedrooms.getSelectedItem()));
				int numBathroomsInput = Integer.valueOf(String.valueOf(NumBathrooms.getSelectedItem()));
				String quadrantTypeInput = String.valueOf(Quadrant.getSelectedItem());
				String furnishedInput = "NO";
				if(Furnished.isSelected()){
					furnishedInput = "YES";
				}
				NotificationController n = new NotificationController();
				n.saveCriteria(propertyTypeInput, numBedroomsInput, numBathroomsInput, furnishedInput, quadrantTypeInput);
				JOptionPane.showMessageDialog(null, "Search Criteria has been saved.");
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.setVisible(true); //making frame actually visible
	}
}
