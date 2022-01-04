/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     2.1
 * @since       1.0
 */
package controller;

import java.util.ArrayList;
import GUI.MainMenu;
import model.*;
import model.Property;

/**
 * Class gets property information from the database
 */
public class ViewSearchCriteria{
    private Property propertyModel;
    private DBMS db;

    /**
     * Constructor that connects to the database
     */
    public ViewSearchCriteria() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    /**
     * Getter for property information
     * @return String[][] with house ID and parameters which describe the property 
     * (type, bathrooms, bedrooms, furnished, quandrant)
     */
    public String[][] getActiveProperties() {
        return db.getActiveProperties();
    }
    /**
     * Getter for search criteria
     * @param type type of property
     * @param numBedrooms number of bedrooms on property
     * @param numBathrooms number of bathrooms on property
     * @param furnished furnished or not
     * @param quadrant quadrant of the city the property is located in
     * @return String[][] with house ID and parameters which describe the property 
     * (type, bathrooms, bedrooms, furnished, quandrant)
     */
    public String[][] getCriteriaProperties(String type, int numBedrooms, int numBathrooms, String furnished, String quadrant) {
        return db.getCriteriaProperties(type, numBedrooms, numBathrooms, furnished, quadrant);
    }
    /**
     * Getter for database*
     * @return DBMS variable db
     */
    public DBMS getDb() {
        return db;
    }
    /**
     * Setter for database
     * @param db DBMS variable db
     */
    public void setDb(DBMS db) {
        this.db = db;
    }
}
