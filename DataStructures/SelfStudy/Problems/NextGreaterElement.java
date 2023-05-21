package DataStructures.SelfStudy.Problems;


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement 
{
    /*
        Given an array of integers. For each element in the array,
        find its next greater element in that array. The next greater
        element is the first element towards right, which is the greater
        than the current element. output "-1" if no greater element exist

        ex: 
            input: arr = {4, 7, 3, 4, 8, 1}
            output: arr = {7, 8, 4, 8, -1, -1}
     */


    public static int[] nextGreaterElement(int[] array)
    {
        int[] resultArray = new int[array.length];

        Stack<Integer> container = new Stack<>();

        for(int i = array.length - 1; i >= 0; i--)
        {
            if(!container.isEmpty())
            {
                while((!container.isEmpty()) && container.peek() <= array[i])
                    container.pop(); //remove elements that are smaller than the current index
            }

            if(container.isEmpty()) // no greater element exist
                resultArray[i] = -1;
            else
                resultArray[i] = container.peek(); //next greater element is at the top of the stack
            
            container.push(array[i]); //push the element from the array index
        }
        return resultArray;
    }

/**************************************************** */
    public static void main(String[] args) 
    {
        int[] test = {4, 7, 3, 4, 8, 1};
        int[] result = nextGreaterElement(test);

        System.out.println(Arrays.toString(result));
    }
}
