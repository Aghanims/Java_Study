package DataStructures.SelfStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class SortAlgos 
{

    public static int[] resize(int[] toBeResize) //resize array 2x the exisisting array.
    {
        int[] temp = new int[toBeResize.length * 2];

        for(int i = 0; i < toBeResize.length; i++)
        {
            temp[i] = toBeResize[i];
        }

        toBeResize = temp;
        return toBeResize;
    }

    public static int linearSearch(int[] array, int key)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == key)
                return key;
        }

        return -1;//not found
    }

    static void insertionSort(int[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            int j = i;

            while(j > 0 && array[j] < array[j - 1])
            {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;

                j--;
            }
        }
    }

    static int binarySearch(int[] array, int key)
    {
        int low = 0;
        int high = array.length - 1;
        int mid = 0; // (high + low) / 2

        while(high >= low)
        {
            mid = (high + low) / 2;

            if(array[mid] < key)
                low = mid + 1; 
            else if(array[mid] > key)  
                high = mid - 1;
            else
                return array[mid]; 
        }

        return -1; //not found
    }
/******************************************************************************************* */

    private static int partition(int[] array, int lowIndex, int endIndex)
    {   

        int midPoint = (lowIndex + endIndex) / 2;
        int pivot = array[midPoint];

        boolean done = false;
        while(!done)
        {
            while(array[lowIndex] < pivot)
                lowIndex++;

            while(pivot < array[endIndex])
                endIndex--;

            if(lowIndex >= endIndex)
                done = true;
            else
            {
                int temp = array[lowIndex];
                array[lowIndex] = array[endIndex];
                array[endIndex] = temp;

                lowIndex++;
                endIndex--;
            }
            
        }
        return endIndex;//endIndex is the last index of the left segment.
    }

    public static void quickSort(int[] array, int startIndex, int endIndex)
    {
        if(endIndex <= startIndex)
            return;
        
        int highIndex = partition(array, startIndex, endIndex);

        quickSort(array, startIndex, highIndex); //recursively sort the left segment
        quickSort(array, highIndex + 1, endIndex); //recursively sort the right segment
    }

/********************************************************************************* */

    private static int getMaxlength(int[] array)
    {
        int maxDigits = 0;

        for(int i = 0; i < array.length; i++)
        {
            int digitCounter = getLength(array[i]);

            if(digitCounter > maxDigits)
                maxDigits = digitCounter;
        }

        return maxDigits;
    }

    private static int getLength(int value)
    {
        if(value == 0)
            return 1;
        
        int digits = 0;
        while(value != 0)
        {
            digits++;
            value = value / 10;
        }
        return digits;
    }

    public static void radixSort(int[] array)
    {
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        for(int i = 0; i < 10; i++)
        {
            buckets.add(new ArrayList<>());
        }

        int copyBackIndex = 0;
        int maxDigit = getMaxlength(array);
        int pow10 = 1;

        for(int digitIndex = 0; digitIndex < maxDigit; digitIndex++)
        {
            for(int i = 0; i < array.length; i++)
            {
                int value = array[i];
                int bucketIndex = (Math.abs(value) / pow10) % 10;
                buckets.get(bucketIndex).add(value);
            }

            copyBackIndex = 0;

            for(int i = 0; i < 10; i++)
            {
                ArrayList<Integer> bucket = buckets.get(i);
                
                for(int insideBucket = 0; insideBucket < bucket.size(); insideBucket++)
                {
                    array[copyBackIndex] = bucket.get(insideBucket);
                    copyBackIndex++;
                }
                bucket.clear();
            }

            pow10 *= 10;
        }

        ArrayList<Integer> negatives = new ArrayList<>();
        ArrayList<Integer> nonNegatives = new ArrayList<>();

        for(int numbers : array)
        {
            if(numbers < 0)
                negatives.add(numbers);
            else
                nonNegatives.add(numbers);    
        }

        copyBackIndex = 0; //place negative numbers first in the array in reverse order

        for(int i = negatives.size() - 1; i >= 0; i--)
        {
            array[copyBackIndex] = negatives.get(i);
            copyBackIndex++;
        }

        for(int i = 0; i < nonNegatives.size(); i++)
        {
            array[copyBackIndex] = nonNegatives.get(i);
            copyBackIndex++;
        }
    }
/********************************************************************************* */

    public static void selectionSort(int[] array)
    {
        for(int i = 0; i < array.length - 1; i++ )
        {
            int minIndex = i;

            for(int j= i + 1; j < array.length; i++)
            {
                if(array[j] < array[minIndex])
                {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

/********************************************************************************* */

    private static int insertionInterleaved(int[] array, int startIndex, int gapValue)
    {
        int swaps = 0;

        for(int i = startIndex + gapValue; i < array.length; i += gapValue)
        {
            int j = i;

            while(j - gapValue >= startIndex && array[j] < array[j - gapValue])
            {
                swaps++;

                //perform a swap
                int temp = array[j];
                array[j] = array[j-1];
                array[j - 1] = temp;

                j = j - gapValue; 
            }
          
        }
        return swaps;
    }

    public static int shellSort(int[] array, int[] gapValues)
    {
        int totalSwaps = 0;
        int swapsForGap = 0;

        for(int gapIndex = 0; gapIndex < gapValues.length; gapIndex++)
        {
            for(int i = 0; i < gapValues[gapIndex]; i++)
            {
                swapsForGap = swapsForGap +  insertionInterleaved(array, i, gapValues[gapIndex]);
            }

            totalSwaps += swapsForGap;
        }
        return totalSwaps;
    }

/********************************************************************************* */
    public static void main(String[] args) 
    {
        int[] test = {100, 45, 1, 5, 69, 24, 92, 55};

        int judge = linearSearch(test, 69);
        if(judge == -1)
            System.out.println("Key not found");
        else
            System.out.println(judge + " is in the array");
        
        System.out.println();

        System.out.println("Sorted array using insertion sort");
        insertionSort(test);
        for(int values : test)
        {
            System.out.print(values + " ");
        }
        System.out.println();
        
        System.out.println("Searching using binary search; find 92: ");
        int binaryJudge = binarySearch(test, 92);
        if(binaryJudge == -1)
            System.out.println("Not found");
        else
            System.out.println(binaryJudge + " is found in the array");

/************************************************************************************** */
        System.out.println("QuickSort test: ");
        int[] test2 = {7, 4, 6, 18, 8};
        quickSort(test2, 0, test2.length - 1);
        for(int value : test2)
            System.out.print(value + " ");
        System.out.println();
/************************************************************************************** */

        //Radix sort
        int[] test3 = {98, -234, 78, 45, 89, 44, -643};
        radixSort(test3);
        System.out.println(Arrays.toString(test3));
        System.out.println();

        System.out.println("Resized array:");
        int[] newTest3 = resize(test3);
        System.out.println(Arrays.toString(newTest3));
    }    
}
