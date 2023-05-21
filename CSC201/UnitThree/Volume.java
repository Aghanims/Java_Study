package CSC201.UnitThree;

//Unit#3.Problem3
//Algorithm
/*
    Instance Variables:
        - volumeName
        - numberOfBooks
        - Book[] 
    methods:
        - constructors
        - toString()
        - getBookArray(); this will return a string of all the properties of the book
*/
public class Volume 
{
    private String volumeName;
    private int numberOfBooks;
    private Book[] books;

    public Volume()
    {
        this("N/A", 0, null);
    }

    public Volume(String volumeName, int numberOfBooks, Book[] books)
    {
        this.volumeName = volumeName;
        this.numberOfBooks = numberOfBooks;
        this.books = books;
    }

    public String toString()
    {
        return "Volume Name: " + volumeName + "\n" +
                "Number of Books: " + numberOfBooks + "\n";
    }

    public String getBookArray()  
    {   
        String result = "";
        for(int index = 0; index < numberOfBooks; index++)
        {
           result = result + books[index].toString() + "\n\n";
        }

        return result;
    }
    
}
