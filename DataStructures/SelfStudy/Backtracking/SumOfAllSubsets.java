package DataStructures.SelfStudy.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsets 
{
    /*
        The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

        For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
        Given an array nums, return the sum of all XOR totals for every subset of nums. 

        Note: Subsets with the same elements should be counted multiple times.

        An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. 

        Example 1:

        Input: nums = [1,3]
        Output: 6
        Explanation: The 4 subsets of [1,3] are:
        - The empty subset has an XOR total of 0.
        - [1] has an XOR total of 1.
        - [3] has an XOR total of 3.
        - [1,3] has an XOR total of 1 XOR 3 = 2.
        0 + 1 + 3 + 2 = 6
        Example 2:

        Input: nums = [5,1,6]
        Output: 28
        Explanation: The 8 subsets of [5,1,6] are:
        - The empty subset has an XOR total of 0.
        - [5] has an XOR total of 5.
        - [1] has an XOR total of 1.
        - [6] has an XOR total of 6.
        - [5,1] has an XOR total of 5 XOR 1 = 4.
        - [5,6] has an XOR total of 5 XOR 6 = 3.
        - [1,6] has an XOR total of 1 XOR 6 = 7.
        - [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
        0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28 
     
    */
    public static int XORSum(int[] nums)
    {
        List<Integer> sum = new ArrayList<>();
       int result = 0;
       List<List<Integer>> subsets = new ArrayList<>();

       backtrack(nums, subsets, new ArrayList<>(), 0, sum);

       for(int i = 0; i < sum.size(); i++)
       {
            result += sum.get(i);
       }

       return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> currSet, int index,  List<Integer> sum)
    {
        /*
                                []
                            [1]    [3]
                        [1, 3]        [3, 1]
                
            sum = [0, 1]

            j   i
            [1, 3]
        */

        subsets.add(new ArrayList<>(currSet)); //[ [], [1], [1, 3]]
        System.out.print(currSet + " ");
        if(currSet.size() == 0) 
            sum.add(0);
        else if(currSet.size() == 1)
            sum.add(currSet.get(0));
        else 
        {
            int XOR = currSet.get(0);
            for(int i = 1; i < currSet.size(); i++)
            {
                XOR = XOR ^ currSet.get(i);
            }

            sum.add(XOR);
        }
        
        for(int i = index; i < nums.length; i++)
        {
            //make changes
            if(currSet.contains(nums[i]))
                continue;

            currSet.add(nums[i]);// [3]

            //backtrack
            backtrack(nums, subsets, currSet, i + 1, sum); //2

            //undo changes
            currSet.remove(currSet.size() - 1);
        }
    }

    
    public static void main(String[] args) 
    {
        int[] array = {5, 1, 6};
        List<List<Integer>> container = new ArrayList<>();

        System.out.println(XORSum(array));
    }
}
