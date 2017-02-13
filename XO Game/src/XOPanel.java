
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class XOPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8247989323336875042L;
	
	public static String X = "X";
	public static String O = "O";
	private String currentSymbol = X;
	private int moves=0;


	ArrayList<JButton> buttons;

	public XOPanel() {
		super(new GridLayout(3, 3, 5, 5));
		init();
	}

	private void init() {
		buttons = new ArrayList<JButton>();
		for (int i = 0; i < 9; i++) {
			JButton button = new JButton();
			button.addActionListener(this);
			button.setActionCommand("" + i);
			buttons.add(button);
			add(button);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = buttons.get(Integer.valueOf(e.getActionCommand()));
		if (clickedButton.getText().equals("")) {
			clickedButton.setText(currentSymbol);
			moves++;
			if (getResult()) {
				JOptionPane.showMessageDialog(null, "Wygra³ " + currentSymbol);
				restart();
			}
			if (currentSymbol.equals(X))
				currentSymbol = O;
			else
				currentSymbol = X;
			
			if (moves==9){
				JOptionPane.showMessageDialog(null, "Remis!");
				restart();
			}
		}
	}

	public boolean getResult() {

		for (int i = 0; i < 9; i += 3) {
			if ((buttonValue(i).equals(buttonValue(i + 1)) && (buttonValue(i).equals(buttonValue(i + 2))))
					&& !buttonValue(i).equals("")) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if ((buttonValue(i).equals(buttonValue(i + 3)) && (buttonValue(i).equals(buttonValue(i + 6))))
					&& !buttonValue(i).equals("")) {
				return true;
			}
		}

		if ((((buttonValue(0).equals(buttonValue(4))) && (buttonValue(4).equals(buttonValue(8))))
				|| (((buttonValue(2).equals(buttonValue(4))) && (buttonValue(4).equals(buttonValue(6))))))
				&& !buttonValue(4).equals("")) {
			return true;
		}

		return false;
	}

	public String buttonValue(int i) {
		return buttons.get(i).getText();
	}

	public void restart() {
		for (JButton a : buttons)
			a.setText("");
		currentSymbol = X;
		moves=0;
	}

	public String getCurrentSymbol() {
		return currentSymbol;
	}
}
