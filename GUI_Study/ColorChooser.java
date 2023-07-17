package GUI_Study;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooser extends JFrame implements ActionListener
{
    private JButton forForeGround;
    private JButton forBackGround;
    private JLabel label;
    
    public ColorChooser()
    {
        this.setTitle("Color Chooser");
        this.setLayout(new FlowLayout());

        forForeGround = new JButton("Change Foreground Color");
        forForeGround.setFocusable(false);
        forForeGround.addActionListener(this);

        forBackGround = new JButton("Change Background Color");
        forBackGround.setFocusable(false);
        forBackGround.addActionListener(this);

        JPanel buttonContainer = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonContainer.add(forForeGround);
        buttonContainer.add(forBackGround);
        

        label = new JLabel("Learning is Life Changing!");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font(null, Font.BOLD, 25));
        label.setPreferredSize(new Dimension(350, 150));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.DARK_GRAY);
        label.setOpaque(true);

        this.add(buttonContainer);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource() == forForeGround)
       {
            //JColorChooser colorChooser = new JColorChooser();
            Color foreGround = JColorChooser.showDialog(null, "Pick Color", Color.BLACK);
            label.setForeground(foreGround);
       }
       else if(e.getSource() == forBackGround)
       {
            Color backGround = JColorChooser.showDialog(null, "Pick Color", Color.BLACK);
            label.setBackground(backGround);
       }

    }

    public static void main(String[] args) 
    {
        ColorChooser GUI = new ColorChooser();
    }
}
