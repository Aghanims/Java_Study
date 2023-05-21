package CSC208;

import java.util.ArrayList;
import java.util.Arrays;

public class SymmetricDifference 
{
    public static ArrayList<Character> symmetricDifference(char[] arrayA, char[] arrayB)
    {
        ArrayList<Character> result = new ArrayList<>();

        //add every elements of arrayA in the list
        for(int i = 0; i < arrayA.length; i++)
        {
            char currentChar = arrayA[i];
            result.add(currentChar);    
        }

        //traverse arrayB and remove the elements in the result list if arrayB[i] is already in the list
        for(int  i = 0; i < arrayB.length; i++)
        {
            char currentChar = arrayB[i];

            if(result.contains(currentChar))
                result.remove(result.indexOf(currentChar));
            else 
                result.add(currentChar);                
        }

        return result;
    }
   
    
    //test
    public static void main(String[] args) 
    {
        char[] arrayA = {'a' , 'b', 'c', 'e', 'f'};
        char[] arrayB = {'d', 'e', 'f', 'g'};   

        ArrayList<Character> result = symmetricDifference(arrayA, arrayB);

        System.out.println("arrayA: " + Arrays.toString(arrayA));
        System.out.println("arrayB: "+ Arrays.toString(arrayB));
        System.out.println("Symmetric Difference operation: " + Arrays.toString(result.toArray()));
    }
}
