package DataStructures;

public class StringLinkedList 
{
    private ListNode head; //contains the reference of the first node

    public StringLinkedList()
    {
        head = null;
    }

    //Displays data on the list
    public void showList()
    {
        ListNode position = head;

        while(position != null)
        {
            System.out.println(position.getData());
            position = position.getlink();
        }
    }

    //Return the number of nodes on the list
    public int length()
    {
        int count = 0;
        ListNode position = head;

        while(position != null)
        {
            count++;
            position = position.getlink();
        }

        return count;
    }

    //Adds a node containing the data addData at the start of the list
    public void AddANodeToStart(String addData)
    {
        head = new ListNode(addData, head);
    }

    //deletes the first node on the list
    public void deleteNode()
    {
        if(head != null)
            head = head.getlink();
        else
        {
            System.out.println("Deleting from an empty list");
            System.exit(0);
        }
    }

    //Sees whether target is on the list
    public boolean onList(String target)
    {
        return find(target) != null; 
    }

    //Returns a reference to the first node containing the target data.
    //If target is not on the list, returns null.
    private ListNode find(String target)
    {
        boolean found = false;
        ListNode position = head;

        while((position != null) && !found)
        {
            String dataAtPosition  = position.getData();

            if(dataAtPosition.equals(target))
                found = true;
            else
                position = position.getlink();  //thre reference in position from one node to the next via this assignment
            /*
                A reference to the next node in the linked list is "postion.getlink()"
                You "move" the position variable by giving it the value of position.getlink();
            */
        }

        return position;
    }
}
