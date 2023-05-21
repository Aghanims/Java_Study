package Recursion;

import java.util.Scanner;
import java.util.ArrayList;

/*
    Write a program that lists all ways people can line up for a photo (all permutations of a list of Strings). 
    The program will read a list of one word names (until -1), and use a recursive method to create and output all possible orderings 
    of those names separated by a comma, one ordering per line.

    Ex input: Leonard, Richmond, Nimra, Nikki -1
 */

public class PhotoLineups 
{

   // TODO: Write method to create and output all permutations of the list of names.

   public static void printAllPermutations(ArrayList<String> permList, ArrayList<String> nameList) 
   {
      if (nameList.isEmpty()) 
      {
			//Iterate through the list 
			for (int i = 0; i < permList.size(); i++) 
			{
				System.out.print(permList.get(i));
				 
                //prevent from printing extra comma and space at the end
				if(i < permList.size() -1)
				   System.out.print(", ");
			}
			System.out.println();
		} 
		else 
		{
			//Iterate through the list 
			for (int i = 0; i < nameList.size(); ++i) //iterate without changing the orignal nameList and just create tempContainer inside
			{
				//declare list 
				//create temporary list for permLists and nameList and process permutations each iteration of name
				ArrayList<String> temp = new ArrayList<String>(permList);
				temp.add(nameList.get(i)); 

				ArrayList<String> newNameList = new ArrayList<String>(nameList);
				newNameList.remove(i);
				
				//Recursive call to the method  
				printAllPermutations(temp, newNameList);
			}
		}
   }

   public static void main(String[] args) 
   {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;
      
      while (true) 
      {
			//Read input 
			name = scnr.next();
			
			//Check if input is -1
			if (name.equals("-1")) 
				break;
				
			nameList.add(name);
		}
		
		//Call method 
		printAllPermutations(permList, nameList);

        scnr.close();
	}
   
}
