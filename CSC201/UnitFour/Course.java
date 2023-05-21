package CSC201.UnitFour;
//part of problem#3
public class Course extends Curriculum
{
    private String subject;

    public Course()
    {
        this("N/A", "N/A", "N/A");
    }
    public Course(String institution, String semester, String subject)
    {
        super(institution, semester);
        this.subject = subject;
    }

    public String getSubject()
    {
        return subject;
    } 
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void CourseInfo()
    {
        System.out.println("Course: " + getSubject());
        System.out.println("Institution: " + getInstitution());
        System.out.println("Semester: " + getSemester());
    }
}
