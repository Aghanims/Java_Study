package CSC201.Project;

public class Electronic extends Product
{
    private String model;
    private String manufacturer;
    private float weight;

    public Electronic()
    {
        this("N/A", 0, "N/A");
    }
    public Electronic(String model, float weight, String manufacturer)
    {
        this.model = model;
        this.weight = weight; 
        this.manufacturer = manufacturer;
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

    public void setModel(String model)
    {
        this.model = model;
    }
    public void setWeight(float weight)
    {
        this.weight = weight;
    }
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String toString()
    {
        return super.toString() + "\n" +
            "Model: " + getModel() + "\n" +
            "Manufacturer: " + getManufacturer() + "\n" +
            "Weight: " + getWeight();
    }
}
