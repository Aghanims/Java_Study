package CSC208;

import java.util.Arrays;
import java.util.ArrayList;

    /* 
        - Richmond Gonzales
        - Christian Toliver
        - Tristen Ferren
        - Michael Tafasse
    */

public class Intersect 
{
    public static int[] intersection(int[] arrayA, int[] arrayB) //Time Complexity: O(nlogn)
    {
        //outputs the array of integers of the intersecting elements of both arrays
        //Example: a = {1, 4, 3, 7}
                // b = {1, 4, 3, 9}
                //output: {1, 4, 3} --> common element

        ArrayList<Integer> intersection = new ArrayList<>();

        for(int i = 0; i < arrayA.length; i++)
        {
            int start = 0;
            int end = arrayB.length - 1;

            while(start < end)
            {
                if(arrayA[i] == arrayB[start] || arrayA[i] == arrayB[end])
                {
                    //check wheter the array is already in the list
                    if(intersection.contains(arrayA[i]))
                        continue;
                    else
                        intersection.add(arrayA[i]);
                }
                start++;
                end--;
            }
        }

        int[] result = new int[intersection.size()];
        for(int i = 0 ; i < result.length; i++)
            result[i] = intersection.get(i);

        return result;
    }

    public static void main(String[] args) 
    {
        //3 int[] arrays 
            int[] a = {1, 4, 7, 10, 13, 16, 19};
            int[] b = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
            int[] c = {3, 6, 9, 12, 15, 18};

            System.out.println("Set a is = " + Arrays.toString(a));
            System.out.println("Set b is = " + Arrays.toString(b));
            System.out.println("Set c is = " + Arrays.toString(c));

            int[] aIntersectB = intersection(a, b);
            int[] aIntersectC = intersection(a, c);
            int[] bIntersectC = intersection(b, c);
            int[] aIntersectBIntersectC = intersection(aIntersectB, c);
            System.out.println();
            
            System.out.println("a intersect b is = " + Arrays.toString(aIntersectB));
            System.out.println("a intersect c is = " + Arrays.toString(aIntersectC));
            System.out.println("b intersect c is = " + Arrays.toString(bIntersectC));
            System.out.println("a intersect b intersect c = " + Arrays.toString(aIntersectBIntersectC));

        
    }
}
