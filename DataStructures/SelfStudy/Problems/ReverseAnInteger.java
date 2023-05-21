package DataStructures.SelfStudy.Problems;

public class ReverseAnInteger 
{
    /*
        Given an Integer, return the Integer x with its digits reversed
        
        Example: 
            input: 1234
            output: 4321
     */

    public static int reverseInteger(int value)
    {
        String valueAsString = "";

        while(value != 0)
        {
            //store the last digit with the help of % operator
            String lastDigit = String.valueOf(value % 10); // 1234 % 10 = 4 

            valueAsString = valueAsString + lastDigit; //concatenate the last digit in each iteration

            //Remove the last digit and proceed to the next last digit
            value = value / 10;
        }

        return Integer.parseInt(valueAsString); //return back as a String
    }

    public static int reverseIntegerWithoutString(int value)
    {
        int reverse = 0;

        //Given value = 1234

        while(value > 0)
        {
            int lastDigit = value % 10; // 1234 % 10 = 4 --> 123 % 10 = 3 ...

            reverse = reverse * 10 + lastDigit; //0 * 10 + 4 = 4 --> 4 * 10 + 3 = 43 ...

            value = value / 10;
        }

        return reverse;
    }

/****************************************************************************************************** */
    public static void main(String[] args) 
    {
        int test = 24312323;

        int result = reverseInteger(test);
        int result2 = reverseIntegerWithoutString(test);

        System.out.println("Result 1: " + result);
        System.out.println("Result 2: " + result2);

    }
}
