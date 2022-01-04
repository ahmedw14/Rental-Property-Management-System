/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     3.4
 * @since       1.0
 */
package model;
/**
 * This property class stores all the required information of any property
 */
public class Property {
    
    private String propertyStatus;
    private String propertyType;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private String quadrant;
    private String address;
    private int id;
    private String email;
    /**
     * This constructor initializes the property information
     * @param propertyStatus String of the property status
     * @param propertyType String of the property type
     * @param numBedrooms integer of the number of bedrooms the property has
     * @param numBathrooms integer of the number of bathrooms the property has
     * @param furnished boolean if the property is furnished(true) or not(false)
     * @param quadrant String of the Quadrant where the property is stored
     * @param address String of the address
     * @param id integer of the id
     * @param loggedinEmail String of the owner's email
     */
    public Property(String propertyStatus, String propertyType, int numBedrooms, int numBathrooms, boolean furnished,
            String quadrant, String address, int id, String loggedinEmail) {
        this.propertyStatus = propertyStatus;
        this.propertyType = propertyType;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.address = address;
        this.id = id;
        this.email = loggedinEmail;
    }
    /**
     * Getter for the status of a property
     * @return String of the property status
     */
    public String getStatus() {
        return propertyStatus;
    }
    
    /**
     * Setter for the status of the property
     * @param propertyStatus String of the property status
     */
    public void setStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
    /**
     * Getter for the type of the property
     * @return String for the type of the property
     */
    public String getType() {
        return propertyType;
    }
    /**
     * Getter for the number of the bedrooms
     * @return integer for the number of bedrooms
     */
    public int getNumBedrooms() {
        return numBedrooms;
    }
    /**
     * Getter for the number of the bathrooms
     * @return integer for the number of bedrooms
     */
    public int getNumBathrooms() {
        return numBathrooms;
    }
    /**
     * Getter of the boolean if the property is furnished
     * @return boolean if the property is furnished(true) or not(false)
     */
    public boolean isFurnished() {
        return furnished;
    }
    /**
     * Setter of the boolean if the property is furnished
     * @param furnished boolean if the property is furnished(true) or not(false)
     */
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }
    /**
     * Getter for the quadrant of which the property is located in the city
     * @return String of the Quadrant where the property is stored
     */
    public String getQuadrant() {
        return quadrant;
    }
    /**
     * Getter for the property's Address
     * @return String of the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Getter for the property id
     * @return integer of the id
     */
    public int getId() {
        return id;
    }
    /**
     * getter for the email address of the property's owner
     * @return String of the email
     */
    public String getEmail() {
        return email;
    }
    
    
}
