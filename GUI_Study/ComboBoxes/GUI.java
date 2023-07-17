package GUI_Study.ComboBoxes;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
    private JComboBox<String> comboBox;
    private JPanel panel;

    public GUI()
    {
        this.setTitle("Combo Box");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //serves as a padding
        Border border = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBorder(border);

        //Combo Box
        String[] animal = {"Dog", "Cat", "Bird"};
        comboBox = new JComboBox<>(animal);

        //some combo box functions:
        comboBox.setEditable(false);
        //comboBox.getItemCount();
        //comboBox.insertItemAt("Gorilla", 2);
        //comboBox.insertItemAt("Gorilla", 1);
        comboBox.setSelectedIndex(1);
        //comboBox.removeItem("Dog");
        //comboBox.removeItemAt(1);
        //comboBox.removeAllItems();
        comboBox.addActionListener(this);

        
        panel.add((comboBox));
        this.add(panel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == comboBox)
        {
            System.out.println(comboBox.getSelectedItem());
            comboBox.setEnabled(false);
        }
    }  
    
}
