/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     1.4
 * @since       1.0
 */
package model;

import java.util.ArrayList;
/**
 * The Landlord class stores the Landlord's email, name, and password. Additionally, 
 * they can add properties in which they own.
 */
public class Landlord extends User{
    private ArrayList<Property> properties = new ArrayList<Property>();
    /**
     * This constructor initializes the Landlord's Credentials, which will be 
     * stored in the User class(parent class)
     * @param email String of the Landlord's email
     * @param name String of the Landlord's name
     * @param pass String of the Landlord's password
     */
    public Landlord(String email, String name, String pass){
        super(email, name, pass);
    }
    /**
     * This function associates a certain landlord to a property
     * @param newProperty The new Property that is registered under the landlord's email
     */
    public void addProperty(Property newProperty){
        properties.add(newProperty);
    }
}
