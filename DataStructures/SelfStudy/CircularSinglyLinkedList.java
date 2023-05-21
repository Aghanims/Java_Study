package DataStructures.SelfStudy;

public class CircularSinglyLinkedList 
{
    //private ListNode head;
    private ListNode tail;
    private int length; // the size

    public CircularSinglyLinkedList()
    {
        tail = null;
        length = 0;
    }
    
/******************************************************************** */
    private class ListNode
    {
        private int data;
        private ListNode next;

        public ListNode(int data)
        {
            this.data = data;
            next = null;
        }
    }

/******************************************************************** */

    public int size() {return length;}

    public boolean isEmpty() { return length == 0;}

    public void prepend(int data)
    {
        ListNode newNode = new ListNode(data);

        if(tail == null)
            tail = newNode;
        else
            newNode.next = tail.next; 
        
        tail.next = newNode;  //point back to the first node
        length++;
    }

    public void append(int data)
    {
        ListNode newNode = new ListNode(data);

        if(tail == null)
        {
            tail = newNode;  
            tail.next = tail;
        }
        else 
        {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public int removeFirst()
    {
        ListNode head = tail.next;

        //if(tail == null) empty; then return an exception

        if(tail.next == tail) //only one item
            tail = null;
        
        tail.next = head.next;
        length--;
        return head.data;
    }

    public void displayCircularList()
    {
        if(tail == null) {return;}

        ListNode head = tail.next; //since it is circular and tail != null;

        while(head != tail) //traverse the List
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print(head.data); // print the tail node
    }

/******************************************************************** */
    public static void main(String[] args) 
    {
        CircularSinglyLinkedList test = new CircularSinglyLinkedList();

        test.prepend(4);
        test.prepend(1);
        test.prepend(8);
        test.append(5);
        test.append(7);
        test.removeFirst();
        test.displayCircularList();

        System.out.println();
        System.out.println("Size: " + test.size());
    }
}
