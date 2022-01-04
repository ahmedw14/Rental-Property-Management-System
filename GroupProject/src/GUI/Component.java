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
package GUI;

import javax.swing.JFrame;
/**
 * This Component interface has a JFrame that is repeatedly used by any Classes that inherit it. Except for the NotificationScreen and EmailSystem
 * Screen, because we prefer them to show up on top rather than override previous frame.
 * Any class that inherits Component will override the draw() method to draw their GUI.
 */
public interface Component {
	public JFrame frame = new JFrame();
	public void draw();
}

