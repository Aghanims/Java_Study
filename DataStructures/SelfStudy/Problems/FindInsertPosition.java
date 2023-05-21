package DataStructures.SelfStudy.Problems;

import java.util.Arrays;

public class FindInsertPosition 
{

    /*
        Given a sorted array of distinct integers and a target value,
        return the index if the target is found. If not, return the index
        where it would be if it were inserted in order. 
        The algorithm should run in O(log n) time.
     */

    public static int searchInsertPosition(int[] array, int value)
    {
        int lowIndex = 0;
        int highIndex = array.length - 1;

        while(highIndex >= lowIndex) //binary search
        {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;

            if(array[midIndex] == value) 
                return midIndex;
            
            if(array[midIndex] > value)
                highIndex = midIndex - 1;
            else //array[midIndex] < value
                lowIndex = midIndex + 1;
        }
        return lowIndex;
    }

    //method for merging two sorted arrays
    public static int[] mergeSortedArray(int[] array1, int[] array2)
    {
        //create an array with length combined from array 1 and 2.
        int[] resultArray = new int[array1.length + array2.length];

        int array1Iterator = 0;
        int array2Iterator = 0;
        int arrangeIterator = 0; //provide pointers for each array

        //iterate until either array is exhausted first
        while(array1Iterator < array1.length && array2Iterator < array2.length)
        {
            if(array1[array1Iterator] < array2[array2Iterator])
            {
                resultArray[arrangeIterator] = array1[array1Iterator];
                array1Iterator++; 
            }
            else
            {
                resultArray[arrangeIterator] = array2[array2Iterator];
                array2Iterator++;
            }

            arrangeIterator++;
        }

        //Case: there is a possiblity that either array is exhausted first. So, just copy the leftover element to the result array.
        while(array1Iterator < array1.length)
        {
            resultArray[arrangeIterator] = array1[array1Iterator];
            array1Iterator++;
            arrangeIterator++;
        }
        while(array2Iterator < array2.length)
        {
            resultArray[arrangeIterator] = array2[array2Iterator];
            array2Iterator++;
            arrangeIterator++;
        }

        return resultArray;
    }

/********************************************************************* */

    private static void merge(int[] array, int start, int mid, int end)
    {
        int mergeSize = end - start + 1;
        int[] resultArray = new int[mergeSize]; //array for storing merged element

        int resultIterator = 0; // iterator for storing element in the result array

        //dynamically compare left and right partition to place lesser element in the result array
        int leftIterator = start;
        int rightIterator = mid + 1;

       //case 1: (normal case) iterate until either parition is exhausted
        while(leftIterator <= mid && rightIterator <= end)
        {
            if(array[leftIterator] < array[rightIterator]) //element in left partition is lesser than the element of the right parition
            {
                resultArray[resultIterator] = array[leftIterator];
                leftIterator++;
            }
            else //if value of right partition is lesser than value of the left partition
            {
                resultArray[resultIterator] = array[rightIterator];
                rightIterator++;
            }
            resultIterator++; //move on to the next index of the result array
        }

        //case 2: either one the partition is exhausted first; there is a partition that still contains an element
        while(leftIterator <= mid)
        {   
            resultArray[resultIterator] = array[leftIterator];
            leftIterator++;
            resultIterator++;
        }
        while(rightIterator <= end)
        {
            resultArray[resultIterator] = array[rightIterator];
            rightIterator++;
            resultIterator++;
        }

        //copy result array back to the original array
        for(resultIterator = 0;  resultIterator < mergeSize; resultIterator++)
        {
            //there is a possibility that index do not start at 0
            array[start + resultIterator] = resultArray[resultIterator];
        }
    }

    public static void mergeSort(int[] array, int start, int end)
    {
        int mid = 0;

        //only apply recursion if there and element greater than 0
        if(start < end) //base case; recursively create a partition of the array
        {
            mid = (start + end) / 2;

            //recursively sort each partiion
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            merge(array, start, mid, end);
        }
    }


/***************************************************** */
    public static void main(String[] args) 
    {
        int[] test = {1, 8, 9, 12, 16, 18, 20};

        int insertIndex = searchInsertPosition(test, 17);

        System.out.println("Array: " + Arrays.toString(test));
        System.out.println("value 17 should be inserted at: " + insertIndex);
        System.out.println();

        int[] array1 = {2, 3, 6, 10, 12, 14, 20};
        int[] array2 = {1, 4, 5, 8, 9, 13};

        int[] result = mergeSortedArray(array1, array2);

        System.out.println("First Array: " + Arrays.toString(array1));
        System.out.println("Second Array: " + Arrays.toString(array2));
        System.out.println("Combined Array: " + Arrays.toString(result));
        System.out.println();

        int[] unsorted = {12, 99, 1, 5, 89, 6, 21, -21, 1000, 69};
        System.out.println("Unsorted array: " + Arrays.toString(unsorted));

        mergeSort(unsorted, 0, unsorted.length -1);
        System.out.println("Sorted array: " + Arrays.toString(unsorted));
    }
}
