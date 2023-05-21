package ClassNotes;
import java.util.Scanner;

public class SalesReporter 
{
    private double highestSales;
    private double averageSales;
    private SalesAssociate[] team;
    private int numberOfAssociates; // team.length

    Scanner keyboard = new Scanner(System.in);

    public void getData()
    {
        System.out.println("Enter number of sales associate: ");
        numberOfAssociates = keyboard.nextInt();
        team = new SalesAssociate[numberOfAssociates +1];

        for(int i = 1; i <= numberOfAssociates; i++)
        {
            team[i] = new SalesAssociate(); // object creation
            System.out.println("Enter data for associate "+ i);
            team[i].readInput();
            System.out.println();
        }
    }

    public void computeStats()
    {
        double nextSales = team[1].getSales();
        highestSales = nextSales;
        double sum = nextSales;
        for(int i = 2; i <= numberOfAssociates; i++)
        {
            team[i].getSales();
            sum = sum + nextSales;
            if(nextSales > highestSales)   
            {
                highestSales = nextSales; // highest sales so far
            }
            averageSales = sum / numberOfAssociates;
        }
    }

    //display sales report on screen
    public void displayResult()
    {
        System.out.println("Average sales per associate is $" + averageSales);
        System.out.println("Highest sales figure is $" + highestSales);
        System.out.println();

        System.out.println("The following had the highes sales:");
        for(int i = 1; i <= numberOfAssociates; i++)
        {
            double nextSales = team[i].getSales();
            if(nextSales == highestSales)
            {
                team[i].writeOuput();
                System.out.println("$" + (nextSales - averageSales) + " above the average.");
                System.out.println();
            }
        }

        System.out.println("The rest performed as follows:");
        for(int i = 1; i <= numberOfAssociates; i++)
        {
            double nexSales = team[i].getSales();
            if(team[i].getSales() != highestSales)
            {
                team[i].writeOuput();
                if(nexSales >= averageSales)
                {
                    System.out.println("$" + (averageSales -nexSales) + " below the average.");
                    System.out.println();
                }
            }
        } 
    }

    public static void main(String[] args)
    {
        SalesReporter clerk = new SalesReporter();
        clerk.getData();
        clerk.computeStats();
        clerk.displayResult();
        
    }
}

