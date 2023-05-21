package Algorithm;

import java.util.Arrays;

//Time complexity: O(N^2)
public class SelectionSort 
{   
    //Selection Sort algorithm
    private static void selectionSort(int[] numbers) 
    {
      for (int i = 0; i < numbers.length - 1; i++) 
      {
         // Find index of smallest remaining element
         int indexSmallest = i;
         for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[j] < numbers[indexSmallest]) {
               indexSmallest = j;
            }
         }
         
         // Swap numbers[i] and numbers[indexSmallest]
         int temp = numbers[i];
         numbers[i] = numbers[indexSmallest];
         numbers[indexSmallest] = temp;
      }
   }

   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the selectionSort method
      selectionSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED: " + Arrays.toString(numbers));
   } 
}
