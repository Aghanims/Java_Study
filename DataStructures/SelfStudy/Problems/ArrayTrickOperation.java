package DataStructures.SelfStudy.Problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ArrayTrickOperation 
{
    public static int[] removeEvenInteger(int[] array)
    {
        /*
            Algo:
             - count number of odd integers in the array through iteration
             - Assigns a counter variable afterwards
             - create a int[] newArray with the counter as the length
         
        */

        int oddCounter = 0; //we will use this varaible as the length of the new array

        for(int i = 0; i < array.length; i++)
        {
            if((array[i] % 2) != 0) // number % 2 == even number             
                oddCounter++; 
        }

        int[] onlyOddInteger = new int[oddCounter];

        int oddIndex = 0;
        for(int i = 0; i < array.length; i++)
        {   
            if((array[i] % 2) != 0)
            {
                onlyOddInteger[oddIndex] = array[i]; // assign the odd integer from the old array
                oddIndex++;
            }
        }
        return onlyOddInteger;
    }    

/************************************************************************************************************** */

    public static int[] reverseArray(int[] array, int start, int end)
    {
        //two pointer approach
        while(start < end)
        {
            int temp = array[start]; //swap both start and end index 
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        return array;
    }

/************************************************************************************************************** */
    public static int findMin(int[] array)
    {
        int result = 0;

        int start = 0;
        int end = array.length-1;

        int temp = array[start];
        int temp2 = array[end];

        while(start < end)
        {
            if( array[start + 1] <temp)
                temp = array[start +1];
            
            if(array[end -1] < temp2)
                temp2 = array[end -1];

            start++;
            end--;
        }

        result = Math.min(temp, temp2);

        return result;
    }

/************************************************************************************************************** */
    /*
        Given an integer array, return true if any value appears at least twice in the array, and return false if 
        every element is distinct

        Example: 
            input: nums = {1, 2, 3, 1} 
            output: true
    */

    public static boolean containsDuplicate(int[] array)
    {   
        //structure used for checking wheter the value at index is a duplicate
        HashSet<Integer> uniqueContainer = new HashSet<>();

        for(int i = 0; i < array.length; i++)
        {   
            int currentNum = array[i];

            if(uniqueContainer.contains(currentNum))
                return true;
            
            uniqueContainer.add(currentNum);  
        }
        return false;
    }

    public static int findDuplicate(int[] array)
    {

        /*
            Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
            There is only one repeated number in nums, return this repeated number.
            You must solve the problem without modifying the array nums and uses only constant extra space.

            Example 1:
            Input: nums = [1,3,4,2,2]
            Output: 2
        */

        //Floyd's cycle detection 
        // Space complexity : O(1)
        // Time complexity: O(n)

        int slow = 0;
        int fast = 0;

        while(true)
        {
            slow = array[slow];
            fast = array[array[fast]];

            if(slow == fast)
                break;
        }

        int check = 0;
        while(true)
        {
            slow = array[slow];
            check = array[check];

            if(slow == check)
                break;
        }

        return check;
    }

/************************************************************************************************************** */
    /*
        Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An anagram is a word or phrase formed by rearrangin the letters of a different word or phrase, typically
        using all the original letters exactly once.

        Example:
            input: s = "anagram" ; t = "nagaram"
            output: true

            input: s = "rat", t = "car"
            output: false
    */
    public static boolean isAnagram(String s, String t)
    {
        if(s.length() != t.length()) {return false;} //A case of not the samme length

        ArrayList<Character> container = new ArrayList<>();

        //add all character of string s to the container
        for(int i = 0; i < s.length(); i++)
            container.add(s.charAt(i));
        
        //iterate String t and compare wheter the character at element exist in the container
        for(int i = 0; i < t.length(); i++)
        {
            char currentChar = t.charAt(i);

            if(!container.contains(currentChar))
                return false;
        }

        return true; //all character of String t exists in String s
    }

    /*
        Given an array of String words, group the anagrams together. You can return the answer in any order.

        Example: 
            input: words = {"eat", "tea", "tan", "ate", "nat", "bat"}
            output: {["bat"], ["nat", "tan"], ["ate", "eat", "tea"]}
    */

    public static List<List<String>> groupAnagrams(String[] words)
    {
        List<List<String>> result = new ArrayList<>();

        //idea: sort all the word in lexicographical order, and compare to other elements while iterating.
        //      if the same value then it is an anagram, hence, store it on the same map.
        /*
            Example: (above)
                map:
                    aet | {eat, tea, ate}
                    atn | {nat, tan} 
                    ...
            *Store all the values back to the result
        */
        HashMap<String, ArrayList<String>> groupOfAnagram = new HashMap<>();

        for(String word : words)
        {
            char[] wordInArray = word.toCharArray();
            Arrays.sort(wordInArray);
            String sortedString = new String(wordInArray); //the word at element in lexicographical order

            if(groupOfAnagram.containsKey(sortedString))
                groupOfAnagram.get(sortedString).add(word);
            else
            {
                ArrayList<String> groupedWords = new ArrayList<>();

               result.add(groupedWords); //add a reference of the list to be putted in the map; makes the code run faster

                groupedWords.add(word);
                groupOfAnagram.put(sortedString, groupedWords); //create a record of the word and add the word in the list
            }
        }
        
        //  for(String map : groupOfAnagram.keySet())
        //     result.add(groupOfAnagram.get(map));  

        return result;
    }


/************************************************************************************************************** */

    public static int findSecondMax(int[] array)
    {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > max)
            {
                secondMax = max; //assign the previous max value to second max
                max = array[i];
            }
            else if(array[i] > secondMax && array[i] != max)
                secondMax = array[i];
        }
        return secondMax;
    }

/************************************************************************************************************** */

    public static int[] moveZeroToEnd(int[] array)
    {
        int zeroPointer = 0;
        int nonZeroPOinter = 0;

        for(nonZeroPOinter = 0; nonZeroPOinter < array.length; nonZeroPOinter++)
        {
            if(array[nonZeroPOinter] != 0 && array[zeroPointer] == 0)
            {
                //perform a swap
                int temp = array[nonZeroPOinter];
                array[nonZeroPOinter] = array[zeroPointer];
                array[zeroPointer] = temp;
            }

            if(array[zeroPointer] != 0)   
                zeroPointer++;      
        }
        return array;
    }
/************************************************************************************************************** */
    /*
        Given an array that contains only numbers in the range from 1 to array.length, find the first duplicate
        number for which the second occurence has the minimal index In other words, if there are more than 1
        duplicated numbers, return the numer for which the second occurence has a smaller index than the other 
        number does. If there are no such elements, return -1.

        Example: 
            input: array = {0, 12, 15, 6, 3} : invalid --> elements are not within 1 and arra.length

            input: array = {1, 2, 3, 4} 
            output: -1;

            input: array = {2, 1, 3, 5, 3, 2}
            output: 3
    */
    public static int firstDuplicate(int[] array)
    {
        //approach: use the elements itself as an index to mark the other duplicate as 
        //          negative(implies it's first duplicate) 

        for(int i = 0; i < array.length; i++)
        {
            int currentValue = array[i];

            if(array[Math.abs(currentValue) - 1] < 0)
                return Math.abs(array[i]);
            else
                array[Math.abs(currentValue - 1)] = -array[Math.abs(currentValue - 1)];
        }
        return -1;  //no duplicate elements found
    }

/************************************************************************************************************** */
    /*
        Container with most water:

        You are given an integer array height of length n. There are n vertical lines drawn that two endpoints of
        the ith line are (i, 0) and (i, height[i]).
        Find two lines that are together with the x-axis form a container, such the container contains the most water.
        Return the maximum of water a container can store

        Example: 
            input: heigth = {1, 8, 6, 2, 5, 4, 8, 3, 7}
            Output: 49

        --> because the above vertical lines are represented by array [1, 8, 6, 2, 5, 4, 8, 3, 7]. In this case,
            the max area of water (blue section) the container can contain is 49.
    */
    public static int maxArea(int[] height)
    {
        int maximizedArea = 0;

        int startPointer = 0;
        int endPointer = height.length - 1;
        while(startPointer < endPointer)
        {
            int length = endPointer - startPointer;
            int width = Math.min(height[startPointer], height[endPointer]);

            int currentArea = length * width;
            maximizedArea = Math.max(maximizedArea, currentArea);

            if(height[startPointer] < height[endPointer])
                startPointer++;
            else //height[endPointer] < height[startPointer]
                endPointer--;

        }

        return maximizedArea;
    }

/************************************************************************************************************** */
    /*
        Given an integer array nums and an integer k, return the k most frequent elements. You may return the 
        answer in any order.
            Example:
                input: nums = {1, 1, 1, 2, 2, 3} ; where k = 2;
                output {1, 2}
    */
    public static int[] topKFrequentElements(int[] nums, int k)
    {
        int[] result = new int[k];
        HashMap<Integer, Integer> elementFrequency = new HashMap<>(); //record the number the elements being repeated

        //gives the abitity the pull out the max first                       comparator: arrange in ascending order base on values
        PriorityQueue<Map.Entry<Integer, Integer>> maxPriority = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue()); 

        for(int i = 0; i < nums.length; i++)
            elementFrequency.put(nums[i], elementFrequency.getOrDefault(nums[i], 0) + 1);

        for(Map.Entry<Integer, Integer> keySet : elementFrequency.entrySet())
        {
            maxPriority.add(keySet); //automatically arrange set int ascending order

            if(maxPriority.size() > k)
                maxPriority.poll(); //remove the unnecessary set of elements
        }
            
        for(int i = 0; i < result.length; i++)
            result[i] = maxPriority.poll().getKey();

        return result;    
    }

/************************************************************************************************************** */

    static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(i == array.length -1) 
                System.out.println(array[i]);        
            else
                System.out.print(array[i] + ", ");   
        }
    }

    public static void main(String[] args) 
    {
        int[] randomArray = {2,0, 5, 98, 0, 32, 7,0 , -100, 1, 77, 69, 0, 23, 54};
        System.out.println("Original Array:");
        printArray(randomArray);
        System.out.println();

        System.out.println("Move all zero to the end of the array: ");
        printArray(moveZeroToEnd(randomArray));
        System.out.println();

        System.out.println("All odd values in the array: ");
        int[] onlyOdd = removeEvenInteger(randomArray);

        printArray(onlyOdd);
        System.out.println();

        System.out.println("Array in reverse Order");
        int [] reversedArray = reverseArray(randomArray, 0, randomArray.length -1);
        printArray(reversedArray);

        System.out.println();
        
        System.out.println("Minimum value of the array: " + findMin(randomArray));
        System.out.println("Second Max value in the array: " + findSecondMax(randomArray));
        System.out.println(Arrays.toString(onlyOdd) +  " contains duplicate values: " + containsDuplicate(onlyOdd));
        System.out.println();

        String s = "nagaram";
        String t = "anagram";
        System.out.println(t + " is an anagram of " + s + ": " + isAnagram(s, t));


        int[] firstDuplicate = {2, 1, 3, 5, 3, 2};
        System.out.println( "First duplicate of " + Arrays.toString(firstDuplicate) + ": " + firstDuplicate(firstDuplicate));

        System.out.println();

        String[] wordGroup = {"eat", "tea", "tan", "ate", "nat", "bat", "rich", "chir"};
        System.out.println("String that are group by anagram: " + Arrays.toString(wordGroup));
        System.out.print("Result: ");
        for(List<String> groupOfAnagram : groupAnagrams(wordGroup))
            System.out.print(Arrays.toString(groupOfAnagram.toArray()) + " ");

        System.out.println();
        int[] topKElement = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        System.out.println("Top (k = 2) frequent elements of " + Arrays.toString(topKElement) + ": ");
        System.out.print(Arrays.toString(topKFrequentElements(topKElement, 2)));
        System.out.println(); System.out.println();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Given array: " + Arrays.toString(height));
        System.out.println("Area of the container with most water: " + maxArea(height));

        
    }
}
