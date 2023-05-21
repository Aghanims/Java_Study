package Chapter2Exercises;

public class ATweetInfo 
{
    /*
        userName (max of 15 characters)
        TweetContent (max of 140 chars)
        number of favorites (int)

        dispaly every content in a table
    */
    private String userName;
    private String tweetContent;
    private int favorites;
    
    public ATweetInfo(String userName, String tweetContent, int favorites)
    {
        addUserName(userName);
        addTweetContent(tweetContent);
        addFavorites(favorites);
    }

    public ATweetInfo()
    {
        addUserName("N/A");
        addTweetContent("N/A");
        addFavorites(0);
    }

    public String getUserName()
    {
        return userName;
    }

    public String getTweetContent()
    {
        return tweetContent;
    }

    public int getFavorites()
    {
        return favorites;
    }

    public void addUserName(String userName)
    {
        this.userName = userName;
    }

    public void addTweetContent(String tweetContent)
    {
        this.tweetContent = tweetContent;
    }

    public void addFavorites(int favorites)
    {
        this.favorites = favorites;
    }
}
