package ExceptionHandling.CatchingMultipleException;
import java.util.Scanner;

public class TwoCatchesDemo 
{
    public static void main(String[] args) 
    {
        try
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter number of widgets: ");
            int widgets = keyboard.nextInt();

            if(widgets < 0)
                throw new NegativeNumberException("widgets");
            
            System.out.print("How many were defective: ");
            int defective = keyboard.nextInt();

            if(defective < 0)
                throw new NegativeNumberException("defective widgets");

            double ratio = exceptionalDiviison(widgets, defective);

            System.out.println("One in every " + ratio + " widgets is defective");
        }
        catch(DivideByZeroException e) // specific exception should be first after the parent exception like "Exception"
        {
            System.out.println("Congratulations! A perfect record!");
        }
        catch(NegativeNumberException e)
        {
            System.out.println("Cannot have a negative number of " + e.getMessage());
        }

    }    

    public static double exceptionalDiviison(double numerator, double denominator) throws DivideByZeroException
    {
        if(denominator == 0)
            throw new DivideByZeroException();
        
        return numerator / denominator;
    }
}
