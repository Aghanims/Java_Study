package Blockchain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

/**
 * Class that can do various function with regards to transactions.
 */
public final class Utilities
{
    /**
     * Reads the transaction from a text file and adds them to a priority queue.
     * 
     * @param pgmFile is a text file that contains information of the transactions.
     * @return A new object PriorityLine of type Transaction with the already stage Transactions from the text file.
     */
    public static PriorityLine<Transaction> loadTransactions(String pgmFile)
    {
        //Accessing the file
        Scanner inputStream = null;
        try
        {
            inputStream = new Scanner(new File(pgmFile));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file: " + pgmFile);
            System.exit(0);
        }

        //Stow all of the transaction in the prioity line in priority line where the highest fee is prioritized.
        PriorityLine<Transaction> transactionLine = new PriorityLine<>();
        while(inputStream.hasNext())
        {
            String sender = inputStream.next();
            String reciever = inputStream.next();
            int amount = Integer.parseInt(inputStream.next());
            int fee = Integer.parseInt(inputStream.next());

            Transaction newRecord = new Transaction(sender, reciever, amount, fee);
            transactionLine.enqueue(newRecord);
        }

        return transactionLine;
    }

    /**
     * Verify if a transaction in a block exists.
     * 
     * @param t is the transaction that we want to verify it's contained in a certain block.
     * @param proof is the list of hashes extracted with the method extractProof.
     * @param blockRootHash is the root hash code stored in the repective block.
     * @return true if the transaction is verified, false otherwise.
     */
    public static boolean verifyTransaction(Transaction t, SinglyLinkedList<String> proof, String blockRootHash)
    {
        String transactionHash = Utilities.cryptographicHashFunction(t.toString());

        for (String hashProof : proof) 
        {
            //Each iteration will update transaction hash with previously XOR-ed hash and the new element
            transactionHash = Utilities.cryptographicHashFunction(transactionHash, hashProof);
        }

        if(transactionHash.equals(blockRootHash))
            return true;
        else 
            return false;
    }

    /**
     * SHA-256 cryptographic hash function for a single input.
     * 
     * @param input is the string to be used for creating the hash.
     * @return A cryptographich hash string.
     */
    public static String cryptographicHashFunction(String input)
    {
        StringBuilder hexString = null;

        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            hexString = new StringBuilder(2 * encodedhash.length);
            for (int i = 0; i < encodedhash.length; i++)
            {
                String hex = Integer.toHexString(0xff & encodedhash[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        return hexString.toString();
    }

    /**
     * SHA-256 cryptographic hash function for a pair of inputs.
     * It uses the XOR bitwise operator to merge the two hash codes.
     * 
     * @param input1 is one of the string to be used for creating the hash string.
     * @param input2 is used to create the hash string from two inputs by XOR-ing them.
     * @return A cryptographich hash string.
     */
    public static String cryptographicHashFunction(String input1, String input2)
    {
        StringBuilder hexString = null;

        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash1 = digest.digest(input1.getBytes(StandardCharsets.UTF_8));
            byte[] encodedhash2 = digest.digest(input2.getBytes(StandardCharsets.UTF_8));
            hexString = new StringBuilder(2 * encodedhash1.length);
            for (int i = 0; i < encodedhash1.length; i++)
            {
                String hex = Integer.toHexString(0xff & (encodedhash1[i] ^ encodedhash2[i]) );
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        return hexString.toString();
    }

    /**
     * For testing all of the above functions.
     * 
     * @param args not currently in used.
     */
    public static void main(String[] args) 
    {
        
        PriorityLine<Transaction> test = loadTransactions("transactions_example____sender_receiver_amount_fee.txt");
        Iterator<Transaction> loop = test.iterator();
        while(loop.hasNext())
        {
            Transaction currentTransaction = loop.next();
            System.out.println(currentTransaction.toString());
        }
    }

}
