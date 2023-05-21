package DataStructures.SelfStudy.Problems;

public class FindMinInRotatedSortedAray 
{
    /*
        Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 

        For example, the array nums = [0,1,2,4,5,6,7] might become:
        [4,5,6,7,0,1,2] if it was rotated 4 times.
        [0,1,2,4,5,6,7] if it was rotated 7 times.

        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the 
        array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

        Given the sorted rotated array nums of unique elements, return the minimum element of this array.

        You must write an algorithm that runs in O(log n) time.

        Example:
            Input: nums = [3,4,5,1,2]
            Output: 1
            --> Explanation: The original array was [1,2,3,4,5] rotated 3 times.
    */
    public static int findMin(int[] nums)
    {
        //Approach:
        /*
            -Binary Search
                - check mid if the element is the last element of the original array
                - we do this by comparing nums[mid] >= nums[l]
                - if yes, then shift start pointer to mid + 1;
        */

        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            //means we are in the domain of the normal ascending sort.
            if(nums[start] <= nums[end])
                return nums[start];

            int mid = (start + end) / 2;

            if(nums[mid] >= nums[start])
                start = mid + 1;
            else 
                end = mid;
        }
        return 0;
    }

    //find the target value in a rotated sorted array in O(log(n))
    public static int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right)
        {
            int mid = (left + right) / 2;   

            if(nums[mid] == target)
                return mid;
            
            //check if target is in left sorted portion
            else if(nums[mid] >= nums[left])
            {
                if(nums[left] <= target && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            //if the target is in the right sorted portion
            else 
            {
                if(nums[mid] <= target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
    

/******************************************************************************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {3,4,5,1,2};
        int result = findMin(test);

        System.out.println(result);

        int[] test2 = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println("index of the target: " + search(test2, target));
    }
}
