package StreamAndFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Doubler 
{
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;

    //Double the integers in one file and puts them in another file

    public static void main(String[] args) 
    {
        Doubler twoTimer = new Doubler();

        twoTimer.connectInputFile();
        twoTimer.connectOutputFile();
        twoTimer.timesTwo();
        twoTimer.closeFiles();
        System.out.println("Numbers from input file");
        System.out.println("doubled and copied to output file.");
    }   
    
    public void connectInputFile()
    {
        String inputFileName = getFileName("Enter name of input file: ");

        try
        {
            inputStream = new ObjectInputStream(new FileInputStream(inputFileName));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File " + inputFileName + " not found");
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Error opening the file " + inputFileName);
            System.exit(0);
        }
    }

    private String getFileName(String prompt)
    {
        String fileName = null;
        System.out.println(prompt);
        Scanner keyboard = new Scanner(System.in);
        fileName = keyboard.next();
        return fileName;
    }

    public void connectOutputFile()
    {
        String outputFileName = getFileName("Enter name of output file: ");

        try
        {   
            outputStream = new ObjectOutputStream(new FileOutputStream(outputFileName));
        }
        catch(IOException e)
        {
            System.out.println("Error opening output file " + outputFileName);
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void timesTwo()
    {
        try
        {
            while(true)
            {
                int next = inputStream.readInt();
                outputStream.writeInt(2 * next);
            }
        }
        catch(EOFException e)
        {
            //Do nothing; end of the loop
        }
        catch(IOException e)
        {
            System.out.println("Error: reading or writing the files.");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void closeFiles()
    {
        try
        {
            inputStream.close();
            outputStream.close();
        }
        catch(IOException e)
        {
            System.out.println("Error closing the files " + e.getMessage());
            System.exit(0);
        }
    }
}
