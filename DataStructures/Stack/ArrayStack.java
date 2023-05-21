package DataStructures.Stack;

public class ArrayStack 
{
    private int allocationSize;
    private int[] array;

    int length;
    int maxLength;
 
    // The default constructor initializes an unbounded stack
    public ArrayStack() 
    {
       this(-1); // call the one-parameter constructor
    }
    
    public ArrayStack(int maximumLength) //bounded stack
    {
       allocationSize = 1;
       array = new int[allocationSize];
       length = 0;
       maxLength = maximumLength;
    }
     
    public int getLength() 
    {
       return length;
    }
         
    public int getMaxLength() 
    {
       return maxLength;
    }
         
    public boolean push(int item) 
    {
       // If at max length, return false
       if (length == maxLength) 
       {
          return false;
       }
           
       // Resize if length equals allocation size
       if (length == allocationSize) 
       {
          resize();
       }
             
       // Push the item and return true
       array[length] = item;
       length++;
       return true;
    }
         
    public int pop() 
    {
       length--;
       return array[length];
    }
     
    private void resize() 
    {
       // Allocate new array and copy existing items
       int newSize = allocationSize * 2;
       int[] newArray = new int[newSize];

       for (int i = 0; i < length; i++) 
       {
          newArray[i] = array[i];
       }
          
       // Assign new array and allocation size
       array = newArray;
       allocationSize = newSize;
    }
 }
