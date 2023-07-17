package GUI_Study;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerStudy  extends JFrame implements MouseListener
{
    private JLabel top;
    private JLabel bottom;
    private JLabel left;
    private JLabel right;
    private JLabel center;

    public MouseListenerStudy()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(700, 600);

        top = new JLabel("TOP");   
        top.setHorizontalAlignment(JLabel.CENTER);     
        top.setFont(new Font(null, Font.PLAIN, 45));
        top.setBackground(new Color(245, 157, 98));
        top.setOpaque(true);
        top.addMouseListener(this);

        bottom = new JLabel("BOTTOM");
        bottom.setHorizontalAlignment(JLabel.CENTER);
        bottom.setFont(new Font(null, Font.PLAIN, 45));
        bottom.setBackground(new Color(98, 237, 245));
        bottom.setOpaque(true);
        bottom.addMouseListener(this);

        left = new JLabel("LEFT");
        left.setHorizontalAlignment(JLabel.CENTER);
        left.setFont(new Font(null, Font.PLAIN, 45));
        left.setBackground(new Color(224, 245, 147));
        left.setOpaque(true);
        left.addMouseListener(this);

        right = new JLabel("RIGHT");
        right.setHorizontalAlignment(JLabel.CENTER);
        right.setFont(new Font(null, Font.PLAIN, 45));
        right.setBackground(new Color(199, 110, 245));
        right.setOpaque(true);
        right.addMouseListener(this);

        center = new JLabel("CENTER");
        center.setHorizontalAlignment(JLabel.CENTER);
        center.setFont(new Font(null, Font.PLAIN, 45));
        center.setBackground(new Color(245, 171, 122));
        center.setOpaque(true);
        center.addMouseListener(this);

        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(center, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        // Invoke when the mouse button has been clicked (pressed and released) on a component
        System.out.println("You clicked the mouse");
    
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        // Invoke when the mouse button has ben pressed on a component
        System.out.println("You pressed the mouse");
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        // Invoke when the mouse button has ben released on a component
        System.out.println("You released the mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        // Invoke when the mouse enters a component
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        // Invoke when the mouse exits a component
    }

    
    public static void main(String[] args) 
    {
        new MouseListenerStudy();
    }
}
