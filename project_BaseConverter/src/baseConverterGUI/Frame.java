package baseConverterGUI;

import ansConvert.Convert;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Frame extends JFrame implements ActionListener{
	Convert convert = new Convert();
	JButton convertBtn, resetBtn, swapBtn;
	JComboBox<String> comboBoxFrom, comboBoxTo;
	JTextField inputField, answerField;

	Frame() {
		this.setTitle("Base Converter");
		this.setSize(400, 500);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(170, 193, 158));;
		//this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// -- mainPanel --
		JPanel mainPanel = new Panel();
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.setOpaque(false);
		// -- Input Panel --
		JPanel inputPanel = new Panel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setPreferredSize(new Dimension(50, 50));
		
		JPanel inLabelPanel = new Panel();
		inLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel inputLabel = new Label("Enter number");
		inLabelPanel.add(inputLabel);
		
		JPanel fieldPanel = new Panel();
		inputField = new JTextField();
		inputField.setPreferredSize(new Dimension(352, 50));
		inputField.setFont(new Font("Arial", Font.BOLD, 13));
		fieldPanel.add(inputField);
		
		
		inputPanel.add(inLabelPanel);
		inputPanel.add(fieldPanel);

		
		/// ComboBox
		String[] items = {"Base 2", "Base 8", "Base 10", "Base 16"};
		
			// -- ComboBox (From) --
		JPanel fromPanel = new Panel();
		fromPanel.setLayout(new BoxLayout(fromPanel, BoxLayout.Y_AXIS));
		fromPanel.setPreferredSize(new Dimension(352, 40));
		JLabel fromLabel = new Label("From Base");
		JPanel fromLabelPanel = new Panel();
		fromLabelPanel.setPreferredSize(new Dimension(5, 1));
		fromLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		fromLabelPanel.add(fromLabel);
		
		JPanel comboFromPanel = new Panel();
		comboBoxFrom = new JComboBox<>(items);
		comboBoxFrom.setPreferredSize(new Dimension(352, 30));
		comboFromPanel.add(comboBoxFrom);
		fromPanel.add(fromLabelPanel);
		fromPanel.add(comboFromPanel);


			// -- ComboBox (To) --
		JPanel toPanel = new Panel();
		toPanel.setLayout(new BoxLayout(toPanel, BoxLayout.Y_AXIS));
		toPanel.setPreferredSize(new Dimension(352, 40));
		
		JLabel toLabel = new Label("To Base");
		JPanel toLabelPanel = new Panel();
		toLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		toLabelPanel.setPreferredSize(new Dimension(5, 1));
		toLabelPanel.add(toLabel);
		
		JPanel comboToPanel = new Panel();
		comboBoxTo = new JComboBox<>(items);
		comboBoxTo.setPreferredSize(new Dimension(352, 30));
		
		comboToPanel.add(comboBoxTo);
		toPanel.add(toLabelPanel);
		toPanel.add(comboToPanel);



		// -- Output Panel--
		JPanel ansPanel = new Panel();
		ansPanel.setLayout(new BoxLayout(ansPanel, BoxLayout.Y_AXIS));
		
		JLabel answerLabel = new Label("Resulting number");
		JPanel ansLabelPanel = new Panel();
		ansLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ansLabelPanel.add(answerLabel);
		
		JPanel field2Panel = new Panel();
		answerField = new JTextField();
		answerField.setEditable(false);
		answerField.setPreferredSize(new Dimension(352, 50));
		answerField.setFont(new Font("Arial", Font.BOLD, 13));
		field2Panel.add(answerField);
		ansPanel.add(ansLabelPanel);
		ansPanel.add(field2Panel);
		
		// -- buttons panel --
		JPanel btnPanel = new Panel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		convertBtn = new JButton("Convert");
		resetBtn = new StyleButton("Reset");
		swapBtn = new StyleButton("Swap");
		
		convertBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		swapBtn.addActionListener(this);
		
		convertBtn.setBackground(new Color(82, 171, 84));
		convertBtn.setFocusable(false);
		convertBtn.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		convertBtn.setForeground(Color.white);
		
		btnPanel.add(convertBtn);
		btnPanel.add(resetBtn);
		btnPanel.add(swapBtn);


		// -- Adding of components --
		mainPanel.add(inputPanel);
		mainPanel.add(fromPanel);
		mainPanel.add(toPanel);
		mainPanel.add(ansPanel);
		mainPanel.add(btnPanel);

		
		// -- Margins --
		JPanel westMargin = new Panel();
		westMargin.setPreferredSize(new Dimension(12, 0));
		JPanel eastMargin = new Panel();
		eastMargin.setPreferredSize(new Dimension(12, 0));
		JPanel northMargin = new Panel();
		northMargin.setPreferredSize(new Dimension(0, 12));
		JPanel southMargin = new Panel();
		southMargin.setPreferredSize(new Dimension(0, 12));
		
		this.add(northMargin, BorderLayout.NORTH);
		this.add(southMargin, BorderLayout.SOUTH);
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(westMargin, BorderLayout.WEST);
		this.add(eastMargin, BorderLayout.EAST);	
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == convertBtn) {
			String num = inputField.getText();
			String toSelected = (String) comboBoxTo.getSelectedItem();
			String fromSelected = (String) comboBoxFrom.getSelectedItem();
			answerField.setText(convert.convert(num, toSelected, fromSelected));
		} else if (e.getSource() == resetBtn) {
			inputField.setText("");
			answerField.setText("");
		} else if (e.getSource() == swapBtn) {
			String temp = (String) comboBoxTo.getSelectedItem();
			comboBoxTo.setSelectedItem(comboBoxFrom.getSelectedItem());
			comboBoxFrom.setSelectedItem(temp);
		}
	}
	
	
}
