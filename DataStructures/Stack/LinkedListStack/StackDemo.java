package DataStructures.Stack.LinkedListStack;

public class StackDemo 
{
    public static void main(String[] args) 
    {
       int[] numbers = { 91, 66, 9, 46, 23, 65, 6, 77 };
       
       // Initialize a new Stack and add numbers
       LinkedStack numStack = new LinkedStack();
       for (int number : numbers) 
       {
           numStack.push(number);
       }
 
       // Output stack
       System.out.print("Stack after push: ");
       numStack.print();
       
       // Pop 77 and print
       numStack.pop();
       System.out.print("Stack after first pop: ");
       numStack.print();
       
       // Pop 6 and print
       numStack.pop();
       System.out.print("Stack after second pop: ");
       numStack.print();
    }
}
