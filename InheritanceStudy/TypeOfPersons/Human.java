package InheritanceStudy.TypeOfPersons;

public class Human 
{
    private String name;
    private int age;
    private char sex;
    
    //Constructor
    public Human()
    {
        this("No Record", 0, 'N'); //calling the constructor of this class
    }

    public Human(String name, int age, char sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    //Mutators
    public void setName(String newName)
    {
        name = newName;
    }
    public void setAge(int newAge)
    {
        age = newAge;
    }
    public void setSex(char newSex)
    {
        sex = newSex;
    }

    //Accessors
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public char getSex()
    {
        return sex;
    }

    public void viewInfo()
    {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Sex: " + getSex());
    }

    public boolean equals(Human anotherHuman)
    {
        if((getName().equalsIgnoreCase(anotherHuman.getName())) && (getAge() == anotherHuman.getAge()) && (getSex() == anotherHuman.getSex()))
            return true;
        else    
             return false;
    }


}
