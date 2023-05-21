package ClassNotes;
public class OneWayNoRepeatList 
{
    public static int START_POSITION = 1;
    public static int DEFAULT_SIZE = 50;
    private int countOfEntries; // number of items currently on the list
    private String[] entry; // entry.length is the capacity of the list

    //creates an empty lists with a given capacity
    public OneWayNoRepeatList(int totalEntries)
    {
        entry = new String[totalEntries];
        countOfEntries = 0;
    }
    
    //creates an empty list with a capacity of DEFAULT_SIZE
    public OneWayNoRepeatList()
    {
        entry = new String[DEFAULT_SIZE];
        countOfEntries = 0;
    }

    public boolean isFull()
    {
        return countOfEntries == entry.length;
    }

    public boolean isEmpty()
    {
        return countOfEntries == 0;
    }

    public boolean isOnList(String item) // returns true if item is on the list
    {   
        boolean found = false;
        int i = 0;
        
        while(!found && (i < countOfEntries))
        {
            if(item.equalsIgnoreCase(entry[i]))
                found = true;
            else
                i++;
        }
        return found;
    }

    /*
        Pre-Condition: list is not full
        Postcondition: if tiem was not on the list, it has been added to the list. 
     */
    public void addItem(String item)
    {
        if(!isOnList(item))
        {
            if(countOfEntries == entry.length)
            {
                System.out.println("Adding to a full list!!!");
            }
            else
            {
                entry[countOfEntries] = item;
                countOfEntries++;
            }
            // else do nothing; item is already in the list.
        }
    }

    // argument indicates a position on the list, the entry at that specified position is returned; otherwise, null is returned.
    public String getEntryAt(int position)
    {
        String result = null;

        if((1 <= position) && (position <= countOfEntries))
        {
            result = entry[position -1];
        }
        return result;
    }

    //return true if position indicates the last item on the list; otherwise, returns fals.
    public boolean lastEntry(int position)
    {
        return position == countOfEntries;
    }

    //accessors
    public int getMaximumNumberOfEntries()
    {
        return entry.length;
    }
    public int getNumberOfEntries()
    {
        return countOfEntries;
    }
    
    public void eraseList()
    {
        countOfEntries = 0;
    }
}
