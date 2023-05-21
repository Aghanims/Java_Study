package CSC201.UnitFour;
//base class for problem #2
public class Books 
{
    private int pageNum;
    private  String name;
    private String author;

    public Books()
    {
        this(0, "Unknown", "Unknown");
    }
    

    public Books(int pageNum, String name, String author)
    {
        this.pageNum = pageNum;
        this.name = name;
        this.author = author;
    }

    public int getPageNum()
    {
        return pageNum;
    }
    public String getName()
    {
        return name;
    }
    public String getAuthor()
    {
        return author;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void description()
    {
        System.out.println("Name: " + getName());
        System.out.println("Author: " + author);
        System.out.println("Page Number: " + getPageNum());
    }
}
