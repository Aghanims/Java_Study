package GUI_Study.DragAndDrop;

import javax.swing.JFrame;

public class TheFrame extends JFrame
{
    DragPanel dragPanel = new DragPanel();

    public TheFrame()
    {
        this.setTitle("Drag & Drop");   
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        this.add(dragPanel);
        this.setVisible(true);
    }
}
