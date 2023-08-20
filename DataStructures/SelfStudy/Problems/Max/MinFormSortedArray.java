package DataStructures.SelfStudy.Problems.Max;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinFormSortedArray 
{
    /* 
        Given a sorted array of integers, rearrange array in such a way
        that the first position will have the largest number, the second
        will have the smallest, the third will have the second-largest, and so
        on. Using O(1) extra space.

        Ideal scenario: {Largest value, smallest value, second largest value, second smallest value, ... nth largest value, nth smallest value}
     */
    public static void maxMinRearrange(int[] array)
    {
        int maxIndex = array.length - 1;
        int minIndex = 0;

        int maxValue = array[maxIndex] + 1; //since maxIndex is movable maxValue is the main reference as the greater value.

        for(int i = 0; i < array.length; i++)
        {   
            //idea: generate a number that can extract value of the previous and current index.
            // where: x / maxValue --> is the previous index, and x % maxValue is the currentIndex

            //case 1: even indices must hold nth greater values
            if(i % 2 == 0)
            {//               to access the unmodified value of the previous element
                array[i] = array[i] + (array[maxIndex] % maxValue) * maxValue;
                maxIndex--;
            }
            else //case 2: odd indices must hold nth lesser value
            {
                array[i] = array[i] + (array[minIndex] % maxValue) * maxValue;
                minIndex++;
            }
        }

        for(int i = 0; i < array.length; i++)
        {
            array[i] = array[i] / maxValue; //get the intended value format by dividing to the maxValue
        }
    }

/********************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {4, 7, 10, 15, 78, 90, 200, 213, 600, 456, 698};

        System.out.println("Original array: " + Arrays.toString(test));
        maxMinRearrange(test);
        System.out.println("Array in Max/Min form: " + Arrays.toString(test));
    }     
}
