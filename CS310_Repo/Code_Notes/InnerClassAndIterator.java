public class InnerClassAndIterator
{
    private Object[] items;
    private int size = 0;

    public Iterator iterator()
    {
        return new LocalIterator(this);
    }

    private static class LocalIterator implements Iterator
    {
        private int length = 0;
        private InnerClassAndIterator container;

        public LocalIterator(InnerClassAndIterator container)
        {
            this.container = container;
        }

        public boolean hasNext()
        {
            return length < container.size;
        }

        public Object next()
        {
            return container.items[length++];
        }
    }

    private static interface Iterator
    {
        boolean hasNext();
        Object next();
    }

//********************************************************************************** */
    public static void main(String[] args)
    {

    }
}