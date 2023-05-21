package CSC201.UnitEight;

import java.io.RandomAccessFile;
import java.io.IOException;

//Problem#2
public class ReadMe 
{
    public static void main(String[] args)
    {
        String fileName = "Pledge.txt"; //"D:/Coding/Richmond_Java/out.txt"
        //D:/Coding/Richmond_Java/Pledge.txt

        String readings = readFromPosition(fileName, 124);
        System.out.println(readings);
        
        System.out.println();

        String readings2 = readFromPosition(fileName, 135);
        System.out.println(readings2);
    }

    public static String readFromPosition(String fileName, int position)
    {
        String contain = "";
        RandomAccessFile read = null;

        try
        {
            read = new RandomAccessFile(fileName, "rw");
            read.seek(position);

            contain = read.readLine();
            read.close();
        }
        catch(IOException e)
        {
            contain = "Error opening file " + fileName + ".";
        }
        return contain;
    }
}
