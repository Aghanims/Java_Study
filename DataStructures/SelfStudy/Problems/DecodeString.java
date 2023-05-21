package DataStructures.SelfStudy.Problems;

import java.util.Stack;

public class DecodeString 
{
    /*
        Given an encoded String, return its decoded String.

        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being 
        repeated exactly k times. Note that k is guaranteed to be a positive integer.

        You may assume that the input string is always valid; No extra spaces, square brackets are well-formed, 
        etc.

        Furthermore, you may assume that the original data does not contain any digits and that digits are only 
        for those repeated numbers, k. For example, there won't be input like 3a of 2[4]

        Examples:
            s = "3[a]2[bc]", return "aaabcbc"
            s = "3[a2[c]]", return "accaccacc"
            s = "2[abc]3[cd]ef", return "abcabccdcdcdef"
    */
    public static String decodeString(String input)
    {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String totalString = "";


        //4 cases as we iterate: 
            //char at index is a number
            //char at index is '['
            //char at index is ']'
            //char at index is a letter

        int index = 0;
        while(index < input.length())
        {
            if(Character.isDigit(input.charAt(index))) //value at index is a number
            {
                int counter = 0;
                while(Character.isDigit(input.charAt(index)))
                {
                    counter = (10 * counter) + (input.charAt(index) - '0');
                    index++;
                }
                count.push(counter);
            }
            else if(input.charAt(index) == '[') //char at index is '['
            {
                result.push(totalString); 
                totalString = "";
                index++;
            }
            else if(input.charAt(index) == ']') //char at index is ']'
            {
                StringBuilder semiDecode = new StringBuilder(result.pop()); //all of current decoded string

                int printCounter = count.pop();
                for(int i = 0; i < printCounter; i++)
                    semiDecode.append(totalString);
                
                totalString = semiDecode.toString();
                index++;
            }
            else //char at index is a letter
            {
                totalString += input.charAt(index);
                index++;
            }
        }
        return totalString;
    }



/*****************************************************************************************************************/
    public static void main(String[] args) 
    {
        String test = "3[a]2[bc]";
        
        String result = decodeString(test);

        System.out.println(result);
    }
}
