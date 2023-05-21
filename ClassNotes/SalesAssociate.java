package ClassNotes;
import java.util.Scanner;

public class SalesAssociate 
{
    Scanner keyboard = new Scanner(System.in);

    private String name;
    private double sales;

    public SalesAssociate()
    {
        name = "No Record";
        sales = 0;
    }
    public SalesAssociate(String initialName, double initialSales)
    {
        set(initialName, initialSales);
    }

    public void set(String name, double sales)
    {
        this.name = name;
        this.sales = sales;
    }

    public void readInput()
    {
        System.out.print("Enter name of sales associate: ");
        name = keyboard.nextLine();

        System.out.print("Enter associate's sales: $");
        sales = keyboard.nextDouble();
    }

    public void writeOuput()
    {
        System.out.println("Name: " + name);
        System.out.println("Sales: $" + sales);
    }

    public String getName()
    {
        return name;
    }
    public double getSales()
    {
        return sales;
    }
}
