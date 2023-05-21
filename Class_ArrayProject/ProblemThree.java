package Class_ArrayProject;

import java.util.Scanner;
public class ProblemThree 
{
    private String firstName, lastName;
    private int postalCode;  
    private String[] address;

    //constructor will have the size of the array
    public ProblemThree()
    {
        address = new String[0]; //default constructor has zero size.
    }

    public ProblemThree(int arraySize)
    {
        address = new String[arraySize];
    }

    public void readInput()//ask user of information
    {
        Scanner keyboard = new Scanner(System.in);
        
        for(int index = 0; index < address.length; index++)
        {
            System.out.println("Enter first name, last name, and postal code for costumer " + (index + 1) + ": ");
            firstName = keyboard.next();
            lastName = keyboard.next();
            postalCode = keyboard.nextInt();
            //Using valueOf() method from String class to convert int to String.
            address[index] = firstName + " " + lastName + "  " + postalCode; 
        }
        keyboard.close();
    }

    public void writeOutput()
    {
        for(int index = 0; index < address.length; index++)
        {
            System.out.println(address[index]);
        }
    }

    public void setInformation(int element, String newFirstName, String newLastName, int newPostalCode)
    {
        address[element -1] = newFirstName + " " + newLastName + "  " + newPostalCode;    
    }
}
