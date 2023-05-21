package DataStructures.SelfStudy.Problems;

import java.util.Stack;

public class LargestRectangleInHistogram 
{
    /*
        Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
        return the area of the largest rectangle in the histogram.

        Example: 
            Input: heights = [2,1,5,6,2,3]
            Output: 10

            Explanation: The above is a histogram where width of each bar is 1.
            The largest rectangle is shown in the red area, which has an area = 10 units.
    */

    /********************************************************* */
    //static class for storing ordered pair of index and the height(element of heights)
    public static class Element
    {
        public int index;
        public int height;

        public Element(int index, int height)
        {
            this.index = index;
            this.height = height;
        }
    }

    /********************************************************* */

    public static int largestRectangleArea(int[] heights)
    {
        int totalArea = 0;
        Stack<Element> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++)
        {
            int currentHeight = heights[i];
            int start = i;

            while(!stack.isEmpty() && stack.peek().height > currentHeight)
            {
                Element pair = stack.pop();
                
                int index = pair.index;
                int height = pair.height;

                totalArea = Math.max(totalArea, height * (i - index));
                start = index;
            }
            stack.push(new Element(start, currentHeight));
        }

        //evaluate the remaiing elements in the staack
        while(!stack.isEmpty())
        {
            Element pair = stack.pop();

            int index = pair.index;
            int height = pair.height;

            totalArea = Math.max(totalArea, height * (heights.length - index));
        }

        return totalArea;
    }


/******************************************************************************************************************* */
    public static void main(String[] args) 
    {
        int[] heights = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(heights));
    }
}
