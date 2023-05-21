package Random;

public class Undergraduate extends Student
{
    private int level; //1 for freshman, 2 for sophomore, 3 for junior, and 4 for senior.
    
    //Constructors
    public Undergraduate()
    {
        super();
        level = 1;
    }
    public Undergraduate(String name, int studentNumber, int level)
    {
        super(name, studentNumber);
        setLevel(level);
    }

    public void reset(String name, int studentNumber, int level)
    {
        reset(name, studentNumber); //Student's reset method
        setLevel(level);
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int newLevel)
    {
        if((1 <= newLevel) && (newLevel <= 4))
        {
            level = newLevel;
        }
        else
        {
            System.out.println("Illegal level");
            System.exit(0);
        }
    }

    public void writeOutput()
    {
        super.writeOutput();
        System.out.println("Student level: " + level);
    }

    public boolean equals(Undergraduate otherUndergraduate)
    {
        return super.equals(otherUndergraduate) && (this.level == otherUndergraduate.level);
    }
}
