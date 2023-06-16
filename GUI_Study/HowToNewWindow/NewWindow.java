package HowToNewWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NewWindow  
{
    private JFrame frame = new JFrame();
    JLabel label = new JLabel("What's Up :)");
    JLabel dummyLabelN = new JLabel();
    JLabel dummyLabelW = new JLabel();
    JLabel dummyLabelE = new JLabel();
    JLabel dummyLabelS = new JLabel();

    NewWindow()
    {
        //Label config:
        label.setPreferredSize(new Dimension(250, 100));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(null, Font.BOLD,50));
        label.setBackground(Color.LIGHT_GRAY);
        label.setOpaque(true);

        //dummy Label config
        dummyLabelE.setPreferredSize(new Dimension(100, 100));
        dummyLabelN.setPreferredSize(new Dimension(100, 100));
        dummyLabelW.setPreferredSize(new Dimension(100, 100));
        dummyLabelS.setPreferredSize(new Dimension(100, 100));

        //frame config:
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());

        

        frame.add(label, BorderLayout.CENTER);
        frame.add(dummyLabelN, BorderLayout.NORTH);
        frame.add(dummyLabelE, BorderLayout.EAST);
        frame.add(dummyLabelS, BorderLayout.SOUTH);
        frame.add(dummyLabelW, BorderLayout.WEST);


        frame.setVisible(true);
    }
}
