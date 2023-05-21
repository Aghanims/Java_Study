package StreamAndFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArrayIODemo 
{
    //sample pogram that writes and reads an array using a binary file.

    public static void main(String[] args) 
    {
        Species[] oneArray = new Species[2];
        
        oneArray[0] = new Species("Calif. Condor", 27, 0.02);
        oneArray[1] = new Species("Black Rhino", 100, 1.0);

        String fileName = "array.dat";

        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(oneArray); //we use writeObject since Java treats array as an object
            outputStream.close();
        }
        catch(IOException e)
        {
            System.out.println("Error writing to file " + fileName + ".");
            System.exit(0);
        }

        System.out.println("Array written to file " + fileName + " and file is closed.");
        System.out.println("Open the file for input and echo the array.");

        //Starting the input proceduce
        Species[] anotherArray = null;

        try 
        {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
                            //notice the typecast
            anotherArray = (Species[])inputStream.readObject();
            inputStream.close();
        } 
        catch(Exception e)
        {
            System.out.println("Error reading the file " + fileName + ".");
            System.exit(0);
        }

        System.out.println("The following were read from the file " + fileName + ".");

        for(int index = 0; index < anotherArray.length; index++)
        {
            System.out.println(anotherArray[index].toString());
            System.out.println();
        }

        System.out.println("End of the program");
    }
}
