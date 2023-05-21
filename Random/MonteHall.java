package Random;
import java.util.Scanner;

public class MonteHall 
{
    int[] doors = {0,0,0,};

    public static void main(String[] args) 
    { 
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of trial simulation: ");
        int trials = input.nextInt(); // n  trials
        int wins = 0;                 // n times you win by switching
        int choiceWin = 0;    // n times win by choosing the correct door

        // repeat simulation by # of trials
        for (int i = 0; i < trials; i++) 
        {
            // host hides prize behind 1 of 3 doors in random
            int prize  = (int) (3 * Math.random());

            // contestant selects 1 of 3 doors in random
            int choice = (int) (3 * Math.random());

            // at random, host reveals an unchosen door not containing prize
            int reveal;
            do 
            {
                reveal = (int) (3 * Math.random());
            } while ((reveal == choice) || (reveal == prize));

            int other = 0 + 1 + 2 - reveal - choice;

            // switching leads to a win
            if (other == prize) 
                wins++;
            // initial choice win
            else if(choice == prize)
                choiceWin++;    
        } 
        System.out.println();
        System.out.println("Number of trials: " + trials);
        System.out.println("Wins by initial choice: " + choiceWin);
        System.out.println("Wins by switching: " + wins);

        input.close();
    }

}

