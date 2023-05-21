package DataStructures.SelfStudy.RecursionAndDynamicProgramming;

public class MaximumSubarraySum 
{
    /*
        Task: Given an array, find and print the elements of a contiguous subarray of numbers that has
        the largest sum: 
        
        Example: 
            Input: array =  [-2, -3, 4, -1, -2, 1, 5, -3]
            Output: array = [4, -1, -2, 1, 5]
     */

     public static void subArrayWithMaxSum(int[] array)
     {
        int EndIndex = 0; //variable to record end index of the subarray; to be used for printing the subarray later

        int currentMax = array[0];
        int globalMax = array[0];
        
        //iterate througout the array and add each index and store it on currentMax
        for(int i = 1; i < array.length; i++)
        {
            //add each index value to currentMax
            //Case: if value at "i" is greater than the combined value of the previous currentMax, then
            //      update currentMax to the value at 'i': this implies that it is the subarray to be ignored 

            currentMax = Math.max(array[i], array[i] + currentMax); //statement that decides to become part of the subArray

            if(currentMax > globalMax) //update globalMax
            {
                globalMax = currentMax;
                EndIndex = i; //end index of the subarray
            }
        }

        /****************************************** */
        //identifying start index of the subarray by subtracting global max until it equals 0
        int startIndex = EndIndex;

        while(startIndex >= 0) 
        {
            globalMax = globalMax - array[startIndex];

            if(globalMax == 0)
                break;
            
            startIndex--;
        }

        //acutal printing of the subarray
        for(int i = startIndex; i <= EndIndex; i++)
        {
            System.out.print(array[i] + " ");
        }


     }


/*************************************************************************8 */
    public static void main(String[] args) 
    {
        int[] test = {-2, -3, 4, -1, -2, 1, 5, -3};

        subArrayWithMaxSum(test);
    }
}
