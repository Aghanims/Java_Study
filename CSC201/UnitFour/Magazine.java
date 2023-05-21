package CSC201.UnitFour;

public class Magazine extends Books
{
    private String subject;
    private String publishDate;
    private String scoop;
    private String publisher;

    public Magazine()
    {
        this(0, "Unknown", "Unknown", "Unknown", "N/A", "N/A", "Unknown");
    }
    public Magazine(int pageNum, String name, String author, String subject, String publishDate, String scoop, String publisher)
    {
        super(pageNum, name, author);
        this.subject = subject;
        this.publishDate = publishDate;
        this.scoop = scoop;
        this.publisher = publisher;
    }

    public String getSubject()
    {
        return subject;
    }
    public String getPublishDate()
    {
        return publishDate;
    }
    public String getScoop()
    {
        return scoop;
    }
    public String getPublisher()
    {
        return publisher;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    public void setPublishDate(String publishDate)
    {
        this.publishDate = publishDate;
    }
    public void setScoop(String scoop)
    {
        this.scoop = scoop;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public void MagazineDescription()
    {   
        description();
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Subject: " + getSubject());
        System.out.println("Date published: " + getPublishDate());
        System.out.println("Scoop: " + getScoop());
    }



}
