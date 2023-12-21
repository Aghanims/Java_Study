package Image;

import java.util.Iterator;

/**
 * A gateway program that exclusive for iterating the 2d doubly-linked list of an image object.
 * 
 * @author Richmond D. Gonzales
 * @param <T> is the data type being used on each pixel of the image.
 */
public class ImageIterator<T extends Comparable<T>> implements Iterator<Node<T>>
{
    /**
     * Main iterator or runner that visits all the nodes.
     */
    private Node<T> currNode;

    /**
     * Serves as the index 0, or the head of the current row or column (depending on the direction).
     * This will be used to be able for the currNode to backtrack and move down or right
     * to the first node of the next row or column until it reached maximum boundaries of the iteration.
     */
    private Node<T> nodeBacktracer;

    /**
     * Direction on where the iteration will run.
     */
    private Direction dir;

    /**
     * Used only for letting the head of the list to be retrieved before going to the next right or down node.
     */
    private int initialCount;

    /**
     * Constructor for initializing the starting point and the horizontal direction of the iteration.
     * 
     * @param head is the starting node of the image. The head is placed at the most top-left of the image. 
     */
    public ImageIterator(Node<T> head)
    {
        currNode = head;
        nodeBacktracer = head;
        dir = Direction.HORIZONTAL;
        initialCount = 0;
    }

    /**
     * Constructor for initializing the starting point and a specified direction of the direction.
     * 
     * @param head or the current node of the 2d doubly-linked list; initially starts at head.
     * @param dir specification which is chosed from a VERTICAL or HORIZONTAL iteration.
     */
    public ImageIterator(Node<T> head, Direction dir)
    {
        currNode = head;
        nodeBacktracer = head;
        this.dir = dir;
        initialCount = 0;
    }

    @Override
    public boolean hasNext() 
    {
        //Configure conditions on both directions of the iteration.

        if(dir == Direction.HORIZONTAL)
        {
            //check if next right is available
            if(currNode.getRight() != null)
                return true;
            
            //if the next right is null, then check the first node of the next row
            //if it is available for visiting.
            if(nodeBacktracer.getDown() != null)
                return true;
        }
        else if(dir == Direction.VERTICAL)
        {
            //check if the next bottom is available
            if(currNode.getDown() != null)
                return true;

            //If the no node is available down, the check if the next right column is 
            //available for traversing.
            if(nodeBacktracer.getRight() != null)
                return true;
        }

        //no available nodes to traverse.
        return false;
    }

    @Override
    public Node<T> next() 
    {
        if(initialCount == 0)
        {
            initialCount++;
            return currNode;
        }

        //determine the direction first before proceeding to the next node
        if(dir == Direction.HORIZONTAL)
        {
            //determine if a right node exist and proceed if it does.
            if(currNode.getRight() != null)
            {
                currNode = currNode.getRight();
                return currNode;
            }
            else 
            {
                //otherwise check if the next row is available and proceed if it does.
                if(nodeBacktracer.getDown() != null)
                {
                    currNode = nodeBacktracer.getDown();
                    nodeBacktracer = nodeBacktracer.getDown();
                    return currNode;
                }
            }
        }
        else if(dir == Direction.VERTICAL)
        {
            if(currNode.getDown() != null)
            {
                currNode = currNode.getDown();
                return currNode;
            }
            else 
            {
                if(nodeBacktracer.getRight() != null)
                {
                    currNode = nodeBacktracer.getRight();
                    nodeBacktracer = nodeBacktracer.getRight();
                    return currNode;
                }
            }
        }
        return null;
    }
}
