package Class_ArrayProject;
import java.util.Scanner;

public class ProblemTwo 
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter number of sequence: ");// The row
        int row = keyboard.nextInt();

        char[][] values = new char[row][]; //the row of the array named "values" is instantiated

        //This for-loop will instantiate the columns for each row
        for(int index = 1; index <= values.length; index++)
        {
            System.out.println("Enter the maximum values for sequence " + index + ":");
            int maxValues = keyboard.nextInt();
            values[index-1] = new char[maxValues];// this will create the 2d array; the column will differ depending on the inputted values.
        }

        //reads and outputs the caption along with the asterisk which represents the number of values of the elements.
        for(int index = 0; index < values.length; index++)
        {   
            System.out.print("Caption for sequence " + (index+1) + ":  ");
            String caption = keyboard.next();  
            System.out.print(caption);
            for(int column = 0; column < values[index].length ; column++)// loop that prints the asterisk
            {
                values[index][column] = '*';
                System.out.print(values[index][column]);
            }
            System.out.println();
        }
        keyboard.close();
    }
}
