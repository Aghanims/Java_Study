package GUI_Study;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectFile extends JFrame implements ActionListener
{
    private JButton button = new JButton("Select a File");
    private JPanel panel = new JPanel();

    public SelectFile()
    {
        this.setTitle("File Chooser");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLayout(new BorderLayout());

        panel = new JPanel(new BorderLayout());
        Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);
        panel.setBorder(padding);

        button.setFocusable(false);
        button.addActionListener(this);
     
        panel.add(button, BorderLayout.CENTER);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == button)
        {
            //JFileChooser -> GUI mechanism that allows the user to choose a file.
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("D:\\Coding\\Richmond_Java\\src\\GUI_Study"));

            //select file to open
            int response = fileChooser.showOpenDialog(null); 

            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }

    public static void main(String[] args) 
    {
        SelectFile GUI = new SelectFile();   
    }
}
