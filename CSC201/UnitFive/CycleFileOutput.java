package CSC201.UnitFive;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CycleFileOutput 
{
//Unit #3, Problem #2

    public static void main(String[] args) 
    {
        String fileName = "Cycle.txt"; //reference to the file as a String

        PrintWriter outputStream = null; //To access methods outside the local variable
        try
        {
            outputStream = new PrintWriter(fileName);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(fileName + " not found");
            System.exit(0);
        }

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter number of wheels: ");
        int numberOfWheels = keyboard.nextInt();
        System.out.print("Enter weight: ");
        int weight = keyboard.nextInt();

        CycleFileOutput bike = new CycleFileOutput(numberOfWheels, weight);

        outputStream.println(bike.toString());
        outputStream.close();
        System.out.println("Texts are displayed at " + fileName);
        keyboard.close();
    }

   private int numberOfWheels;
   private int weight;

   public CycleFileOutput(int numberOfWheels, int weight)
   {
        this.numberOfWheels = numberOfWheels;
        this.weight = weight;
   }

   //default constructo
   public CycleFileOutput()
   {
       this(100, 1000);
   }

   public String toString()
   {
        return "number of Wheels: " + numberOfWheels + "\n" +
                "Weight: " + weight + " lbs";
   }
}
