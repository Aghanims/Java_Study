package CSC201.UnitThree;

// Problem 1 test
/*
    •Creates locker number 100 for Mickey Mouse. The combination for this locker is 28, 17, 39. This locker will include 3 books.
    •Create locker number 275 for Donald Duck. The combination for this locker is 35, 16, 27. This locker will include 0 books.
    •Try to open the locker for Mickey Mouse using 15, 18, 18.
    •Add three books to Mickey Mouse’s locker.
    •Remove one book from Donald Duck’s locker.
    •After all of these actions have been completed, print out the current state of both lockers to the console.
*/
public class Mod3Problem1 
{
    public static void main(String[] args) 
    {
        CombinationLock MickeyPassword = new CombinationLock(28, 17, 39);
        CombinationLock DonaldPassword = new CombinationLock(35, 16, 27);

        Locker mickeyMouse = new Locker(MickeyPassword, 3, 100, "Mickey Mouse");
        Locker donaldDuck = new Locker(DonaldPassword, 0, 275, "Donald Duck");

       mickeyMouse.openLocker();

        mickeyMouse.putBookInLocker();
        mickeyMouse.putBookInLocker(); 
        mickeyMouse.putBookInLocker();

        donaldDuck.removeBookFromLocker();
        System.out.println();
        mickeyMouse.displayResult();
        System.out.println();
        donaldDuck.displayResult();


    }
}
