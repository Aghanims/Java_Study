package Class_ArrayProject;

public class ProblemFour 
{
    public static final int ROW = 10;
    public static final int COLUMN = 10;
    public static void main(String[] args)
    {
        int[][] theaterSeats = new int[ROW][COLUMN];

        int changePrice = 0;
        System.out.println("Theater Seating Chart price: ");
        for(int row = 0; row < theaterSeats.length; row++ )
        {
            if(row%2 == 0)
                 changePrice = changePrice + 20;

            for(int column = 0; column < COLUMN; column++)
            {  
                theaterSeats[row][column] = changePrice; 
                System.out.print(theaterSeats[row][column] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Theather offers price of $60 on seats? ");
        matchPrice(60);
        System.out.println();

        System.out.println("Theather offers price of $70 on seats?");
        matchPrice(70);

        System.out.println();
        System.out.println("Find any seat with a price of $80");
        findSeat(80, theaterSeats);

        System.out.println();
        System.out.println("Seat on column 6 on row 4");
        isAvailable(theaterSeats[6][4]);

        System.out.println();
        System.out.println("I want to seat on column 7 on row 6");
        soldSeat(6, 7, theaterSeats);
        System.out.println();

        SeatingChart(theaterSeats);

        
    }

    public static void SeatingChart(int[][] array)
    {   
        System.out.println("Theater Seating Chart price: ");
        for(int row = 0; row < array.length; row++ )
        {
            for(int column = 0; column < COLUMN; column++)
            {  
                System.out.print(array[row][column] + "\t");
            }
            System.out.println();
        }
    }

    //Method that marks the sold seat int zero
    public static int soldSeat(int row, int column, int[][] array)
    {    
        return array[row-1][column-1] = 0;
    }

    //method that returns true if the specified seat is available
    public static void isAvailable(int seatLocation)
    {
        if(seatLocation == 0)
            System.out.println("This seat is not available");
        else
            System.out.println("This seat is available");
    }    
    
    //method that finds any available seat with the specified price
    public static void findSeat(int seatPrice, int[][] array)
    {
        //scans the seats for avilability for that specified price
        for(int row = 0; row < array.length; row++)
        {
            for(int column = 0; column < COLUMN; column++)
            {
                if(array[row][column] == seatPrice)
                {
                    System.out.println("Seat at row " + row + " on column "+ column + " is available");
                    seatPrice = 9999; //statement that ends the loop
                }
            }
        }
    }

    // method that verify the price is offered in the theather
    public static void matchPrice(int price)
    {
        switch(price)
        {
            case 20:
            {
                System.out.println("We offer $20 seat price in this theater");
                break;
            }
            case 40:
            {
                System.out.println("We offer $40 seat price in this theater");
                break;
            }
            case 60:
            {
                System.out.println("We offer $60 seat price in this theater.");
                break;
            }
            case 80:
            {
                System.out.println("We offer $80 seat price in this theater.");
                break;
            }
            case 100:
            {
                System.out.println("We offer $100 seat price in this theater.");
            }
            default:
            {
                System.out.println("this theater do not offer $" + price + " price." );
            }
        }
                 
            
        
    }    
}
