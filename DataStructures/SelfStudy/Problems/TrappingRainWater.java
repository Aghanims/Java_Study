package DataStructures.SelfStudy.Problems;

public class TrappingRainWater 
{
    /*
        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
        how much water it can trap after raining.

        Example:
            input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
            output: 6

        --> Output: 6
            Explanation: The above elevation map (black section) is represented by 
            array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water 
            are being trapped.
    */
    public static int countTrappedRainWater(int[] height)
    {
        if(height.length == 0) return 0;
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int countRainWater = 0;

        //record of maximum height of the left section of the array from ith index
        int currentMax = height[0];
        for(int i = 0; i < leftMax.length; i++)
        {
            leftMax[i] = Math.max(height[i], currentMax);
            currentMax = leftMax[i];
        }

        //record of maximum height of the right section of the array from ith index
        currentMax = height[height.length - 1];
        for(int i = height.length - 1; i >= 0; i--)
        {
            rightMax[i] = Math.max(height[i], currentMax);
            currentMax = rightMax[i];
        }

        //count number of trapped rainwater
        for(int i = 0; i < height.length; i++)
            countRainWater = countRainWater + (Math.min(leftMax[i], rightMax[i]) - height[i]);

        return countRainWater;
    }

/************************************************************************************** */
    //Algorithm using only O(1) extra space
    public static int amountOfTrappedWater(int[] heights)
    {
        if(heights.length == 0) return 0;

        //use to track the maximum height of left and right portion of the array
        int leftMax = heights[0];
        int rightMax = heights[heights.length - 1];

        int countRainWater = 0;

        int startPointer = 0;
        int endPointer = heights.length - 1;
        while(startPointer < endPointer)
        {
            if(leftMax < rightMax)
            {  
                startPointer++;
                leftMax = Math.max(leftMax, heights[startPointer]);
                countRainWater = countRainWater + (leftMax - heights[startPointer]);
            }
            else //leftMax > rightMax
            {
                endPointer--;
                rightMax = Math.max(rightMax, heights[endPointer]);
                countRainWater = countRainWater + (rightMax - heights[endPointer]);
            }
        }
        return countRainWater;
    }


/************************************************************************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};

        int rainWaterCount = countTrappedRainWater(test);
        System.out.println(rainWaterCount);

        int secondResult = amountOfTrappedWater(test);
        System.out.println(secondResult);

        int toInt = Integer.parseInt("12");
        System.out.println(toInt);
    }
}
