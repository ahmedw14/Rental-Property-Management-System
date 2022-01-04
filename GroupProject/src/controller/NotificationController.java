package controller;

import java.util.ArrayList;

import GUI.MainMenu;

public class NotificationController implements NotificationsSubject{
    DBMS db;
    private Observer observer;
    
    public NotificationController(){
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    public String[][] getNotifications(){
       return db.getNotifications(); 
    }
    public void saveCriteria(String propertyType, int numBedrooms, int numBathrooms, String furnished,
    String quadrant){
        db.saveSearchCriteria(propertyType, numBedrooms, numBathrooms, furnished, quadrant);
    }
    public void unsubscribe(){
        db.removeRenter();
    }
	public void notifyAllObservers() {
		observer.update();
	}
}
