package InheritanceStudy.TypeOfPersons;

public class TitledHuman extends Human
{
    private String title;

    //Constructors
    public TitledHuman()
    {
        this("No Record", 0, 'N', "N/A");
    }
    public TitledHuman(String name, int age, char sex, String title)
    {
        super(name, age, sex);
        this.title = title;
    }

    public void writeOutput()
    {
        if(getTitle().equalsIgnoreCase("N/A"))
        {
            System.out.println("Name: " + getName());
            System.out.println("Age: " + getAge());
            System.out.println("Sex: " + getSex());
        }
        else
        {
            System.out.println("Name: " + getTitle() + getName());
            System.out.println("Age: " + getAge());
            System.out.println("Sex: " + getSex());
        }
    }

    //Accessors
    public String getTitle()
    {
        return title;
    }

    //Mutators
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public void reset(String newName, int newAge, char newSex, String newTitle)
    {
        setName(newName);
        setAge(newAge);
        setSex(newSex);
        setTitle(newTitle);
    }

    public boolean hasSameTitle(TitledHuman otherHumman)
    {
        if(getTitle().equalsIgnoreCase(otherHumman.getTitle()))
            return true;
        else if(otherHumman.getTitle().equalsIgnoreCase("N/A"))
            return false;
        else
            return false;
    }

    public boolean equals(TitledHuman otherHuman)
    {
        if((super.equals(otherHuman)) && (getTitle().equalsIgnoreCase(otherHuman.getTitle())))
            return true;
        else
            return false;
    }
        
}
