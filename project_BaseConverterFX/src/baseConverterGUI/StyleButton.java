package baseConverterGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class StyleButton extends JButton{
	
	public StyleButton(String text) {
		super(text);
		//this.setFocusPainted(false);
		//this.setContentAreaFilled(false);
		this.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		this.setForeground(Color.white);
		this.setFocusable(false);
		this.setBackground(Color.DARK_GRAY);
		this.setAlignmentX(Component.LEFT_ALIGNMENT); // Align this to the left

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setBackground(Color.gray); // Change the this color when clicked
			}

			public void mouseEntered(MouseEvent e) {
				setBackground(Color.gray); // Change the this color when hovered

			}

			public void mouseExited(MouseEvent e) {
				setBackground(Color.DARK_GRAY); // Restore the this color

			}
		});

	}
	
}
