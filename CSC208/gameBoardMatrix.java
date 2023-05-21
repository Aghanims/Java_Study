package CSC208;

import java.util.Random;

public class gameBoardMatrix 
{
    /*
    Create the representation of a room in a game as a matrix.

    Read the length and width of the room as two integers. We will have "width" rows and "length" columns in the matrix.

    Around the room there is a wall marked with '#'. In the room there is one exit marked with 'E' randomly placed. 
    Also in the room there is a player marked with 'O'. Empty spaces are marked with '.'

    Read a number of obstacles (bricks '#') and place the obstacles, as many as the given number, in the matrix. 
    Check that your number is not too big compared with the length and width 
    (i.e. less or equal with .2 * (length-2) * (width-2) ).

    Print the matrix with all required elements.
    */

    public static void generateGameBoard(int length, int width, int numOfObstacles)
    {  
        //matrix for the game board
        char[][] gameBoard = new char[width][length];
        
        // fill the array with empty "#" (wall) and "." (empty spaces)
        for (int i = 0; i < width; i++) 
        {
            for (int j = 0; j < length; j++) 
            {
                if (i == 0 || i == width-1 || j == 0 || j == length-1) 
                    gameBoard[i][j] = '#'; // Walls
                else
                    gameBoard[i][j] = '.'; // Empty spaces    
            }
        }
        
        //random.nextInt(int n) ... generates random number between 0(inclusive) to n(exclusive)
        // generate 2 random numbers and assign them to a coordinate for room[rand_1][rand_2]
        Random random = new Random();
        int rand_1 = random.nextInt(length-3) + 1;
        int rand_2 = random.nextInt(width-3) + 1;
        gameBoard[rand_1][rand_2] = 'E';
        
        // same for the Player's coordinate
        int pos_1 = random.nextInt(length-3) + 1;
        int pos_2 = random.nextInt(width-3) + 1;
        gameBoard[pos_1][pos_2] = 'O';
        
        // Add obstacles inside the gameBoard
        int maxObstacles = (int)(0.2 * (length-2) * (width-2));
        if(numOfObstacles > maxObstacles) 
            numOfObstacles = maxObstacles;
        
        for(int i = 0; i < numOfObstacles; i++) 
        {
            int obstacle1 = random.nextInt(length-2) + 1;
            int obstacle2 = random.nextInt(width-2) + 1;

            if(gameBoard[obstacle2][obstacle1] == '.') 
                gameBoard[obstacle2][obstacle1] = '#';
        }
        
        // Print game board matrix
        for(int i = 0; i < width; i++) 
        {
            for(int j = 0; j < length; j++) 
                System.out.print(gameBoard[i][j] + " ");

            System.out.println();
        }
    }

    /***************************************************************** */
    public static void main(String[] args) 
    {
        int length = 8;
        int width = 10;
        int numOfObstacles = 6;

      generateGameBoard(length, width, numOfObstacles);
    }
}
