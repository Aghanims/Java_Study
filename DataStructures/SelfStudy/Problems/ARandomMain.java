package DataStructures.SelfStudy.Problems;

import java.util.*;

public class ARandomMain 
{
   public static int[] topKFrequentElements(int[] array, int k)
   {
        /*
            Given an integer array nums and an integer k, return the k most frequent elements. You may return the 
            answer in any order.
                Example:
                    input: nums = {1, 1, 1, 2, 2, 3} ; where k = 2;
                    output {1, 2}

            Algo:
                Step1 - record the element's frequency in the array in using HashMap
                Step2 - store all of the elements in the PriorityQueue in ascending order (use comparator)
                Step3 - store all of the top K elements in the result array 
        */

        int[] result = new int[k];

        HashMap<Integer, Integer> elementFrequency = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> sort = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        //Step 1
        for(int i = 0; i < array.length; i++)
            elementFrequency.put(array[i], elementFrequency.getOrDefault(array[i], 0) + 1);
        
        //Step 2
        for(Map.Entry<Integer, Integer> entrySet : elementFrequency.entrySet())
            sort.add(entrySet);
        
        //Step 3
        for(int i = 0; i < k; i++)
            result[i] = sort.poll().getKey();
        
        

        return result;
   }

    public static void main(String[] args) 
    {
        int[] test = {1, 1, 1, 2, 2, 3};

        int[] result = topKFrequentElements(test, 2);

        System.out.println(Arrays.toString(result));
    }
}
