package Recursion;
import java.util.Scanner;

public class ArraySearcherDemo 
{
    public static void main(String[] args) 
    {
        int[] anArray = new int[10];
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 integers in increasing order");  
        System.out.println("One per line");  
        for(int index = 0; index < 10; index++)
            anArray[index] = input.nextInt();
            
        System.out.println();

        for(int index = 0; index < 10; index++)
            System.out.println("a[" + index + "]= " + anArray[index] + " " );

        System.out.println();
        System.out.println();

        ArraySearcher finder = new ArraySearcher(anArray);
        String ans;
        do
        {
            System.out.print("Enter a value to search for: ");
            int target = input.nextInt();
            int result = finder.find(target);

            if(result < 0)
                System.out.println(target + " is not in the array.");
            else
                System.out.println(target + " is at index " + result);
            System.out.println("Again?");
            ans = input.next();
        } while(ans.equalsIgnoreCase("yes"));

        System.out.println("May you find what you're searching for.");

        input.close();
    }
}
