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
package model;

/**
 * The Manager class stores the Manager's email, name, and password. Additionally, 
 * they can create a report.
 */
public class Manager extends User{
    /**
     * This constructor initializes the Manager's Credentials, which will be 
     * stored in the User class(parent class)
     * @param email String of the Manager's email
     * @param name String of the Manager's name
     * @param pass String of the Manager's password
     */
    public Manager(String email, String name, String pass){
        super(email, name, pass);
    }
    /**
     * This function calls the report class to generate the report.
     * @param numHousesRented integer of the number of houses rented
     * @param numHousesListed integer of the number of houses listed(Active, rented, suspended, or cancelled)
     * @param numActiveListings integer of the number of houses Active
     * @param housesRented 2d Array of the rented houses
     */
    public void createReport(int numHousesRented, int numHousesListed, int numActiveListings, String[][] housesRented){
        Report createReport = new Report(numHousesRented, numHousesListed, numActiveListings, housesRented);
        createReport.generate();
    }
}
