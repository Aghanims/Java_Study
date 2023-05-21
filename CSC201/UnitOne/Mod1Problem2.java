package CSC201.UnitOne;
import java.util.Scanner;

/*
    Scope: Functionality of a Vending Machine 

    Algorithm:
    * Ask user for an integer input (1 to 5) for a selection, and 0 to exit selection
        - option 1 -> ($2)Fanta
        - option 2 -> ($2.50)Coke Zero
        - option 3 -> ($1.67)Doritios
        - option 4 -> ($3)Sparkling Water
        - option 5 -> ($5)Gatorade
    * Ask user for paying options:
     *create a loop for user to enter dollar bills, and to add them up:
        - press 1 -> to pay with 1 dollar
        - press 5 -> to pay with 5 dollars
        - press 2 -> to pay with coins
        - press 0 -> finish/ loop ends

*/
public class Mod1Problem2 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int fanta, cokeZero, doritos, sparklingWater, gatorade;
        //formatted to cents
        fanta = 200;
        cokeZero = 250;
        doritos = 167;
        sparklingWater = 300;
        gatorade = 500;

        vendingMenu();

        int totalCost = 0;
        for(int numberOfSelection = 4; numberOfSelection > 0; numberOfSelection--)
        {   
            if(numberOfSelection > 0)
            {
                System.out.println("You have maximum of " + numberOfSelection + " selections left");
                System.out.print("Please press 1 - 5 to choose snacks and beverages: ");
                int selection = input.nextInt();
                switch(selection)
                {
                    case 0:
                    {
                        numberOfSelection = 0;
                        break;
                    }
                    case 1:
                    {
                        totalCost = totalCost + fanta;
                        break;
                    }
                    case 2:
                    {
                        totalCost = totalCost + cokeZero;
                        break;
                    }
                    case 3:
                    {
                        totalCost = totalCost + doritos;
                        break;
                    }
                    case 4:
                    {
                        totalCost = totalCost + sparklingWater;
                        break;
                    }
                    case 5:
                    {
                        totalCost = totalCost + gatorade;
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Selection ended");
            }
        }
        System.out.println("Total Cost: $" + (float)totalCost / 100.0);
        
        boolean judge = true;
        int pay = 0;
        while(judge)
        {
            System.out.println("Press 1 to insert  1 dollar bill, press 5 to insert 5 dollar bill, press 2 to insert coins, press 0 to finish:");
            int identifier = input.nextInt();
            if(identifier == 1 || identifier == 5 || identifier == 2)
            {
                if((identifier== 1)||(identifier == 5))   
                    pay = (identifier * 100) + pay;
                else if(identifier == 2)
                {   
                    System.out.println("Enter either 25cents, 10cents, 5cents, or 1cent");
                    int cents = input.nextInt();
                    pay = pay + cents; 
                }
            } 
            else
            {
                judge = false;  
                input.close();
            }
        }

        double change = pay - totalCost;
        System.out.println("Your change is " + change + " cents");

        input.close();
    }

    public static void vendingMenu()
    {    
        System.out.println("1 -> ($2)Fanta\n2 -> ($2.50)Coke Zero\n3 -> ($1.67)Doritos\n4 -> ($3)Sparkling Water\n5 -> ($5)Gatorade\n0 -> finish Selection");
        System.out.println("---------------------------------");
    }    
}
