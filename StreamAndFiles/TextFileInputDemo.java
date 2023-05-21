package StreamAndFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileInputDemo 
{
    public static void main(String[] args) 
    {
        String fileName = "out.txt" ; // "D:/Coding/Richmond_Java/out.txt" ; is also used if want a directory path instead of file name

        Scanner inputStream = null;   

        System.out.println("The file " + fileName + "\ncontains the following lines:\n");
        try
        {
            inputStream = new Scanner(new File(fileName)); 
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        while(inputStream.hasNextLine())//could also use(if applicable): hasNext(), hasNextDouble, hasNextInt()
        {
            String line = inputStream.nextLine();
            System.out.println(line);
        }
        inputStream.close();
    }

   

}
