package DataStructures.SelfStudy.Problems;

import java.util.Arrays;

public class PermutationInString 
{
    /*
        Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

        In other words, return true if one of s1's permutations is the substring of s2.

        Example: 
            Input: s1 = "ab", s2 = "eidbaooo"
            Output: true
            Explanation: s2 contains one permutation of s1 ("ba").

            Input: s1 = "ab", s2 = "eidboaoo"
            Output: false
    */
    public static boolean checkInclusion(String s1, String s2)
    {
        if(s1.length() > s2.length()) return false;

        int[] array1 = new int[26];
        int[] array2 = new int[26];

        //register alphabet of s1 into array1
        for(int i = 0; i < s1.length(); i++)
        {
            char currentChar = s1.charAt(i);
            array1[currentChar - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++)
        {
            char currentChar = s2.charAt(i);

            array2[currentChar - 'a']++;

            //decrement the character from the start to ith index from s2; to accomodate the length of s1
            if(i >= s1.length())
                array2[s2.charAt(i - s1.length()) - 'a']--;
            
            //directly return true if both array is identical. no need to iterate whol string
            if(Arrays.equals(array1, array2))
                return true;
        }
        return false;
    }

/***************************************************************************************************************** */
    public static void main(String[] args) 
    {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }    
}
