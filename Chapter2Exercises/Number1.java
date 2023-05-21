package Chapter2Exercises;

import java.util.Scanner;

public class Number1
{
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);
    
    float xValue, yValue, minus1;

    System.out.print("Enter an x-value:  ");
    xValue = input.nextFloat();

    yValue = (float)1.0 / xValue;
    minus1 = yValue -1 ;

    System.out.println("The values are: ");
    System.out.println("x-value:  " + xValue);
    System.out.printf("y-value:  %2.2f\n", yValue);
    System.out.printf("y-value decrement:  %2.2f", minus1);
    

    input.close(); 

    }
}