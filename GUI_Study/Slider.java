package GUI_Study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider  implements ChangeListener
{
    JFrame frame;
    JPanel panel;
    JLabel celsiusLabel;
    JLabel farenLabel;
    JSlider slider;

    public Slider()
    {

        frame = new JFrame("Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);

        panel = new JPanel(new BorderLayout());
        Border border = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        panel.setBorder(border);


        slider = new JSlider(SwingConstants.VERTICAL ,-1000, 1000, 0);
        //slider.setPreferredSize(new Dimension(900, 200));
        slider.setFont(new Font(null, Font.PLAIN, 15));
        slider.setBackground(Color.lightGray);
        slider.addChangeListener(this);

        // slider.setPaintTicks(true);
        // slider.setMinorTickSpacing(100);

        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(200);

        slider.setPaintLabels(true);

        //label for celsius
        celsiusLabel = new JLabel(slider.getValue() + " \u00B0C");
        celsiusLabel.setFont(new Font(null, Font.PLAIN, 50));
        celsiusLabel.setHorizontalAlignment(JLabel.CENTER);

        //label for farehnheit
        double inFaren = (slider.getValue() * 1.8) + 32;
        farenLabel = new JLabel((int)inFaren + " \u00B0C");
        farenLabel.setFont(new Font(null, Font.PLAIN, 50));
        farenLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(slider, BorderLayout.CENTER);
        panel.add(celsiusLabel, BorderLayout.NORTH);
        panel.add(farenLabel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) 
    {
       celsiusLabel.setText(slider.getValue() + " \u00B0C");

       double inFaren = (slider.getValue() * 1.8) + 32;
       farenLabel.setText((int)inFaren + " \u00B0C");
    }    


    public static void main(String[] args) 
    {
        Slider GUI = new Slider();
    }
}
