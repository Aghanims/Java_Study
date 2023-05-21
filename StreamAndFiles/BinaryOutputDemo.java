package StreamAndFiles;

import java.io.FileOutputStream; //throws a fileNotfoundException
import java.io.ObjectOutputStream; //throws an IOexception
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BinaryOutputDemo 
{
    public static void main(String[] args) 
    {
        String fileName = "numbers.dat";

        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter nonnegative Integers.");
            System.out.println("Place a negative number at the end.");

            int anInteger;
            do
            {
                anInteger = keyboard.nextInt();
                outputStream.writeInt(anInteger);
            }while(anInteger >= 0);

            /* this could also be used; since this will throws EOFException if you enter negative numbers, and will change to false
                while(true)
                {
                    int anInteger = inputStream.readInt();

                } ||be sure to put catch block for EOFException
            */

            System.out.println("Numbers in sentinel value");
            System.out.println("Written to the file " + fileName);
            outputStream.close();
            keyboard.close();
        }
        /*
            catch(EOFException e)
            {
                System.out.println("End of reading from file.");
            }
        */
        catch(FileNotFoundException e)
        {
            System.out.println("Problem opening the file " + fileName);
        }
        catch(IOException e)
        {
            System.out.println("Problem with output to the file " + fileName);
        }
    }
}
