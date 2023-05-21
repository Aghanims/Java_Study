package DataStructures.SelfStudy;

public class Stack 
{
    private ListNode top;
    private int length;

    public Stack()
    {
        top = null;
        length = 0;
    }

/*********************************************************************************** */
    private static class ListNode
    {
        private int data; //can be generic
        private ListNode next;

        public ListNode(int data)
        {
            this.data = data;
            next = null;
        }
    }
/*********************************************************************************** */

    public int size()
    {
        return length;
    }

    public void push(int data)
    {
        ListNode newNode = new ListNode(data);

        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop()
    {
        int result  = top.data;
        top = top.next;
        length--;

        return result;
    }

    public void printStack()
    {
        ListNode currentNode = top;

        while(currentNode != null)
        {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.print(" null ");
    }

/********************************************************************************* */ 
    public static void main(String[] args) 
    {
        Stack test = new Stack();

        test.push(49);
        test.push(26);
        test.push(69);

        test.printStack();

        System.out.println();
        System.out.println("Popped element: " + test.pop());

        test.printStack();       
    }    
}
