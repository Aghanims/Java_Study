package DataStructures.Queue.LabExamples;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TicketingService 
{

   public static void main (String[] args) 
   {
      Scanner scnr = new Scanner(System.in);
      String personName = "";
      int counter = 0;
      int youPosition = 0;

      Queue<String> peopleInQueue = new LinkedList<String>();
      
      personName = scnr.nextLine();

      String[] placeofYou = new String[peopleInQueue.size()];
      
      while (!personName.equals("-1")) 
      {
         // TODO: Add personName to peopleInQueue and 
         //       determine position of "You" (youPosition)              
         
         peopleInQueue.add(personName);

         if(personName.equalsIgnoreCase("You"))
         {
            youPosition = counter + 1;
         }
         counter++;

         personName = scnr.nextLine();
      }

      System.out.println("Welcome to the ticketing service... ");
      System.out.println("You are number " + youPosition + " in the queue.");

      // TODO: In a loop, remove head person from peopleInQueue,                                    
      //       output their name and that they have purchased a ticket,                             
      //       then output your position in the queue. When you are at                              
      //       the head, output that you can purchase your ticket.    
      
      while(!peopleInQueue.peek().equalsIgnoreCase("You"))
      {
         System.out.println(peopleInQueue.remove() + " has purchased a ticket.");
         System.out.println("You are now " + (--youPosition));
      }
      System.out.println("You can now purchase your ticket!");

   }
}
