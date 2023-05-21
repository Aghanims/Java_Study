package Class_ArrayProject;

//Array Operations
public class ProblemFive 
{
    private int[][] testData;

    public ProblemFive(int row, int column)
    {
        testData = new int[row][column];
    }

    public int getTotal(int[][] array)
    {
        int allSum = 0;
        for(int row = 0; row < array.length; row++)
        {   
            for(int column = 0; column < array[row].length; column++)
            {
                allSum = allSum + array[row][column];
            }
        }
        return allSum;
    }

    public int getAverage(int[][] array)
    {
        int allSum = 0; // will first add all of the values in the array
        int howManyElements = 0;
        for(int row = 0; row < array.length; row++)
        {
            for(int column = 0; column < array[row].length; column++ )
            {
                allSum = allSum + array[row][column];
                howManyElements++;  // this will count all of the elements of the 2d array 
            }
        }
        int average = allSum / (howManyElements);
        return average;       
    }

    public int getRowTotal(int[][] array, int whichRow)
    {
        int totalRowValues = 0;
            for(int column = 0; column < array[whichRow].length; column++)
            {
                totalRowValues = totalRowValues + array[whichRow-1][column];
            }
        return totalRowValues;
    }

    public int getColumnTotal(int[][] array, int whichColumn)
    {
        int totalColValues = 0;
        for(int row = 0; row < array.length; row++)
        {
            totalColValues  = totalColValues + array[row][whichColumn-1];
        }
        return totalColValues;
    }

    public int getHighestInRow(int[][] array, int whichRow)
    {
        int highesValue = array[whichRow][0];
        for(int index = 0; index < array[whichRow].length; index++)
        {
            if(highesValue < array[whichRow-1][index])
                highesValue = array[whichRow-1][index];
        }
        return highesValue;
    }

    public int getlowestInRow(int[][] array, int whichRow)
    {
        int lowestValue = array[whichRow][0];
        for(int index = 0; index < array[whichRow].length; index++)
        {
            if(lowestValue > array[whichRow-1][index])
                lowestValue = array[whichRow-1][index];
        }
        return lowestValue;
    }

    public int[][] getArray()
    {
        return testData;
    }
}
