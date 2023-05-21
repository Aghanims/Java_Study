package DataStructures.Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSortDemo 
{
   // Binary max heap percolate down
   static void maxHeapPercolateDown(int nodeIndex, int[] heapArray, int heapSize) 
   {
      int childIndex = 2 * nodeIndex + 1;
      int value = heapArray[nodeIndex];
      
      while (childIndex < heapSize) 
      {
         // Find the max among the node and all the node's children
         int maxValue = value;
         int maxIndex = -1;
         int i = 0;
         while (i < 2 && i + childIndex < heapSize) 
         {
            if (heapArray[i + childIndex] > maxValue) 
            {
               maxValue = heapArray[i + childIndex];
               maxIndex = i + childIndex;
            }
            i++;
         }
         
         if (maxValue == value) 
            return;
         
         // Swap heapArray[nodeIndex] and heapArray[maxIndex]
         int temp = heapArray[nodeIndex];
         heapArray[nodeIndex] = heapArray[maxIndex];
         heapArray[maxIndex] = temp;
         
         nodeIndex = maxIndex;
         childIndex = 2 * nodeIndex + 1;
      }
   }
   
   // Sorts the array of numbers using the heap sort algorithm
   static void heapSort(int[] numbers) 
   {
      // Heapify numbers array
      int i = numbers.length / 2 - 1;
      while (i >= 0) 
      {
         maxHeapPercolateDown(i, numbers, numbers.length);
         i--;
      }
                
      i = numbers.length - 1;
      while (i > 0) 
      {
         // Swap numbers[0] and numbers[i]
         int temp = numbers[0];
         numbers[0] = numbers[i];
         numbers[i] = temp;

         maxHeapPercolateDown(0, numbers, i);
         i--;
      }
   }

   public static void main(String[] args) 
   {
      int[] numbers = { 82, 36, 49, 82, 34, 75, 18, 9, 23 };
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      heapSort(numbers);
      System.out.println("SORTED:   " + Arrays.toString(numbers));

      System.out.println();


      // *******************************************************************
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //Abstract data type that implements Min Heap

      minHeap.add(100);
      minHeap.add(40);
      minHeap.add(2);

      System.out.println("Min Heap: " +minHeap.toString());

      System.out.println("First Priority: " + minHeap.poll());
      System.out.println("Second Priority: " + minHeap.poll());

      System.out.println();
    //***************************************************************************** */
      //Priority queue with maxHeap implementation
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

      maxHeap.add(3);
      maxHeap.add(69);
      maxHeap.add(1243);
      maxHeap.add(1);

      System.out.println("Max heap: "+ maxHeap.toString());
      System.out.println("First priority: "+ maxHeap.poll());
      System.out.println("Second priority: "+ maxHeap.poll());
      
   }
}

