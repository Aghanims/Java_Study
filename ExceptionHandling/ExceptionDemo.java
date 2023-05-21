package ExceptionHandling;
import java.util.Scanner;

public class ExceptionDemo 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        //The try block contains the code for the basic algorithm when everything goes smoothly.
        //It is called try block because you are not 100% sure that all will go smoothly, but you want to give it a "try"
        try
        {
            System.out.println("Enter number of donuts:");
            int donutCount = keyboard.nextInt();

            System.out.println("Enter number of milk:");
            int milkCount = keyboard.nextInt();
            
            keyboard.close();

            if(milkCount < 1)
                throw new Exception("Exception: No Milk!"); //if somehing does go wrong, you want to throw an exception, which is a way of indicating that there is some sort of problem.
            //the code in the surrounding stops executing when an exception is thrown
            double donutsPerGlass = donutCount / (double)milkCount;
            System.out.println(donutCount + " donuts");
            System.out.println(milkCount + " milk");
            System.out.println("You have " + donutsPerGlass + " donuts for each glass of milk.");
        }
        // "Catching the Exception"
        catch(Exception e)
        {
            //Every exception object has a method named ".getMessage()" ; which retrieves the string thaw was given to the exception object
            
            System.out.println(e.getMessage());
            System.out.println("Go buy some milk");
        }
        System.out.println("End of program");
    }
}
