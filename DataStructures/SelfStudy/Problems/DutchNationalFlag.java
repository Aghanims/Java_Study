package DataStructures.SelfStudy.Problems;

import java.util.Arrays;

public class DutchNationalFlag 
{
    
    /*
        Given an array containing only 0's, 1's, and 2's, Sort the array
        in linear time and constant space
     */

    private static void swapUtil(int[] array, int n, int m)
    {
        int temp = array[n];
        array[n] = array[m];
        array[m] = temp;
    }
    
    public static void sort(int[] array)
    {
        int j = 0;
        int mainIterator = 0;
        int k = array.length -1; 

        while(mainIterator <= k)
        {
            if(array[mainIterator] == 0) //swap i and mainIterator because 0's should be place in front 
            {
                swapUtil(array, j, mainIterator);
                j++;
                mainIterator++;
            }
            else if(array[mainIterator] == 1) //1's are placed in the middle, so no swap are needed
            {
                mainIterator++;
            }
            else //2's are at the end, so mainIterator and k are needed to be swapped
            {
                swapUtil(array, mainIterator, k);
                k--;
            }
        }
    }

/**************************************************************** */
    public static void main(String[] args) 
    {
        int[] test = {0, 1, 0, 2, 2, 1, 0, 0, 2, 2, 1, 0};

        System.out.println("Orignal array: " + Arrays.toString(test));
        sort(test);
        System.out.println("Sorted array: " + Arrays.toString(test));
    }
}
