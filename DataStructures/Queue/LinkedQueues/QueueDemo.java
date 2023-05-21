package DataStructures.Queue.LinkedQueues;

public class QueueDemo 
{
    public static void main(String[] args) 
    {
       int[] numbers = { 83, 4, 57, 6, 92, 49, 64, 5 };
       
       // Initialize a new Queue and add numbers
       LinkedQueue numQueue = new LinkedQueue();
       for (int number : numbers) 
       {
           numQueue.enqueue(number);
       }
 
       // Output queue
       System.out.print("Queue after initial enqueues: ");
       numQueue.print();
       
       // Dequeue 83 and print
       numQueue.dequeue();
       System.out.print("Queue after first dequeue:    ");
       numQueue.print();
       
       // Enqueue 99 and print
       numQueue.enqueue(99);
       System.out.print("Queue after enqueueing 99:    ");
       numQueue.print();
       
       // Dequeue 4 and print
       numQueue.dequeue();
       System.out.print("Queue after second dequeue:   ");
       numQueue.print();
    }
 }