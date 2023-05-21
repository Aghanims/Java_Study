package DataStructures.SelfStudy.Problems;

import java.util.HashSet;

public class LongestConsecutiveSequence 
{

    /*
        Given an unsorted array of integers nums, return the length of the longest consecutive
        elements subsequence.

        You must write an algorithm that runs in O(n) time.

        Example: 
            input: nums = {100, 4, 200, 1, 3, 2}
            output: 4

            **because the longest consecutive sequence is [1, 2, 3, 4]; therefor length = 4
    */
    public static int longestConsecutive(int[] nums)
    {
        if(nums.length == 0) return 0;

        HashSet<Integer> container = new HashSet<>();
        int greatestLength = 1;

        for(Integer values : nums)
            container.add(values);
        
        for(Integer values : nums)
        {
            //only start if the value is the start of the consecutive integers
            if(!container.contains(values - 1))
            {
                int counter = 1;
                while(container.contains(values + 1))
                {
                    counter++;
                    values++;
                }

                //update the greatestLength
                greatestLength =  Math.max(greatestLength, counter); 
            }
        }

        return greatestLength;
    }

/******************************************************************************************************** */
    public static void main(String[] args) 
    {
        int[] test =  {100, 4, 200, 1, 3, 2, 10, 11, 12, 13, 14, 15};
        //int[] test2 = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(test));
    }    
}
