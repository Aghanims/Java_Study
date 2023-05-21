package CSC201.UnitFour;
//base class of problem#3
public class Curriculum 
{
    private String institution;
    private String semester;
    
    public Curriculum()
    {
        this("N/A", "N/A");
    }
    public Curriculum(String institution, String semester)
    {
        this.institution = institution;
        this.semester = semester;
    }

    public String getInstitution()
    {
        return institution;
    }
    public String getSemester()
    {
        return semester;
    }

    public void setInstitution(String instituiton)
    {
        this.institution = semester;
    }
    public void setSemester(String semester)
    {
        this.semester = semester;
    }

    public void CourseInfo()
    {
        System.out.println("Institution: " + getInstitution());
        System.out.println("Semester: " + getSemester());
    }
}
