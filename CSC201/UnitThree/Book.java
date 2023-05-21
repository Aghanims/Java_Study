package CSC201.UnitThree;
//Unit#3.Problem#3
//Algorithm
/*
    Instance variables:
        - Title
        - Author
        - numberOfPages
    - a toString() method
    - constructor
*/
public class Book 
{
    private String author;
    private String title;
    private int numberOfPages;

    public Book()
    {
        this("N/A", "N/A", 0);
    }
    public Book(String author, String title, int numberOfPages)
    {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle()
    {
        return title;
    }

    public String toString()
    {
        return "Author: " + author + "\n" +
                "Title: " + title + "\n" +
                "Number of Pages: " + numberOfPages;
    }
}
