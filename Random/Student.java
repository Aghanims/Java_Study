package Random;
// A derived class
public class Student extends Person
{
    private int studentNumber;
    
    public Student()
    {
        super();
        studentNumber = 0;
    }

    public Student(String initalName, int initialStudentNumber)
    {
        super(initalName);
        studentNumber = initialStudentNumber;
    }

    public void reset(String newName, int newStudentNumber)
    {
        setName(newName);
        studentNumber = newStudentNumber;
    }

    public int getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(int newStudentNumber)
    {
        studentNumber = newStudentNumber;
    }

    public void writeOutput()
    {
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + studentNumber);
    }

    public boolean equals(Object otherObject)//this way the equals method from the "Object" class is overrided
    {
        boolean isEqual = false;

        if((otherObject != null) && (otherObject instanceof Student))
        {
            Student otherStudent = (Student)otherObject;
            isEqual = this.hasSameName(otherStudent) && (this.studentNumber == otherStudent.getStudentNumber());
        }
        return isEqual;
    }
}
