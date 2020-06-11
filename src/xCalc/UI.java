package xCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class UI extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994525294846766937L;

	private int width;
	private GridBagConstraints gc;
	private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, add, sub, mult, div, dec, equal, clear, back, negative;
	private static JTextPane display, display2;
	private ArrayList<Button> buttons;
	private Calculate calculate;
	private Color buttonColor = new Color(240, 132, 10);

	public UI(int width, int height) {

		calculate = new Calculate();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		componentLayout();

	}

	public void componentLayout() {

		buttons = new ArrayList<>();
		buttons.add(b0 = new Button("0"));
		buttons.add(b1 = new Button("1"));
		buttons.add(b2 = new Button("2"));
		buttons.add(b3 = new Button("3"));
		buttons.add(b4 = new Button("4"));
		buttons.add(b5 = new Button("5"));
		buttons.add(b6 = new Button("6"));
		buttons.add(b7 = new Button("7"));
		buttons.add(b8 = new Button("8"));
		buttons.add(b9 = new Button("9"));
		buttons.add(add = new Button("+"));
		buttons.add(sub = new Button("-"));
		buttons.add(mult = new Button("X"));
		buttons.add(div = new Button("\u00f7"));
		buttons.add(dec = new Button("."));
		buttons.add(equal = new Button("="));
		buttons.add(clear = new Button("C"));
		buttons.add(back = new Button("\u2190"));
		buttons.add(negative = new Button("\u00b1"));

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setPreferredSize(new Dimension(95, 95));
			buttons.get(i).setMinimumSize(new Dimension(95, 95));
			buttons.get(i).setMaximumSize(new Dimension(95, 95));
			buttons.get(i).setFont(new Font("Helvetica", Font.BOLD, 50));
			buttons.get(i).setFocusPainted(false);
			buttons.get(i).addActionListener(this);
			buttons.get(i).addMouseListener(this);
			buttons.get(i).setBorderPainted(false);
			buttons.get(i).setBackground(buttonColor);
			buttons.get(i).setForeground(Color.BLACK);
		}
		equal.setBackground(Color.GREEN);

		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);
		StyleConstants.setFontSize(attribs, 40);
		StyleConstants.setFontFamily(attribs, "Helvetica");

		display = new JTextPane();
		display.setPreferredSize(new Dimension(width, 50));
		display.setMinimumSize(new Dimension(width, 50));
		display.setEditable(false);
		display.setParagraphAttributes(attribs, true);

		display2 = new JTextPane();
		display2.setPreferredSize(new Dimension(width, 50));
		display2.setMinimumSize(new Dimension(width, 50));
		display2.setEditable(false);
		display2.setParagraphAttributes(attribs, true);

		gc = new GridBagConstraints();
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(2, 0, 2, 0);

		int row0 = 0;
		int row1 = 1;
		int row2 = 2;
		int row3 = 3;
		int row4 = 4;
		int row5 = 5;
		int row6 = 6;

		gc.gridx = 0;
		gc.gridy = row0;
		gc.weighty = .01;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(display2, gc);

		gc.gridx = 0;
		gc.gridy = row1;
		gc.weighty = .01;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(display, gc);
///////////////////////////////////////////////////////////////	
		gc.insets = new Insets(2, 2, 2, 2);

		gc.gridx = 0;
		gc.gridy = row2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weighty = 0;
		gc.fill = GridBagConstraints.NONE;
		this.add(clear, gc);

		gc.gridx = 1;
		gc.gridy = row2;
		this.add(back, gc);

		gc.gridx = 2;
		gc.gridy = row2;
		this.add(div, gc);
///////////////////////////////////////////////////////////////			
		gc.gridx = 0;
		gc.gridy = row3;
		this.add(b7, gc);

		gc.gridx = 1;
		gc.gridy = row3;
		this.add(b8, gc);

		gc.gridx = 2;
		gc.gridy = row3;
		this.add(b9, gc);

		gc.gridx = 3;
		gc.gridy = row3;
		this.add(mult, gc);
///////////////////////////////////////////////////////////////
		gc.gridx = 0;
		gc.gridy = row4;

		this.add(b4, gc);

		gc.gridx = 1;
		gc.gridy = row4;
		this.add(b5, gc);

		gc.gridx = 2;
		gc.gridy = row4;
		this.add(b6, gc);

		gc.gridx = 3;
		gc.gridy = row4;
		this.add(sub, gc);
///////////////////////////////////////////////////////////////
		gc.gridx = 0;
		gc.gridy = row5;
		this.add(b1, gc);

		gc.gridx = 1;
		gc.gridy = row5;
		this.add(b2, gc);

		gc.gridx = 2;
		gc.gridy = row5;
		this.add(b3, gc);

		gc.gridx = 3;
		gc.gridy = row5;
		this.add(add, gc);
///////////////////////////////////////////////////////////////
		gc.gridx = 0;
		gc.gridy = row6;
		this.add(negative, gc);

		gc.gridx = 1;
		gc.gridy = row6;
		this.add(b0, gc);

		gc.gridx = 2;
		gc.gridy = row6;
		this.add(dec, gc);

		gc.gridx = 3;
		gc.gridy = row6;
		this.add(equal, gc);
///////////////////////////////////////////////////////////////

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == b0) {
			display.setText(display.getText() + "0");
		}
		if (source == b1) {
			display.setText(display.getText() + "1");
		}
		if (source == b2) {
			display.setText(display.getText() + "2");
		}
		if (source == b3) {
			display.setText(display.getText() + "3");
		}
		if (source == b4) {
			display.setText(display.getText() + "4");
		}
		if (source == b5) {
			display.setText(display.getText() + "5");
		}
		if (source == b6) {
			display.setText(display.getText() + "6");
		}
		if (source == b7) {
			display.setText(display.getText() + "7");
		}
		if (source == b8) {
			display.setText(display.getText() + "8");
		}
		if (source == b9) {
			display.setText(display.getText() + "9");
		}
		if (source == negative) {
			display.setText(display.getText() + "-");
		}
		if (source == dec) {
			display.setText(display.getText() + ".");
		}
		if (source == clear) {
			display.setText("");
			display2.setText("");

		}
		if (source == back) {
			Document doc = display.getDocument();
			if (doc.getLength() > 0) {
				try {
					doc.remove(doc.getLength() - 1, 1);
				} catch (BadLocationException e1) {

					e1.printStackTrace();
				}
			}
		}
		if (locked2()) {
			if (locked()) {

				if (source == div) {
					display.setText(display.getText() + "\u00f7");

				}
				if (source == mult) {
					display.setText(display.getText() + "*");

				}
				if (source == add) {
					display.setText(display.getText() + "+");

				}
				if (source == sub) {
					display.setText(display.getText() + "\u2212");

				}
			}
			if (source == equal) {
				display2.setText(display.getText().toString());
				try {
					if (display.getText().contains("\u00f7")) {
						read(display.getText().toString(), "\u00f7");
						write();
					}

					if (display.getText().contains("*")) {
						read(display.getText().toString(), "\\*");
						write();
					}

					if (display.getText().contains("\u2212")) {
						read(display.getText().toString(), "\u2212");
						write();
					}

					if (display.getText().contains("+")) {
						read(display.getText().toString(), "\\+");
						write();
					}
				} catch (NumberFormatException exception) {
					exception.printStackTrace();
				}
			}
		}

	}

	public void read(String s, String type) {
		try {
			String[] data = new String[2];
			data = s.split(type);
			double x = Double.parseDouble(data[0]);
			double y = Double.parseDouble(data[1]);
			if (type.equals("\u00f7")) {
				calculate.divide(x, y);
			} else if (type.equals("\\*")) {
				calculate.multiply(x, y);
			} else if (type.equals("\u2212")) {
				calculate.subtract(x, y);
			} else if (type.equals("\\+")) {
				calculate.add(x, y);
			}
		} catch (Exception e) {

		}

	}

	public void write() {
		if (calculate.getSolution() % 1 == 0) {
			display.setText(String.format("%.0f", calculate.getSolution()));
			display2.setText(display2.getText() + " = " + display.getText());

		} else {
			display.setText(String.valueOf(calculate.getSolution()));
			display2.setText(display2.getText() + " = " + display.getText());
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		for (int i = 0; i < buttons.size(); i++) {
			if (e.getSource() == buttons.get(i)) {
				buttons.get(i).setBackground(Color.WHITE);
			}
		}

		if (e.getSource() == b1) {
			b1.setBackground(Color.WHITE);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setBackground(buttonColor);
		}
		equal.setBackground(Color.GREEN);

	}
	
	public static boolean locked() {

		String check = display.getText();
		if (check.contains("\u00f7") || check.contains("*") || check.contains("\u2212") || check.contains("+")) {
			return false;
		} else
			return true;

	}

	public static boolean locked2() {
		String check = display.getText();
		if (check.equals("")) {
			return false;
		} else
			return true;
	}
}
