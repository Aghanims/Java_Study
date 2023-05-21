package ClassNotes;
public class ArraySorterDemo 
{
    public static void main(String[] args)
    {
        int[] test = {7, 6, 9, 10, 12, 67, 89, 98, 69, 99, 23, 56};

        display(test, "before");
        ArraySorter.selectionSort(test);
        display(test, "after");
        
    }

    public static void display(int[] array, String when)
    {
        System.out.println("Array values " + when + " sorting:");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println( );
    }
}
