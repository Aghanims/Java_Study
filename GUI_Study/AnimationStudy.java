import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationStudy  extends JFrame
{
    private ThePanel panel = new ThePanel();

    public AnimationStudy()
    {
        this.setTitle("Animation Study");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private static class ThePanel extends JPanel implements ActionListener
    {
        final int WIDTH = 800;
        final int HEIGHT = 600;
        Image ghost;
        Timer timer;

        int xVelocity = 2;
        int yVelocity = 2;

        int x = 0;
        int y = 0;

        public ThePanel()
        {
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setBackground(Color.BLACK);
            
            ghost = new ImageIcon("D:\\Coding\\Richmond_Java\\src\\GUI_Study\\images\\Ghost Emoji.png").getImage();
            Image theReplaced = ghost; //resize the image
            Image newImage = theReplaced.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ghost = newImage;

            timer = new Timer(10, this);
            timer.start();

            
        }

        public void paint(Graphics g) 
        {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(ghost, x, y, null);
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if((x >= WIDTH - ghost.getWidth(null)) || x < 0)
                xVelocity = -xVelocity;
            
            if(y >= HEIGHT - ghost.getHeight(null) || y < 0) 
                yVelocity = -yVelocity;
            
            x = x + xVelocity;
            y = y + yVelocity;
            
            repaint();
        }
    }

    public static void main(String[] args) 
    {
        new AnimationStudy();
    }
}
