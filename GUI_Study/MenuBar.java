import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBar extends JFrame implements ActionListener
{
    private JMenuBar menuBar;
    private JMenuItem loadItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;
    
    
    public MenuBar()
    {
        this.setTitle("Menu Bar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLayout(new FlowLayout());

        //MenuBar
        menuBar = new JMenuBar();

        //Menu tabs
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt + f 

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E); // alt + e

        JMenu helpMenu = new JMenu("Help"); 
        helpMenu.setMnemonic(KeyEvent.VK_H); //alt + h

        //menu tab contents
        loadItem = new JMenuItem("Load");
        loadItem.setMnemonic(KeyEvent.VK_L); // l for load
        loadItem.addActionListener(this);
   

        saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S); //s for save
        saveItem.addActionListener(this);

        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_E); // e for exit
        exitItem.addActionListener(this);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == loadItem)
            System.out.println("Loading Item");
        
        if(e.getSource() == saveItem)
            System.out.println("File Saved");

        if(e.getSource() == exitItem)
            System.exit(0);
    }

    public static void main(String[] args) 
    {
        MenuBar GUI = new MenuBar();
    }

}
