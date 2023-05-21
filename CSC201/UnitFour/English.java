package CSC201.UnitFour;
//part of problem#3
public class English extends Course
{
    private int level;
    private String description;
    private String prerequisite;

    public English()
    {
        this("N/A", "N/A", "N/A", 000, "N/A", "N/A");
    }
    public English(String institution, String semester, String subject, int level, String description, String prerequisite)
    {
        super(institution, semester, subject);
        this.level = level;
        this.description = description;
        this.prerequisite = prerequisite;
    }

    public int getLevel()
    {
        return level;
    }
    public String getDescription()
    {
        return description;
    }
    public String getPrerequisite()
    {
        return prerequisite;
    }

    public void setLevel(int level) 
    {
        this.level = level;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setPrerequisite(String prerequisite)
    {
        this.prerequisite = prerequisite;
    }

    public void CourseInfo()
    {
        System.out.println("Course: " + getSubject() + " " + getLevel());
        System.out.println("Prerequisite: " + getPrerequisite());
        System.out.println("Institution: " + getInstitution());
        System.out.println("Semester: " + getSemester());
        System.out.println("Description: " + getDescription());
    }
    
}
