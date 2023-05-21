package Recursion;

import java.util.Scanner;

//output example:  parameter(12, 3) = 12 9 6 3 0 3 6 9 12
public class NumberPattern 
{
   public static int x, count;
   
   public static void printNumPattern(int num1, int num2)
   {
      if (num1 > 0 && x == 0) 
        {
            System.out.print(num1 + " ");
            count++;
            printNumPattern(num1 - num2, num2);
        } 
        else if(num1 == 0)
        {
            x = 1;
            count++;
            System.out.print(num1 + " ");
            System.out.print(num1 - num2 + " ");
            System.out.print(num1+ " ");
            count = count -2;
            printNumPattern(num1 + num2, num2);
        }
        else 
        {
            x = 1;

            if (count >= 0) 
            {
                System.out.print(num1 + " ");
                count--;
                
                if (count < 0)            
                    System.exit(0);          
                
                printNumPattern(num1 + num2, num2);
            }
            

         }
    }
  
   public static void main(String[] args) 
   { 
      Scanner scnr = new Scanner(System.in);
      int num1;
      int num2;
      
      num1 = scnr.nextInt();
      num2 = scnr.nextInt();
      printNumPattern(num1, num2); 

      scnr.close();
   } 
} 
