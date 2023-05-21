package CSC201.UnitFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CycleFileInput 
{
    public static void main(String[] args) 
    {
        String fileName = "Cycle.txt";

        Scanner inputStream = null;
        System.out.println(fileName + " contains the following lines: ");
        try
        {
           inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e)
        {
            System.out.println(fileName + " not found");
            System.exit(0);
        }

        while(inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            System.out.println(line);
        }

        inputStream.close();   
    }
}
