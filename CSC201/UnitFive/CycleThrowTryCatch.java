package CSC201.UnitFive;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CycleThrowTryCatch 
{
    //Unit #5, Problem #1
    //Revision from Unit#3 Problem #2
 
    public static void main(String[] args) 
    {
        Scanner keyboard =  new Scanner(System.in);

        try
        {
            System.out.print("Enter number of wheels: ");
            int numOfWheels = keyboard.nextInt(); // inputMismatchException is thrown by the Scanner

            System.out.print("Enter weight: ");
            int weight = keyboard.nextInt();
            keyboard.close();

            if((numOfWheels <= 0) || (weight <= 0))
                throw new Exception("Cannot be less than or equal to 0");

            CycleThrowTryCatch bike = new CycleThrowTryCatch(numOfWheels, weight);
            System.out.println();
            System.out.println(bike.toString());
        }
        catch(InputMismatchException e)
        {
            System.out.println("Integer can only be accepted");
            System.out.println("End of program");
        }
        catch(Exception e)
        {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println("End of program");
        }
    }

   private int numberOfWheels;
   private int weight;

   public CycleThrowTryCatch(int numberOfWheels, int weight)
   {
        this.numberOfWheels = numberOfWheels;
        this.weight = weight;
   }

   //default constructo
   public CycleThrowTryCatch()
   {
       this(100, 1000);
   }

   public String toString()
   {
        return "number of Wheels: " + numberOfWheels + "\n" +
                "Weight: " + weight;
   }
}
