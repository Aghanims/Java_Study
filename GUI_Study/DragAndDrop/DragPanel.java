package GUI_Study.DragAndDrop;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel
{
    ImageIcon icon = new ImageIcon("D:\\Coding\\Richmond_Java\\src\\GUI_Study\\DragAndDrop\\LookinGood.png");
    final int WIDTH = icon.getIconWidth();
    final int HEIGHT = icon.getIconHeight();
    Point imageCorner;
    Point prevPoint;

    public DragPanel()
    {
        imageCorner = new Point(0, 0);

        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();

        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        icon.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            prevPoint = e.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point currentPoint = e.getPoint();
            imageCorner.translate((int)(currentPoint.getX() - prevPoint.getX()), (int)(currentPoint.getY() - prevPoint.getY()));
            prevPoint = currentPoint;
            repaint();
        }
    }
}
