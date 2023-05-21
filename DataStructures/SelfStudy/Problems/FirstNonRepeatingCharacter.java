package DataStructures.SelfStudy.Problems;

import java.util.HashMap;

public class FirstNonRepeatingCharacter 
{
    /*
        Given a String word, return the index of first non-repeating character in it.
        If it does not exist, return -1. The String will only contain lowercase letters.

        Example:
            Input: word = "codeforcode"
            output: 4
            --> because the first non-repeating character is "f" and is found at index 4

            Input: word = "aabb"
            Output: -1
            --> because there is no non-repeating character
     */

    public static int firstNonRepeatingChar(String word)
    {
        HashMap<Character, Integer> letterFrequency = new HashMap<>();

        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);

            //concise code: letterFrequency.put(currentChar, letterFrequency.getOrDefault(currentChar, 0) + 1);

            if(!letterFrequency.containsKey(currentChar)) //if character is non-existent in the map
                letterFrequency.put(currentChar, 1);
            else //if there is a character currently exist in the map; then just add 1
            {
                int currentValue = letterFrequency.get(currentChar);

                letterFrequency.put(currentChar, currentValue + 1);
            }
        }

        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);

            if(letterFrequency.get(currentChar) == 1)
                return i; 
            
        }
        return -1;
    }



/**********************************************************************************************************************/
    public static void main(String[] args) 
    {
        String word = "nakakapagbabagabag"; 

        int result = firstNonRepeatingChar(word);

        if(result == -1)
            System.out.println("Non-repeating character is non-existent.");
        else
            System.out.println("First non-repeating character is at index " + result + ", which is letter " + word.charAt(result));
        
    }
}   
