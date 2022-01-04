
/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     1.5
 * @since       1.0
 */
package controller;
import GUI.MainMenu;
import java.util.ArrayList;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The AuthenticateController class controls all funcionality related to logging in and registering
 */
public class AuthenticateController implements ActionListener {
    private ArrayList<String> storedNames = new ArrayList<String>();
    private ArrayList<String> storedEmails = new ArrayList<String>();
    private ArrayList<String> storedPasswords = new ArrayList<String>();
    private ArrayList<String> storedTypes = new ArrayList<String>();
    private static AuthenticateController instance;
    private User user;
    private String userType; 
    private DBMS db;
    /**
     * If no instance of the controler exists create one, if there is an instance return it
     * @return The only instance of authenticateController
     */
    public static AuthenticateController getOnlyInstance() {
        if(instance == null)
            instance = new AuthenticateController();
        return instance;
    }
    /**
     * Setter for the singleton instance
     * @param onlyInstance AuthenticateController
     */
    public static void setOnlyInstance(AuthenticateController onlyInstance) {
        AuthenticateController.instance = onlyInstance;
    }
    /**
     * set the user type and instantiate user to the matching type
     * @param name User name    
     * @param email User email
     * @param password User password
     * @param userType User Type
     */
    public void setUser(String name, String email, String password,String userType){
        this.userType = userType;
        if(userType.equalsIgnoreCase("renter")){
            user = new RegisteredRenter(email, name, password);
        }else if(userType.equalsIgnoreCase("landlord")){
            user = new Landlord(email, name, password);
        }else if(userType.equalsIgnoreCase("manager")){
            user = new Manager(email, name, password);
        }
        db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    /**
     * Default Constructor establishes database connection
     */
    public AuthenticateController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    /**
     * Checks to see if user exists within database
     * @return Boolean of whether user exists in database or not
     * @throws UserNotFoundException
     */
    public boolean login() throws UserNotFoundException{
        //get user
        if(userType.equalsIgnoreCase("renter")){
            return(db.getRenter(user.getName(), user.getEmail(), user.getPassword()));
        }else if(userType.equalsIgnoreCase("landlord")){
            return(db.getLandlord(user.getName(), user.getEmail(), user.getPassword()));
        }else if(userType.equalsIgnoreCase("manager")){
            return(db.getManager(user.getName(), user.getEmail(), user.getPassword()));
        }
        throw new UserNotFoundException();
    }
    /**
     * Registers the user 
     * @return Whether or not the registration was succesful
     */
    public boolean register(){
        //get user
        if(userType.equalsIgnoreCase("renter")){
            
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("renter");
            return db.registerRenter(user.getName(), user.getEmail(), user.getPassword());
        }else if(userType.equalsIgnoreCase("landlord")){
            
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("landlord");
            return db.registerLandlord(user.getName(), user.getEmail(), user.getPassword());
        }else if(userType.equalsIgnoreCase("manager")){
            
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("manager");
            return db.registerManager(user.getName(), user.getEmail(), user.getPassword());
        }

        return false;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
