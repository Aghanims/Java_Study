package Chapter2Exercises;

import java.util.Scanner;

public class Number3 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        float xValue;

        System.out.print("Enter floating-point number:  ");
        xValue = input.nextFloat();

        int yValue = (int)xValue % 2;
        int zValue = (int)xValue;

        System.out.println("\nThe modulus of " + xValue +  " is equals to " + yValue);
        System.out.println(zValue + " is the integer form of " + xValue );
        
        input.close();

    }
}
