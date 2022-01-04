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
package controller;

import java.util.ArrayList;
import model.*;
import GUI.MainMenu;

public class DBCViewController {
	private DBMS db;
	/**
	 * Default consrtuctor establishes database connection
	 */
	public DBCViewController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
	/**
	 * 
	 * @return 
	 */
	public ArrayList<String> getRenterInfo(){
		return db.getRenterInfo();
	}
	public ArrayList<String>getLandlordInfo(){
		return db.getLandlordInfo();
	}
	public String[][] getPropertyInfo(){
		return db.getPropertyInfo();
	}
	public void changeFees(int amount, int period){
        	db.updateFee(amount, period);
    	}
	public void createReport(){
		int numberOfPropertiesActive = db.getActiveProperties().length;
		String[][] allProperties = db.getPropertyInfo();
		int numberOfPropertiesListed = allProperties.length;
		int numberOfPropertiesRented = 0;
		for(int i = 0;i<allProperties.length;i++){
			if(allProperties[i][0].equalsIgnoreCase("Rented")){
				numberOfPropertiesRented++;
			}
		}
		String [][] propertiesRented = new String[numberOfPropertiesRented][3];
		int rentedIndex = 0;
		for(int i = 0;i<allProperties.length;i++){
			System.out.println(allProperties[i].length);
			if(allProperties[i][0].equalsIgnoreCase("Rented")){
				System.out.println(propertiesRented.length);
				propertiesRented[rentedIndex][0] = db.getLandlord(allProperties[i][8]); //landlord's name
				propertiesRented[rentedIndex][1] = allProperties[i][7]; //id
				propertiesRented[rentedIndex][2] = allProperties[i][6]; //address
				rentedIndex++;
			}
		}
		Report report = new Report(numberOfPropertiesRented,numberOfPropertiesListed,numberOfPropertiesActive, propertiesRented);
		report.generate();
	}
}
