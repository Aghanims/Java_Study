package DataStructures.Lists.LabExamples;

import java.util.Scanner;
import java.util.LinkedList;

public class ShoppingList 
{
   public static void main (String[] args) 
   {
      Scanner scnr = new Scanner(System.in);

        // Declare a LinkedList called shoppingList of type ListItem
        LinkedList<ListItem> shoppingList = new LinkedList<ListItem>();
        String item;
        int counter = 0;
      
      // Scan inputs (items) and add them to the shoppingList LinkedList
      //       Read inputs until a -1 is input
        System.out.println("Enter Items (enter -1 to terminate):");

        item = scnr.nextLine();
        while(item.equals("-1") != true)
        {
            shoppingList.add(new ListItem(item));
            counter++;
            item = scnr.nextLine();  
        }
        
        System.out.println();
        System.out.println("Item lists: ");
        // Print the shoppingList LinkedList using the printNodeData() method
        for(int i = 0; i < counter; i++)
        {
            shoppingList.get(i).printNodeData(); 
        }

        scnr.close();

   }
}