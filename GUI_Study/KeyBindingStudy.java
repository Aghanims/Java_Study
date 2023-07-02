
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class KeyBindingStudy 
{
    /*
        Key Bindings -> * bind an Action to a KeyStroke 
                        * don't require to click a component to give it focus
                        * all Swing components use Key Bindings
                        * increased flexibility compared to KeyListener
                        * can assign key strokes to individual Swing components
                        * more difficult to utilize and set up
    */
    
    private JFrame frame;
    private JLabel label;

    private Action upAction;
    private Action downAction;
    private Action lefAction;
    private Action rightAction;

    public KeyBindingStudy()
    {
        //frame
        frame = new JFrame("Key Binding Study");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(null);

        //label
        ImageIcon icon = new ImageIcon("D:\\Coding\\Richmond_Java\\src\\GUI_Study\\images\\Ghost Emoji.png");
        Image theReplaced = icon.getImage(); //resize the image
        Image newImage = theReplaced.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);

        label = new JLabel();
        label.setIcon(icon);
        label.setBounds(100, 100, 100, 100);

        //actions
        upAction = new UpAction();
        downAction = new DownAction();
        lefAction = new LeftAction();
        rightAction = new RightAction();

        //add keystrokes to key events
        //for upAction
        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        label.getActionMap().put("upAction", upAction);

        //for downAction
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        label.getActionMap().put("downAction", downAction);

        //for rightAction
        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        label.getActionMap().put("rightAction", rightAction);

        //for leftAction
        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        label.getActionMap().put("leftAction", lefAction);

        //adding components to frame
        frame.add(label);
        frame.setVisible(true);
    }

    private class UpAction extends AbstractAction
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            label.setLocation(label.getX(), label.getY() - 10);
        }    
    }

    private class DownAction extends AbstractAction
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            label.setLocation(label.getX(), label.getY() + 10);
        }
    }

    private class RightAction extends AbstractAction
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            label.setLocation(label.getX() + 10, label.getY());
        }
    }

    private class LeftAction extends AbstractAction
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            label.setLocation(label.getX() - 10, label.getY());
        }
    }

/********************************************************************************************** */
    public static void main(String[] args) 
    {
        new KeyBindingStudy();
    }
}
