import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class Circle implements Icon {
	/**
	 * paintIcon - paints the icon on screen
	 * @param c the component
	 * @param g the graphic
	 * @param x the x location
	 * @param y the y location
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double planet = new Ellipse2D.Double(x,y, 50,50);
		g2.setColor(Color.WHITE);
		g2.fill(planet);
		
	}

	/**
	 * getIconWidth sets the width of the circle 
	 * @return the width of the circle
	 */
	public int getIconWidth() {
		return 75;
	}

	/**
	 * getIconHeight - sets the height of the circle
	 * @return the height of the circle
	 */
	public int getIconHeight() {
		return 75;
	}

    
}
