/**
 * Rental Property Management System Group 26
 * @author Ahmed Waly
 * @author Kai Wang
 * @author Jaxson Waterstreet
 * @author Dylan Windsor
 * @author Mohamed Yassin
 * @version     2.2
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
import controller.NotificationController;
/**
 * This screen is used to display notifications for new properties when registered renter presses on notifications.
 * Uses its own JFrame so that it can display while keeping the other screen active.
 */
public class NotificationScreen implements Component{
	private JFrame notificationFrame;
	/*
	 * Default constructor, calls draw method
	 */
	public NotificationScreen(){
		draw();
	}
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Main draw method, draws the GUI contents of this notification screen
	 */
	@SuppressWarnings("serial")
	@Override
	public void draw() {
		//Frame setup such as size, position, layout and other settings.
		notificationFrame = new JFrame();
		notificationFrame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
		notificationFrame.setLocation(dim.width/2-250, dim.height/2-250); 
		notificationFrame.getContentPane().setLayout(null);
		notificationFrame.setSize(767,305);
		/*
		 * Decorative Panel 
		 */
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(new Color(0, 191, 255));
		TitlePanel.setBounds(0, 0, 753, 22);
		notificationFrame.getContentPane().add(TitlePanel);
		TitlePanel.setLayout(null);
		NotificationController controller = new NotificationController(); //used to help get notifications
		/*
		 * Decorative Label for the panel
		 */
		JLabel titleLabel = new JLabel("Notifications");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		titleLabel.setBounds(350, 0, 355, 22);
		TitlePanel.add(titleLabel);
		/*
		 * A scroll pane so that our table inside it can be scrolled through.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 740, 221);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		notificationFrame.getContentPane().add(scrollPane);
		/*
		 * Table to put notification results inside.
		 * Has two columns: PropertyID and Address
		 */
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			controller.getNotifications(),
			new String[] {
				"PropertyID", "Address"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(table);
		
		notificationFrame.setVisible(true);
		
		
	}
}

