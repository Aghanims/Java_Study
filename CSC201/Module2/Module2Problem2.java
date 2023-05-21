package CSC201.Module2;
import java.util.Scanner;
//Program: Diving
/*
    Algorithm: 
    - create an array that holds the scores in each 7 judges (assign as a float)
        - identify the lowest and highest score and throw them out(in this case equal them to 0)
        - Add the remaing score
        - after that, multiply(assign the values from 1.2 - 3.8 points) by the degree of dificulty 
        - the total is then multiplied by 0.6
    - create a default constructor, and a constructor that accepts  difficulty as its argument
    - make a float variable name "diverScore"

 The following method is needed:
    - A method name inputValidScore that inputs one valid score for one judge for one diver. 
        This method will return the valid score.
    - A method named inputAllScores that creates an array to store the scores for all judges 
        for the diver. This method will fill the array with a valid score from each judge. This 
        method does not take input arguments, but it does return the array of scores.
    - A method named inputValidDegreeOfDifficulty that inputs a valid degree of difficulty for 
        the dive. The valid degree of difficulty will be returned from the method.
    - A method named calculateScore that will calculate the score for the diver based on the 
        scores from all judges and the degree of difficulty. The score will be returned from the method.
    - A main method that uses the previous methods to determine the score for the diver and  then prints out the score to the console.
*/
public class Module2Problem2
{
    public static boolean inputValidScore(float score)
    {
        if((score >= 0) && (score <= 10))
            return true;
        else
        {
            System.out.println("Invalid input; try again(1 to 10): ");
            return false;
        }
    }   

    public static float[] inputAllScores()
    {
        Scanner keyboard = new Scanner(System.in);
        float[] scores = new float[7];

        System.out.print("Judge #1 score: ");

        do{
            scores[0] = keyboard.nextFloat();
        }while(inputValidScore(scores[0]) == false);

        for (int index = 1; index < 7; index++)
        {
            System.out.print("Judge #"+ (index+1) +" score: ");
            do{
                scores[index] = keyboard.nextFloat();
            }while(inputValidScore(scores[index]) == false);
        }
        keyboard.close();
        return scores;
        }

    public static boolean inputValidDegreeOfDifficulty(float difficulty)
    {
        if((difficulty>=1.2) && (difficulty<=3.8))
            return true;
        else
        {
            System.out.println("Invalid input; try Again: ");
            return false;
        }
    }

    public static float calculateScore(float judgeScores[], float difficulty)
    {
        //loop that determines the highest and lowest value
        float highestScore = judgeScores[0];
        float lowerScore = judgeScores[0];
        int lowProx = 0;
        int highProx = 0;
        for(int index = 0; index < judgeScores.length; index++)
        {
            if(judgeScores[index] >= highestScore)
            {
                highProx = index;
                highestScore = judgeScores[index];
            }
            if(judgeScores[index] <= lowerScore)
            {
                lowerScore = judgeScores[index];
                lowProx = index;
            }
        }
        judgeScores[highProx] = 0; //highest value converted into 0
        judgeScores[lowProx] = 0;

        float sum = 0;
        for(int index = 0; index < judgeScores.length ; index++)
        {
            sum = sum + judgeScores[index];
        }
        float multiply = sum * difficulty;

        return  multiply * (float)0.6;   
    }  

        public static void main(String[] args)
        {
            Scanner keyboard = new Scanner(System.in);  
            float difficulty;
            float[] judgeScores = new float[7];
            float finalScore;

            System.out.print("Enter Degree of difficulty(1.2 to 3.8): ");
            do{
                difficulty = keyboard.nextFloat();
            }while(inputValidDegreeOfDifficulty(difficulty)==false);

            judgeScores = inputAllScores();

            finalScore = calculateScore(judgeScores , difficulty);

            System.out.println("Diver Final Score: " + finalScore);
            keyboard.close();
        }
}
