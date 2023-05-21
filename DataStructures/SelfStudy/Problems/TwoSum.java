package DataStructures.SelfStudy.Problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum 
{
    /*
        TasK: Given an array of Integers, return indices of the two numbers such that they add up 
        to a specific target.
        
        Example: target = 9
            input : array = {2, 11, 5, 10, 7, 8}
            outpupt: array = {0, 4}
     */

    public static int[] twoSumOfTargetMap(int[] array, int target)
    {
        int[] indexOfSum = new int[2];

        HashMap<Integer, Integer> container = new HashMap<>();

        for(int i = 0; i < array.length; i++)
        {
            int complimentNum = target - array[i]; //example: 9 - 7 = 2; 2 is compliment of seven because 7 + 2 = 9

            if(!container.containsKey(complimentNum))
                container.put(array[i], i);
            else
            {
                indexOfSum[0] = container.get(complimentNum);
                indexOfSum[1] = i;
                return indexOfSum;
            }
        }
        return new int[0];
    }

    public static int[] twoSumOfTargetTwoPointer(int[] array, int target)
    {
        Arrays.sort(array);

        int leftPointer = 0;
        int rightPointer = array.length - 1;

        int[] indicesOfSum = new int[2];

        while(leftPointer < rightPointer)
        {
           int leftAndRightSum = array[leftPointer] + array[rightPointer];

           if(leftAndRightSum == target) //value of left and right pointer is equals to target value
           {
                indicesOfSum[0] = array[leftPointer];
                indicesOfSum[1] = array[rightPointer];
                
                return indicesOfSum;
           }
           else if(leftAndRightSum > target)
                rightPointer--;
           else 
                leftPointer++;     
        }

        return new int[0]; //there could be possibility that there is no values equal to sum; then just return empty array
    }

/****************************************************************************** */
    public static void main(String[] args) 
    {
        int[] test = {2, 11, 5, 10, 7, 8};

        int[] result = twoSumOfTargetMap(test, 9);
        System.out.println("Indices of the values that add up to the target value 9 : " + Arrays.toString(result));
        System.out.println();
        int[] twoPointerResult = twoSumOfTargetTwoPointer(test, 9);
        System.out.println("values from the array that add up to 9 using two-pointer approach: " + Arrays.toString(twoPointerResult));
    }
}
