package DataStructures.SelfStudy.Problems;

public class Subsequence 
{

    public static boolean isSubsequence(String word, String subsequence)
    {
        int wordIterator = 0;
        int subsequenceIterator = 0;

        while(wordIterator < word.length() && subsequenceIterator < subsequence.length())
        {
            char currentChar = word.charAt(wordIterator);
            char subCurrentChar = subsequence.charAt(subsequenceIterator);

            if(currentChar == subCurrentChar) //compares wheter the index value of word is equal to the subsequence
                subsequenceIterator++;

            wordIterator++;
        }

        return subsequenceIterator == subsequence.length();
    }

/*******************************************************************************/
    
    public static void main(String[] args) 
    {
        String test = "richmond";
        String subsequence = "rcio";

        boolean judge = isSubsequence(test, subsequence);
        System.out.println(judge);
    }
}
