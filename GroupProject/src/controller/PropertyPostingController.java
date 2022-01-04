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

import java.util.ArrayList;

import GUI.MainMenu;
import model.*;
import model.Property;
public class PropertyPostingController{
    private Property propertyModel;
    private DBMS db;
     /**
     * @param propertyModel stored property object
     * @param db stored database URL, 
     */

    /**
     * Controller in property posting used to register the property, requires 
     * @param propertyStatus status of the property i.e. SUSPENDED
     * @param propertyType type of property i.e. APARTMENT
     * @param numBedrooms number of bedrooms i.e. 3
     * @param numBathrooms number of bathrooms i.e. 4
     * @param furnished is the house furnished, checked/unchecked
     * @param quadrant quadrant where the house is located i.e. SW
     * @param address address of the house
     * @param landlord_email email of the landlord who owns the house
     * calls the registerProperty function connected through the db oject
     */
    public PropertyPostingController(String propertyStatus, String propertyType, int numBedrooms, int numBathrooms, String furnished,
    String quadrant, String address, String loggedinEmail) {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
        db.registerProperty(propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,
        quadrant, address, loggedinEmail);
    }
    /**
     * Getter function used to retrieve the property
     * @return Property object 
     */
    public Property getPropertyModel() {
        return propertyModel;
    }
    /**
     * Setter function used to store a Property object within the controller
     */
    public void setPropertyModel(Property propertyModel) {
        this.propertyModel = propertyModel;
    }
    /**
     * Getter function used to retrieve database connection object
     * @return DBMS object
     */
    public DBMS getDb() {
        return db;
    }
    /**
     * Setter function used to set database connection object within the controller
     */
    public void setDb(DBMS db) {
        this.db = db;
    }
    /*
    public Landlord getLandlord() {
        return landlord;
    }*/
    /*
    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }*/
}
