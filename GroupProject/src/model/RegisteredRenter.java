/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     1.1
 * @since       1.0
 */
package model;

public class RegisteredRenter extends Renter{
    /**
     * This constructor initializes the Registered Renter's Credentials, which will be 
     * stored in the User class(parent class)
     * @param email String of the Registered Renter's email
     * @param name String of the Registered Renter's name
     * @param pass String of the Registered Renter's password
     */
    public RegisteredRenter(String email, String name, String pass){
        super(email, name, pass);
    }
    
    /**
     * his constructor initializes the Registered Renter's Credentials, which will be 
     * stored in the User class(parent class) using the parent renter class
     * @param r The parent Renter object
     */
    public RegisteredRenter(Renter r){
        super(r.email, r.name, r.password);
    }
    
    
    
}
