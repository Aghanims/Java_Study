package CSC201.UnitFour;

//base class ; Part of Problem#1
public class Sport 
{
    private String name;

    public Sport()
    {
        this("Unknown");
    }

    public Sport(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {   
        this.name = name;
    }

    public void statistics()
    {
        System.out.println("Sport Name: " + getName());
    }
}
