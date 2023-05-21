package CSC201.UnitThree;
import java.util.Scanner;

//Algorithm
/*
•	A method named putBookInLocker that puts one additional book into the locker. This method does not take any input arguments and does not return a value.
•	A method named removeBookFromLocker that tries to remove one book from the locker. This method does not take an input argument, but does return a value. 
        The book returns true if the book is removed successfully and returns false if the book is not removed successfully.
•	A method named openLocker that will try to open the locker. This method will prompt the user to input the three numbers in the combination to try. 
        This method will print out the success or failure of opening the locker.
*/
public class Locker 
{
    private String owner;
    private int lockerNumber;
    private int book = 0;
    private CombinationLock password = null;

    public Locker()
    {
        this(null,0,0,"N/A");
    }
    public Locker(CombinationLock password, int book, int lockerNumber, String owner)
    {
        this.password = password;
        this.book = book;
        this.lockerNumber = lockerNumber;
        this.owner = owner;
    }

    public String getOwner()
    {
        return owner;
    }
    public int getLockerNumber()
    {
        return lockerNumber;
    }
    public int getBook()
    {
        return book;
    }
    public CombinationLock getPassword()
    {
        return password;
    }

    public void setOwner(String name)
    {
        owner = name;
    }
    public void setLockerNumber(int num)
    {
        lockerNumber = num;
    }

    public void setBook(int numOfBook)
    {
        book = numOfBook;
    }

    public void setNewPassword(int digit1, int digit2, int digit3)
    {
        password = new CombinationLock(digit1, digit2, digit3);
    }

    public void putBookInLocker()
    {
       book = book + 1;
    }
    public void removeBookFromLocker()
    {
        
        if(book == 0)
        {            
            System.out.println("No book to remove(0)");
        }
        else
            book--;
    }

    public void openLocker()
    {
        int combination1= 0, combination2 = 0, combination3 = 0;
        Scanner input = new Scanner(System.in);
        
        for(int index = 1; index <= 3; index++)
        {
            System.out.println("Passcode combination " + index);
            int passcode = input.nextInt();
            if(index == 1)
                combination1 = passcode;
            else if(index == 2)
                combination2 = passcode;
            else if(index == 3)
                combination3 = passcode;    
        }
        boolean result = password.openLock(combination1, combination2, combination3);
        if(result)
            System.out.println("You have open the locker");
        else
            System.out.println("Wrong passcode");
        input.close();
    }

    public void displayResult()
    {
        System.out.println(
            "Owner: " + getOwner() +"\n" +
            "Locker Number: " + getLockerNumber() + "\n" +
            "Number of Books: " + getBook()
        );
    }
}
