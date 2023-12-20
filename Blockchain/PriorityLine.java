package Blockchain;

import java.util.Iterator;

/**
 * Class that is responsible for storing element in order where an element with highest value takes precedence.
 * 
 * @param <T> is the type to be contained in the priority line.
 */
public class PriorityLine<T extends Comparable<T>> implements Iterable<T>
{
    /**
     * Underlying data structure for supporting Priority queue.
     */
    private SinglyLinkedList<T> container;

    /**
     * Creates a new object.
     */
    public PriorityLine()
    {
        container = new SinglyLinkedList<>();
    }

    /**
     * Add and element to the priority queue.
     * 
     * @param element to be added to the list of priority. It's priority is determined by its value.
     */
    public void enqueue(T element)
    {
        //TIME COMPLEXITY REQUIREMENT: O(N)

        /*
            Note: 
                The company that will process the transactions and generate a block has an incentive to first
                process the transactions with the higher fees and leave the ones with lower or zero fees for later.
        */

        //Every enqueue will make the structure organize in descending order (element 1 being the highest priority)
        container.insert(element);
    }

    /**
     * Remove and element from the list that yields the highest priority.
     * 
     * @return The data from the removed highest  priority element.
     */
    public T dequeue()
    {
        //TIME COMPLEXITY REQUIREMENT: O(1)
        
        //The first element yields the highest priority.
        return container.remove(0);
    }

    /**
     * Utilized for identifying how many elements are existing in the list.
     * 
     * @return The number of element existing inside the list.
     */
    public int size()
    {
        //TIME COMPLEXITY REQUIREMENT: O(1)
        return container.size();
    }

    /**
     * For determining if the list is currently empty.
     * 
     * @return True if the list contains zero elements, otherwise, return false.
     */
    public boolean isEmpty()
    {
        //TIME COMPLEXITY REQUIREMENT: O(1)
        return container.isEmpty();
    }

    /**
     * Retrieve the element with highest priority without removing it from the list.
     * 
     * @return The data of the node with the highest priority without removing.
     */
    public T peek()
    {
        //TIME COMPLEXITY REQUIREMENT: O(1)

        if(isEmpty())
            return null;

        return container.get(0);
    }

    @Override
    public Iterator<T> iterator() 
    {
        return container.iterator();
    }

    /**
     * Used for debugging.
     */
    private void printPriorityLine()
    {
        Iterator<T> iterate = iterator();

        while(iterate.hasNext())
            System.out.print(iterate.next() + " -> ");
    }

    /**
     * Only used for program testing.
     * 
     * @param args is not currently in used.
     */
    public static void main(String[] args) 
    {
        PriorityLine<Integer> test = new PriorityLine<>();

        System.out.println("Peak an empty list: " + test.peek());

        test.enqueue(3);
        test.enqueue(9);
        test.enqueue(5);

        test.printPriorityLine();

        System.out.println("\nPrint elements: in highest priority first:");
        while(!test.isEmpty())
        {
            Integer currVal = test.dequeue();
            System.out.println(currVal);
        }
        
    }

}
