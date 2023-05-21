package DataStructures.Lists.LabExamples.SortedNameList;

public class SortedNameList
{
    LLNode head;
    
    public SortedNameList()
    {
       head=null;
    }

    public LLNode getHead()
    {
       return head;
    }
    
    public boolean isEmpty()
    {
       //return true if the list is empty, otherwise true
       return head == null;     
    }
    
    public void add(Name name)
    {
       //add name to the list, after this operation, the list should maintain sorted in ascending order
       LLNode newEntry = new LLNode(name, null);
       add(newEntry);
       
    }
      
    public void add(LLNode node)
    {
       //overloaded method: add node to the list, after this operation, the list should maintain sorted in ascending order

       node.setNext(null);

       //if the list is empty, set node as head
       if(isEmpty())
       {
            head = node;
       }
       else
       {
         //fetch first node
         LLNode current = head;
         LLNode previous = null;

         //loop until a proper position is found to place the new node
         while(current != null && current.getName().compareTo(node.getName()) < 0)
         {
            previous = current;
            current = current.getNext();
         }

         //if previous is null, place new node before head
         if(previous == null)
         {
            node.setNext(head);
            head = node;
         }
         else
         {
            // else, place new node between previous current
            node.setNext(current);
            previous.setNext(node);
         }
       }
    }
    
    public int size()
    {
       //return the number of nodes in the list
       int count = 0;

       //take reference to head
       LLNode current = head;

       //loop until current is null
       while(current != null)
       {
            //increment count
            count++;

            //move to next node
            current = current.getNext();
       }
       
       //return count
       return count;
    }
    
    public boolean isFull()
    {
       return false;
    }
 
    public int search(Name name)
    {
       //return index of the name (the first occurrence) in the list, return -1 if not found
       int index = 0;
       LLNode current = head;

       //loop until current is null
       while(current != null)
       {
            //compare current node's data with name
            int compare = current.getName().compareTo(name);

            //if compare is 0, found the name, return index
            if(compare == 0)
            {
                return index;
            }
            //if compare > 0, stop searching because the rest of the names are guaranteed to be sorted
            //greater than given namme
            else if(compare > 0)
            {
                break;
            }

            index++;
            current = current.getNext();   
       }

       return -1;
    }

    public LLNode get(int index)
    {
       // return the LLNode object at the specified index location, for invalid index, return null
       
       //if index is negative, return null
       if(index < 0)
       {
            return null;
       }

       LLNode current = head;

       //loop until current is null or index is 0
       for(int i = 0; i < index && current != null; i++)
       {
            //move to  next node
            current = current.getNext();
       }

       //return current. which might be null if index invalid
       return current;
       
       
    }
    public void remove(int index)
    {
       //Remove node at the specified index location if valid.
       if(index < 0 || index >= size())
       {
            return;
       }

       //if index is 0, remove head
       if(index == 0)
       {
            head = head.getNext();
       }
       else
       {
        //fetch node at index -1
            LLNode current = head;
            for(int i = 0; i < index-1; i++)
            {
                current = current.getNext();
            }
            
            //remove node at index by connecting previous node to node at index+1
            current.setNext(current.getNext().getNext());
       }
       
    }
    
    public void remove(Name name)
    {
       //remove all occurences of name - please refer to Name class for details
       LLNode current = head;
       LLNode previous  = null;

       //first locate the first node with the given name
       while(current != null && current.getName().compareTo(name) != 0)
       {
            previous  = current;
            current = current.getNext();
       }

       //remove the nodes as long as the name matches
       //removing until the name doesn't match
       while(current != null && current.getName().compareTo(name) == 0)
       {
            if(previous == null)
            {
                head = head.getNext();
                current = head;
            }
            else
            {
                previous.setNext(current.getNext());
                current = current.getNext();
            }
       }
    } 
    
    public void removeAll()
    {
       //remove all nodes
       head = null;
    }

    public static void main(String[] args) 
    {
        //SortedNameList
        SortedNameList list = new SortedNameList();

        //Names
        Name name1 = new Name("Richmond", "Gonzales");
        Name name2 = new Name("Merlin", "Hermes");
        Name name3 = new Name("Sherlock", "Moriarty");
        Name name4 = new Name("Gehrman", "Sparrow");
        Name name5 = new Name("Audrey", "Hall");
      
        //add the names
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.add(name4);
        list.add(name5);

        //testing size method,
        System.out.println("List size: " + list.size());

        System.out.println("List:");

        //display the contents.
        System.out.println("Arranged by ascending order of last names: ");
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.println(list.get(i).getName());
        }

        //testing search method
       // System.out.println("Search for Will West: " + list.search(new Name("Will", "West")));
       System.out.println("Searcing for Sherlock Moriarty: " + list.search(name1));
        System.out.println("Search for Audrey Hall: " + list.search(name5));

        //testing remove method
        list.remove(name1);
        System.out.println("Updated List size: " + list.size());
        System.out.println("Search for Richmond Gonzales: " + list.search(name1));

    }
 }
 
