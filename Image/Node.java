package Image;

/**
 * Class for representing a node element in a linked list. However, exlclusively used to represent as a pixel of 
 * an image.
 * 
 * @author Richmond D. Gonzales
 * @param <T> is the data type used to store values in a node.
 */
public final class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{    
    /**
     * Holds the data of the node.
     */
    private T data;

    /**
     * The pointer to the node above.
     */
    private Node<T> up;

    /**
     * The pointer to the node below.
     */
    private Node<T> down;

    /**
     * The pointer to the node on the right.
     */
    private Node<T> right;

    /**
     * The pointer to the node on the left.
     */
    private Node<T> left;
    

    /**
     * Constructor that sets everything to null.
     */
    public Node()
    {
        //Everything is initially already set to null.
    }

    /**
     * Constructor that sets the data field only and everythinge else to null.
     * 
     * @param value to be contained on the node, or the data of the node.
     */
    public Node(T value)
    {
        data = value;
    }   

    /**
     * Setter method for the data field.
     * 
     * @param value replacement for the current existing data of the node.
     */
    public void setValue(T value)
    {
        data = value;
    }

    /**
     * Getter method for the data of the node.
     * 
     * @return The data of the node.
     */
    public T getValue()
    {
        return data;
    }

    /**
     * Getter method for the node that is being pointer up of the current node.
     * 
     * @return The node above the current node.
     */
    public Node<T> getUp()
    {
        return up;
    }

    /**
     * Getter method for the node that is being pointed down of the current node.
     * 
     * @return The node below the current node.
     */
    public Node<T> getDown()
    {
        return down;
    }

    /**
     * Getter method for the node that is being pointed right of the current node.
     * 
     * @return The right node of the current node.
     */
    public Node<T> getRight()
    {
        return right;
    }

    /**
     * Getter method for the node that is being pointer left of the current node.
     * 
     * @return The left node of the current node.
     */
    public Node<T> getLeft()
    {
        return left;
    }

    /**
     * Setter method for the up pointer.
     * 
     * @param p of the new node for modifying the up node.
     */
    public void setUp(Node<T> p)
    {
        up = p;
    }

    /**
     * Setter method for the down pointer.
     * 
     * @param p of the new node for modifying the down node.
     */
    public void setDown(Node<T> p)
    {
        down = p;
    }

    /**
     * Setter method for modifying the right pointer.
     * 
     * @param p of the new node for modifying the right node.
     */
    public void setRight(Node<T> p)
    {
        right = p;
    } 
    
    /**
     * Setter method for the left pointer.
     * 
     * @param p of the new node for modifying the left node.
     */
    public void setLeft(Node<T> p)
    {
        left = p;
    }

    @Override
    public int compareTo(Node<T> o) 
    {
        return data.compareTo(o.getValue());
    }
}
