package HowToNewWindow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener
{
    private JFrame frame = new JFrame();
    private JButton myButton = new JButton("New Window");

    LaunchPage()
    {
        //button configurations:
        myButton.setBounds(100, 160, 200, 40);
        myButton.setHorizontalAlignment(SwingConstants.CENTER);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        //frame configurations:
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(null);

        frame.add(myButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        NewWindow window;
        if(e.getSource() == myButton) 
        {   
            frame.dispose(); //exits the launchpage
            window = new NewWindow(); //open new window
        }
    }   
}
