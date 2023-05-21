package Chapter2Exercises;

import java.util.Scanner;

public class Number2 
{
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter an x-value:  ");
    float xValue = input.nextFloat();

    int yValue = (int)xValue;
    byte zValue = (byte)xValue;

    System.out.println("Floating-point x-value:  " + xValue);
    System.out.println("Integer y-value:  " + yValue);
    System.out.println("Byte z-value:  " + zValue);

    input.close();




    }
}
