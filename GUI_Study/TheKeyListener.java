import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;


public class TheKeyListener extends JFrame implements KeyListener
{
    JLabel label;
    
    public TheKeyListener()
    {
        this.setTitle("Key Listener");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\Coding\\Richmond_Java\\src\\GUI_Study\\images\\Ghost Emoji.png");
        Image theReplaced = icon.getImage(); //resize the image
        Image newImage = theReplaced.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setIcon(icon);

        this.addKeyListener(this);
       
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        //keyTyped -> Invoked whe a key is typed. Uses KeyChar, char output

        switch(e.getKeyChar())
        {
            case 'a':
                label.setLocation(label.getX() - 5, label.getY()); //shift to the left;
                break;
            case 'w':
                label.setLocation(label.getX(), label.getY() - 5); //shift upward
                break;
            case 's':
                label.setLocation(label.getX(), label.getY() + 5);
                break;
            case 'd':
                label.setLocation(label.getX() + 5, label.getY());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        //keyPressed -> Invoked when a key is typed. Uses KeyChar, char output
        // it will return '?' when printed
        switch(e.getKeyCode())
        {
            case 37:
                label.setLocation(label.getX() - 5, label.getY()); //shift to the left;
                break;
            case 38:
                label.setLocation(label.getX(), label.getY() - 5); //shift upward
                break;
            case 40:
                label.setLocation(label.getX(), label.getY() + 5);
                break;
            case 39:
                label.setLocation(label.getX() + 5, label.getY());
                break;
        }

      
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        //keyReleased -> called whenever a button is released.
        System.out.println("You released '" + e.getKeyChar() + "' char; with key code = " + e.getKeyCode());
    }


    public static void main(String[] args) 
    {
        TheKeyListener GUI = new TheKeyListener();
    }
}
