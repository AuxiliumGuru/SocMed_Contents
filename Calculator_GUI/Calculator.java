package calculator_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	Stack_Calculator compute;
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, subButton, mulButton, divButton,
	decButton, equButton, delButton, clrButton;
	JPanel panel;

	String text = "";
	Font myFont = new Font("Segoe UI Light", Font.BOLD, 25);

	Calculator(){
		compute = new Stack_Calculator();
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 540);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.white);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setBackground(Color.white);
		textField.setEditable(false);
		textField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");


		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = delButton;
		functionButtons[6] = clrButton;
		functionButtons[7] = equButton;


		for(int i =0;i<7;i++) {
			
			if (i <= 3) {
				functionButtons[i].setForeground(new Color(0, 128, 194));
				functionButtons[i].setFont(new Font("Segoe UI Light", Font.BOLD, 25));
			} else {
				functionButtons[i].setFont(myFont);
			}
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			functionButtons[i].setBackground(Color.white);
			
		}
		functionButtons[7].addActionListener(this);
		functionButtons[7].setFont(myFont);
		functionButtons[7].setForeground(Color.white);
		functionButtons[7].setFocusable(false);
		functionButtons[7].setBackground(Color.blue);

		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(Color.white);
			numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		}

		delButton.setBounds(90,430,100,50);
		clrButton.setBounds(210,430,100,50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.white);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(equButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				text += i;
				textField.setText(text);
			}
		}
		if (e.getSource() == decButton) {
			text = text + ".";
			textField.setText(text);
		} else if (e.getSource() == addButton) {
			text = text + "+";
			textField.setText(text);
		} else if (e.getSource() == subButton) {
			text = text + "-";
			textField.setText(text);
		} else if (e.getSource() == mulButton) {
			text = text + "*";
			textField.setText(text);
		} else if (e.getSource() == divButton) {
			text = text + "/";
			textField.setText(text);
		} else if (e.getSource() == clrButton) {
			text = "";
			textField.setText(text);
		} else if (e.getSource() == delButton) {
			String newText = "";
			for (int i = 0; i < text.length() - 1; i++) {
				newText += text.charAt(i);
			}
			text = newText;
			textField.setText(text);
		} else if (e.getSource() == equButton) {
			compute.getResult(compute.infixToPostfix(text));
			double num = compute.stack.pop();
			textField.setText(getAnswer(num));
			text = "";
		}

	}

	private String getAnswer(double num) {

		if (compute.hasDecimalValue(num)) {
			return String.format("%.0f", num);
		}
		return num + "";
	}
	
	public static void main(String[] args) {
		new  Calculator();
	}

}
