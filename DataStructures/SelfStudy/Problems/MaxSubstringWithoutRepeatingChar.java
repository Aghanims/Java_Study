package DataStructures.SelfStudy.Problems;

import java.util.HashMap;
import java.util.ArrayList;

public class MaxSubstringWithoutRepeatingChar 
{
    /*
        Given a String, find the length of a longest substring without repeating characters.

        Example: 
            input: str = "abcabcbb"
            output: 3

            input: str = "bbbb"
            output: 1
    */

    public static int lengthOfLongestSubstring(String word)
    {
        HashMap<Character, Integer> charContainer = new HashMap<>();
        int substringMaxLength = 0;

        int startOfSubstring = 0;
        for(int endOfSubstring = 0; endOfSubstring < word.length(); endOfSubstring++)
        {
            char currentChar = word.charAt(endOfSubstring);

            if(charContainer.containsKey(currentChar))
                startOfSubstring = Math.max(startOfSubstring, charContainer.get(currentChar) + 1);
            
            charContainer.put(currentChar, endOfSubstring);
            
            substringMaxLength = Math.max(substringMaxLength, (endOfSubstring - startOfSubstring) + 1);
        }
        return substringMaxLength;
    }


    public static void combinationOfLongestUniqueSubstring(String word)
    {
        HashMap<Character, Integer> charContainer = new HashMap<>();
        ArrayList<Integer> endIndexOfSubstring = new ArrayList<>();

        int substringMaxLength = 0;

        int startOfSubstring = 0;
        for(int endOfSubstring = 0; endOfSubstring < word.length(); endOfSubstring++)
        {
            char currentChar = word.charAt(endOfSubstring);

            if(charContainer.containsKey(currentChar))
            {
                startOfSubstring = Math.max(startOfSubstring, charContainer.get(currentChar) + 1);
            }

            charContainer.put(currentChar, endOfSubstring);

            int currentMax = (endOfSubstring - startOfSubstring) + 1;
            if(substringMaxLength == currentMax)
            {
                endIndexOfSubstring.add(endOfSubstring); //list of combinations of substring that has equal maxLength
            }
            else if(substringMaxLength < currentMax) //new maxLength found; erase all existing records and update based on the new maxLength
            {
                endIndexOfSubstring.clear();
                endIndexOfSubstring.add(endOfSubstring);
            }
            substringMaxLength = Math.max(substringMaxLength, currentMax);
        }

        //printing substrings
        for(int i = 0; i < endIndexOfSubstring.size(); i++)        
        {
            int startIndex = (endIndexOfSubstring.get(i) + 1) - substringMaxLength; 

            for(int j = startIndex; j <= endIndexOfSubstring.get(i); j++)
            {
                System.out.print(word.charAt(j));
            }
            System.out.println();
        }
    }

/*********************************************************************************************************** */
    public static void main(String[] args) 
    {
        String test = "abcabcbbap";
        int result = lengthOfLongestSubstring(test);

        System.out.println("Max length: " + result);

        combinationOfLongestUniqueSubstring(test);

    }
}
