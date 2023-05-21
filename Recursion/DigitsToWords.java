package Recursion;

import java.util.Scanner;

public class DigitsToWords 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer");    
        int number = input.nextInt();

        System.out.println("The digits in that number are:");
        displayAswords(number);
        System.out.println();

        System.out.println("If you add ten to that number, ");
        System.out.println("The digits in the new number are: ");
        number = number + 10;
        displayAswords(number);
        System.out.println();

        input.close();
    }

    /*
        Precondition: number >= 0;
        display the digits in number as words.
     */

     public static void displayAswords(int number)
     {
        if(number < 10)
            System.out.print(getWordFromDigit(number) + " ");
        else//number has two or more digits
        {
            displayAswords(number / 10); // recursive call
            System.out.print(getWordFromDigit(number % 10) + " ");
            
        }
     }

     //Precondition: 0 <= digit <=9
     //Returns the word for the argument digit.
     private static String getWordFromDigit(int digit)
     {
        String result = null;

        switch(digit)
        {
            case 0: result = "zero"; break;
            case 1: result = "one"; break;
            case 2: result = "two"; break;
            case 3: result = "three"; break;
            case 4: result = "four"; break;
            case 5: result = "five"; break;
            case 6: result = "six"; break;
            case 7: result = "seven"; break;
            case 8: result = "eight"; break;
            case 9: result = "nine"; break;   
            default:
            {
                System.out.println("Fatal error");
                System.exit(0);
            }
        }
        return result;
     }
}
