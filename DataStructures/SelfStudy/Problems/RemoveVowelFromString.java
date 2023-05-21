package DataStructures.SelfStudy.Problems;

import java.util.Set;

public class RemoveVowelFromString 
{
    /*
        Given a Sting, remove the vowels from the String and return the String without vowels. 
        The String will contain lowercase letters. 
     */

    public static String removeVowels(String input)
    {
        //Set use for comparing character in each iteration 
        Set<Character> vowels = Set.of('a', 'e', 'i','o', 'u'); 

        //Create a new String without the vowels.
        StringBuilder newString = new StringBuilder();

        for(int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i);

            if(!vowels.contains(currentChar)) //append all non vowel letter
                newString.append(currentChar);    
        }

        return newString.toString();
    }

/********************************************************************************************************* */
    public static void main(String[] args) 
    {
        String phrase = "nakakapagbabagabag";

        String noVowels = removeVowels(phrase);

        System.out.println(noVowels);
    }
}
