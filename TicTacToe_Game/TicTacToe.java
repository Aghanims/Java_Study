package TicTacToe_Game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener
{
    private JPanel title_panel = new JPanel();
    private JLabel textfield = new JLabel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private MainGameComponent ticTacToe = new MainGameComponent();
    private int occupiedCount = 0;


    public TicTacToe()
    {
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        //texfield
        textfield.setBackground(new Color(107, 80, 66));
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font(null, Font.BOLD, 55));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);
        textfield.setText("Tic-Tac-Toe");

        //title_panel
        title_panel.setLayout(new BorderLayout());

        //Player_turn_panel
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(new Color(230, 28, 30));
        JLabel playerXIdentify = new JLabel();
        playerXIdentify.setFont(new Font(null, Font.BOLD, 35));
        playerXIdentify.setText("Player X");

        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(new Color(45, 54, 229));
        JLabel playerOIdentify = new JLabel();
        playerOIdentify.setFont(new Font(null, Font.BOLD, 35));
        playerOIdentify.setText("Player O");

        leftPanel.add(playerXIdentify, BorderLayout.CENTER);
        rightPanel.add(playerOIdentify, BorderLayout.CENTER);

        // Add action listener to buttons
        for(int i = 0; i < 9; i++)
            ticTacToe.getButton(i).addActionListener(this);  

        title_panel.add(textfield);
        this.add(ticTacToe, BorderLayout.CENTER);
        this.add(title_panel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        occupiedCount++;
        //asign X and O values to clicked buttons
        for(int i = 0; i < 9; i++)
        {
            if(e.getSource() == ticTacToe.getButton(i))
            {
                // X 
                if(ticTacToe.getPlayerTurn() == true)
                {
                    if(ticTacToe.getButton(i).getText() == "")
                    {
                        ticTacToe.getButton(i).setText("X");
                        ticTacToe.getButton(i).setForeground(new Color(230, 28, 30));
                    }
                    ticTacToe.setPlayerTurn(false);
                    leftPanel.setBackground(new Color(230, 99, 89));
                    rightPanel.setBackground(new Color(45, 54, 229));

                    ticTacToe.checkXWinCondition();        
                    if(ticTacToe.getWinner() == 0)
                    {
                        textfield.setText("X Wins!!!");
                        textfield.setFont(new Font(null, Font.BOLD, 75));
                    }
                    else if((occupiedCount == 9) && (ticTacToe.getWinner() == -1))         
                    {  
                        textfield.setText("Draw!!!");     
                        textfield.setFont(new Font(null, Font.BOLD, 75)); 
                    }             
                }
                else 
                {
                    // O
                    if(ticTacToe.getButton(i).getText() == "")
                    {
                        ticTacToe.getButton(i).setText("O");
                        ticTacToe.getButton(i).setForeground(new Color(45, 54, 229));
                    }

                    ticTacToe.setPlayerTurn(true);
                    rightPanel.setBackground(new Color(119, 130, 230));
                    leftPanel.setBackground(new Color(230, 28, 30));

                    ticTacToe.checkOWinCondition();          

                    if(ticTacToe.getWinner() == 1)
                    {
                        textfield.setText("O Wins!!!");
                        textfield.setFont(new Font(null, Font.BOLD, 75));
                    }
                    else if((occupiedCount == 9) && (ticTacToe.getWinner() == -1))
                    {
                        textfield.setText("Draw!!!");
                        textfield.setFont(new Font(null, Font.BOLD, 75));
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        boolean whoseTurn = ticTacToe.firstTurn();

        if(whoseTurn == true)
            rightPanel.setBackground(new Color(119, 130, 230));
        else 
            leftPanel.setBackground(new Color(230, 99, 89));
    }

    
}
