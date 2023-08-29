import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayList <T> extends AbstractCollection<T> implements List<T>
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final int NOT_FOUND = -1;

    private T[] items;
    private int size; 
    private int modCount = 0; //variable to be used for tracking if the structural modification of ArrayList and Itrator matched

    public ArrayList()
    {
        clear();
    }

    public ArrayList(Collection<? extends T> other)
    {
        clear();
        for(T object : other)
            add(object);
    }

    @SuppressWarnings("unchecked")
    public void clear()
    {
        size = 0;
        items = (T[]) new Object[DEFAULT_CAPACITY];
        modCount++;
    }

    @Override
    public int size() 
    {
        return size;
    }
    
    public boolean contains(Object x)
    {
        return findPos(x) != NOT_FOUND;
    }

    private int findPos(Object x)
    {
        for(int i = 0; i < size(); i++)
        {
            if(x == null)
            {
                if(items[i] == null)
                    return i;
            }
            else 
            {
                if(items[i].equals(x))
                    return i;
            }
        }

        return NOT_FOUND;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(T e) 
    {
        //add values to the end
        // if the size of the elements is equal to the size fo the array, then double the size of the array

        //resizing
        if(items.length == size())
        {
            T[] newArray = (T[]) new Object[items.length * 2];

            //copy the elements from the old array to the new array
            for(int i = 0; i < items.length; i++)
                newArray[i] = items[i];

            //make the new Array the default item array
            items = newArray;
        }

        items[size() + 1] = e;
        size++;

        return true;
    }

    @Override
    public T get(int index) 
    {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        return items[index];
    }

    @Override
    public T set(int index, T element) 
    {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        T oldValue = items[index];
        items[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, T element) 
    {
        
    }

    @Override
    public T remove(int index) 
    {
        T extractedValue = items[index];

        for(int i = index; i < size() - 1; i++)
            items[i] = items[i + 1];
        
        size--;
        modCount++;
        return extractedValue;
    }

    public boolean remove(Object x)
    {
        int pos = findPos(x);

        if(pos == NOT_FOUND)
            return false;
        else 
            remove(pos);

        return true;
    }

    public Iterator<T> iterator()
    {
        return new ArrayListIterator(0);
    }

    public ListIterator<T> listIterator(int index)
    {
        return new ArrayListIterator(index);
    }

    private class ArrayListIterator implements ListIterator<T>
    {
        private int current;
        private int expectedModCount = modCount;
        private boolean nextCompeleted = false;
        private boolean prevCompleted = false;

        public ArrayListIterator(int pos)
        {
            if(pos < 0 || pos > size())
                throw new IndexOutOfBoundsException();

            current = pos;
        }

        @Override
        public boolean hasNext() 
        {
            if(expectedModCount != modCount)
                throw new ConcurrentModificationException();

            return current < size();
        }

        @Override
        public T next() 
        {
            if(!hasNext())
                throw new NoSuchElementException();

            nextCompeleted = true;
            prevCompleted = false;

            return items[current++];   
        }

        @Override
        public boolean hasPrevious() 
        {
            if(expectedModCount != modCount)
                throw new ConcurrentModificationException();

            return current > 0;
        }

        @Override
        public T previous() 
        {
            if(!hasPrevious())
                throw new NoSuchElementException();

            nextCompeleted = false;
            prevCompleted = true;

            return items[--current];
        }

        @Override
        public void remove() 
        {
            if(expectedModCount != modCount)
                throw new ConcurrentModificationException();

            if(nextCompeleted)
                ArrayList.this.remove(--current);
            else if(prevCompleted)
                ArrayList.this.remove(current);
            else 
                throw new IllegalStateException();

            nextCompeleted = false;
            prevCompleted = false;

            expectedModCount++;

        }
    }
}
