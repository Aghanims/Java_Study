package ClassNotes;
import java.util.Scanner;

public class ReturnArrayDemo 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter score on exam 1: ");
        int firstScore = keyboard.nextInt();
        
        int[] nextScore = new int[3];
        for(int index = 0; index < nextScore.length; index++)
        {
            nextScore[index] = firstScore + 5 * index;
        }

        double[] averageScore = getArrayAverages(firstScore, nextScore);
        for(int i = 0; i < nextScore.length; i++)
        {
            System.out.println("If your score on exam 2 is " + nextScore[i]);
            System.out.println("Your average will be " + averageScore[i]);
        }

        keyboard.close();
    } 
    
    public static double[] getArrayAverages(int firstScore, int[] nextScore)
    {
        double[] temp = new double[nextScore.length];
        for(int i = 0; i < temp.length; i++)
        {
            temp[i] = getAverage(firstScore, nextScore[i]);
        }
        return temp;
    }

    public static double getAverage(int n1, int n2)
    {
        return (n1 + n2) / 2.0;
    }
}
