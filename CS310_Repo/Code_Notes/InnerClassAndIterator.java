public class InnerClassAndIterator
{
    private Object[] items;
    private int size = 0;

    public Iterator iterator()
    {
        return new LocalIterator();
    }

    private class LocalIterator implements Iterator
    {
        private int length = 0;

        public boolean hasNext()
        {
            return length < size;
        }

        public Object next()
        {
            return items[length++];
        }
    }

    private static interface Iterator
    {
        boolean hasNext();
        Object next();
    }
}