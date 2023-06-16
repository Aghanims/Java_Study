package RadioButtonStudy;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheFrame extends JFrame implements ActionListener
{
    /*
        JRadioButton -> One or more buttons in a grouping in which only 1 may be selected per group.
    */

    JRadioButton choiceA;
    JRadioButton choiceB;
    JRadioButton choiceC;
    JRadioButton choiceD;
    
    public TheFrame()
    {
        this.setTitle("Radio Button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        Border border = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        panel.setBorder(border);

        //question label
        JLabel question = new JLabel("What is the outer most layer of the Earth");
        question.setFont(new Font(null, Font.BOLD, 15));

        //Radio Button
        choiceA = new JRadioButton("Mantle");
        choiceB = new JRadioButton("Inner Core");
        choiceC = new JRadioButton("Crust");
        choiceD = new JRadioButton("Outer Core");

        choiceA.setFocusable(false);
        choiceB.setFocusable(false);
        choiceC.setFocusable(false);
        choiceD.setFocusable(false);

        //so that user can only pick one choice
        ButtonGroup group = new ButtonGroup();
        group.add(choiceA);
        group.add(choiceB);
        group.add(choiceC);
        group.add(choiceD);

        choiceA.addActionListener(this);
        choiceB.addActionListener(this);
        choiceC.addActionListener(this);
        choiceD.addActionListener(this);

        panel.add(question);
        panel.add(choiceA);
        panel.add(choiceB);
        panel.add(choiceC);
        panel.add(choiceD);

        this.add(panel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() != choiceC)    
            System.out.println("Wrong answer\nCorrect answer: Crust");
        else 
            System.out.println("Correct answer");

        choiceA.setEnabled(false);
        choiceB.setEnabled(false);
        choiceC.setEnabled(false);
        choiceD.setEnabled(false);
    }


    public static void main(String[] args) 
    {
        TheFrame frame = new TheFrame();
    }
}
