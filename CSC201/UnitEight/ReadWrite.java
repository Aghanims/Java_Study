package CSC201.UnitEight;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadWrite 
{
    public static void main(String[] args) 
    {
        String combineData = "";
        Scanner keyboard = new Scanner(System.in);
        String fileName = "Stu.dat";
        RandomAccessFile file = null;

        try
        {
            file = new RandomAccessFile(fileName, "rw");

            int recordedLines = 0; // This will record the number of lines used on the the "Stu.dat"
            boolean judge = true;
            do
            {   
                //Write Student data to "Stu.dat"
                System.out.print("Enter Student ID: ");
                String studentID = keyboard.nextLine();
                while(!(studentID.length() == 7)) //can only proceed if Student ID is exactly 7 digits
                {
                    System.out.println("ID can only contain 7 digits. Please Try again: ");
                    System.out.print("Enter Student ID: ");
                    studentID = keyboard.nextLine();
                }

                System.out.print("Enter corresponding GPA: ");
                String GPA = keyboard.nextLine();

                combineData = studentID + "," + GPA;

                file.write(combineData.getBytes()); //write the data to the file
                file.writeBytes(System.getProperty("line.separator")); //This will proceed to a new line
        
                System.out.println("Do you still want to add data? (y/n)");
                String answer = keyboard.nextLine();
                if(answer.equalsIgnoreCase("n"))
                    judge = false;
                else if(answer.equalsIgnoreCase("y"))
                    judge = true;

                recordedLines++;
            }while(judge == true);

            int charsPerLine = combineData.length() + 2; //for some reason I need to add two if I want to make the code work

            System.out.println();

            //This portion will display the GPA of a corresponding Student ID
            for(int startingLine = 0; startingLine < recordedLines; startingLine++)
            {
                file.seek(charsPerLine * startingLine); // this will transition to the next line of data
                
                String[] split = file.readLine().split(",");
                int StudentID = Integer.parseInt(split[0]);
                float GPA = Float.parseFloat(split[1]);
                System.out.println("Student " + StudentID +  " has a GPA of " + GPA);
            }

            file.close(); //closing Stream
        }   
        catch(IOException e)
        {
            System.out.println("Error opening file " + fileName);
        } 
        finally
        {
            System.out.println("Data of Students has been recorded.");
            System.out.println("End of program");
            keyboard.close();
            System.exit(0);
        }
    }
}
