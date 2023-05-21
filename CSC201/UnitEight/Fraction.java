package CSC201.UnitEight;

import java.util.Scanner;

import java.io.Serializable; //So that we can store this file to "SerialF.dat"; which is a binary file

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Poblem#1
public class Fraction implements Serializable
{
    private int numerator;
    private int denominator;
    // private static char slash = '/';

    public Fraction() throws DivideByZeroException
    {
        this(0, 1);
    }

    public Fraction(int numerator, int denominator) throws DivideByZeroException
    {
        this.numerator = numerator;

        if(denominator == 0)
            throw new DivideByZeroException();
        else
            this.denominator = denominator;
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setNumerator(int newNumerator)
    {
        numerator = newNumerator;
    }

    public void setDenominator(int newDenominator)
    {   
        denominator = newDenominator;
    }

    public String toString()
    {
        return (getNumerator() + "/" + getDenominator());
    }

    
    //The main method will write the file to "SerialF.dat"
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        ObjectOutputStream outputStream = null;
        String fileName = "SerialF.dat";

        try
        {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        }
        catch(IOException e)
        {
            System.out.println("Error opening file " + fileName + ".");
            System.exit(0);
        }

        boolean judge = true;
        try
        {
            do
            {
            System.out.println("Enter a fraction: (#/#)");
            String fraction = keyboard.nextLine();

            //separates the string into two pieces in order for placement to the constructor Fraction(numerator, denominator)
            String[] portion = fraction.split("/"); 
            int numerator = Integer.parseInt(portion[0]);        //  portion[0]   splitIdentifier       portion[1]
            int denominator = Integer.parseInt(portion[1]);     //   SomeNumber          /             SomeNumber

            Fraction object = new Fraction(numerator, denominator); //Fraction object creation

            outputStream.writeObject(object); //sent to SeriaF.dat

            System.out.println("Do you want to continue? (y/n)");
            String answer = keyboard.nextLine();
            if(answer.equalsIgnoreCase("n"))
                judge = false;
            else 
                judge = true;

            }while(judge == true);

            outputStream.close(); //closing the Stream
            keyboard.close();
        }
        catch(DivideByZeroException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Error opening file " + fileName + ".");
            System.exit(0);
        }

        System.out.println("Fraction objects are sent to file " + fileName + ".");
        System.exit(0);
    }
}
