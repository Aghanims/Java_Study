package DataStructures.SelfStudy.Problems;

import java.util.HashMap;

public class MinimumWindowSubstring 
{
    /*
        Given two strings s and t of lengths m and n respectively, return the minimum window 
        substring   of s such that every character in t (including duplicates) is included in the window. 
        If there is no such substring, return the empty string "".

        The testcases will be generated such that the answer is unique.

 

        Example 1:
            Input: s = "ADOBECODEBANC", t = "ABC"
            Output: "BANC"
            -->Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
    */
    public static String minWindow(String s, String t)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char tValue : t.toCharArray())
            map.put(tValue, map.getOrDefault(tValue, 0) + 1);


        int matched = 0;
        int start = 0;
        int minLength = s.length() + 1;
        int startOfSubstring = 0;
        for(int endWindow = 0; endWindow < s.length(); endWindow++)
        {
            //compare element and endWindow if it matches the map and count how many are matched
            char matchingChar = s.charAt(endWindow);
            if(map.containsKey(matchingChar))
            {
                map.put(matchingChar, map.get(matchingChar) - 1);

                if(map.get(matchingChar) == 0)
                    matched++;
            }

            while(matched == map.size())
            {
                //shift the  start index of substring (delete first char)
                //minimize the length of substring and constantly update the sliding window
                if(minLength > (endWindow - start + 1))
                {
                    minLength = (endWindow - start + 1);
                    startOfSubstring = start;
                }

                //search for a shorter substring
                //return back the token points of the delete char into the hashmap
                char deleteChar = s.charAt(start);
                if(map.containsKey(deleteChar))
                {
                    //decrement matched because the substring currently don't have the required letters
                    //decrement matched if there is no tokens left(no duplicate)
                    if(map.get(deleteChar) == 0) 
                        matched--;

                    map.put(deleteChar, map.get(deleteChar) + 1);
                }
                start++;
            }
        }

        return minLength > s.length() ? "" : s.substring(startOfSubstring, startOfSubstring + minLength);
        

    }

/***************************************************************************************************************** */
    public static void main(String[] args) 
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);
        System.out.println(result);
    }
}
