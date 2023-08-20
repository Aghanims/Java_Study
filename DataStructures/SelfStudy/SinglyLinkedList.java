package DataStructures.SelfStudy;

public class SinglyLinkedList 
{
    private ListNode head;

/**********************************************************************/
//static class for ListNode

    static class ListNode
    {
        private int data; //both attributes can be generic
        private ListNode next;

        public ListNode(int data)
        {
            this.data = data;
            next = null;
        }
    }
/************************************************************************/

    public void prepend(int value)
    {
        ListNode newNode = new ListNode(value);
        newNode.next = head; //newNode points to current head
        head = newNode; //newNode will become the new head
    }

    public void append(int value)
    {
        ListNode newNode = new ListNode(value);

        if(head == null)
        {
            head = newNode;
            return;
        }

        ListNode currentNode = head;
        while(currentNode.next != null)
        {
            currentNode = currentNode.next; //traverse to the end of the list
        }

        currentNode.next = newNode;     
    }

    public void insertAfter(int currentNode, int value)
    {
        ListNode newNode = new ListNode(value);

        if(head == null) 
        {
            head = newNode;
            return;
        }

        ListNode current = head;
        while(current != null)
        {
            if(current.data == currentNode)
            {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public void insertInPosition(int position, int value)
    {
        ListNode newNode = new ListNode(value);

        if(position == 1)
        {
            newNode.next = head;
            head = newNode;
        }
        else // any other position
        {
            ListNode previous = head;
            int counter = 1; //identifier being used to locate the previous node

            while(counter < position - 1)
            {
                previous = previous.next;
                counter++;
            }

            ListNode currentNode = previous.next;

            newNode.next = currentNode;
            previous.next = newNode;
        }
    }

    public int getLength()
    {
        ListNode currentNode = head;
        int counter = 0;

        while(currentNode != null)
        {
            counter++;
            currentNode = currentNode.next;
        }

        return counter;
    }

    public ListNode removeFirst()
    {   
        if(head == null)
            return null;

        ListNode temp = head;
        head = head.next;
        temp.next = null;

        return temp;
    }

    public ListNode removeLast()
    {
        if(head == null || head.next == null) {return head;}

        ListNode currentNode = head;
        ListNode previous = null;
        while(currentNode.next != null)
        {
            previous = currentNode;
            currentNode = currentNode.next;
        }
        previous.next = null; //change the previousNode's next pointer to null; 

        return currentNode;
    }

    public void deleteInPosition(int position)
    {
        if(position == 1) 
        {
            head = head.next;
        }
        else
        {
            ListNode previous = head;
            int counter = 1;

            while(counter < position -1) //determine the previous node of the desired position
            {
                previous = previous.next;
                counter++;
            }
            ListNode currentNode = previous.next;
            previous.next = currentNode.next;
        }
        
    }

    public void deleteNode(int data)
    {
        if(head == null) return;

        ListNode currentNode = head;
        ListNode previousNode = null;

        while(currentNode != null && currentNode.data != data)
        {
            previousNode = currentNode; 
            currentNode = currentNode.next;
        }
        previousNode.next = currentNode.next;
    }   

    public boolean isContain(int key)
    {
        if(head == null){return false;}
    
        ListNode currentNode = head;

        while(currentNode != null)
        {
            if(currentNode.data == key)
                return true;

            currentNode = currentNode.next;
        }
        return false;
    }

    public ListNode getMiddleNode()
    {
        if(head == null){return null;}

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public ListNode reverseList()
    {
        if(head == null) {return null;}
    
        ListNode currentNode = head;
        ListNode previous = null;
        ListNode next = null;

        while(currentNode != null)
        {
            next = currentNode.next;
            currentNode.next = previous; //point the current node to the previous node
            previous = currentNode;
            currentNode = next;
        }
        return previous;
    }

    public ListNode nthNodeFromtheEnd(int nth)
    {
        if(head == null) {return null;}

        //main idea: mainPointer will always follow referencePointer by the distance of n.
        // Then simultaneosly traverse the list until referencePointer == null; and return mainPointer.
        ListNode mainPointer = head;
        ListNode referencePointer = head;

        int counter = 0;
        while(counter < nth)
        {
            //create and the nth distance from mainPointer to the referencePointer
            referencePointer = referencePointer.next;
            counter++; 
        }

        while(referencePointer != null) //simultaneosly traverse up to the end
        {
            referencePointer = referencePointer.next;
            mainPointer = mainPointer.next;
        }

        return mainPointer;
    }

/****************************************************************************************** */
//all about loop
    public boolean loopDetection()
    {
        if(head == null) {return false;};

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null)
        {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(slowPointer == fastPointer)
                return true;
        }

        return false;
    }

    private ListNode getLoopStartingNode(ListNode slowPointer) //extension of floyd cycle detection algo
    {
        ListNode currentNode = head;

        while(currentNode != slowPointer)
        {
            currentNode = currentNode.next;
            slowPointer = slowPointer.next;
        }
        return currentNode;
    }

    public ListNode getStartingNodeOfLoop()
    {
        if(head == null) {return null;}

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(fastPointer != null && fastPointer.next != null)
        {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(slowPointer == fastPointer)
               return getLoopStartingNode(slowPointer);
        }

        return null; //no loop detected
    }

    private void removeLoopUtil(ListNode slowPointer)
    {
        ListNode currentNode = head;

        while(currentNode.next != slowPointer.next)
        {
            slowPointer = slowPointer.next;
            currentNode = currentNode.next;
        }
        slowPointer.next = null;
    }

    public void breakTheLoop()
    {
        if(head == null) {return;}

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(fastPointer != null && fastPointer.next != null)
        {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if(fastPointer == slowPointer)
            {
                removeLoopUtil(slowPointer);
                return;
            }     
        }
    }
/**************************************************************************************** */
//Merge two sorted singly linkedList

    public static ListNode mergeSortedLists(ListNode a, ListNode b)
    {
        ListNode dummyNode = new ListNode(0);
        ListNode arrangeNode = dummyNode;

        //Traverse both lists and compare each node which is lesser
        //Case1: assign the lesser node to arrangeNode and increment the list, as well as the arrangeNode
        //Case2: if a list is exhausted(null) assign all the nodes of the list that is not yet exhausted

        //Case1:
        while(a != null && b != null) //traverse until the end of both list
        {
            if(a.data <= b.data) //simultaneosly compare each node
            {
                arrangeNode.next = a; //assign the arrangeNode to the lesser 
                a = a.next; //move on to other node
            }
            else //if b is less than a
            {
                arrangeNode.next = b;
                b = b.next;
            }
            arrangeNode = arrangeNode.next; //update the index of the arrangeNode
        }

        //Case2:
        if(a == null)
            arrangeNode.next = b;
        else 
            arrangeNode.next = a;
        
        return dummyNode.next; //disregard the dummyNode
    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b)
    {
        //this process is in reverse order 
        /* ex:
         *      4 -> 6 -> 5 -> 2
         *      3 -> 4 -> 7 -> null
         * 
         *      2564 + 743 = 3307
         */

        ListNode dummyNode = new ListNode(0);
        ListNode arrangeNode = dummyNode;
        int carry = 0;

        while(a != null || b != null)
        {
            int x = (a != null)? a.data : 0;
            int y = (b != null)? b.data : 0;

            int sum = carry + x + y;
            carry = sum / 10; //update the carry number
            
            arrangeNode.next = new ListNode(sum % 10);
            arrangeNode = arrangeNode.next;

            if(a != null)
                a = a.next;
            if(b != null)
                b = b.next;
        }
        if(carry > 0)
            arrangeNode.next = new ListNode(carry);
        
        return dummyNode.next;
    }

/**************************************************************************************** */
    public void displayList()
    {
        ListNode currentNode = head;

        while(currentNode != null)
        {
            System.out.print(currentNode.data + " --> ");

            currentNode = currentNode.next; // this will traverse the LinkedList
        }
        System.out.print("null");
    }

    public static void displayList(ListNode node)
    {
        ListNode currentNode = node;

        while(currentNode != null)
        {
            System.out.print(currentNode.data + " --> ");

            currentNode = currentNode.next; // this will traverse the LinkedList
        }
        System.out.print("null");
    }

/**************************************************************************************************************** */
    public static void main(String[] args) 
    {
        SinglyLinkedList test = new SinglyLinkedList();    

        test.prepend(34);
        test.append(44);
        test.append(69);
        test.prepend(78);
        
        test.insertAfter(78, 11);
        test.insertAfter(69, 21);
        test.insertInPosition(3, 29);
        test.insertInPosition(8, 100);

        test.displayList();

        System.out.println();

        ListNode nodeRemoved = test.removeFirst();
        ListNode lastNodeRemoved = test.removeLast();
        test.deleteInPosition(4);

        System.out.println("Removed first node: " + nodeRemoved.data);
        System.out.println("Removed last node: " + lastNodeRemoved.data);
        System.out.println(); test.displayList();

        System.out.println(); System.out.println("size: " + test.getLength());
        System.out.println("2nd node from the end: " + test.nthNodeFromtheEnd(2).data);
        
        System.out.println("List contains 69: " + test.isContain(45));
        System.out.println("Middle Node: " + test.getMiddleNode().data);
        System.out.println("is the list in a loop: " + test.loopDetection());
        System.out.println("Starting node from detected loop: " + test.getStartingNodeOfLoop());

        System.out.println();
        System.out.println("Reversing List: ");
        ListNode reverseList = test.reverseList();
        test.head = reverseList;
        test.displayList();
        System.out.println();
        System.out.println("Deleting Node 34: ");
        test.deleteNode(34);
        test.displayList();

        SinglyLinkedList sortedA = new SinglyLinkedList();
        sortedA.append(4);
        sortedA.append(6);
        sortedA.append(8);
        sortedA.append(10);

        SinglyLinkedList sortedB = new SinglyLinkedList();
        sortedB.append(1);
        sortedB.append(2);
        sortedB.append(3);
        sortedB.append(5);
        sortedB.append(7);


        System.out.println(); System.out.println();
        System.out.println("Two sorted Linked Lists sorted: ");
        ListNode newSorted = mergeSortedLists(sortedA.head, sortedB.head);
        displayList(newSorted);
        System.out.println(); System.out.println();
        
        SinglyLinkedList addA = new SinglyLinkedList();
        addA.append(4);
        addA.append(6);
        addA.append(5);
        addA.append(2);

        System.out.println("First List to be added");
        addA.displayList(); System.out.println();

        SinglyLinkedList addB = new SinglyLinkedList();
        addB.append(3);
        addB.append(4);
        addB.append(7);

        System.out.println("Second list to be added");
        addB.displayList(); System.out.println();

        System.out.println("Adding the two list : (2564 + 743)");
        ListNode newlyAddedList = addTwoNumbers(addA.head, addB.head);
        displayList(newlyAddedList);
    }
}
