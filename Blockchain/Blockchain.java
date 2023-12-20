package Blockchain;

import java.util.Iterator;

/**
 * Class for storing transaction in chained blocks where each block can only hold up to a specified threshold.
 */
public class Blockchain implements Iterable<Block>
{
    /**
     * The container that link and hold all of the blocks that contains transaction depending on cumulative amount.
     */
    private SinglyLinkedList<Block> blockChain;

    /**
     * The constructor that takes a priority queue and creates the inked list of blocks.
     * 
     * @param queue of transaction to be loaded to their respective blocks in the blockchain.
     * @param threshold is the minimum amount of cumulative fees that is required to create a new block.
     *     The block must contain the minimum number of transactions that satisfy the threshold criterion.
     */
    public Blockchain(PriorityLine<Transaction> queue, int threshold)
    {
        blockChain = new SinglyLinkedList<>();

        int cumulativeSum = 0;
        Block currentBlock = new Block();

        //Iterate through the queue 
        Iterator<Transaction> iterate = queue.iterator();
        while(iterate.hasNext())
        {
            Transaction currQueue = iterate.next();
            cumulativeSum += currQueue.getFee();

            if(cumulativeSum <= threshold)
            {
                //add the transaction to the current block
                currentBlock.addTransaction(currQueue);
                continue;
            }
            
            //Load the block with fully charged threshold to the block chain.
            if(cumulativeSum > threshold && currentBlock.numOfTransactions() == 0)
            {   
                Block alreadyFull = new Block();
                alreadyFull.addTransaction(currQueue);
                blockChain.add(alreadyFull);
                currentBlock = new Block();
                cumulativeSum = 0;
                continue;
            }
            else 
                blockChain.add(currentBlock);

            //reset the cumulative fee back to 0
            cumulativeSum = 0;
            //create a new block and add the current transaction.
            Block newBlock = new Block();
            newBlock.addTransaction(currQueue);
            //update the cumulative fee 
            cumulativeSum += currQueue.getFee();

            //make the newBlock the current block
            currentBlock = newBlock;
        }

        //Add the last block to the block chain.
        blockChain.add(currentBlock);
    }

    @Override
    public Iterator<Block> iterator() 
    {
        return blockChain.iterator();
    }

    /**
     * Used for debugging purposes.
     * 
     * @param args CLA not used in this program.
     */
    public static void main(String[] args) 
    {
        PriorityLine<Transaction> test = new PriorityLine<>();
        Transaction transac0 =  new Transaction("Line", "Bara", 786, 10);
        Transaction transac1 = new Transaction("Bhoxz", "Jolan", 200, 9);
        Transaction transac2 = new Transaction("Richmond", "Eunice", 900, 5);
        Transaction transac3 = new Transaction("Aghanims", "REaper", 200, 4);
        Transaction transac4 = new Transaction("Galan", "Balor", 678, 2);
        Transaction transac5 = new Transaction("Boll", "Bill456", 456, 1);
        test.enqueue(transac0);
        test.enqueue(transac1);
        test.enqueue(transac2);
        test.enqueue(transac3);
        test.enqueue(transac4);
        test.enqueue(transac5);

        int blockCounter = 1;
        Blockchain result = new Blockchain(test, 9);
        Iterator<Block> loop = result.iterator();
        while(loop.hasNext())
        {
            Block currentBlock = loop.next();

            System.out.print("Block" + blockCounter + ": ");
            Iterator<Transaction> blockLooper = currentBlock.iterator();
            while(blockLooper.hasNext())
            {
                Transaction currTransac = blockLooper.next();
                System.out.print(currTransac.getFee() + " -> ");
            }
            blockCounter++;
            System.out.println();
        }
    }

}
