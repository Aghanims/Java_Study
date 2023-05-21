package Recursion;
//Scope: class for sorting an array of integers from smallest to largest using the merge sort algorithm.
public class MergeSort 
{
    //Precondition: Every indexed variable of the array a has a value.
    //Postcondition: a[0] <= a[1] <= a[2] <= a[a.length - 1].
    public static void sort(int[] a)
    {
        if(a.length >= 2)
        {
            int halfLength = a.length / 2;
            int[] firstHalf = new int[halfLength];
            int[] lastHalf = new int[a.length - halfLength];

            divide(a, firstHalf, lastHalf);
            sort(firstHalf);
            sort(lastHalf);
            merge(a, firstHalf, lastHalf);
        }
    }

    //Precondition: a.length = firstHalf.length + lastHalf.length
    //Postcondition: All the elements of a are divided between the arrays firstHalf and lastHalf
    private static void divide(int[] a, int[] firstHalf, int[] lastHalf)
    {
        for(int i = 0; i < firstHalf.length; i++)
            firstHalf[i] = a[i];
        
        for(int i = 0; i < lastHalf.length; i++)
            lastHalf[i] = a[firstHalf.length + i];
    }

    //Precondition: Arrays firsthHalf and lastHalf are sorted from smallest to largest; a.length = firstHalf.length + lastHalf.length.
    //Postcondition: Array a contains all the values from firstHalf and lastHalf and is sorted from smallest to largest.
    private static void merge(int[] a, int[] firstHalf, int[] lastHalf)
    {
        int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;

        while((firstHalfIndex < firstHalf.length) && (lastHalfIndex < lastHalf.length))
        {
                if(firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex])
                {
                    a[aIndex] = firstHalf[firstHalfIndex];
                    firstHalfIndex++;
                }
                else
                {
                    a[aIndex] = lastHalf[firstHalfIndex];
                    lastHalfIndex++;
                }
                aIndex++;

                //Copy rest of firstHalf, if any
            while(firstHalfIndex < firstHalf.length)
            {
                a[aIndex] = firstHalf[firstHalfIndex];
                aIndex++;
                firstHalfIndex++; 
            }

            //Copy resrt of the lastHalf, if any
            while(lastHalfIndex < lastHalf.length)
            {
                a[aIndex] = lastHalf[lastHalfIndex];
                aIndex++;
                lastHalfIndex++;
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] anArray = {7, 5, 11, 2, 16, 4, 18, 14, 12, 30};
       
        System.out.println("Array values before sorting:");
        for(int i = 0; i < anArray.length; i++)
             System.out.print(anArray[i] + "\t");
         
         System.out.println();
 
         MergeSort.sort(anArray);
 
         System.out.println("Array values after sorting:");
         for(int i = 0; i < anArray.length; i++)
             System.out.print(anArray[i] + "\t");
         System.out.println();
    }
    
}
