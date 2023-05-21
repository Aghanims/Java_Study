package StreamAndFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClassObjectIODemo 
{
    public static void main(String[] args) 
    {
        ObjectOutputStream outputStream = null;
        String fileName = "species.records";

        try
        {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        }
        catch(IOException e)
        {
            System.out.println("Error opening output file " + fileName + ".");
            System.exit(0);
        }

        Species califCondor = new Species("Calif. Condor", 27, 0.02);
        Species blackRhino = new Species("Black Rhino", 100, 1.0);

        try
        {
            outputStream.writeObject(califCondor);
            outputStream.writeObject(blackRhino);
            outputStream.close();
        }
        catch(IOException e)
        {
            System.out.println("Error opening output file " + fileName + ".");
            System.exit(0);
        }

        System.out.println("Records sent to the file " + fileName + ".");
        System.out.println("Now let's open reopen the file and echo the records.");

        ObjectInputStream inputStream = null;

        try
        {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
        }
        catch(IOException e)
        {
            System.out.println("Error opening output file " + fileName + ".");
            System.exit(0);
        }

        Species readOne = null;
        Species readTwo = null;

        try
        {
                        //notice the typecast
            readOne = (Species)inputStream.readObject(); 
            readTwo = (Species)inputStream.readObject();
            inputStream.close();
        }
        catch(Exception e)
        {
            System.out.println("Error reading from file " + fileName + ".");
            System.exit(0);
        }

        System.out.println("The following were read\nfrom the following file " + fileName + ".");
        System.out.println(readOne.toString());
        System.out.println();
        System.out.println(readTwo.toString());
        System.out.println("End of program");
    }
}