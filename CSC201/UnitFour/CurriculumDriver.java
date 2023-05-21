package CSC201.UnitFour;

public class CurriculumDriver 
{
    public static void main(String[] args) 
    {
        Curriculum course1 = new CompSci("NOVA", "Spring", "CSC", 201, "Object-oriented programming and problem-solving methods using high-level programming language", "CSC 200 or CSC 130 or a grade of C in MTH 173 or MTH 263.");
        Curriculum course2 = new English("NOVA", "Spring", "ENG", 112, "Critical thingking & writing, research; theme: media and information literacy", "ENG111");
        Curriculum course3 = new Calculus("NOVA", "Spring", "MTH", 263, "Present concepts of limits, derivatives, differentiaton of various types of function.", ": Completion of MTH 167 or MTH 161/162 or equivalent with a grade of C or better.");
        course1.CourseInfo();
        System.out.println();
        course2.CourseInfo();
        System.out.println();
        course3.CourseInfo();
    }
    

}
