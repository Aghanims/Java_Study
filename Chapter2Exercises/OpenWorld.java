package Chapter2Exercises;

import java.util.Scanner;

public class OpenWorld
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        for(int i = 1; i <= 5; i++ )
        {
           for(int c = 0; c < i; c++)
           {
            System.out.print("*");
           }
           System.out.println();
        }

        for(int r = 5; r >= 1 ; r--)
        {
            for(int x = 0; x < r; x++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

            
        input.close();

    } 
}
