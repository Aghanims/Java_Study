package ClassNotes;
import java.util.Scanner;

public class ArrayPractice 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many temperatures do you have?");
        int size = keyboard.nextInt();

        double[] temperature = new double[size];

        System.out.println("Enter " + temperature.length + " temperatures:");

        double sum = 0;
        
        for(int index = 0; index < temperature.length; index++)
        {
            temperature[index] = keyboard.nextDouble();
            sum = sum + temperature[index];
        }

        double average = sum / temperature.length;

        System.out.println("The average temperature is " + average) ;

        System.out.println("The temperatures are:");
        for(int index = 0; index < temperature.length; index++)
        {
            if(temperature[index] < average)
            {
                System.out.println(temperature[index] + " is below average");
            }
            else if(temperature[index] > average)
            {
                System.out.println(temperature[index] + " is above average");
            }
            else
            {
                System.out.println(temperature[index]  + " is the average");
            }
        }

        System.out.println("Have a nice week!!!");

        keyboard.close();
    }
}
