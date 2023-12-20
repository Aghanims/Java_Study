package Blockchain;

import java.util.Iterator;

/**
 * Class that represents a single block in the blockchain.
 */
public class Block implements Comparable<Block>, Iterable<Transaction>
{
    /**
     * A block contains a list of transactions.
     */
    private SinglyLinkedList<Transaction> transactions;

    /**
     * Hashcode of the the root in a Merkle tree for effecient verificaiton.
     */
    private String rootHash;

    /**
     * Constructor for creating new Block object with 0 transaction.
     */
    public Block()
    {
        transactions = new SinglyLinkedList<>();
        rootHash = null;
    }

    /**
     * Add a transaction in the block.
     * 
     * @param t Transaction to be added to the list of transaction in a block.
     */
    public void addTransaction(Transaction t)
    {
        transactions.add(t);
    }

    /**
     * Deterimine the number of transaction contained in a block.
     * 
     * @return The count of transaction existed in a block.
     */
    public int numOfTransactions()
    {
        return transactions.size();
    }

    /**
     * Retrieve the root hash of a root node in a Merkle tree.
     * 
     * @return A root hash of the root node in a Merkle tree.
     */
    public String getRootHash()
    {
        return rootHash;
    }

    /**
     * Assigns a hashcode from the root of a Merkle tree to this block.
     * 
     * @param hashCode of the root node from Merkle tree.
     */
    public void setRootHash(String hashCode)
    {
        rootHash = hashCode;
    }

    @Override
    public Iterator<Transaction> iterator() 
    {
        return transactions.iterator();
    }

    @Override
    public int compareTo(Block o) 
    {
        if(numOfTransactions() < o.numOfTransactions())
            return -1;
        else if(numOfTransactions() > o.numOfTransactions())
            return 1;
        else 
            return 0;
    }

    /**
     * Utilized for debugging.
     * 
     * @param args CLA not currently in used.
     */
    public static void main(String[] args) 
    {   
        Block test = new Block();

        Transaction dummy = new Transaction("Balor", "Baler", 567, 8);
        test.addTransaction(dummy);
    }
}
