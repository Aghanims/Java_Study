package DataStructures.SelfStudy;

import java.util.Arrays;
import java.util.HashSet;


public class CSS223Project 
{

    public static boolean isSubset(int[] array, int[] arrayBeingCompared)
    {
        //case when either subsetA and subsetB is empty
        if(array.length == 0)
            return true;  
        
        HashSet<Integer> temp = new HashSet<>();

        for(int value : arrayBeingCompared)
        {   
            temp.add(value); //store substB in a set
        }

        for(int i = 0; i < array.length; i++)
        {
            int valueToFind = array[i];

            if(!temp.contains(valueToFind))
                return false;
        }
        
        return true;
    }

    public static void printResult(int[] arrayA, int[] arrayB)
    {
        System.out.println(Arrays.toString(arrayA) + " is a subset of " + Arrays.toString(arrayB) + ": "); 
        System.out.println("--> " + isSubset(arrayA, arrayB));
    }


    public static void main(String[] args) 
    {
        int[] subsetA = {4, 2, 10, 5};
        int[] subsetB = {4, 10, 18, 25, 2, 32, 5, 14};
        printResult(subsetA, subsetB);

        int[] secondArrayA = {5, 6, 5, 8, 2, 22, 6, 24};
        int[] secondArrayB = {5, 6, 2, 22, 6};
        printResult(secondArrayA, secondArrayB);

        int[] thirdArrayA = {};
        int[] thirdArrayB = {5, 2, 22, 6, 27};
        printResult(thirdArrayA, thirdArrayB);
    }
}
