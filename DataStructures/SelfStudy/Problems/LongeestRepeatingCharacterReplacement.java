package DataStructures.SelfStudy.Problems;

import java.util.HashMap;

public class LongeestRepeatingCharacterReplacement 
{
    /*
        You are given a string s and an integer k. You can choose any character of the string and change it to 
        any other uppercase English character. You can perform this operation at most k times.

        Return the length of the longest substring containing the same letter you can get after performing the 
        above operations.

        Example: 
            Input: s = "AABABBA", k = 1
            Output: 4
            Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
            The substring "BBBB" has the longest repeating letters, which is 4.
    */
    public static int characterReplacement(String s, int k)
    {
        HashMap<Character, Integer> frequentChar = new HashMap<>();

        int maxResult = 0;   
        int maxCountRepeatingChar = 0;

        int start = 0;
        for(int end = 0; end < s.length(); end++)
        {
            char currentChar = s.charAt(end);

            //register or add 1 to hasmap of frequent letter
            frequentChar.put(currentChar, frequentChar.getOrDefault(currentChar, 0) + 1);

            //check character that needs to be change(the one that has the least amount)
            maxCountRepeatingChar = Math.max(maxCountRepeatingChar, frequentChar.get(currentChar));

            //not much k tokens to change the current length of string; so minimize by start++;
            if((end - start + 1) - maxCountRepeatingChar > k)
            {
                frequentChar.put(currentChar, frequentChar.get(s.charAt(start)) - 1);
                start++;   
            }

            maxResult = Math.max(maxResult, end - start + 1);   
        }
        return maxResult;
    }

    //using only array and without hashmap
    public static int replaceCharacter(String s, int k)
    {
        int[] array = new int[26];

        int maxResult = 0;
        int maxCountRepeatingChar = 0;

        int start = 0;
        for(int end = 0; end < s.length(); end++)
        {
            //subtract end - 'A' to get the index
            array[s.charAt(end) - 'A']++;

            maxCountRepeatingChar = Math.max(maxCountRepeatingChar, array[s.charAt(end) - 'A']);

            if((end - start + 1) - maxCountRepeatingChar > k)
            {
                array[s.charAt(start) - 'A']--;
                start++;
            }

            maxResult = Math.max(maxResult, end - start + 1);
        }
        return maxResult;
    }

/*************************************************************************************************** */
    public static void main(String[] args) 
    {
        String test = "AABABBA";
        int k = 1;

        int result = characterReplacement(test, k);
        System.out.println(result);


    }
}
