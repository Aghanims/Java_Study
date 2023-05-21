package DataStructures.SelfStudy.Problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray 
{

    /* 
        Example 
            input: nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4} 
            output: 5, nums = {0, 1, 2, 3, 4, -1, -1, -1, -1, -1}

        explanation: Function should return k =5, with the first five elements of nums being
                    0, 1, 2, 3, and 4 repectively.
    */
    public static int removeDuplicates(int[] array)
    {
        if(array.length == 0) {return 0;}

        int addIndex = 1; //index for unique elements that are need to be placed in front

        //iterate only up to "< array.length - 1 " because we are comparing the i and (i+1) indices
        for(int i = 0; i < array.length - 1; i++)
        {
            if(array[i] < array[i + 1])
            {
                array[addIndex] = array[i + 1];
                addIndex++;
            }
        }
        
        //index for populating -1 to elements after all unique elements
        int startIndex = addIndex;
        for(int i = startIndex; i < array.length; i++)
            array[i] = -1;

        return addIndex;
    }


/********************************************************************************************************/
    public static void main(String[] args) 
    {
        int[] test = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("Original array: " + Arrays.toString(test));
        System.out.println("Total of unique numbers: " + removeDuplicates(test) );
        System.out.println(Arrays.toString(test));
    }
}
