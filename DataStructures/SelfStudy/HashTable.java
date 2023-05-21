package DataStructures.SelfStudy;

import java.util.HashMap;

public class HashTable 
{
    private HashNode[] buckets;
    private int numOfBuckets; //capacity
    private int size;  //number of key value pair in the hashtable

    public HashTable()
    {
        this(10); //default capacity of 10
    }

    public HashTable(int capacity)
    {
        numOfBuckets = capacity;
        buckets = new HashNode[numOfBuckets]; //assign the capacity as the size of the array of HashNode
        size = 0;   //there are no hashnode at the initial of hashtable
    }
   
/******************************************************************************************************************* */  
    private class HashNode
    {
        private Integer key; //can be generic type
        private String value; //can be generic type
        private HashNode next; //reference to the next hashnode

        private HashNode(Integer key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }    

 /******************************************************************************************************************* */     

    public int size() {return size;}

    public boolean isEmpty() { return size == 0;} //empty when there is no HashNode

    public void put(Integer key, String value)
    {

        //Throw exception if needed like: when key == null, or value == null;

        int bucketIndex = getBucketIndex(key); //access the HashFunction (modular)

        HashNode head = buckets[bucketIndex]; //access the index of provided hashfunction

        while(head != null)
        {
            if(head.key.equals(key))
            {
                head.value = value; //update the value if there is a similar key with different value
                return;
            }
            head = head.next; //traverse the list to search for similar key
        }

        size++;
        head = buckets[bucketIndex]; 

        HashNode node = new HashNode(key, value);
        node.next = head; //update the pointer; added HashNode is pointed to the previous head
        buckets[bucketIndex] = node; //the added HashNode is the new head
    }

    public String get(Integer key)
    {
        int bucketIndex = getBucketIndex(key);

        HashNode head = buckets[bucketIndex];
        while(head != null)
        {
            if(head.key.equals(key))     
                return head.value;
            
            head = head.next; //iterate throught the list to find node with similar key
        }
        return null; //signifies that given value is not present in the hashtable
    }

    public int getBucketIndex(Integer key)
    {   
        return key % buckets.length; //hash function
    }

    public String remove(Integer key)
    {
        int bucketIndex = getBucketIndex(key);

        HashNode head = buckets[bucketIndex];
        HashNode previous = null;

        //travers the list and keep record of our previous HashNode
        while(head != null)
        {
            if(head.key.equals(key)) //purpose: determine the locationn of the hashnode to be removed
                break;
            
            previous = head; 
            head = head.next;
        }

        if(head == null) {return null;}
        size--;

        if(previous != null) 
        {   
            previous.next = head.next; //point the next pointer of previous to the next pointer of the head
        }
        else //previous == null ; indicates that hashindex has only one node inside.
        {
            buckets[bucketIndex] = head.next; 
        }

        return head.value;
    }

/******************************************************************************************************************* */

    public static void main(String[] args) 
    {
        HashTable itemPrice = new HashTable(5);

        itemPrice.put(20, "Red Horse");
        itemPrice.put(10, "Pancit Canton");
        itemPrice.put(150, "Lechon Manok");
        itemPrice.put(19, "Balut");
        itemPrice.put(249, "Electric Fan");
        itemPrice.put(9, "Itlog");

        System.out.println(itemPrice.size());
        System.out.println(itemPrice.get(150));
        System.out.println(itemPrice.remove(10));

        System.out.println("Updated size: " + itemPrice.size());
    }
}
