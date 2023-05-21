package InheritanceStudy.QuestionClasses;
public class QuizTime 
{
    public static void main(String[] args) 
    {
        int Questions = 25;

        Quiz midterm = new Quiz(Questions);

        midterm.add();
        midterm.add();
        midterm.add();
        midterm.add();
        midterm.add();
        midterm.add();

        midterm.giveQuiz();
    }    
}
