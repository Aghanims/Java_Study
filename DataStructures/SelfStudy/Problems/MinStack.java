package DataStructures.SelfStudy.Problems;

import java.util.Stack;

public class MinStack 
{
    /*
        Design a stack that supports push, pop, top, and retrieving the minimum element in constant time

        Implement the MinStack class:
        *   MinStack - initializes the stack object.
        *   void push(int val) - pushes the element val onto the stack.
        *   void pop() - removes the element on the top of the stack. 
        *   int top() - gets the top element of the stack.
        *   int getMin() - retrieves the minimum element in the stack.

        You must implement a solution with O(1) time complexity for each function.

        Example:
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin(); // return -3
            minStack.pop();
            minStack.top(); // return 0
            minStack.getMin(); // return -2
    */

    //Approach: create two stacks
    /*
        - regularStack: contains all elements that is being pushed.
        - minStack: contains only the minimum value during each index
    */
/* 
    private Stack<Integer> regularStack;
    private Stack<Integer> minStack;

    public MinStack()
    {
        regularStack = new Stack<>();
        minStack = new Stack<>();   
    }

    public void push(int val)
    {
        // -> push val on both stacks

        //push on regular stack:
        regularStack.push(val);

        //push only the min value on MinStack
        if(minStack.isEmpty())
            minStack.push(val);
        else 
        {
            val = Math.min(val, minStack.peek());
            minStack.push(val);
        }
    }

    public void pop()
    {
        regularStack.pop();
        minStack.pop();
    }

    public int top()
    {
        return regularStack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }
*/

    /*******************************************Other way *****************************************/
    //without using double Stack

/************************************************************ */
    private static class Element
    {
        public  int value;
        public int min;

        public Element(int value, int min)
        {
            this.value = value;
            this.min = min;
        }
    }
/************************************************************ */

    private Stack<Element> minStack;

    public MinStack()
    { 
        minStack = new Stack<>();
    }

    public void push(int value)
    {
        Element newElement = null;

        if(minStack.isEmpty())
        {
            newElement = new Element(value, value);
            minStack.push(newElement);
        }
        else
        {
            int min = Math.min(value, minStack.peek().min);
            newElement = new Element(value, min);

            minStack.push(newElement);
        }
    }

    public void pop()
    {
        minStack.pop();
    }
    public int top()
    {
        return minStack.peek().value;
    }
    public int getMin()
    {
        return minStack.peek().min;
    }

/************************************************************************************************************* */
    public static void main(String[] args) 
    {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // returns -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
