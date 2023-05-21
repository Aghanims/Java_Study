package DataStructures.SelfStudy.Problems;

import java.util.Arrays;

public class SquaresOfSortedArray 
{
    /*
        Given an integer array sorted in ascending order, return an array
        of the squares of eacah number sorted in ascending order
     */

    public static int[] squareElements(int[] array)
    {
        int[] resultArray = new int[array.length];

        int startIterator = 0;
        int endIterator = array.length - 1;

        for(int i = array.length - 1; i >= 0; i--)
        {
            if(Math.abs(array[startIterator]) > Math.abs(array[endIterator]))
            {
                resultArray[i] = array[startIterator] * array[startIterator];
                startIterator++;
            }
            else
            {
                resultArray[i] = array[endIterator] * array[endIterator];
                endIterator--;
            }
        }
        return resultArray;
    }


/******************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {-100, -9, -3, -1, 0, 3, 4, 6, 8, 10, 12};

        int[] result = squareElements(test);

        System.out.println("Original array: " + Arrays.toString(test));
        System.out.println("Squared array: " + Arrays.toString(result));
    }    
}
