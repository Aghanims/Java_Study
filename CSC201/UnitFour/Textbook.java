package CSC201.UnitFour;
//Part of problam #2

public class Textbook extends Books
{
    private String course;
    private int edition;
    private String publisher;

    public Textbook()
    {
        this("Unknown", 0, "Unknown", 0, "Unknown", "Unknown");
    }
    public Textbook(String course, int edition, String publisher, int pageNum, String name, String author)
    {
        super(pageNum, name, author);
        this.course = course;
        this.publisher = publisher;
        this.edition = edition;
    }

    public String getCourse()
    {
        return course;
    }
    public int getEdition()
    {
        return edition;
    }
    public String getPublisher()
    {
        return publisher;
    }

    public void TextbookDescription()
    {
        description();
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Course: " + getCourse());
        System.out.println("Edition: " + getEdition());
    }
}
