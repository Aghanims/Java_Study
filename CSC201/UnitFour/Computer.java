package CSC201.UnitFour;

public class Computer extends Electronics
{
    private double storage;
    private String OS;
    private double RAM;

    public Computer()
    {
        this("N/A", 0, "N/A", 0, 0, "N/A", 0);
    }
    public Computer(String model, double weight, String manufacturer, double cost, double storage, String OS, double RAM)
    {
        super(model, weight, manufacturer, cost);
        this.storage = storage;
        this.OS = OS;
        this.RAM = RAM;
    }

    public double getStorage()
    {
        return storage;
    }
    public String getOS()
    {
        return OS;
    }
    public double getRAM()
    {
        return RAM;
    }

    public void setStorage(double storage)
    {
        this.storage = storage;
    }
    public void setOS(String OS)
    {
        this.OS = OS;
    }
    public void setRAM(double RAM)
    {
        this.RAM = RAM;
    }

    public void ComputerDetails()
    {
        description();
        System.out.println("Storage: " + getStorage() + " GB");
        System.out.println("Operating System: " + getOS());
        System.out.println("Random Acess Memory: " + getRAM());
    }

}
