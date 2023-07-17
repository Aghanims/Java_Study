package GUI_Study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BorderLayoutStudy 
{
    
    //Border Layout -> places components in five areas: NORTH, SOUTH, EAST, WEST, CENTER; all extra space is placed in center area.
    public static void main(String[] args) 
    {
        
        //frame
        JFrame frame = new JFrame();
        frame.setTitle("Border Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout(10, 10)); //BorderLayout parameters are both the margins of width & height in pixels
        frame.setVisible(true);

        //panels
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(100, 100));
        panel1.setBackground(new Color(71, 199, 35));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(100, 100));
        panel2.setBackground(new Color(199, 35, 71));

        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(100, 100));
        panel3.setBackground(new Color(199, 98, 35));

        JPanel panel4 = new JPanel();
        panel4.setPreferredSize(new Dimension(100, 100));
        panel4.setBackground(new Color(35, 106, 199));

        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(100, 100));
        panel5.setBackground(new Color(35, 199, 128));
        panel5.setLayout(new BorderLayout(10, 10));

        //-------------sub panels for center panel (panel5)-----------------------------
        JPanel panel5_a = new JPanel();
        panel5_a.setPreferredSize(new Dimension(50, 50));
        panel5_a.setBackground(new Color(199, 60, 35));

        JPanel panel5_b = new JPanel();
        panel5_b.setPreferredSize(new Dimension(50, 50));
        panel5_b.setBackground(new Color(82, 35, 199));

        JPanel panel5_c = new JPanel();
        panel5_c.setPreferredSize(new Dimension(50, 50));
        panel5_c.setBackground(new Color(199, 142, 35));

        JPanel panel5_d = new JPanel();
        panel5_d.setPreferredSize(new Dimension(50, 50));
        panel5_d.setBackground(new Color(199, 183, 35));

        JPanel panel5_e = new JPanel();
        panel5_e.setPreferredSize(new Dimension(50, 50));
        panel5_e.setBackground(new Color(166, 35, 199));
        
        panel5.add(panel5_a, BorderLayout.NORTH);
        panel5.add(panel5_b, BorderLayout.SOUTH);
        panel5.add(panel5_c, BorderLayout.WEST);
        panel5.add(panel5_d, BorderLayout.EAST);
        panel5.add(panel5_e, BorderLayout.CENTER);

        //-------------sub panels for center panel (panel5)-----------------------------

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.EAST);
        frame.add(panel5, BorderLayout.CENTER);        
    }
}
