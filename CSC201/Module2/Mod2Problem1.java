package CSC201.Module2;
import java.util.Scanner;
//Module 2: Problem #1

/*
    Algorithm: 
    - ask user for total number of students
    - create an array that holds the categrories of each boxes
    - create a loop that ask each students how many boxes of cookies they sold.
    - increment the value on one the the index of the array depending on the answer.
 */
public class Mod2Problem1
{
    public static final int SIZE = 5;
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Total number of girl scouts: ");
        int girlScuouts = input.nextInt();

        int[] boxesSold = new int[SIZE];
        /*
        boxesSold[0] = 0 to 10 boxes
        boxesSold[1] = 11 to 20 boxes
        boxesSold[2] = 21 to 30 boxes
        boxesSold[3] = 31 to 40 boxes
        boxesSold[4] = 41 or more boxes
        */

        for(int index = 1; index <= girlScuouts; index++)
        {
            System.out.print("Enter total of sold boxes for girl #" + index + ": ");
            int totalSold = input.nextInt();

            if((totalSold >= 0) && (totalSold <= 10))
                boxesSold[0]++;
            else if((totalSold >= 11) && (totalSold <= 20))
                boxesSold[1]++;
            else if((totalSold >= 21) && (totalSold <= 30))
                boxesSold[2]++;
            else if((totalSold >= 31) && (totalSold <= 40))
                boxesSold[3]++;
            else if(totalSold >= 41)
                boxesSold[4]++;
            else
                System.out.println("invalid input; cannot be negative");
        }

        display(boxesSold);

        input.close();    
    }

    public static void display(int[] boxesSold)
    {
        System.out.println("TOTAL BOXES \t\t\t NUMBER OF GIRL SCOUTS");
        System.out.println("0 to 10\t\t\t\t" + boxesSold[0]);
        System.out.println("11 to 20\t\t\t" + boxesSold[1]);
        System.out.println("21 to 30\t\t\t" + boxesSold[2]);
        System.out.println("31 to 40\t\t\t" + boxesSold[3]);
        System.out.println("41 or more\t\t\t" + boxesSold[4]);
    }
}
