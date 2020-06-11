// this is the link to the code used in this class
//https://harryjoy.me/2011/08/21/different-button-shapes-in-swing/


package xCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class Button extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6095699407736753724L;

	public Button(String label) {

		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);

		setPreferredSize(size);
		setContentAreaFilled(false);
		setFocusable(false);
		setFocusPainted(false);

	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.WHITE);
			
		} else {
			g.setColor(getBackground());
			
		}
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	Shape shape;

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}
}
