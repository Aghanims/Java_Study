package DataStructures.SelfStudy.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow 
{
    /*
        Given an array of integers, there is a sliding window of size "k" which is moving from the very left of the array
        up to the very right. You can only see the "k" numbers in the windows. Each time the sliding window moves right by 
        one position. Return the max sliding window.

        Example: 
            Input: array = {44, 77, 33, 44, 88, 11} where k = 3
            Output: result = {77, 77, 88, 88}
    */

    public static ArrayList<Integer> maxNumberOfAllSubArrayOfSizeK(int[] array, int window)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int[] nextGreaterElement = nextGreaterElement(array);

        for(int i = 0; i <= array.length - window; i++)
        {
            int subArrayI = i;
            
            //check wheter the index of the next greater element is within the range of the sliding window
            while(nextGreaterElement[subArrayI] < i + window)
                subArrayI = nextGreaterElement[subArrayI];
            
            result.add(array[subArrayI]);
        }
        return result;
    }

    private static int[] nextGreaterElement(int[] array)
    {
        int[] result = new int[array.length];
        Stack<Integer> container = new Stack<>();

        for(int i = array.length - 1; i >= 0; i--)
        {
            //case1: value in stack is lesser than the value at index
            if(!container.isEmpty())
            {
                while(!container.isEmpty() && array[container.peek()] <= array[i])
                    container.pop();  
            }

            //case2: if stack is empty; no greater value exist
            if(container.isEmpty())
                result[i] = array.length;
            else //case3: pass all the checkpoints so far; means value in stack is greater than the index
            {
                result[i] = container.peek();
            }
            container.push(i);
        }
        return result;
    }

/**************************************************************************************************************** */

    //second version of sliding window maximum
    public static int[] maxSlidingWindow(int[] nums, int window)
    {
        int[] result = new int[nums.length - window + 1];

        Deque<Integer> container = new LinkedList<>();

        int resultIterator = 0;
        for(int i = 0; i < nums.length; i++)
        {
            //disregard all previous element that is outside the window
            if(!container.isEmpty() && container.peekFirst() < (i - window + 1))
                container.pollFirst();

            //disregard all previous element that is less than the current element at index i
            while(!container.isEmpty() && nums[i] > nums[container.peekLast()])
                container.pollLast();
                
            container.offer(i);

            //place output value in result
            if(i >= window - 1)
            {
                result[resultIterator] = nums[container.peekFirst()];
                resultIterator++;
            }
        }   

        return result;
    }


/*************************************************************************************************************************/
    public static void main(String[] args) 
    {
        int[] test = {44, 77, 33, 44, 88, 11};
        int[] nextGreatElement = nextGreaterElement(test);

        ArrayList<Integer> slidingWindowMax = maxNumberOfAllSubArrayOfSizeK(test, 3);
        int[] result2 = maxSlidingWindow(test, 3);

        System.out.println("Result 2: " + Arrays.toString(result2));
        System.out.println(Arrays.toString(slidingWindowMax.toArray()));

    }
}
