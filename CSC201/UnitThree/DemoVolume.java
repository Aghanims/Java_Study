package CSC201.UnitThree;
import java.util.Scanner;

public class DemoVolume
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("number of books to enter: ");
        int booksNum = input.nextInt();

        Book[] bookRecord = new Book[booksNum];
        for(int index = 0; index < bookRecord.length; index++)
        {
            System.out.print("Author Name: ");
            String author = input.nextLine();
            author = input.nextLine();
            System.out.print("Book Title: ");
            String title = input.nextLine();
            System.out.print("Number of Pages: ");
            int numberOfPages = input.nextInt();
            bookRecord[index] = new Book(author, title, numberOfPages);
            System.out.println();
        }
        System.out.println();

        Volume volume1 = new Volume("Music Theory", booksNum, bookRecord);
        
        System.out.println(volume1.toString());
        System.out.println(volume1.getBookArray());

        input.close();

        
    }
}
