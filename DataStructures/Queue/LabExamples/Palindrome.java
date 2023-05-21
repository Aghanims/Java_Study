package DataStructures.Queue.LabExamples;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;

public class Palindrome 
{

   public static void main(String[] args) 
   {
      Scanner scnr = new Scanner(System.in);
      String line;

      /* Type your code here. */
      Deque<Character> compare = new LinkedList<>();

      System.out.println("Enter a String");
      line = scnr.nextLine();
      
      //put characters from String into the list
      for(int i = 0; i < line.length(); i++)
      {
         if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z')
         {
            compare.add(line.charAt(i));
         }
      }
      
      //// keep on checking first and last element of the deque and removing the first and last element
      while(compare.size() > 1)
      {
         if(compare.getFirst() != compare.getLast()) //continuous comparison of first and last element
         {
            break;
         }
         else // remove the first element of the list
         {
            compare.pollFirst();
            compare.pollLast();
         }
      }
      
      // compare.size() is greater than 1, then not a palindrome
      if(compare.size() > 1)
      {
         System.out.println("No, \"" + line + "\" is not a palindrome.");
      }
      else
      {
         System.out.println("Yes, \"" + line + "\" is a palindrome.");
      }

      scnr.close();
   }
}

