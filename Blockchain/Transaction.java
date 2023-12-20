package Blockchain;

/**
 * Program that represents the transaction that is happening in blockchain. Each transaction contains information about the reciever, sender, as well as the fee given
 * for processing.
 */
public class Transaction implements Comparable<Transaction>
{
    /**
     * Name of the sender in the transaction.
     */
    private String sender;

    /**
     * Reciever name of the transaction.
     */
    private String receiver;

    /**
     * Transaction amount.
     */
    private int amount;

    /**
     * Each transaction must pay a fee for processing. There is no restriction in the amount of fee.
     * That means, the higher the free, the higher level of accomadation in a transaction.
     */
    private int fee;
    
    /**
     * Constructor that initializes all necessary fields of a transaction into an object.
     * 
     * @param sender name of the transaction that will send the amount.
     * @param receiver name that will be the recieving end of the transaction.
     * @param amount to be sent by the sender, as well as the amout to be recieved.
     * @param fee for processing; higher fee means higher accomodation during processing.
     */
    public Transaction(String sender, String receiver, int amount, int fee)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.fee = fee;
    }

    /**
     * Function for giving a detailed information about the transaction.
     * 
     * @return a formated string of a transaction with its details.
     */
    public String toString()
    {
        return String.format("%s %s %d %d", sender, receiver, amount, fee);
    }

    /**
     * Getter on the fee given for a transaction.
     * 
     * @return an integer value on how much processing fee was given in a transaction.
     */
    public int getFee()
    {
        return fee;
    }

    @Override
    public int compareTo(Transaction o) 
    {
        if(fee < o.fee)
            return -1;
        else if(fee == o.fee)
            return 0;
        else 
            return 1;
    }
}
