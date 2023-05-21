package Algorithm;

import java.util.Scanner;
import java.util.ArrayList;

//implementing quicksort algorithm
public class IDsorting
{
   // TODO: Write the partitioning algorithm - pick the middle element as the 
   //       pivot, compare the values using two index variables l and h (low and high), 
   //       initialized to the left and right sides of the current elements being sorted,
   //       and determine if a swap is necessary
   public static int partition(ArrayList<String> userIDs, int i, int k) 
   {
      // Pick middle element as pivot
      String pivot = userIDs.get((i + (k- i) / 2));
   
      boolean done = false;
      while (!done) 
      {
         // Increment lowIndex while numbers[lowIndex] < pivot
         while (userIDs.get(i).compareTo(pivot) < 0) 
         {
            i += 1;
         }
         
         // Decrement highIndex while pivot < numbers[highIndex]
         while (userIDs.get(k).compareTo(pivot) > 0) 
         {
            k -= 1;
         }
         
         // If zero or one elements remain, then all numbers are 
         // partitioned. Return highIndex.
         if (i >= k) 
         {
            done = true;
         }
         else 
         {
            // Swap numbers[lowIndex] and numbers[highIndex]
            String temp = userIDs.get(i);
            userIDs.set(i,userIDs.get(k));
            userIDs.set(k,temp);
   
            // Update lowIndex and highIndex
            i += 1;
            k -= 1;
         }
      }
   
         return k;
   }

   // TODO: Write the quicksort algorithm that recursively sorts the low and 
   //       high partitions
   public static void quicksort(ArrayList<String> userIDs, int i, int k) 
   {
      // Base case: If the partition size is 1 or zero 
      // elements, then the partition is already sorted
      if (i >= k) 
      {
         return;
      }
      
      // Partition the data within the array. Value lowEndIndex 
      // returned from partitioning is the index of the low 
      // partition's last element.
      int lowEndIndex = partition(userIDs, i, k);
      
      // Recursively sort low partition (lowIndex to lowEndIndex) 
      // and high partition (lowEndIndex + 1 to highIndex)
      quicksort(userIDs, i, lowEndIndex);
      quicksort(userIDs, lowEndIndex + 1, k);
   }

   public static void main(String[] args) 
   {
      Scanner scnr = new Scanner(System.in);

      ArrayList<String> userIDList = new ArrayList<String>();

      String userID;

      userID = scnr.next();
      while (!userID.equals("-1")) 
      {
         userIDList.add(userID);
         userID = scnr.next();
      }
      
      // Initial call to quicksort 
      quicksort(userIDList, 0, userIDList.size() - 1);

      for (int i = 0; i < userIDList.size(); ++i) 
      {
         System.out.println(userIDList.get(i));
      }

      scnr.close();
   }
}
