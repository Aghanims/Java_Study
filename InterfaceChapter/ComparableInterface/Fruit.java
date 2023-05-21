package InterfaceChapter.ComparableInterface;

public class Fruit implements Comparable
{
    private String fruitName;

    public Fruit()
    {
        fruitName = "";
    }
    public Fruit(String name)
    {
        fruitName = name;
    }

    public void setName(String name)
    {
        fruitName = name;
    }
    public String getName()
    {
        return fruitName;
    }

    public int compareTo(Object o)
    {
        if((o != null) && (o instanceof Fruit))
        {
            Fruit otheFruit = (Fruit) o;
            
            return (fruitName.compareTo(otheFruit.fruitName));
        }
        return -1; //Default if other object is not a Fruit 
    }
    
}
