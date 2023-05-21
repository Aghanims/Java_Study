package CSC201.UnitThree;
import java.util.Scanner;
//Unit#3.Problem#4
//Algorithm
/*
    •Create a class called Builder. 
    •Using the StringBuilder class, write a program which will accept a string from the keyboard, “Java is fun!” 
    •Your program must determine and display the capacity of the string. 
    •Append a second string, “I love it!” to the first string. 
    •Require the user to enter a string “Yes, “ 
    •Insert the string, “Yes ” at the correct location, such that the output of the entire string will be “Java is fun. Yes, I love it!” 
    •Display your output using clear and appropriate messages. 
 */
public class Builder 
{   
   private String word;

   public Builder()
   {
        this("Unknown");
   }
   public Builder(String word)
   {
        this.word = word;
   }

   public int getCapacity()
   {
       StringBuilder capacity = new StringBuilder(word);
       return capacity.capacity();
   }

   public String getWord()
   {
       return word;
   }
   public String combineWord(Builder string )
   {
       StringBuilder combine = new StringBuilder();
       combine.append(word);
       combine.append(string.getWord());
       return combine.toString();
   }

   public String putMiddleWord(Builder word2, String middleWord)
   {    
        StringBuilder combine = new StringBuilder(combineWord(word2));
        combine.insert(12, middleWord);

        return combine.toString();
   }

   public static void main(String[] args) 
   {
       Scanner input = new Scanner(System.in);

       Builder word1 =  new Builder("Java is fun.");
       Builder word2 = new Builder("I love it.");

       System.out.println(word1.combineWord(word2));
       System.out.println("Word #1 capacity: " +  word1.getCapacity());
       System.out.println("Word #2 capacity: " + word2.getCapacity());

       System.out.println("Enter a word to be put in the middle: ");
       String middleWord = input.nextLine();

       
       System.out.println(word1.putMiddleWord(word2, middleWord));

       input.close();

       
   }
}
