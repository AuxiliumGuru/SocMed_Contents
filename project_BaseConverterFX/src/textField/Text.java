package textField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
 
public class Text {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded TextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
 
        JTextField textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        textField.setBackground(new Color(220, 220, 220));
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
 
        panel.add(textField);
 
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}