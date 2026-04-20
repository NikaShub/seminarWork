package seminar73;

import javax.swing.*;
import java.awt.*;

public class swing {
    private static int counter = 0;
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(300, 300);

        panel.setLayout(new BorderLayout());

        JButton bt = new JButton();
        JLabel lb = new JLabel();
        bt.addActionListener(e -> {
            counter++;
        });
        frame.add(bt);// ase yvealfes daamatrn
        frame.add(panel);
        frame.setVisible(true);
    }
}
