package InheritanceStudy.QuestionClasses;
public class Question 
{
    private String question;

    public Question()
    {
        this(null);
    }

    public Question(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String newQuestion)
    {
        question = newQuestion;
    }

}
