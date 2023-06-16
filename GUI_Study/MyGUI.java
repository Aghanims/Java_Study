import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyGUI implements ActionListener
{    
    JButton button;
    JLabel label;

    public MyGUI()
    {
        //component instances:
        JFrame frame = new JFrame(); //Frame -> a GUI window to add components to.
        label = new JLabel(); //JLabel -> A GUI display area for String of text, an image, or both.
        button = new JButton(); //JButton -> creates a button that initiates an action
        //JPanel -> A GUI component that functions as a container to hold other components.
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        //optional component(s)
        Border border = BorderFactory.createLineBorder(new Color(58, 45, 196), 3, true); 

        //Images to be used:
        ImageIcon logo = new ImageIcon("D:\\Coding\\Richmond_Java\\src\\GUI_Study\\images\\logo.jpg");
        ImageIcon icon = new ImageIcon("D:\\Coding\\Richmond_Java\\src\\GUI_Study\\images\\logo.jpg");

        //resizing image(s):
        Image theReplaced = icon.getImage(); //resize the image
        Image newImage = theReplaced.getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);

        //label configurations:
        label.setText("Hello World!!! Cheers!");
        label.setBounds(55, 60, 150, 90); //set xy coordinates of label and its boudary size --- alternative for horiz & vert alignments
        //label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text on either LEFT, CENTER, or RIGHT within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text on either TOP, CENTER, or BOTTOM within label
        //label.setIcon(icon);
        //label.setHorizontalTextPosition(JLabel.CENTER); //set text either LEFT, CENTER, or RIGHT of image icon
        //label.setVerticalTextPosition(JLabel.CENTER); //set text either TOP, CENTER, or BOTTOM of image icon
        label.setForeground(new Color(60, 65, 222)); ///change text color
        label.setFont(new Font("Josefin Sans", Font.BOLD, 12)); //set font of text
        //label.setIconTextGap(10); //set a gap between the text and image
        label.setBackground(new Color(219, 219, 219)); //set background color of label
        label.setOpaque(true); // display background color of label
        //label.setBorder(border); 
        label.setVisible(false);

        //Left panel configurations:
        leftPanel.setBackground(new Color(230, 175, 80));
        leftPanel.setBounds(30, 20, 250, 250);
        leftPanel.setLayout(null); //null needs to be used for setBounds(), can use: new BorderLayout()


        //Right Panel configurations:
        rightPanel.setBackground(new Color(230, 175, 80));
        rightPanel.setBounds(400, 20, 250, 250);
        rightPanel.setLayout(null);

        //Bottom Panel configurations:
        bottomPanel.setBackground(new Color(230, 175, 80));
        bottomPanel.setBounds(100, 290, 500, 250);
        bottomPanel.setLayout(null);

        //Button configuration:
        button.addActionListener(this); //the function when the button is clicked
        button.setBounds(200, 100, 100, 50);
        button.setText("Click Me");
        button.setFocusable(false); // remove the border of the text
        button.setBackground(Color.LIGHT_GRAY);
        button.setBorder(BorderFactory.createCompoundBorder());

        //frame configurations:
        frame.setTitle("My first Frame"); //sets frame title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits out of the application
        //frame.setResizable(false); //prevent frame frome being resized
        frame.setSize(700, 600); //sets x and y dimensions in bytes
        frame.setLayout(null);
        frame.setVisible(true); //make frame visible
        frame.setIconImage(logo.getImage()); //change icon of frame
        frame.getContentPane().setBackground(new Color(219, 161, 60)); //change background color of entire frame

        //adding the components inside the frame:
        rightPanel.add(label);
        bottomPanel.add(button);
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.add(bottomPanel);
        frame.add(bottomPanel);
    
        
        //frame.pack(); //Alternative for setSize(width, height);
    } 

    
    private int counter = 1;
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == button)
            System.out.println("Cheers!");
        
        if(counter == 5)
        {
            button.setEnabled(false); //button can only be clicked 5 times
            label.setVisible(true); //make the label appear after 5 clicks
        }

        counter++;
    }

    public static void main(String[] args)
    {
       MyGUI test = new MyGUI();
    }
}
