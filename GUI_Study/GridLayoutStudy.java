import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutStudy 
{
    

    public static void main(String[] args) 
    {
        /*
            GridLayout -> places components in a grid of a cells. Each component takes all the available space 
                            within its cell, and each cell is the same.
        */

        JFrame frame = new JFrame("Grid Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
    
        frame.setLayout(new GridLayout(5, 2, 15, 15));

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));
        frame.add(new JButton("10"));


        frame.setVisible(true);
    }
}
