package TicTacToe_Game;

import java.awt.GridLayout;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainGameComponent extends JPanel
{   
    private Random random = new Random();
    private JButton[] buttons = new JButton[9];
    private boolean player_turn;

    // X win -> 0 ; O Win -> 1
    private int whoWins = -1;

    public MainGameComponent()
    {
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(new Color(150, 150, 150));

        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font(null, Font.BOLD, 120));
            buttons[i].setFocusable(false);

            this.add(buttons[i]);
        }

        firstTurn();
    }


    public JButton getButton(int index)
    {
        return buttons[index];
    }

    public boolean getPlayerTurn()
    {
        return player_turn;
    }

    public void setPlayerTurn(boolean value)
    {
        player_turn = value;
    }

    //PvP
    public boolean firstTurn()
    {
        // 0 is player_1's turn, 1 is player__2's turn
        boolean turn;

        if(random.nextInt(2) == 0)
        {
            //player x
            player_turn = true;
            turn = true;
        }
        else 
        {
            player_turn = false;
            turn = false;
        }

        return turn;
    }

    public void checkXWinCondition()
    {
        //by Row
        if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X"))
            xWins(0, 1, 2);
        
        if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X"))
            xWins(3, 4, 5); 
        
        if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X"))
            xWins(6, 7, 8);           

        // by Column
        if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X"))
            xWins(0, 3, 6); 
           
        if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X"))
            xWins(1, 4, 7);
        
        if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X"))
            xWins(2, 5, 8);
            
        // by Diagonal
        if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X"))     
            xWins(0, 4, 8);                  
        
        if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X"))        
            xWins(2, 4, 6);       
    }   

    public void checkOWinCondition()
    {
        //by Row
        if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O"))      
            oWins(0, 1, 2);       

        if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O"))
            oWins(3, 4, 5);     
        
        if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O"))    
            oWins(6, 7, 8);
        
        // by Column
        if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O"))      
            oWins(0, 3, 6);    

        if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O"))       
            oWins(1, 4, 7);      
        
        if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O"))       
            oWins(2, 5, 8);     
        
        // by Diagonall
        if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O"))      
            oWins(0, 4, 8);
              
        if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O"))      
            oWins(2, 4, 6);   
    }
    

    //highlight all buttons that triggered win condition
    public void xWins(int x, int y, int z)
    {
        buttons[x].setBackground(new Color(230, 28, 30));
        buttons[y].setBackground(new Color(230, 28, 30));
        buttons[z].setBackground(new Color(230, 28, 30));

        disableButtons();
        whoWins = 0;
    }

    public void oWins(int x, int y, int z)
    {
        buttons[x].setBackground(new Color(45, 54, 229));
        buttons[y].setBackground(new Color(45, 54, 229));
        buttons[z].setBackground(new Color(45, 54, 229));

        whoWins = 1;
        disableButtons();
    }

    public int getWinner()
    {
        return whoWins;
    }

    private void disableButtons()
    {
        for(int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
    }
}
