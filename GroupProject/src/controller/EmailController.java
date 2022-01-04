/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     1.9
 * @since       1.0
 */

 package controller;

import model.Email;

import java.util.ArrayList;

import GUI.EmailSystemScreen;
import GUI.MainMenu;

public class EmailController {
    private EmailSystemScreen view;
    private Email email;
    private DBMS db;
    /**
     * @param view stores the GUI for email
     * @param email stores the email object
     * @param db stored database URL, 
     */
    
    /**
     * Email controller used to connect email menu with connected user 
     */
    public EmailController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    /**
     * Getter function used to see all the properties
     * calls getActiveProperties() function from DBMS
     * @return String[]
     */
    public String[] getProperties() {
    	String[][] temp =  db.getActiveProperties();
    	String[] x = new String[temp.length];
    	for (int i = 0; i < temp.length; i++)
    	{
    		x[i] = temp[i][0];
    	}
    	return x;
    }
    /**
     * function used to send an email, requires
     * @param propertyID the house Id number
     * @param message a message up to 250 characters
     * @param subject subject of this email
     * calls the send email function
     */
    public void send(int propertyID, String message, String subject) {
    	email = new Email(db.loggedinEmail, db.getLandlordEmail(propertyID), message, subject);
    	db.sendEmail(email.getReceiver(), email.getMessage(), email.getSubject());
    }

    /**
     * function used to send an email, requires
     * @param renter_email the email of the renter
     * @param message a message up to 250 characters
     * @param subject subject of this email
     * calls the send email function
     */
    public void send(String renter_email, String message, String subject) {
    	// email = new Email(db.loggedinEmail, db.getLandlordEmail(propertyID), message, subject);
    	db.sendEmail(renter_email, message, subject);
    }

     /**
     * Getter function used to get landlord email
     * @return the email as a string
     */
    public String getLandlordEmail() {
    	return email.getReceiver();
    }

     /**
     * Getter function used to get use type i.e renter/landlord/manager
     * @return the user type as a string
     */
    public String getUserType() {
    	return db.loggedinType;
    }
    /**
     * Getter function used check if renter email exists
     * @return if exists(true), if not(false)
     */
    public boolean getRenterEmails(String emailToCheck){
        return db.getRentersEmails().contains(emailToCheck);
    }
    /**
     * Getter function used to get all emails that landlord received
     * @return all emails as String[][]
     */
    public String[][] getLandlordInbox(){
    	return db.getEmails();
    }
}