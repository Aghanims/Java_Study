package Chapter2Exercises;

import java.util.*;

public class ATweetTable 
{
    //Collection Tweet table that has user information on a specific tweet
    private ArrayList<ATweetInfo> tweetCollection = new ArrayList<>();

    public void addData()
    {
        Scanner input = new Scanner(System.in);

       //ask user to input correct requirments 
        
            /*
                userName (max of 15 characters)
                TweetContent (max of 140 chars)
                number of favorites (int)

                dispaly every content in a table
            */

            ATweetInfo newObject = new ATweetInfo();
            String userName = "";
            String tweetContent = "";
            int favorites = 0;

            boolean correctInput = false;
            
            while(!correctInput)
            {
                System.out.print("Enter username: ");
                userName = input.nextLine();

                if(userName.length() <= 15)
                {
                    newObject.addUserName(userName);
                    correctInput = true;
                }
                else
                {
                    System.out.println("Max of 15 characters are allowed. Please try again: ");
                }
            }

            correctInput = false;

            while(!correctInput)
            {
                System.out.print("Enter tweet content: ");
                tweetContent = input.nextLine();

                if(tweetContent.length() <= 140)
                {
                    newObject.addTweetContent(tweetContent);
                    correctInput = true;
                }
                else
                {
                    System.out.println("Max of 140 characters are allowed. Please try again");
                }
            }

        System.out.print("Enter number of favorites: ");
        favorites = input.nextInt();

        newObject.addFavorites(favorites);


        tweetCollection.add(newObject); //put all data in the collection

        input.close();
    }

    public void displayTable()
    {
        for(int row = 0; row < tweetCollection.size(); row++)
        {
                String userName = tweetCollection.get(row).getUserName();
                String tweetContent = tweetCollection.get(row).getTweetContent();
                int favorites = tweetCollection.get(row).getFavorites();

                System.out.println("User Name: " + userName);
                System.out.println("Tweeet Content: " + tweetContent);
                System.out.println("Number of favorites: " + favorites);
        }
    }
    


    public static void main(String[] args) 
    {
        ATweetTable test = new ATweetTable();
        
        test.addData();
        test.addData();
        System.out.println();
        System.out.println();
        test.displayTable();
    }
}
