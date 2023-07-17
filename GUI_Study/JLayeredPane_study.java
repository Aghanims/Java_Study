package GUI_Study;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class JLayeredPane_study 
{
    
    
    public static void main(String[] args) 
    {
        /*
            JLayeredPane -> Swing container that provides a third dimension
                            for positioning components ex. depth, z-index

            Different Layers; arrange accordingly from bottom to top layer
            -default
            -pallete
            -modal
            -popUp
            -drag

            or use wrapper class on assigning layers
            -Integer.valueOf(n)
        */    

        //labels
        JLabel label1 = new JLabel();
        label1.setBackground(new Color(150, 107, 225));
        label1.setBounds(50, 50, 200, 200);
        label1.setOpaque(true);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBounds(100, 100, 200, 200);
        label2.setBackground(new Color(224, 181, 130));

        JLabel label3 = new JLabel();
        label3.setBackground(new Color(85, 224, 112));
        label3.setBounds(150, 150, 200, 200);
        label3.setOpaque(true);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 700, 600);

        //add labels to layered Pane
        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label2, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label3, JLayeredPane.DRAG_LAYER);

        //frame
        JFrame frame = new JFrame("JLayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(null);
        frame.setVisible(true);
     
        frame.add(layeredPane);
    }
}
