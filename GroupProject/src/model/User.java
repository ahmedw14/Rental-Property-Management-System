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
package model;

/**
 * Any registered user using the application should have an email, password, name;
 * so they should extend this User class.
 */
public abstract class User{
    protected String email;
    protected String password;
    protected String name;
    /**
     * Constructor that initializes the email, name, and password
     * @param email The User's email
     * @param name The User's name
     * @param password The User's password
     */
    public User(String email, String name, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    /**
     * Guest Users should call this constructor, where the name will be given as a 
     * guest
     */
    public User() {
        this.name = "guest";
        
    }
    /**
     * Getter for email
     * @return String of the User's email address
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter for the email
     * @param email String of the User's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter for password
     * @return String of the User's password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Setter for the password
     * @param password String of the User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Getter for name
     * @return String of the User's name
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for the name
     * @param name String of the User's name
     */
    public void setName(String name) {
        this.name = name;
    }  
}
