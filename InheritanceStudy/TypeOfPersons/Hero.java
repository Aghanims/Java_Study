package InheritanceStudy.TypeOfPersons;

public class Hero extends Human
{
    private String power;  
    
    public Hero()
    {
        this("No record", 0, 'N', "Invisibility");
    }

    public Hero(String name, int age, char sex, String power)
    {
        super(name, age, sex);
        this.power = power;
    }

    //Mutator
    public void setPower(String newPower)
    {
        power = newPower;
    }

    //Accessor
    public String getPower()
    {
        return power;
    }

    public void heroInfo()
    {
        System.out.println("Hero Name: " + getName());
        System.out.println("Hero Age: " + getAge());
        System.out.println("Hero Sex: " + getSex());
        System.out.println("Hero power: " + getPower());
    }

    public boolean samePower(Hero otherHero)
    {
        if(getPower().equals(otherHero.getPower()))
            return true;
        else
            return false;
    }

    public boolean equals(Hero anotherHero)
    {
        if((super.equals(anotherHero)) && (getPower().equalsIgnoreCase(anotherHero.getPower())))
            return true;
        else
            return false;
    }

}
