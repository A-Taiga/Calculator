package xCalc;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Frame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038122442164406643L;
	
	private int width, height;
	private UI ui;
	
	public Frame(int width, int height) {
		this.width = width;
		this.height = height;
		
		
	}
	public void createFrame() {
	
		ui = new UI(width,height);
		this.setTitle("My Calculator");
		this.setSize(new Dimension(width, height));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(ui);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
