package GUI_Study;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class FlowLayoutStudy
{
    
    
    public static void main(String[] args) 
    {
        //FlowLayout -> places components in a row, sized at their preferred size.
        //          If the horizontal space in the container is too small,
        //          the FlowLayout class uses the next available row.

        // frame
        JFrame frame = new JFrame("Flow Layout");
        //frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // layout to be used

        //panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setPreferredSize(new Dimension(200, 250));
        panel.setBackground(new Color(35, 106, 199));

        //add components
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("10"));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
