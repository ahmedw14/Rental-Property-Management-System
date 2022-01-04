/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     1.2
 * @since       1.0
 */
package model;
/**
 * This Renter class is a child of the user, and there can be two types of 
 * Renters (Registered and Unregistered). The registered renter will call the 
 * default constructor and the registered will need to pass in their email, username, and password.
 */
public class Renter extends User{
    /**
     * Constructor that will pass to the User class, the renter's email, name, and 
     * password
     * @param email Renter's Email
     * @param name  Renter's Name
     * @param password  Renter's password
     */
    public Renter(String email, String name,String password){
        super(email, name, password);
    }
    /**
     * Constructor for the unregistered Renter where they don't have a name, email, or password
     */
    public Renter(){
        super(); //unregistered
    }
    
}
