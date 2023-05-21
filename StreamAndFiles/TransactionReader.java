package StreamAndFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class TransactionReader 
{
    public static void main(String[] args) 
    {
        //Transaction.txt
        String fileName = "D:/Coding/Richmond_Java/src/StreamAndFiles/Transaction.txt"; 
        

        try
        {
            Scanner inputStream  = new Scanner(new File(fileName));

            //Skip the header line by reading and ignoring it
            String line = inputStream.nextLine();
            
            //Total Sales
            double total = 0;

            //read the rest of the file by line
            while(inputStream.hasNextLine())
            {
                //contains SKU, Quantity, Price, Description
                line = inputStream.nextLine();
                
                //Turn the string into an array of Strings
                String[] ary = line.split(","); // comma is the indicator that splits the strings and converts it into array.

                //Extract each item into an appropriate variable
                String SKU = ary[0];
                int quantity = Integer.parseInt(ary[1]);
                double price = Double.parseDouble(ary[2]);
                String description = ary[3];

                //Output item
                System.out.printf("Sold %d of %s (SKU: %s) at " + "$%1.2f each.\n", quantity, description, SKU, price);

                //Compute total
                total += quantity * price;
                
            }
            System.out.printf("Total sales: $%1.2f\n", total);
            inputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Cannot find file " + fileName);
        }
        catch(IOException e)
        {
            System.out.println("Problem wih input from file" + fileName);
        }
    }
}
