package controller;

import java.util.ArrayList;

import GUI.MainMenu;
import model.*;
import model.Property;
public class EditListingController{
    private Property propertyModel;
    private DBMS db;


    public EditListingController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
        // db.registerProperty(propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,
        // quadrant, address, loggedinEmail);
    }

    public String[] getProperties() {
        return db.getPropertiesOfLandlord();
    }
    public String[] getAllProperties() {
        String[][] allPropertiesInfo = db.getPropertyInfo();
        String[] propertyIds = new String [allPropertiesInfo.length];
        for (int i = 0; i < allPropertiesInfo.length; i++) {
            propertyIds[i] = allPropertiesInfo[i][7];
        }
        System.out.println(propertyIds.length);

        
        return propertyIds;
    }
    public boolean payFee(int house_id){
        boolean to_return = db.changeStatusOfProperty(house_id, "ACTIVE");
        if(to_return == true){
            db.addNotifications(house_id);
        }
        
        return to_return;
    }
    public String getFee(){
        return "$"+db.getFee();
    }
    public boolean changeStatus(int house_id, String Status){
        if(Status.equalsIgnoreCase("ACTIVE")){
            boolean to_return = db.changeStatusOfProperty(house_id, "ACTIVE");
            if(to_return == true){
                db.addNotifications(house_id);
            }

            return to_return;
        }
        return db.changeStatusOfProperty(house_id, Status);
    }
    public void setPropertyModel(Property propertyModel) {
        this.propertyModel = propertyModel;
    }
    public DBMS getDb() {
        return db;
    }
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
