
import javax.swing.*;
import java.awt.*;

public class TwoDGraphics extends JFrame
{
    public TwoDGraphics()
    {
        this.setTitle("2D Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ThePanel panel = new ThePanel();

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static class ThePanel extends JPanel 
    {
        public ThePanel()
        {   
            this.setPreferredSize(new Dimension(700, 600));
        }

        public void paint(Graphics g)
        {
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(10));

            //note: it will overlap

            //g2D.drawLine(0, 0, 700, 600);
            g2D.setPaint(Color.MAGENTA);
            g2D.fillRect(50, 50, 300, 500);

            g2D.setPaint(Color.PINK);
            g2D.drawRect(100, 100, 400, 400);

            g2D.setPaint(Color.RED);
            g2D.drawOval(135, 120, 320, 330);

            g2D.setPaint(Color.BLUE);
            int[] xPoints = {180, 300, 410};
            int[] yPoints = {380, 150, 380};
            g2D.fillPolygon(xPoints, yPoints, 3);
        }
    }

//***************************************************************
    public static void main(String[] args) 
    {
        new TwoDGraphics();
    }
}
