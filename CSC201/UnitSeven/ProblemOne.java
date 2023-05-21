package CSC201.UnitSeven;

/*
    //Chapter 11: Practice Programs #1
    Problem: write a static recursive method that returns the number of digits in the integer passed to it as an argument of type int.
            Allow for both positive and negative arguments. For example, -120 has three digits. Do not count leading zeros. Test it.
*/

public class ProblemOne 
{
    public static void main(String[] args) 
    {
        int testNumber = -1234560;

        System.out.println(testNumber + " has the following number of digit(s): ");
        System.out.println(numberOfDigits(testNumber));
    }


    public static int numberOfDigits(int number) 
    {
        if((number > -10) && (number < 10))    
            return 1;  
        else 
            return numberOfDigits(number / 10) + 1;
    }
}
