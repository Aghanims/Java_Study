package Algorithm;

import java.util.Arrays;

public class BubbleSortDemo
{

    // O(n^2)
    public static void bubbleSort(int[] array)
    {
        for(int i = array.length - 1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(array[j] > array[j + 1])
                {
                    //swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] array = {2, 11, 5, 10, 7, 8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
