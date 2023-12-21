package Image;

import java.util.Iterator;

/**
 * Program that uses 2d doubly-linked list to represent an image. 
 * Each node of the data structure represents a pixel.
 * 
 * @author Richmond D. Gonzales
 * @param <T> is the data type of a pixel that serves as its values.
 */
public class Image<T extends Comparable<T>> implements Iterable<Node<T>>
{
    /**
     * A pointer for the top-left corner of the two-dimenstional doubly-linked list.
     */
    private Node<T> head;
    
    /**
     * A pointer that points the most bottom-right node of the 2D doubly linked list.
     */
    private Node<T> tail;

    /**
     * The height of the image.
     */
    private int height;

    /**
     * The width of the image.
     */
    private int width;

    /**
     * Builds a two-dimensional data structure that has a rectangluar shape. All the rows
     * must have the same number of nodes. The constructor does not assign values to the 
     * nodes.
     * 
     * @param width dimension that is define from left to right of the two-dimensional data.
     * @param height dimension that is define from top to bottom of the two-dimensional data.
     */
    public Image(int width, int height)
    {
        //cannot have negative values for the dimensions
        if(height < 0 || width < 0)
            throw new RuntimeException();

        this.height = height;
        this.width = width;

        //build a two dimentsional doubly-linked list
        Node<T> currHead = null;
        Node<T> rowNode = new Node<T>(null);
        for(int row = 0; row < height; row++)
        {
            if(row == 0)
            {
                head = rowNode;
                tail = rowNode;
                currHead = rowNode;
            }
            
            for(int col = 1; col < width; col++)
            {
                Node<T> nextNode = new Node<>(null);

                nextNode.setLeft(tail);
                
                if(row > 0)
                {
                    nextNode.setUp(tail.getUp().getRight());
                    tail.getUp().getRight().setDown(nextNode);
                }
                
                tail.setRight(nextNode);                
                tail = nextNode;
            }

            if(row < height- 1)
            {
                Node<T> nextRow = new Node<>(null);
                nextRow.setUp(currHead);
                currHead.setDown(nextRow);
                tail = nextRow;
                currHead = nextRow;
            }
        }
    }

    /**
     * Retrieves the value of height of the image.
     * 
     * @return the height of the image.
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Retrieves the value of the width of the image.
     * 
     * @return the width of the image.
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Retrieves the head node of the image.
     * 
     * @return a node that represents as the head of the 2D linked list.
     */
    public Node<T> getHead()
    {
        return head;
    }

    /**
     * Insert a single row that has the same value for all its nodes.
     * The maximum value of the index is k where k is the number of rows.
     * 
     * @param index of the 2d doubly-linked list where the row will be inserted.
     * @param value of all nodes on the row.
     */
    public void insertRow(int index, T value)
    {
        if(index < 0 || index > height + 1)
            throw new RuntimeException();

        Node<T> currHead = head;
        int widthCounter = 0;

        //go the the previous row, of the row to be added; only if it is not zero because zero has no previous row
        if(index > 0)
        {
            for(int i = 0; i < index - 1; i++)
                currHead = currHead.getDown();
        }
        else 
        {
            //If ever the index to be added with row is zero, then make the new row the head, while updating the pointers
            Node<T> newFirstRow = new Node<T>(value);
            
            newFirstRow.setDown(head);
            head.setUp(newFirstRow);
            
            head = newFirstRow;
            currHead = currHead.getRight();
            widthCounter++;
        }

        //responsible for pointing appropriate appropriate linked nodes
        for(int col = widthCounter; col < width; col++)
        {
            Node<T> newNode = new Node<>(value);

            if(index == 0 && col > 0)
            {
                newNode.setLeft(currHead.getLeft().getUp());
                currHead.getLeft().getUp().setRight(newNode);
            }
            else if(index > 0 && col > 0)
            {
                newNode.setLeft(currHead.getLeft().getDown());
                currHead.getLeft().getDown().setRight(newNode);
            }

            if(index == 0)
            {
                newNode.setDown(currHead);
                currHead.setUp(newNode);
            }
            else 
            {
                if(index < height)
                {
                    newNode.setDown(currHead.getDown());
                    currHead.getDown().setUp(newNode);
                }   

                newNode.setUp(currHead);
                currHead.setDown(newNode);
            }   
            currHead = currHead.getRight();
        }

        if(index == height)
             tail = tail.getDown();
        height++;
    }

    /**
     * Removes a single column rom the data structure based on its index.
     * 
     * @param index from left to right of the 2d doubly-linked list.
     */
    public void removeColumn(int index)
    {
        //O(height + width)

        if(index < 0 || index >= width)
            throw new RuntimeException();

        Node<T> currHead = head;
        int control = index - 1;

        if(index == width - 1)
        {
            control = index;
            tail = tail.getLeft();
        }

        if(index == 0 && width > 1)
            head = head.getRight();
        else if(width == 1 && index == 0)
        {
            head = null;
            width--;
            return;
        }

        for(int col = 0; col < control; col++)
            currHead = currHead.getRight();

        for(int row = 0; row < height; row++)
        {
            if(index == 0)
                currHead.getRight().setLeft(null);
            else if(index == width - 1)
            {
                currHead.getLeft().setRight(null);
            }
            else 
            {
                if(currHead.getRight() != null)
                    currHead.setRight(currHead.getRight().getRight());
                else 
                    currHead.setRight(null);
                
                if(currHead.getLeft() != null)
                    currHead.setLeft(currHead.getLeft().getLeft());
                else 
                    currHead.setLeft(null);
            }

            currHead = currHead.getDown();
        }       
        width--;
    }

    /**
     * Removes a node that is identical to its adjacent nodes.
     * 
     * @return The total number of nodes (pixels) removed from the image.
     */
    public int compress()
    {
        int totalRemoved = 0;
        /*
          Algo: 
            - iterate the 2d doubly-linked list
                - during each visit, compare if there is a value that is similar it with its neighbors.
                - if such value exists, then remove the node that is currently visited. 
                    - Update the head and tail if necessary.
                    - This can be done by reassining pointer of their respective neighbors.
        */
        Node<T> nextRowHead = head.getDown();
        Node<T> currTail = head;

        while(nextRowHead != null)
        {
            while(currTail != null)
            {
                //removed this node if it has identical neighbor
                if(hasIdenticalAdjacent(currTail))
                {
                    if(head == currTail)
                    {
                        if(head.getRight() != null)
                            head = head.getRight();
                        else 
                        {
                            head = nextRowHead;
                            height--;
                        }
                    }
                    
                    if(currTail.getRight() != null && currTail.getRight() == tail)
                        tail = currTail;

                    if(currTail.getLeft() != null && currTail.getRight() != null)
                        currTail.getRight().setLeft(currTail.getLeft());
                    else if(currTail.getRight() != null && currTail.getLeft() == null)
                        currTail.getRight().setLeft(null);

                    if(currTail.getUp() != null && currTail.getDown() != null)
                        currTail.getDown().setUp(currTail.getUp());
                    else if(currTail.getDown() != null && currTail.getUp() == null)
                        currTail.getDown().setUp(null);

                    totalRemoved++;
                }
                currTail = currTail.getRight();
            }
            currTail = nextRowHead;
            nextRowHead = nextRowHead.getDown(); 
        }
        return totalRemoved;
    }

    /**
     * Adds a border to the perimeter of the image. The border has a width of 1 pixel
     * and increases the height and width of the image by 2 pixels in each dimension.
     */
    public void addBorder()
    {
        //add top and bottom row; 
        Node<T> topHeight = head;
        Node<T> botHeight = tail;
        for(int row = 0; row < width; row++)
        {
            Node<T> topNewNode = new Node<T>(topHeight.getValue());
            Node<T> botNewNode = new Node<T>(botHeight.getValue());

            //point the top border below and vice versa.
            topNewNode.setDown(topHeight);
            topHeight.setUp(topNewNode);

            //point the the bottom border above and vice versa.
            botNewNode.setUp(botHeight);
            botHeight.setDown(botNewNode);

            //proceed to next node and change left and right pointers.
            if(row > 0)
            {
                topNewNode.setLeft(topHeight.getLeft().getUp());
                botNewNode.setRight(botHeight.getRight().getDown());

                topHeight.getLeft().getUp().setRight(topNewNode);
                botHeight.getRight().getDown().setLeft(botNewNode);
            }

            topHeight = topHeight.getRight();
            botHeight = botHeight.getLeft();
        }

        tail = tail.getDown();
        head = head.getUp();
        height += 2;

        //add left and right column
        Node<T> leftColumn = head;
        Node<T> rightColumn = tail;

        for(int col = 0; col < height; col++)
        {
            //Both of these new nodes will be the one to be added
            Node<T> leftNewNode = new Node<T>(leftColumn.getValue());
            Node<T> rightNewNode = new Node<T>(rightColumn.getValue());

            //Prepend a node on the left column in each iteration
            leftNewNode.setRight(leftColumn);
            leftColumn.setLeft(leftNewNode);

            //Append a node on the right column in each iteration.
            rightNewNode.setLeft(rightColumn);
            rightColumn.setRight(rightNewNode);

            if(col > 0)
            {
                leftNewNode.setUp(leftColumn.getUp().getLeft());
                leftColumn.getUp().getLeft().setDown(leftNewNode);

                rightNewNode.setDown(rightColumn.getDown().getRight());
                rightColumn.getDown().getRight().setUp(rightNewNode);
            }

            //Since the head is on the top-left side of 2D doubly-linked list and bot-right for the tail:
            //Both iterators of these variables wil go the opposite way.
            leftColumn = leftColumn.getDown();
            rightColumn = rightColumn.getUp();
        }
        head = head.getLeft();
        tail = tail.getRight();

        width += 2;
    }

    /**
     * Removes the borderline pixels from the image. The border has a width of 1 pixel, and it
     * decreases the height and the width of the image by 2 pixels in each dimension.
     */
    public void removeBorder()
    {
        if(height <= 2 || width <= 2)
            throw new RuntimeException();

        //remove the top and row bottom
        Node<T> topHeight = head;
        Node<T> botHeight = tail;

        head = head.getDown();
        tail = tail.getUp();

        for(int row = 0; row < width; row++)
        {
            //disconnect the top row
            topHeight.getDown().setUp(null);

            //disconnect the last row.
            botHeight.getUp().setDown(null);

            topHeight = topHeight.getRight();
            botHeight = botHeight.getLeft();
        }
        height -= 2;

        //remove the left and right column.
        Node<T> leftColumn = head;
        Node<T> rightColumn = tail;

        head = head.getRight();
        tail = tail.getLeft();

        for(int col = 0; col < height; col++)
        {
            //disconnect the node of the left column in each iteration
            leftColumn.getRight().setLeft(null);

            //disconnect the node of the right column in each iteration.
            rightColumn.getLeft().setRight(null);

            leftColumn = leftColumn.getDown();
            rightColumn = rightColumn.getUp();
        } 
        width -= 2;
    }

    /**
     * It creates a new image that has the same size with the original, but the value of each pixel is 
     * replaced by the maximum value in its neighborhood.
     * 
     * @return The image that has been maximized.
     */
    public Image<T> maxFilter()
    {
        Image<T> newImage = new Image<>(width, height);

        Node<T> newImgHead = newImage.head;
        Node<T> newImgTail = newImage.head;

        Node<T> currHead = head;
        Node<T> currTail = head;

        while(currHead != null)
        {
            while(currTail != null)
            {
                maximizer(currTail, newImgTail);
                
                currTail = currTail.getRight();
                newImgTail = newImgTail.getRight();
            }
            currHead = currHead.getDown();
            newImgHead = newImgHead.getDown();

            currTail = currHead;
            newImgTail = newImgHead;
        }
        return newImage;
    }
    
    @Override
    public Iterator<Node<T>> iterator() 
    {
        return new ImageIterator<>(head);
    }

    /**
     * An iterator that can set the direction of the iteration to either HORIZONTAL or VERTICAL.
     * 
     * @param dir direction or the path where the operator will iterate.
     * @return an ImageIterator that traverses the image depending on the specified direction.
     */
    public Iterator<Node<T>> iterator(Direction dir)
    {
        return new ImageIterator<>(head, dir);
    }

    /**
     * For debugging purposes. Prints the 2D doubly linked list where 1 represents a null value. If the 
     * node has a value that is no null, it will print the value associated to the node.
     */
    private void printList()
    {
        Node<T> currHead = head;
        Node<T> currTail = head;

        while(currHead != null)
        {
            while(currTail != null)
            {
                if(currTail.getValue() == null)
                    System.out.print("1\t");
                else 
                    System.out.print(currTail.getValue() + "\t");

                currTail = currTail.getRight();
            }
            currHead = currHead.getDown();
            currTail = currHead;
            System.out.println("");
        }
    }

    /**
     * Utilized for identifying if the specified node holds the same value as its neighbor.
     * 
     * @param node from the 2d doubly linked list
     * @return True if the the node has a neighbor with the same value.
     */
    private boolean hasIdenticalAdjacent(Node<T> node)
    {
        if(node.getUp() != null)
        {   
            //up
            if(node.compareTo(node.getUp()) == 0)
                return true;
            //top - left
            if(node.getUp().getLeft() != null && node.compareTo(node.getUp().getLeft()) == 0)
                return true;
            //top - right
            if(node.getUp().getRight() != null && node.compareTo(node.getUp().getRight()) == 0)
                return true;
        }
            
        if(node.getDown() != null)
        {
            //bottom
            if(node.compareTo(node.getDown()) == 0)
                return true;
            //bottom-left
            if(node.getDown().getLeft() != null && node.compareTo(node.getDown().getLeft()) == 0)
                return true;
            //bottom-right
            if(node.getDown().getRight() != null && node.compareTo(node.getDown().getRight()) == 0)
                return true;
        }    

        //left 
        if(node.getLeft() != null && node.compareTo(node.getLeft()) == 0)
            return true;
        //right
        if(node.getRight() != null && node.compareTo(node.getRight()) == 0)
            return true;
            
        return false;
    }

    /**
     * Identify if such value from the neighbors is greater than the value of the specific node from the current image object.
     * If that value exist, then assign that value to the other specified node (toNode) which represents the current node from a different 
     * image object. This way the value from the original image object is not modi fied.
     * 
     * @param fromNode is the reference image object.
     * @param toNode is an existing image object that is used for copying the maximize value.
     */
    private void maximizer(Node<T> fromNode, Node<T> toNode)
    {   
        T newValue = fromNode.getValue();

        //check if there is available row up
        if(fromNode.getUp() != null)
        {
            //up
            if(fromNode.getUp().getValue().compareTo(newValue) > 0)
                newValue = fromNode.getUp().getValue();
            //top-left
            if(fromNode.getUp().getLeft() != null && fromNode.getUp().getLeft().getValue().compareTo(newValue) > 0)
                newValue = fromNode.getUp().getLeft().getValue();
            //top-right
            if(fromNode.getUp().getRight() != null &&  fromNode.getUp().getRight().getValue().compareTo(newValue) > 0)
                newValue = fromNode.getUp().getRight().getValue();  
        }

        //check if there is available row down
        if(fromNode.getDown() != null)
        {
            //bottom
            if(fromNode.getDown().getValue().compareTo(newValue) > 0)
                newValue = fromNode.getDown().getValue();
            //bottom-left
            if(fromNode.getDown().getLeft() != null &&  fromNode.getDown().getLeft().getValue().compareTo(newValue) > 0)
                newValue = fromNode.getDown().getLeft().getValue();
            //bottom-right
            if(fromNode.getDown().getRight() != null && fromNode.getDown().getRight().getValue().compareTo(newValue) > 0)
                newValue = fromNode.getDown().getRight().getValue();
        }

        //check left
        if(fromNode.getLeft() != null && fromNode.getLeft().getValue().compareTo(newValue) > 0)
            newValue = fromNode.getLeft().getValue();
        //check right
        if(fromNode.getRight() != null && fromNode.getRight().getValue().compareTo(newValue) > 0)
            newValue = fromNode.getRight().getValue();

        //update the value of the specified node.
        toNode.setValue(newValue);
    }

    /**
     * For debugging purposes.
     * 
     * @param args from the commandline, however, this is not currently used in this program.
     */
    public static void main(String[] args) 
    {
        Image<Integer> test = new Image<>(5, 1); 

        test.insertRow(1, 2);
        test.insertRow(2, 4);
        test.insertRow(3, 3);

        test.removeBorder();
        test.addBorder();
        test.maxFilter();
        test.printList();
        System.out.println("Width: " + test.getWidth());
        System.out.println("Height: " +  test.getHeight());


        // System.out.println(test.width);

        // test.insertRow(0, 4);
        // test.insertRow(4, 2);
        // System.out.println(test.width);
        // test.addBorder();
        // test.printList();

        // System.out.printf("Height: %d\n", test.getHeight());
        // System.out.printf("Width: %d", test.getWidth());
    }
}
