package ClassNotes;
import java.util.Scanner;

public class ArrayArgument 
{
    public static void main(String[] args)
    {
        //using indexed variables as an argument

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your score on exam 1: ");
        int firstScore = keyboard.nextInt();

        int[] nextScore = new int[3];
        for(int i = 0; i < nextScore.length; i++)
        {
            nextScore[i] = firstScore + 5 * i;
        }
        for(int i = 0; i < nextScore.length; i++)
        {
            double possibleAverage = getAverage(firstScore, nextScore[i]);

            System.out.println("If your score on exam 2 is " + nextScore[i]);
            System.out.println("your average wil be " + possibleAverage);
        }

        keyboard.close();
    }   
    
    public static double getAverage(int n1, int n2)
    {
        return (n1 + n2) / 2.0;
    }
}
