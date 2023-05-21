package StreamAndFiles;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileOutputDemo 
{
    public static void main(String[] args) 
    {
        String fileName = "out.txt"; //The name could be read from the keyboard

        PrintWriter outputStream = null;

        try
        {
            outputStream = new PrintWriter(fileName); 
            /*
                Use: PrintWriter(new FileOutputStream(fileName, true));  
                    if you want to append the file; or not erase the existing contents of the file
            */
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter three lines of text: ");
        for(int count = 1; count <= 3; count++)
        {
            String line = keyboard.nextLine();
            outputStream.println(count + " " + line);
        }
        outputStream.close();
        System.out.println("Those lines were written to " + fileName);
        keyboard.close();

    }
}
