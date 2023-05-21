package DataStructures.SelfStudy;

public class Queue 
{
    
    private ListNode head;
    private ListNode tail;
    private int length;

    public Queue()
    {
        head = null;
        tail = null;
        length = 0;
    }

/****************************************************************************** */
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
/****************************************************************************** */

    public int size()
    {
        return length;
    }

    public void enqueue(int data)
    {
        ListNode newNode = new ListNode(data);

        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    public int dequeue()
    {
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return temp.data;
    }

    public void printQueue()
    {
        ListNode currentNode = head;

        while(currentNode != null)
        {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.print(" null ");
    }

/****************************************************************************** */
    public static void main(String[] args) 
    {
        Queue test = new Queue();

        test.enqueue(45);
        test.enqueue(67);
        test.enqueue(69);
        test.enqueue(45);

        test.printQueue();
        System.out.println();

        System.out.println("Dequeued: " + test.dequeue());
        test.printQueue();
        
        System.out.println();
        System.out.println("Size: " + test.size());
    }
}
