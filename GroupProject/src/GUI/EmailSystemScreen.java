/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     1.8
 * @since       1.0
 */
package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.EmailController;
/**
 * This class is the GUI for the Email System. It interacts with the Email Controller to send user input and change the database.
 * It used by the Registered Renters and Landlords to communicate.
 */
public class EmailSystemScreen implements Component{
	private JFrame emailFrame; //the frame used to draw on.
	/**
	 * Default Constructor for EmailSystemScreen 
	 */
	public EmailSystemScreen(){ 
		draw();
	}
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //This gets the dimensions of the screen.
	/**
	 * The method used to draw our screen, all the GUI components are drawn inside. Some elements such as JButton implement ActionListener 
	 * so that we can dynamically get user input for example, and then communicate that with the controllers, all that is inside this draw() method.
	 */
	@SuppressWarnings("serial")
	@Override
	public void draw() {
		emailFrame = new JFrame("Email System");
		emailFrame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		emailFrame.setLocation(dim.width/2-250, dim.height/2-250);  
		emailFrame.getContentPane().setLayout(null); //Use absolute layout
		emailFrame.setSize(767,305); //Setting up size, location and layout of our frame.
		
		/*
		 * Message Box for message to be sent.
		 */
		JTextArea Message = new JTextArea();
		Message.setForeground(new Color(255, 255, 255));
		Message.setBackground(new Color(192, 192, 192));
		Message.setColumns(10);
		Message.setRows(10);
		Message.setBounds(75, 93, 324, 133);
		Message.setLineWrap(true);
		emailFrame.getContentPane().add(Message);
		
		/*
		 * Combo Box OR Text Field depending on who is sending the email, Combo Box for Renter, Text Field for landlord since they can write the renter's emails.
		 */
		JComboBox renterRecipient = new JComboBox();
		JTextField landlordRecipient = new JTextField();
		EmailController controller = new EmailController();
		if (controller.getUserType().equals("Renter")) {
			renterRecipient.setModel(new DefaultComboBoxModel(controller.getProperties()));
			renterRecipient.setMaximumRowCount(50);
			renterRecipient.setBounds(75, 32, 279, 19);
			emailFrame.getContentPane().add(renterRecipient);
		}
		else {
			landlordRecipient.setBounds(75, 32, 279, 19);
			emailFrame.getContentPane().add(landlordRecipient);
			landlordRecipient.setColumns(10);
		}
		/*
		 * Combo Box for the Subject of the Email.
		 * Either "Need Further Details", or "Arrange a Meeting"
		 */
		JComboBox Subject = new JComboBox();
		Subject.setModel(new DefaultComboBoxModel(new String[] {"Need further details", "Arrange a Meeting"}));
		Subject.setMaximumRowCount(2);
		Subject.setBounds(75, 61, 279, 21);
		emailFrame.getContentPane().add(Subject);
		/*
		 * Dynamic label that shows the recipient based on who is sending.
		 * "PropertyID" for Renter, or "Renter Email" for landlords
		 */
		if (controller.getUserType().equals("Renter")) {
		JLabel RecipientLabel = new JLabel("PropertyID");
		RecipientLabel.setToolTipText("PropertyID");
		RecipientLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		RecipientLabel.setBounds(10, 35, 67, 13);
		emailFrame.getContentPane().add(RecipientLabel);
		}
		else {
			JLabel RecipientLabel = new JLabel("Renter Email");
			RecipientLabel.setToolTipText("Renter Email");
			RecipientLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
			RecipientLabel.setBounds(10, 35, 67, 13);
			emailFrame.getContentPane().add(RecipientLabel);
		}
		/*
		 * Label for the subject.
		 * Just writes subject so that users know that is the subject of the email.
		 */
		JLabel SubjectLabel = new JLabel("Subject");
		SubjectLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		SubjectLabel.setBounds(10, 67, 45, 13);
		emailFrame.getContentPane().add(SubjectLabel);
		/*
		 * Label for the message.
		 * Just writes message so that users know that this is the message portion of the email.
		 */
		JLabel MessageLevel = new JLabel("Message");
		MessageLevel.setFont(new Font("SansSerif", Font.BOLD, 12));
		MessageLevel.setBounds(10, 99, 55, 13);
		emailFrame.getContentPane().add(MessageLevel);
		/*
		 * Button used to send email.
		 * Has an action listener which uses Email Controller to modify the database/models.
		 */
		JButton SendButton = new JButton("Send");
		SendButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		SendButton.setBounds(173, 232, 85, 21);
		emailFrame.getContentPane().add(SendButton);
		/**
		 * Adding user input support for button. 
		 * Uses controller to get user input and send the message
		 * Different conditions for if the user in a renter or the user is a landlord.
		 */
		SendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subjectInput = String.valueOf(Subject.getSelectedItem());
				String messageInput = Message.getText();
				if (controller.getUserType().equals("Renter")) {
					int propertyIDInput = (Integer.valueOf(String.valueOf(renterRecipient.getSelectedItem())));
					controller.send(propertyIDInput, messageInput, subjectInput);
					if (subjectInput.equals("Need further details")) {
						JOptionPane.showMessageDialog(frame, "Email successfully sent");
					}
					else {
						JOptionPane.showMessageDialog(frame, "Email successfully sent to the landlord at : " + controller.getLandlordEmail());
					}
				}
				else {
					String reciever = String.valueOf(landlordRecipient.getText());
					if(controller.getRenterEmails(reciever)){
						controller.send(reciever, messageInput, subjectInput);
						JOptionPane.showMessageDialog(frame, "Email successfully sent");
					}else{
						JOptionPane.showMessageDialog(null, "Please Input a Valid Renter Email");
					}
					
				}
			}
		});
		/*
		 * A decorative panel for the title.
		 */
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(0, 191, 255));
		TitlePanel.setBounds(0, 0, 753, 22);
		emailFrame.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		/*
		 * The title of the screen.
		 * Goes on top of the panel.
		 */
		JLabel titleLabel = new JLabel("Email");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		titleLabel.setBounds(54, 0, 355, 22);
		TitlePanel.add(titleLabel);
		/*
		 * The label for the inbox section.
		 */
		JLabel inboxLabel = new JLabel("Inbox");
		inboxLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		inboxLabel.setBounds(548, 0, 69, 22);
		TitlePanel.add(inboxLabel);
		/*
		 * ScrollPane so that our table for the inbox is scrollable.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(427, 33, 316, 221);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		emailFrame.getContentPane().add(scrollPane);
		/*
		 * Table that gets messages from the EmailController
		 */
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			controller.getLandlordInbox(),
			new String[] {
				"From", "Subject", "Message"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ //To make messages clickable so that we can expand then.
	        public void valueChanged(ListSelectionEvent event) {
	          String email = (table.getValueAt(table.getSelectedRow(), 2).toString());
	          JOptionPane.showMessageDialog(table, "<html><body><p style='width: 100px;'>" + email + "</p></body></html>");
	          //Used html formatting so that the messages are not too wide when expanded.
	        }
	    });
		scrollPane.setViewportView(table);
		//Making Frame visible so that users can actually see it
		emailFrame.setVisible(true);
	}
}
