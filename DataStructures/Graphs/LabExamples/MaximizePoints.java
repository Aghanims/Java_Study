package DataStructures.Graphs.LabExamples;

import java.util.*;
import java.io.*;

public class MaximizePoints 
{
   public static long maxPoints(String input)
   {

        /* Type your code here. */
        
        //read file from data file portion
        Scanner inputStream = null;

        try
        {
            inputStream = new Scanner(new File(input));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        String firstLine = inputStream.nextLine(); //store information of firstLine to variable
        String[] firstLineInfo = firstLine.split("\\s+");
        int bagOfMarbles = Integer.parseInt(firstLineInfo[0]);
        int maxNumAllowed = Integer.parseInt(firstLineInfo[1]);

        String secondLine = inputStream.nextLine(); //store on priority queue in descending order
        String[] secondLineInfo = secondLine.split("\\s+");
    
/*********************************************************************************************************************** */
        //reassignment portion
        //Assignn secondLineInfo to a new int array
        int[] newArray = new int[secondLineInfo.length]; 
        for(int i = 0; i < secondLineInfo.length; i++)
        {   
            int temp = Integer.parseInt(secondLineInfo[i]);
            newArray[i] = temp;
        }

/****************************************************************************************************** */
        //operation portion
        int sumRecorder = 0;
        while(maxNumAllowed > 0)
        {
            Arrays.sort(newArray); //update the sorted array in each iteration

            sumRecorder += newArray[bagOfMarbles - 1]; //add all the highest value in each iteration

            newArray[bagOfMarbles - 1]--; //decement highest value by 1 from bag

            maxNumAllowed--;
        }

        return sumRecorder;
   }

   public static void main(String[] args) 
   {
        String fileName = "D:/Coding/Richmond_Java/src/DataStructures/Graphs/LabExamples/input.data";

        long maximize = maxPoints(fileName);

        System.out.println(maximize);
   }
}
