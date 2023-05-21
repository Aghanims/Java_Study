package DataStructures.SelfStudy.RecursionAndDynamicProgramming;

public class WordScrambler 
{
    //print all possible scramble combination of a word

    public static void allWordCombinations(String word)
    {
       wordScrambler(word, "");
    }

    private static void wordScrambler(String remaining, String scrambled)
    {
        /*
            1. iterate throughout the original word(remaining)
            2. in each iteration, add the char of the index on the scrambled word
            3. Recurse and stop until remaining words are empty; 
            4. print scrambled word if remaining is empty.
         */
        
        String charAtIndex;

        if(remaining.length() == 0)
        {
            System.out.println(scrambled);
        }
        else
        {
            //step1
            for(int i = 0; i < remaining.length(); i++)
            {
                //step2:
                charAtIndex = remaining.substring(i, i + 1); //char to be combined with the scrambled word

                //remove the letter at the index
                remaining = removeCharFromIndex(remaining, i);

                //add the letter at the index to the scrambled letters
                scrambled = scrambled + charAtIndex;

                wordScrambler(remaining, scrambled);

                //add back the letter to the original position
                remaining = insertAtIndex(remaining, charAtIndex, i);

                //remove back the letter to start the new sequence
                scrambled = removeCharFromIndex(scrambled, scrambled.length() - 1);
            }
        }
    }

    //returns a String without the character of the specified index
    private static String removeCharFromIndex(String word, int index)
    {
        //copy the portion of the word up to index
        String firstPartition = word.substring(0, index);

        //copy the second partition one space from the index 
        String secondPartition = word.substring(index + 1, word.length());
        
        String combine = firstPartition + secondPartition;
        return combine;
    }

    //insert String at the specifide index
    private static String insertAtIndex(String word, String insertedWord ,int index)
    {
        //String partition from 0 to the index
        String firstPartition = word.substring(0, index);

        //String partition from index to the length
        String secondPartition = word.substring(index, word.length());

        return firstPartition + insertedWord + secondPartition;
    }




/******************************************************* */
    public static void main(String[] args) 
    {
        String word = "nakakapagbabagabag";

        allWordCombinations(word);

    }    
}
