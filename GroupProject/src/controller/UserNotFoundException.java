package controller;

/**
 * UserNotFoundException for when a user that is not registered trys to login to the software
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
		super("User Is Not Registered");
	}
}
