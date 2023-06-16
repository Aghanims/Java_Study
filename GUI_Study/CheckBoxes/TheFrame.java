package CheckBoxes;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheFrame extends JFrame implements ActionListener
{
    private JButton button;
    private JCheckBox checkBox;

    public TheFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(this);

        //create checkbox
        checkBox = new JCheckBox("I'm not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font(null, Font.TYPE1_FONT, 20));

        //replace the checkbox with image
        //checkBox.setIcon("put icon here");
        //checkBox.setSelectedIcon("put icon here");

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == button && checkBox.isSelected())
            System.out.println("Hello Fellow Human");
        else if(e.getSource() == button)
            System.out.println("s!*&%$#!!...");

        button.setEnabled(false);
    }
}
