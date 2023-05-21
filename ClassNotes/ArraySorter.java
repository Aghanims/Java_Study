package ClassNotes;
public class ArraySorter 
{
    /*
        Precondition: every element in anArray has a value
        Postcondition: Sorts the array int ascending order
     */

    public static void selectionSort(int[] anArray)
    {
        for(int index = 0; index < anArray.length -1; index++)
        {
            //place correct value in anArray[index]
            int indexOfNextSmallest = getIndexOfSmallest(index, anArray);
            interchange(index, indexOfNextSmallest, anArray);

            // Assertion: anArray[0] <= anArray[1] <= ... <= anArray[index]
            //and these are the smallest of the original array elements.
            //the remaining positions contain the rest of the original array elements.
        }
    }

    /* 
        Return index of the smallest value in the portion of the array that begins at the element whose index is startIndex and 
        ends at the last element.
    */
    private static int getIndexOfSmallest(int startIndex, int[] array)
    {
        int min = array[startIndex];
        int indexOfMin = startIndex;
        for(int index = startIndex + 1; index < array.length; index++)
        {
            if(array[index] < min)
            {
                min = array[index];
                indexOfMin = index;
                //min is smallest of array[startIndex] through array[index]
            }
        }
        return indexOfMin;
    }

    /*
        Precondition: i and j are valid indices for the array "array".
        Postcondition: Values of a[i] and a[j] have been interchanged(Swapped)
    */
    private static void interchange(int i, int j, int[] array)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
