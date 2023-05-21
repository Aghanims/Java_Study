package DataStructures.SelfStudy.Problems;

public class MaximumSumSubArrayOfSizeK 
{
    /*
        Given an array of integers, there is a sliding window of size 'k' which is moving from the very 
        left of the array to the very right. Find the maximum sum of any contiguous subarray of size "k"

        Example:
            input: array = {2, 7, 3, 5, 8, 1} where k = 3
            output: 16

            because, window position:
                [2 7 3] 5 8 1  ; sum = 12
                2 [7 3 5] 8 1 ; sum = 15
                2 7 [3 5 8] 1  ; sum = 16 <--
                2 7 3 [5 8 1] ; sum = 15
    */
    public static int slidingWindowMaxSum(int[] array, int window)
    {
        int maxSum = 0;
        int subArraysum = 0;
        int startOfSubarray = 0;

        for(int endOfSubarray = 0; endOfSubarray < array.length; endOfSubarray++)
        {
            subArraysum = subArraysum + array[endOfSubarray];

            if(endOfSubarray >= window - 1)
            {
                maxSum = Math.max(maxSum, subArraysum);
                subArraysum = subArraysum - array[startOfSubarray];
                startOfSubarray++;
            }
        }
        return maxSum;
    }

    public static void slidingWindowElementsWithMaxSum(int[] array, int window)
    {
        int maxSum = 0;
        int subArraySum = 0;
        int endIndex = 0;

        int startOfSubarray = 0;
        for(int endOfSubarray = 0; endOfSubarray < array.length; endOfSubarray++)
        {
            subArraySum = subArraySum + array[endOfSubarray];

            if(endOfSubarray >= window - 1)
            {
                if(subArraySum > maxSum) //determine the last index of the subArray with highest value
                    endIndex = endOfSubarray;
                
                maxSum = Math.max(maxSum, subArraySum);
                
                subArraySum = subArraySum - array[startOfSubarray];
                startOfSubarray++;
            }
        }

        int startIndex = endIndex; //determine the first index of the subArray with max value
        while(maxSum >= 0)
        {
            maxSum = maxSum - array[startIndex];

            if(maxSum == 0)
                break;     

            startIndex--;
        }

        for(int i = startIndex; i <= endIndex; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

/**************************************************************************************************** */
    public static void main(String[] args) 
    {
        int[] test = {2, 7, 3, 5, 8, 1};

        int maxSumOfSubArray = slidingWindowMaxSum(test, 3);

        System.out.println(maxSumOfSubArray);

        System.out.print("Sub-array (window) that has the highest max sum value: ");
        slidingWindowElementsWithMaxSum(test, 3);
    }
}
