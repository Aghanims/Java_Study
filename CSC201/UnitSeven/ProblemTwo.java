package CSC201.UnitSeven;

/*
    //Chapter 11: Practice Programs #2
    Problem#2: Write a static recursive method that returns the sum of the integers in the array of int values passed to it as a 
                single argument. You can assume that every indexed variable or the array has value. Embed the method in a test program.
*/

public class ProblemTwo 
{
    public static void main(String[] args) 
    {
        int[] array = {12, 6, 5, 56, 533}; // Sum: 612

        int totalSum = sumOfArray(array, array.length);

        System.out.println("Total sum of the array of integers is " + totalSum);
    }   
    
    public static int sumOfArray(int[] array, int arrayLength)
    {                                                                                  //Whole idea:
        if(arrayLength == 0)                                                       // sumOfArray(array, 5)  --> the heading                   
            return 0;                                                              // sumOfArray(array, 5-1) + 533
        else                                                                       // sumOfArray(array, 4-1) + 589 
        {                                                                          // sumOfArray(array, 3-1) + 594
            return(sumOfArray(array, arrayLength -1) + array[arrayLength -1]);     // sumOfArray(array, 2-1) + 600
        }                                                                          // sumOfarray(array, 1-1) + 612
                                                                                   // 0(base case) + 612 = 612 
    }
}
