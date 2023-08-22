package CS310_Repo.Week_One;

/**
 * Program that represents a bag of an item
 * tracks how many items are contained in the bag.
 * 
 * @author  Richmond Gonzales
 */
public class OneItemBag<T> 
{
    //Counter for how many items are in the bag.
    private int itemCounter;
    //Will be used for identifying the most recent item added .
    private T obj;
   
    /**
     * Constructor that initializes the contents of the bag to zero.
     */
    public OneItemBag()
    {
        this.itemCounter = 0;
    }

    /**
     * Method for adding an item to the bag that increments the counter 
     * for how many items are contained in the bag. All items must be
     * of the same type in order to be added.
     * 
     * @param item the item to be added 
     * @return  true if the item added is consistent; false otherwise 
     */
    public boolean addItem(T item)
    {
        // if(item instanceof T)
        // {
        //     itemCounter++;
        //     obj = item;
        //     return true;
        // }
        // else 
        //     return false;

        if(item instanceof T && itemCounter <= 0) 
        {
            itemCounter++;
            obj = item;
            return true;
        }
        else 
            return false;
    }

    /**
     * Remove and item from the bag by decrementing the item counter .
     * 
     * @return  an item from the bag; null if the bag is currently empty
     */
    public T removeItem()
    {
        if(itemCounter <= 0)
            return null;
        else 
        {
            itemCounter--;
            return obj;
        }
    }

    /**
     * Method to check wheter the bag contains at least one item.
     * 
     * @return true if the bag contains at least one item; false otherwise.
     */
    public boolean hasItem()
    {
        if(itemCounter <= 0)
            return  false;
        else 
            return true;
    }
}
