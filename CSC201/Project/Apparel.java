package CSC201.Project;

public class Apparel extends Product
{
    private String brand;
    private String size;
    private String type;

    public Apparel()
    {
        this("N/A", 0, "N/A", "N/A", "N/A");
    }

    public Apparel(String name, int price, String brand, String size, String type)
    {
        super(name, price);
        this.brand = brand;
        this.size = size;
        this.type = type;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getSize()
    {
        return size;
    }

    public String getType()
    {
        return type;
    }

    public void setBrand(String newBrand)
    {
        brand = newBrand;
    }

    public void setSize(String newSize)
    {
        size = newSize;
    }

    public void setType(String newType)
    {
        type = newType;
    }

    public String toString()
    {
        return super.toString() + "\n" +
            "Brand: " + getBrand() + "\n" +
            "Size: " + getSize() + "\n" +
            "Apparel Type: " + getType();
    }

}
