package TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheFrame extends JFrame implements ActionListener
{
    private JButton button = new JButton("Enter");
    private JTextField textField = new JTextField();

    public TheFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //button
        button.addActionListener(this);

        //textField
        textField.setFont(new Font(null, Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(250, 30));
        textField.setText("Username");
        //textField.setEditable(true); //can provide or deny access for textfield to be edited
        //textField.setCaretColor(Color.BLUE); //color of the blinking cursor
        
        this.add(textField);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == button) 
        {
            System.out.println("Hello " + textField.getText());
            this.dispose();
        }
    }
}
