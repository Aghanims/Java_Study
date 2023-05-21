package ClassNotes;
public class RetailItem 
{
    // A class that holds an item in a retail store
    private String description;
    private int unitsOnHand;
    private double price;
    private int itemNum;

    public RetailItem(int itemNum, String description, int unitsOnHand, double price)
    {
        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
        this.itemNum = itemNum;
    }

    //mutators
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }
    public void setUnitsOnHand(int unitsOnHand)
    {
        this.unitsOnHand = unitsOnHand;
    }
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
    public void setItemNum(int itemNum)
    {
        this.itemNum = itemNum;
    }

    //accessors
    public String getDescription()
    {
        return description;
    }
    public int getUnitsOnHand()
    {
        return unitsOnHand;
    }
    public double getPrice()
    {
        return price;
    }
    public int getItemNum()
    {
        return itemNum;
    }

    public void itemInformation()
    {
        System.out.println("item #" + itemNum + ": " + description);
        System.out.println("Number of units availabe: " + unitsOnHand);
        System.out.println("Item price: $" + price);
    }
}
