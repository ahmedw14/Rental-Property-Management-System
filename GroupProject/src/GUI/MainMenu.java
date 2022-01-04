/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     4.05
 * @since       1.0
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The main menu screen of the rental property management system.
 * Has buttons to log in as various types of users.
 * You input email, name and password to log in.
 */
public class MainMenu implements Component{
	public static String dbUsernameInput; //the username for the mysql database.
	public static String dbPasswordInput; //the password for the mysql database.
	/**
	 * Default constructor, calls draw method.
	 */
	public MainMenu(){
		draw();
	}
	/**
	 * Draw method, draws our main menu screen and all the GUI components.
	 * Buttons inside implement ActionListener so that we can get user input and add functionality.
	 */
	@Override
	public void draw() {
		//Frame setup and styling, such as position, size, default close operation and layout.
		frame.setTitle("Main Menu");
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
		frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
		frame.setSize(500,500);
		frame.getContentPane().setLayout(null);
		/*
		 * Decorative title panel.
		 */
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 191, 255));
		titlePanel.setBounds(0, 0, 486, 69);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		/*
		 * The title that goes on the title panel.
		 */
		JLabel titleLabel = new JLabel("Group26 Properties Limited");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		titleLabel.setBounds(95, 10, 297, 49);
		titlePanel.add(titleLabel);
		/*
		 * The label that shows that this is where user inputs database username
		 */
		JLabel dbUsername = new JLabel("MySQL username\r\n");
		dbUsername.setFont(new Font("SansSerif", Font.BOLD, 16));
		dbUsername.setBounds(31, 71, 144, 21);
		frame.getContentPane().add(dbUsername);
		/*
		 * The label that shows that is where user inputs database password
		 */
		JLabel dbPassword = new JLabel("MySQL password");
		dbPassword.setFont(new Font("SansSerif", Font.BOLD, 16));
		dbPassword.setBounds(258, 71, 170, 21);
		frame.getContentPane().add(dbPassword);
		/*
		 * The text field where user inputs database username.
		 */
		JTextField sqlUsername = new JTextField();
		sqlUsername.setFont(new Font("SansSerif", Font.BOLD, 14));
		sqlUsername.setColumns(10);
		sqlUsername.setBounds(29, 98, 170, 21);
		frame.getContentPane().add(sqlUsername);
		/*
		 * The text field where user inputs database password
		 */
		JPasswordField sqlPassword = new JPasswordField();
		sqlPassword.setBounds(240, 98, 170, 21);
		frame.getContentPane().add(sqlPassword);
		/*
		 * The label to show that this is where you input email.
		 */
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		emailLabel.setBounds(103, 154, 72, 21);
		frame.getContentPane().add(emailLabel);
		/*
		 * The label to show that this is where you input username.
		 */
		JLabel lblUsername = new JLabel("Name");
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblUsername.setBounds(103, 211, 66, 21);
		frame.getContentPane().add(lblUsername);
		/*
		 * The label to show that this is where you input password.
		 */
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		passwordLabel.setBounds(103, 275, 85, 20);
		frame.getContentPane().add(passwordLabel);
		/*
		 * The text field to input user's email.
		 */
		JTextField email = new JTextField();
		email.setFont(new Font("SansSerif", Font.BOLD, 14));
		email.setBounds(222, 156, 206, 23);
		frame.getContentPane().add(email);
		email.setColumns(10);
		/*
		 * The text field to input user's name.
		 */
		JTextField name = new JTextField();
		name.setFont(new Font("SansSerif", Font.BOLD, 14));
		name.setColumns(10);
		name.setBounds(222, 213, 206, 23);
		frame.getContentPane().add(name);
		/*
		 * The password field to input user's password.
		 */
		JPasswordField password = new JPasswordField();
		password.setBounds(222, 275, 206, 19);
		frame.getContentPane().add(password);
		
		/*
		 * Combo box to select what type of user you are logging in as.
		 */
		JComboBox loginChooser = new JComboBox();
		loginChooser.setModel(new DefaultComboBoxModel(new String[] {"Renter", "Landlord", "Manager"}));
		loginChooser.setFont(new Font("SansSerif", Font.BOLD, 12));
		loginChooser.setBounds(152, 338, 150, 21);
		frame.getContentPane().add(loginChooser);
		/*
		 * Button to register
		 * Action performed gets all the inputs from the text areas and calls authenticate controller to help register the user.
		 * Uses JOptionPane for informative pop-ups.
		 */
		JButton register = new JButton("Register");
		register.setBackground(new Color(0, 191, 255));
		register.setFont(new Font("SansSerif", Font.BOLD, 14));
		register.setBounds(31, 402, 138, 32);
		frame.getContentPane().add(register);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUsernameInput = String.valueOf(sqlUsername.getText());
				dbPasswordInput = String.valueOf(sqlPassword.getPassword());
				String nameInput = name.getText().trim();
				String passwordInput = String.valueOf(password.getPassword()).trim();
				String emailInput = email.getText().trim();
				String selectedType = String.valueOf(loginChooser.getSelectedItem());
				if(nameInput.length() > 3 && passwordInput.length()>3 && emailInput.length()>3 && emailInput.contains("@") && nameInput.matches("[a-zA-Z]+")){
					AuthenticateController authenticate = AuthenticateController.getOnlyInstance();
					authenticate.setUser(nameInput, emailInput, passwordInput, selectedType);
					if(authenticate.register()){
						JOptionPane.showMessageDialog(frame, "you have successfully registered");
					}else{
						JOptionPane.showMessageDialog(frame, "Email is already being used please use a different email");	
					}
				}else{
					JOptionPane.showMessageDialog(frame, "Please make sure your input meeets the following reguirements\n1. All inputs have more than 3 characters\n2. Email should have the '@' character\n3. Name Only Contains Letters");
				}
				
			}
		});
		/*
		 * Button to login
		 * Action performed gets all the inputs from the text areas and calls authenticate controller to help login the user.
		 * Uses JOptionPane for informative pop-ups.
		 */
		JButton login = new JButton("Login");
		login.setFont(new Font("SansSerif", Font.BOLD, 14));
		login.setBackground(new Color(0, 191, 255));
		login.setBounds(179, 402, 138, 32);
		frame.getContentPane().add(login);
		/*
		 * Button to log in as a guest, does not need to get any user input besides the MySQL username and password
		 */
		JButton guestLogin = new JButton("Login as Guest");
		guestLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		guestLogin.setBackground(new Color(0, 191, 255));
		guestLogin.setBounds(327, 402, 150, 32);
		frame.getContentPane().add(guestLogin);
		guestLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUsernameInput = String.valueOf(sqlUsername.getText());
				dbPasswordInput = String.valueOf(sqlPassword.getPassword());
				AuthenticateController authenticate = new AuthenticateController();
				authenticate.setOnlyInstance(null);
			    new UnregisteredRenterScreen();
			}
		});
	
			/*
			 * Action listener for login button, adds functionality so that you can actually log in
			 * uses the authenticate controller.
			 * Can log in as either landlord, renter or manager depending on what you picked from the combo box
			 * and what you are registered as.
			 */
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedLogin = String.valueOf(loginChooser.getSelectedItem());
					dbUsernameInput = sqlUsername.getText();
					dbPasswordInput = String.valueOf(sqlPassword.getPassword());
					if (selectedLogin == "Landlord")
					{
						String nameInput = name.getText();
						String passwordInput = String.valueOf(password.getPassword());
						String emailInput = email.getText();
						String selectedType = String.valueOf(loginChooser.getSelectedItem());
						AuthenticateController authenticate = AuthenticateController.getOnlyInstance();
						authenticate.setUser(nameInput, emailInput, passwordInput, selectedType);
						try{
							if(authenticate.login()){
								new LandlordScreen();
							}
							else{
								JOptionPane.showMessageDialog(frame, "Login failed, check inputs");	
							}
						}catch(UserNotFoundException u){
							JOptionPane.showMessageDialog(frame, "Login failed, check inputs");
						}
						
					}
					if (selectedLogin == "Renter") {
						String nameInput = name.getText();
						String passwordInput = String.valueOf(password.getPassword());
						String emailInput = email.getText();
						String selectedType = String.valueOf(loginChooser.getSelectedItem());
						AuthenticateController authenticate = AuthenticateController.getOnlyInstance();
						authenticate.setUser(nameInput, emailInput, passwordInput, selectedType);
						try{							
							if(authenticate.login()){
								new RegisteredRenterScreen();
							}
							else{
								JOptionPane.showMessageDialog(frame, "Login failed, check inputs");	
							}
						}catch(UserNotFoundException u){
							JOptionPane.showMessageDialog(frame, "Login failed, check inputs");
						}	
					}
					if (selectedLogin == "Manager") {
						String nameInput = name.getText();
						String passwordInput = String.valueOf(password.getPassword());
						String emailInput = email.getText();
						String selectedType = String.valueOf(loginChooser.getSelectedItem());
						AuthenticateController authenticate = AuthenticateController.getOnlyInstance();
						authenticate.setUser(nameInput, emailInput, passwordInput, selectedType);
						try{
							if(authenticate.login()){
								new ManagerScreen();
							}
							else{
								JOptionPane.showMessageDialog(frame, "Login failed, check inputs");	
							}
						}catch(UserNotFoundException u){
							JOptionPane.showMessageDialog(frame, "Login failed, check inputs");
						}
					}

				}
			});
			frame.setVisible(true); //making frame actually visible
		}
	public static void main(String[] args) {
        
		EventQueue.invokeLater(() -> {
				new MainMenu().draw();        
		});
	}
}
