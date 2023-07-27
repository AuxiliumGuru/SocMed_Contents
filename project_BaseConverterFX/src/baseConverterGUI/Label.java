package baseConverterGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	Label(String text) {
		super(text);
		this.setFont(new Font("Sans Serif", Font.BOLD, 13));
		//this.setForeground(Color.white);
	}

}
