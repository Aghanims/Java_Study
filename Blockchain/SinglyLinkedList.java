package Blockchain;

import java.util.Iterator;

/**
 * Data structure for helping utilized the PriorityLine class.
 * 
 * @param <T> is the data type of a pixel that serves as its values.
 */
public class SinglyLinkedList<T extends Comparable<T>> implements Iterable<T>
{
    /**
     * Class that represents each element in the linked list.
     * 
     * @param <T> is the data type of node in the list.
     */
    private static class Node<T extends Comparable<T>> implements Comparable<Node<T>>
    {
        /**
         * Stored value in a node.
         */
        private T data;

        /**
         * A pointer that links to the other nodes.
         */
        private Node<T> next;

        /**
         * Constructor for creating a node object with initialized data.
         * 
         * @param data that is contained in a node.
         */
        public Node(T data)
        {
            this.data = data;
            next = null;
        }

        @Override
        public int compareTo(Node<T> o) 
        {
            return data.compareTo(o.data);
        }
    }

    /**
     * The starting point of the singly linked list that is used to access connected next elements.
     */
    private Node<T> head;
    
    /**
     * Field for easy access of the end of the list so that some operations will run effeciently in terms of time.
     */
    private Node<T> tail;

    /**
     * Increments everytime a new element is added to the list and decrement if an element is removed.
     */
    private int size;

    /**
     * Used for creating a new object of class. It will initialize all instance fields to null or zero.
     */
    public SinglyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * Adds a value to the end of the list.
     * 
     * @param value of the node to be added to the linked list.
     */
    public void add(T value)
    {     
        //TIME COMPLEXITY REQUIREMENT: O(1)

        Node<T> newNode = new Node<T>(value);

        if(head == null)
        {
            head = newNode;
            tail = head;
        }

        //empty list
        else 
        {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }   

    /**
     * Inserts a value to the proper location in the list so that the list order is preserved in descending order.
     * 
     * @param newValue of the node to be inserted to the linked list.
     */
    public void insert(T newValue)
    {
        //TIME COMPLEXITY REQUIREMENT: O(N)

        Node<T> newNode = new Node<T>(newValue);

        //Empty list
        if(head == null)
        {
            head = newNode;
            tail = head;   
            size++;
        }
        else 
        {
            Node<T> currNode = head;
            Node<T> prevNode = null;

            while(currNode != null)
            {
                if(newValue.compareTo(currNode.data) > 0)
                {
                    if(currNode == head)
                    {
                        //prepend the value if the newValue (the max value) is supposed to be at the first element.
                        newNode.next = currNode;
                        head = newNode;
                        break;
                    }
                    else 
                    {
                        prevNode.next = newNode;
                        newNode.next = currNode;
                        break;
                    }   
                }
                else if(currNode == tail)
                {
                    //if all elements are exhausted and the iteration is currently at the end of of the list, then just simply append.
                    add(newValue);
                    return;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            size++;
        }
    }

    /**
     * Remove a single item from the list based on its index.
     * 
     * @param index of the current node from the list.
     * @return The value of the node to be removed.
     */
    public T remove(int index)
    {
        //TIME COMPLEXITY REQUIREMENT: O(N)

        if(index < 0 || index >= size())
            throw new RuntimeException();

        int counter = 1;
        T removedData = null;
        Node<T> currNode = head.next;

        //remove the head
        if(index == 0)
        {   
            removedData = head.data;
            head = head.next;
        }   
        else 
        {
            while(currNode != null)
            {
                if(counter + 1 == index)
                {
                    removedData = currNode.next.data;
                    currNode.next = currNode.next.next;
                    
                    //if the node to be removed is the tail, then update the new tail.
                    if(index + 1 == size())
                        tail = currNode;
                
                    break;
                }
                counter++;
                currNode = currNode.next;
            }
        }
        size--;
        return removedData;
    }

    /**
     * Retrieve the value of an element from the list.
     * 
     * @param index of the current element from the list.
     * @return A single item from the list based on its index without removing the element.
     */
    public T get(int index)
    {
        //TIME COMPLEXITY REQUIREMENT: O(N)
        if(index < 0 || index >= size())
            throw new RuntimeException();

        Node<T> currNode = head;
        int counter = 0;

        while(currNode != null)
        {
            if(counter == index)
                return currNode.data;

            counter++;
            currNode = currNode.next;
        }
        return null;
    }


    /**
     * Count of the total element existing in the list.
     * 
     * @return An integer value of how many elements connected in the list.
     */
    public int size()
    {
        return size;
    }

    /**
     * Determines if the singly-linked list has not existing elements.
     * 
     * @return True if the list contains zero elements, otherwise, false.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Private class that is responsible allowing the singly-linked list to use an iterator.
     * 
     * @param <T> is the data type to be iterated from the list.
     */
    private static class ListIterator<T extends Comparable<T>> implements Iterator<T>
    {
        /**
         * Node element from the list. This Node will change towards its next pointer to initiate iteration.
         */
        private Node<T> currNode;

        /**
         * Constructor that created an object that accepts a head of the singly-linked list to access all the elements.
         * 
         * @param head of the singly-linked list.
         */
        public ListIterator(Node<T> head)
        {
            currNode = head;
        }

        @Override
        public boolean hasNext() 
        {
            return currNode != null;
        }

        @Override
        public T next() 
        {
            T returnValue = currNode.data;
            currNode = currNode.next;
            return returnValue;
        }
    }

    @Override
    public Iterator<T> iterator() 
    {
        return new ListIterator<>(head);
    }

    /**
     * Used for printing the linked-list structure on the console.
     */
    private void printList()
    {
        Iterator<T> looper = iterator();

        while(looper.hasNext())
            System.out.print(looper.next() + " -> "); 
    }

    /**
     * Utlized for debugging.
     * 
     * @param args CLA not currently in used.
     */
    public static void main(String[] args) 
    {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();

        test.insert(9);
        test.insert(5);
        test.insert(6);
    
        test.add(1);
        test.remove(3);
        test.insert(20);
        test.insert(7);
        Integer getValue = test.get(1);

        test.printList();
        System.out.println("\nsize: " + test.size());
        System.out.println("head: " + test.head.data);
        System.out.println("Tail: " + test.tail.data);
        System.out.println("Get value at index 1: " + getValue);
        System.out.println("isEmpty: " + test.isEmpty());
    }
}
