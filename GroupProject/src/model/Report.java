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

import java.io.*;

/**
 * This Report class keeps track of all data that will be displayed in the report, and 
 * once the generate function is called it will generate a text file containing all 
 * the data
 */
public class Report {
    private int numHousesRented;
    private int numHousesListed;
    private int numActiveListings;
    private String[][] housesRented;
    /**
     * This constructor initializes the information that will be displayed in the 
     * report
     * @param numHousesRented integer of the number of houses rented
     * @param numHousesListed integer of the number of houses listed(Active, Rented, Suspended, Cancelled)
     * @param numActiveListings integer of the number of houses Active
     * @param housesRented 2D String array containing information about the rented houses
     */
    public Report(int numHousesRented, int numHousesListed, int numActiveListings,String[][] housesRented) {
        this.numHousesRented = numHousesRented;
        this.numHousesListed = numHousesListed;
        this.numActiveListings = numActiveListings;
        this.housesRented = housesRented;
    }
    /**
     * This file uses all the private data members to generate a report text file showing 
     * all the data in a well ordered format.
     */
    public void generate(){
        File order = null;
        FileWriter output = null;
        try {
            order = new File("Report.txt"); //create a new file called Report.txt
            order.createNewFile();
            output = new FileWriter(order); //open a FileWriter to write into the file
            output.write("Manager Report:\n\n");
            output.write("Houses Rented: "+numHousesRented+"\n");
            output.write("Houses Listed: "+numHousesListed+"\n");
            output.write("Houses Active: "+numActiveListings+"\n");
            output.write("Houses Rented:\n\n");
            //get the property's landlord, propertyid, address of all the rented properties
            for(int i=0;i<(int)housesRented.length;i++){
                //loop through each property that is rented in DB
                output.write(i+".  Landlord's Name: "+housesRented[i][0]+"   Property Id: "+housesRented[i][1]+"  Property address: "+housesRented[i][2]);
                output.write("\n");
            }
            output.close(); //close the file
        }
        catch (IOException e) {
            System.err.print("IOException writing to file.");
            System.exit(1);
        }
    }
}
