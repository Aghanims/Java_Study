package InheritanceStudy.QuestionClasses;
import java.util.Scanner;

public class Quiz 
{
    Question[] quiz;

    public Quiz()
    {
        this(0);
    }

    public Quiz(int numOfQuestions)
    {
        this.quiz = new Question[numOfQuestions];
    }

    public void add()
    {
        Scanner input = new Scanner(System.in);

        for(int index = 0; index < quiz.length; index++)
        {
            if(quiz[index] == null)
            {
                System.out.println("Enter Question: ");
                String inputQuestion = input.nextLine();
                quiz[index] = new Question(inputQuestion);
                index = 50; // Loop cancel
            }
        }
    }

    public void giveQuiz()
    {
        for(int index = 0; index < quiz.length; index++)
        {
            if(quiz[index] != null)
            {
                System.out.println((index + 1) + ". " + quiz[index].getQuestion());
            }    
        }
    } 
}
