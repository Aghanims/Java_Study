package CSC201.UnitFour;
//part of problem #2
public class Novel extends Books
{
    private String genre;
    private String protagonist;

    public Novel()
    {   
        this("Unknown", "Unknown", "Unknown", "Unknown", 0);
    }
    public Novel(String genre, String protagonist, String author, String name, int pageNum)
    {
        super(pageNum, name, author);
        this.genre = genre;
        this.protagonist = protagonist;
    }

    public String getGenre()
    {
        return genre;
    }
    public String getProtagonist()
    {
        return protagonist;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    public void setProtagonist(String protagonist)
    {
        this.protagonist = protagonist;
    }

    public void Magazinedescription()
    {
        description();
        System.out.println("Page Number: " + getPageNum());
        System.out.println("Genre: " + getGenre());
        System.out.println("Protagonist: " + getProtagonist());
    }
    
}
