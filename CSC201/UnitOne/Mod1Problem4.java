package CSC201.UnitOne;
/*
    Scope: Creating methods for complex numbers calculation

    Algorithm:
    * Ask user for input for two complex numbers
    * create object for complex numbers.
    * all input should be a floating type
    * The real part is "a" and the imaginary part is "b"
    * Assign the two complex numbers to a variable "z1" and "z2"
    * Create a static methods for specific calculations:
        * Addition: //complexDivision(float z1, float z2);
            - z1 + z2=(a1+a2) +  i*(b1+b2)
        * Subtraction //complexSubtraction();
            - z1 - z2=(a1-a2) +  i*(b1-b2)
        * Multiplication
            - z1*z2 = (a1*a2 – b1*b2) + i*(a1*b2 + b1*a2)
        * Division 
            - z1/z2 = (a1*a2 +b1*b2)/(a2^2 + b2^2) + i*(b1*a2 – a1*b2)/(a2^2 + b2^2)

*/
import java.util.Scanner;

public class Mod1Problem4 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter value of the real number on experssion #1: ");
        float real1 = keyboard.nextFloat();
        System.out.print("Enter value of the imaginary number on expression #1: ");
        float imaginary1 = keyboard.nextFloat();

        ComplexNumber z1 = new ComplexNumber(real1, imaginary1); //object for complex expression number #1

        System.out.print("Enter value of the real number on experssion #2: ");
        float real2 = keyboard.nextFloat();
        System.out.print("Enter value of the imaginary number on expression #2: ");
        float imaginary2 = keyboard.nextFloat();

        ComplexNumber z2 = new ComplexNumber(real2, imaginary2); //object for second expression
        
        System.out.println();
        z1.complexAddition(z2);
        System.out.println();
        z1.complexSubtraction(z2);
        System.out.println();
        z1.complexMultiplication(z2);
        System.out.println();
        z1.complexDivision(z2);

        keyboard.close();
    }    
}
