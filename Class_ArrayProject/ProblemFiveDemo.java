package Class_ArrayProject;

public class ProblemFiveDemo 
{
    public static void main(String[] args)
    {
        ProblemFive twoDArray = new ProblemFive(10, 10);

        seeChart(twoDArray.getArray());

        System.out.println("Total values is: ");
        System.out.println(twoDArray.getTotal(twoDArray.getArray()));

        System.out.println("Average of all values");
        System.out.println(twoDArray.getAverage(twoDArray.getArray()));

        System.out.println("Total value of row #4:");
        System.out.println(twoDArray.getRowTotal(twoDArray.getArray(), 4));

        System.out.println("Total value of column #6");
        System.out.println(twoDArray.getColumnTotal(twoDArray.getArray(), 6));

        System.out.println("Highest in row #5");
        System.out.println(twoDArray.getHighestInRow(twoDArray.getArray(), 5));

        System.out.println("Lowest in row #7");
        System.out.println(twoDArray.getlowestInRow(twoDArray.getArray(), 7));
        
    }

    public static void seeChart(int[][] array)
    {
        for(int row = 0; row < array.length; row++)
        {
            for(int column = 0; column < array[row].length; column++)
            {
                int randomNum = (int)(Math.random() * 50); // assign random number
                array[row][column] = randomNum;
                System.out.print(array[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
