package GUI_Study;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ProgressBar
{
    private JFrame frame;
    private JPanel panel;
    private JProgressBar bar;

    public ProgressBar()
    {
        frame =  new JFrame("Progress Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(700, 600);

        panel = new JPanel(new BorderLayout());
        Border border = BorderFactory.createEmptyBorder(100, 100, 100, 100);
        panel.setBorder(border);
        panel.setBackground(Color.lightGray);

        bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        bar.setBackground(Color.DARK_GRAY);
        bar.setFont(new Font(null, Font.BOLD, 25));
        bar.setForeground(new Color(123, 214, 101));
        bar.setStringPainted(true);

        panel.add(bar, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);

        fill();
    }

    public void fill()
    {
        int counter = 0;

        while(counter <= 100)
        {
            bar.setValue(counter); //fill the bar with values

            try 
            {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }

            counter += 1;
        }

        bar.setString("Finish Uploading Virus");
    }

    public static void main(String[] args) 
    {
        ProgressBar GUI = new ProgressBar();
    }
}
