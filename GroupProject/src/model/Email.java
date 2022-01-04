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
 * The Email class keeps track of all the information needed to generate an email
 */
public class Email {
    private String sender;
    private String receiver;
    private String message;
    private String subject;
    /**
     * This Constructor initializes all the information stored for an email
     * @param sender String of the Sender's Email
     * @param receiver String of the reciever's Email
     * @param msg String of the message
     * @param subj String of the subject
     */
    public Email(String sender, String receiver, String msg, String subj){
        this.sender = sender;
        this.receiver = receiver;
        this.message = msg;
        this.subject = subj;
    }
    /**
     * Getter for the sender's email
     * @return String of the Sender's Email
     */
    public String getSender() {
        return sender;
    }
    /**
     * Getter for the receiver's email
     * @return String of the reciever's Email
     */
    public String getReceiver() {
        return receiver;
    }
    /**
     * Getter for the Subject's email
     * @return String of the subject
     */
    public String getSubject() {
        return subject;
    }
    /**
     * Setter for the sender's email
     * @param sender String of the Sender's Email
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
    /**
     * Setter for the receiver's email 
     * @param receiver String of the reciever's Email
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    /**
     * Getter for the message
     * @return String of the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * Setter for the message
     * @param message String of the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Setter for the subject
     * @param subject String of the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
