package DataStructures.SelfStudy.Problems;

public class NumOfIslands 
{
    /*
        Given an m x n 2d binary grid, which represents a map of 1's(land) and 0's(water),
        return the number of islands. An island is surrounded by water and is formed by connecting
        adjacent lands horizontally or vertically. You may assume all four edges of the grid are  all surrounded by water.
    */  
    
    public static int numOfIsland(int[][] matrix)
    {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int islandCounter = 0;
        boolean[][] visitor = new boolean[rowLength][columnLength];
        
        for(int row = 0; row < rowLength; row++)
        {
            for(int column = 0; column < columnLength; column++)
            {
                if(!visitor[row][column] && matrix[row][column] == 1)
                {
                    numOfIslandUtil(matrix, visitor, row, column);
                    islandCounter++;
                }
            }
        }
        return islandCounter;
    }   

    private static void numOfIslandUtil(int[][] matrix, boolean[][] visitor, int row, int column)
    {
        if(row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length ||
            visitor[row][column] || matrix[row][column] == 0)
        {
            return;
        }

        visitor[row][column] = true;

        numOfIslandUtil(matrix, visitor, row - 1, column); // go top
        numOfIslandUtil(matrix, visitor, row + 1, column); //go down
        numOfIslandUtil(matrix, visitor, row, column + 1); //go right
        numOfIslandUtil(matrix, visitor, row, column - 1); //go left
    }


/********************************************************************************* */
    public static void main(String[] args) 
    {
        //generate matirx
        int[][] matrix = new int[10][10];

        System.out.println("Island and water representation: (1 = land) (0 = water)");
        for(int row = 0; row < matrix.length; row++)
        {
            for(int column = 0; column < matrix[row].length; column++)
            {
                double randomNum = Math.random();
                matrix[row][column] = (int)Math.round(randomNum);

                System.out.printf("%5s", matrix[row][column]);
            }
            System.out.println();
        }

        System.out.println("Number of Islands: " + numOfIsland(matrix));
    }
}
