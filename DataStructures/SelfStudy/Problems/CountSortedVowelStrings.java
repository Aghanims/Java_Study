package DataStructures.SelfStudy.Problems;

import java.util.*;

public class CountSortedVowelStrings 
{
    /*
        Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

        A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

        Example 1:

        Input: n = 1
        Output: 5
        Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
        Example 2:

        Input: n = 2
        Output: 15
        Explanation: The 15 sorted strings that consist of vowels only are
        ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
        Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
        Example 3:

        Input: n = 33
        Output: 66045 
     
    */
    public static int countVowelStrings(int n) 
    {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        /*
            
        */

        List<String> vowelPerm = new ArrayList<>();
        backtrack(vowels, vowelPerm, new StringBuilder(), n);

        return vowelPerm.size();
    }

    private static void backtrack(char[] vowels, List<String> vowelPerm, StringBuilder currPerm, int n)
    {
        if(currPerm.length() == n) //conditions when goal is reached
           vowelPerm.add(currPerm.toString());
        else 
        {
            for(int i = 0; i < vowels.length; i++) //iterate choices
            {
                //make changes
                currPerm.append(vowels[i]);

                //backtrack call
                backtrack(vowels, vowelPerm, currPerm, n);

                //undo changes
                currPerm.delete(currPerm.length() - 1, currPerm.length());
            }
        }
    }

    public static void main(String[] args) 
    {
        int test = countVowelStrings(2);
        System.out.println(test);
    }    
}
