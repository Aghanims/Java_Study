package DataStructures.SelfStudy.Problems;

import java.util.Arrays;

public class ProductOfAnArrayExceptSelf 
{
    /*
        Given an array of integers array[], return an array result[] such that result[i] is equal
        to the product of all the elements of array except array[i]. The product fits in 32-bit integer.
        The algorithm should run in O(n) time and without using division operator.

        Example: 
            input: array = {1, 2, 3, 4}
            output: result = {24, 12, 8, 6}
     */
    public static int[] productofArray(int[] array)
    {
        int[] result = new int[array.length];

        //approach: iterate and get the product of all preceeding elements and store it in the particular index
        //          iterate again and get all the product of all elements after the index.

        int placeHolder = 1; //variable to store in the first element since there is no element before it
        for(int i = 0; i < array.length; i++)
        {
            result[i] = placeHolder;
            placeHolder = placeHolder * array[i];
        }

        placeHolder = 1; //reset placeholder

        for(int i = array.length - 1; i >= 0; i--) //evaluate now the right side of the index
        {
            result[i] = result[i] * placeHolder;
            placeHolder = placeHolder * array[i];
        }

        return result;
    }

/************************************************************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {1, 2, 3, 4};
        int[] result = productofArray(test);

        System.out.println("Original array: " + Arrays.toString(test));
        System.out.println("Array of product of all elements of integer except self: " + Arrays.toString(result));
    }
}
