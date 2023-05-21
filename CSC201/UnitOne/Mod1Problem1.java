package CSC201.UnitOne;
import java.util.Scanner;
/*
    Scope: Assigning Chapters and programming problems to individuals by their Student ID numbers

    Algorithm:
    * Ask user for their Student ID number
        - create an object from the Scanner class
        - ID must be an INTEGER
    * Get the modulus(%) of the student ID by 3, and increment it by 1
        - Calcuation must have a result of either values: 3, 4, and 5.
    * Depending on the expected results:
        3 -> * get the modulus of the Student ID by 34 and increment it by 1 
              (The result represents the number of programming exercise you will solve; which can be found from chapter 3)
        4 -> * (Need to go to chapter 6) get the modulus of the student ID by 38 and increment it by 1
                (The result represents the number of programming exercise you will solve; which can be found from chapter 6)
        5 -> * get the modulus of the student ID by 46, and increment it by 1.
                (The result represents the number of programming exercise you will solve; which can be found from chapter 5)
*/
public class Mod1Problem1
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        //Ask user for their Student ID number   
        System.out.print("Enter Student ID: "); 
        int id = keyboard.nextInt();

        chapterExercise(id);

        keyboard.close();
    }

    //method for distributing assigned activities
    public static void chapterExercise(int studentId)
    {
        //Get the modulus(%) of the student ID by 3, and increment it by 1
        int chapterDistribute = (studentId % 3) +3;
        //Depending on the expected results:
        int chapterActivity;
        if(chapterDistribute == 3)
        {
            chapterActivity = (studentId % 34) +1;
            System.out.println("You need to solve a total of " + chapterActivity + " programming exercise from chapter 3.");
        }
        else if(chapterDistribute == 4)
        {
            chapterActivity = (studentId % 38) +1;
            System.out.println("You need to solve a total of " + chapterActivity + " programming exercise from chapter 6.");
        }
        else if(chapterDistribute == 5)
        {
            chapterActivity =  (studentId % 46) +1;
            System.out.println("You need to solve a total of " + chapterActivity + " programming exercise from chapter 5.");
        }
    }
}
