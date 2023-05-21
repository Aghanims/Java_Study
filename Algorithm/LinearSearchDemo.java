package Algorithm;

import java.util.Scanner;

//An algorithm for Linear search
public class LinearSearchDemo 
{
   private static int linearSearch(int[] numbers, int key) 
   {
      for (int i = 0; i < numbers.length; i++) 
      {
         if (numbers[i] == key) 
         {
            return i;
         }
      }
      return -1; // not found
   }

   // Main program to test the linearSearch() method
   public static void main(String[] args) 
   {
      int[] numbers = { 2, 4, 7, 10, 11, 32, 45, 87 };
      System.out.print("NUMBERS: ");
      for (int i = 0; i < numbers.length; i++) 
      {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
      
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter an integer value: ");
      int key = scnr.nextInt();
      int keyIndex = linearSearch(numbers, key);
      
      if (keyIndex == -1) 
      {
         System.out.println(key + " was not found.");
      }
      else 
      {
         System.out.printf("Found %d at index %d.\n", key, keyIndex);
      }

      scnr.close();
   }
}
