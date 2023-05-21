package DataStructures.SelfStudy;

public class DoublyLinkedList 
{
    private ListNode  head;
    private ListNode tail;
    private int length;

/******************************************************************************** */    

    private class ListNode
    {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data)
        {
            this.data = data;
        }
    }

/******************************************************************************** */  


    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        length = 0;
    }

    public int getLength() {return length;}

    public boolean isEmpty() {return length == 0;}

    public void prepend(int data)
    {
        ListNode newNode = new ListNode(data);

        if(head == null)
        {
           tail = newNode;
        }
        else
        {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void append(int data)
    {
        ListNode newNode = new ListNode(data);

        if(head == null) //if the list is initially empty
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.previous = tail;     
        }
        tail = newNode;
        length++;
    }

    public void insertAfter(int currentNode, int insertValue)
    {
        ListNode newNode = new ListNode(insertValue);

        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        
        ListNode current = head;
        while(current != null)
        {
            if(current == tail)
            { 
                current.next = newNode;
                newNode.previous = current;
                tail = newNode;
                length++;
                return;
            }                

            if(current.data == currentNode)
            {
                ListNode sucessor = current.next;

                newNode.next = sucessor;
                newNode.previous = current;

                current.next = newNode;
                sucessor.previous = newNode;
                length++;
                return;
            }
            current = current.next;
        }
    }

    public int removeFirst()
    {
        //throw exception if empty

        ListNode temp = head;

        head = head.next;
        head.previous = null;

        return temp.data;
    }

    public int removeLast()
    {
        //throw exception if empty

        ListNode temp = tail;

        tail = tail.previous;
        tail.next = null;

        return temp.data;
    }

    public void printForward()
    {
        ListNode currentNode = head;

        System.out.print("null <--> ");
        while(currentNode != null)
        {   
            System.out.print(currentNode.data + " <--> ");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }

    public void printBackward()
    {
        ListNode currentNode = tail;

        System.out.print("null <--> ");
        while(currentNode != null)
        {
            System.out.print(currentNode.data + " <--> ");
            currentNode = currentNode.previous;
        }
        System.out.print(" null ");
    }

    public static void main(String[] args) 
    {
        DoublyLinkedList test = new DoublyLinkedList();

        test.prepend(14);
        test.prepend(23);
        test.prepend(69);
        test.append(49);
        test.append(96);
        test.insertAfter(69, 92);
        test.insertAfter(96, 89);

        test.printForward();
        System.out.println();
       // test.printBackward();

        int removedNode = test.removeFirst();
        int removeLast = test.removeLast();
     

        System.out.println(); System.out.println("Size: " + test.length);
        System.out.println("removed First Node: " + removedNode);
        System.out.println("Removed Last Node: " + removeLast);

        System.out.println();
        test.printForward();

    }
}
