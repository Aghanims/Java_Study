package DataStructures.SelfStudy.Problems;

import java.util.HashSet;

public class ValidSudoku 
{
    /*
        Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated
        according to the following rules:

        1. Each column must contain the digits 1-9 without repetition.
        2. Each row must contain the digits 1-9 without repetition.
        3. Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without 
            repetition.
        
        Note: 
            * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
            * Only the filled cells need to be validated according to the maintain rules.
    */
    public static boolean isValid(String[][] board)
    {
        //divide the problem depending on the rules and focus first on checking the conditions on each rule
        int rowLength = board.length;
        int columnLength = board[0].length;

        HashSet<String> isRepeated = null;

        //check row if numbers are repeated
        for(int row = 0; row < rowLength; row++)
        {
            isRepeated = new HashSet<>();

            for(int column = 0; column < columnLength; column++)
            {
                String currentValue = board[row][column];

                if(currentValue.equals("."))
                    continue;
                
                if(isRepeated.contains(currentValue))
                    return false;
               
                isRepeated.add(currentValue);
            }
        }

        //check column if values are repeated
        for(int column = 0; column < columnLength; column++)
        {
            isRepeated = new HashSet<>();

            for(int row = 0; row < rowLength; row++)
            {
                String currentValue = board[row][column];

                if(currentValue.equals("."))
                    continue;

                if(isRepeated.contains(currentValue))   
                    return false;
                
                isRepeated.add(currentValue);
            }
        }

        //check 3x3 boxes of the grid if there is a value repeated.
        for(int row = 0; row < rowLength; row += 3)
        {
            for(int column = 0; column < columnLength; column += 3)
            {   
                boolean checkGrid = checkBlock(row, column, board);

                if(checkGrid == false)
                    return false;      
            }
        }

        return true;
    }

    //helper method for analyzing the 3x3 grid of the board
    private static boolean checkBlock(int rowIndex, int columnIndex, String[][] board)
    {
        HashSet<String> isRepeated = new HashSet<>();

        int rowLength = rowIndex + 3;
        int columnLength = columnIndex + 3;

        for(int row = rowIndex; row < rowLength; row++)
        {
            for(int column = columnIndex; column < columnLength; column++)
            {
                String currentValue = board[row][column];

                if(currentValue.equals("."))
                    continue;
                
                if(isRepeated.contains(currentValue))
                    return false;
                
                isRepeated.add(currentValue);
            }   
        }
        return true;
    }


/*******************************************************************************************/
    public static void main(String[] args) 
    {
        String[][] board = {{"5","3",".",".","7",".",".",".","."},
                            {"6",".",".","1","9","5",".",".","."},
                            {".","9","8",".",".",".",".","6","."},
                            {"8",".",".",".","6",".",".",".","3"},
                            {"4",".",".","8",".","3",".",".","1"},
                            {"7",".",".",".","2",".",".",".","6"},
                            {".","6",".",".",".",".","2","8","."},
                            {".",".",".","4","1","9",".",".","5"},
                            {".",".",".",".","8",".",".","7","9"}};

    System.out.println(isValid(board));


    }
}
        

