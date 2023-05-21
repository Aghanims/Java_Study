package DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

// Creating To-Do-List using Arraylist
public class ArrayListDemo
{
    public static void main(String[] args) 
    {
        ArrayList<String> toDoList = new ArrayList<>();

        System.out.println("Enter items for the list, when prompted");

        Scanner keyboard = new Scanner(System.in);

        boolean done = false;
        while(!done)
        {
            System.out.println("Type an entry:");
            String entry = keyboard.nextLine();
            toDoList.add(entry);
            
            System.out.println("More items for the list?");
            String ans = keyboard.nextLine();
            if(!ans.equalsIgnoreCase("yes"))
                done = true;
        }

        System.out.println("The list contains:");
        int listSize = toDoList.size();
        for(int position = 0; position < listSize; position++)
        {
            System.out.println(toDoList.get(position));
        }

        /*
            can be replaced with:

            for(String element: toDoList)
                System.out.println(element);

        */

        toDoList.trimToSize(); // to save memory space
        keyboard.close();
    }    
}
