package CSC201.Project;

public class Product 
{
    private String name;
    private float price;

    public Product()
    {
        this("N/A", 0);
    }

    public Product(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    } 

    public float getPrice()
    {
        return price;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setPrice(float newPrice)
    {
        price = newPrice;
    }

    public String toString()
    {
        return "Name: " + getName() + "\n" +
                "Price: " + getPrice();
    }
}

