package DataStructures.SelfStudy.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum 
{
    /*
        Gievn an array of distinct integers, print all combination of such triplets that they add up to a specific target.
        The triplet should be ordered in ascending order.

        Example: 
            input: array = {2, 4, 3, 7, 1, 8, 9, 0} target = 6
            output: {0, 2, 4}, {1, 2, 3}
     */
    
    public static ArrayList<ArrayList<Integer>> listOfThreesum(int[] array, int target)
    {
        ArrayList<ArrayList<Integer>> sumContainer = new ArrayList<>();

        Arrays.sort(array);

        for(int i = 0; i < array.length - 2; i++)
        {
            int endPointer = array.length -1;
            int nextToStartointer = i + 1;

            while(nextToStartointer < endPointer)
            {
                int sum = array[i] + array[nextToStartointer] + array[endPointer];

                if(sum > target)
                    endPointer--;
                else if(sum < target)
                    nextToStartointer++;
                else //sum == target 
                {
                    ArrayList<Integer> currentCombination = new ArrayList<>();
                    currentCombination.add(array[i]);
                    currentCombination.add(array[nextToStartointer]);
                    currentCombination.add(array[endPointer]);

                    sumContainer.add(currentCombination);

                    nextToStartointer++;
                    endPointer--;  
                }  
            }
        }
        return sumContainer;
    }
/*********************************************************************************************************** */

    public List<List<Integer>> threeSumWithDuplicate(int[] nums) 
    {
        List<List<Integer>> tripletContainer = new ArrayList<>();

        //Sort array to easily minimize and maximize sum value
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++)
        {
            //check whether there is a duplicate (same number to the previious element)
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1]))
            {
                int startPointer = i + 1;
                int endPointer = nums.length - 1;

                while(startPointer < endPointer)
                {
                    int sum = nums[i] + nums[startPointer] + nums[endPointer];

                    if(sum < 0)
                        startPointer++;                  
                    else if(sum > 0)
                            endPointer--;
                    else //sum == 0
                    {
                        ArrayList<Integer> triplets = new ArrayList<>();

                        triplets.add(nums[i]);
                        triplets.add(nums[startPointer]);
                        triplets.add(nums[endPointer]);

                        tripletContainer.add(triplets);

                        //skip duplicated of startPointer and endPointer
                        while(startPointer < endPointer && nums[startPointer] == nums[startPointer + 1])
                            startPointer++;
                        while(startPointer < endPointer && nums[endPointer] == nums[endPointer - 1])
                            endPointer--;

                        startPointer++;
                        endPointer--;
                    }
                }
            }
        }
        return tripletContainer;
    }

/*********************************************************************************************************** */
    public static void printThreeSum(ArrayList<ArrayList<Integer>> threeSum)
    {
        if(threeSum.isEmpty()) 
            System.out.println("No such combination exist!!!");
        

        for(ArrayList<Integer> sumCombination : threeSum)
        {
            System.out.println(Arrays.toString(sumCombination.toArray()));
        }
    }


/******************************************************************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {2, 4, 3, 7, 1, 8, 9, 0, 10, 20, -23, -6, -4};
        int target = 9;

        ArrayList<ArrayList<Integer>> result = listOfThreesum(test, target);

        printThreeSum(result);
    }    
}
