package DataStructures.SelfStudy.Problems;

import java.util.Deque;
import java.util.LinkedList;

public class IsPalindrome 
{

    public static boolean isPalindrome(String input)
    {
        Deque<Character> container = new LinkedList<>(); //data structure to be used

        //store string input to the container
        for(int i = 0; i < input.length(); i++)
        {
            container.add(input.charAt(i));
        }

        //compare first and last char and poll afterwards until empty
        //return false if a comparison does not match
        while(container.size() > 1)
        {
            if(container.getFirst() != container.getLast())
                break;
            else//remove first and last element if it's a match
            {
                container.pollFirst();
                container.pollLast();
            }
        }

        if(container.size() <= 1)
            return true;
        
        return false;
    }

    /* 
        Given a String, return the longest palindromic substring in String.

        Example:
            input: s = "babad"
            outpout: "bab"
            explanation: "aba" is also a valid answer

            input: s = "cbbd"
            output: "bb"

        modification: print all possibe longest palindromic substring
    */
    public static String longestPalindromSubstring(String word)
    {
        if(word.length() <= 1)  {return word;}

        //idea: traverse each char and compare its left and right till end until characters are not equals; record its currentLength and maxLength
        // recordd the start index and endIndex of the substring of the greatest length.

        int maxLength = 1;
        boolean evenLetters = word.length() % 2 == 0; 

        int startIndex= 0; //variable to record the start and end index of the current longest palindromic substring
        int endIndex = 0;

        for(int i = 0; i < word.length() -1; i++)
        {
            int leftPointer = i;
            int rightPointer = i;

            //a case where word.length is even
            if(evenLetters)
                rightPointer = i + 1;
        
            while(leftPointer >= 0 && rightPointer < word.length())
            {
                if(word.charAt(leftPointer) == word.charAt(rightPointer))
                {
                    leftPointer--;
                    rightPointer++;
                }
                else
                    break; 
            }

            int currentLength = (rightPointer - leftPointer) - 1;
            if(currentLength > maxLength)
            {
                maxLength = currentLength;
                startIndex = leftPointer + 1;
                endIndex = rightPointer - 1;
            }
        }
        return word.substring(startIndex, endIndex + 1);
    }

/*************************************************************************************************** */
    
/*
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
 removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric 
 characters include letters and numbers.
    
    Example: 
        input: s = "A man, a plan, a canal: Panama"
        output: true

    --> "amanaplanacanalpanama" is a palindrome.
*/

    public static boolean isPhrasePalindrome(String phrase)
    {   
        
        int startPointer = 0;
        int endPointer = phrase.length() - 1;

        while(startPointer < endPointer)
        {
            char startChar = phrase.charAt(startPointer);
            char endChar = phrase.charAt(endPointer);

            //if char at StartIndex is not a letter or a digit
            if(!Character.isLetterOrDigit(startChar))
            {
                startPointer++;
                continue;
            }

            //if char at EndIndex is not a letter of digit
            if(!Character.isLetterOrDigit(endChar))
            {
                endPointer--;
                continue;
            }

            //compare if not the same char
            if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar))
                return false;
            
            startPointer++;
            endPointer--;
        }
        return true;
    }


/*************************************************************** */
    public static void main(String[] args) 
    {
        String word = "raceacar";
        String word2 = "nakakapagbabagabag";
        String test = "babad";
        //String test2 = "cbbd";
        
        System.out.println(isPalindrome(word));
        System.out.println(isPalindrome(word2));

        System.out.println(longestPalindromSubstring(test));

        String phrase = "A man, a plan, a canal: Panama";
        System.out.println("is the phrase \"" + phrase + "\" a palindrome: " + isPhrasePalindrome(phrase));
        System.out.println(isPhrasePalindrome(phrase));

    }
}
