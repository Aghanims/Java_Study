package CSC201.UnitFour;

public class Electronics 
{
    private String model;
    private double weight;
    private String manufacturer;
    private double cost;
    
    public Electronics()
    {
        this("N/A", 0, "N/A", 0);
    }
    public Electronics(String model, double weight, String manufacturer, double cost)
    {
        this.model = model;
        this.weight = weight; 
        this.manufacturer = manufacturer;
        this.cost = cost;
    }

    public String getModel()
    {
        return model;
    }
    public double getWeight()
    {
        return weight;
    }
    public String getManufacturer()
    {
        return manufacturer;
    }
    public double getCost()
    {
        return cost;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public void description()
    {
        System.out.println("Model: " + getModel());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Price: " + getCost());
        System.out.println("Weight: " + getWeight() + " lbs");
    }
}
