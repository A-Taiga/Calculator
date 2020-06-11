package xCalc;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Frame window = new Frame(410,620);
		
				window.createFrame();
			
			}
		});
	}
}
