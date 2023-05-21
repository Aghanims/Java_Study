package CSC201.UnitSix;

//Problem#1
public class HazardPay extends PayCalculator
{
    public HazardPay()
    {
        super();
    }
    public HazardPay(double payRate)
    {
        super(payRate);
    }

    public double computePay(double hours)
    {
       double newAmount =  super.computePay(hours) * 1.5;
        return newAmount;
    }

    public static void main(String[] args) 
    {
        //this test is for the two class the implemente PayCalculator interface
        RegularPay test1 = new RegularPay(4.60);  
        HazardPay test2 = new HazardPay(4.60);

        System.out.println("Regular payment for 12hrs: $" + Math.round(test1.computePay(12)));
        System.out.println("Payment with hazard compensation: $" + Math.round(test2.computePay(12)));

    }
}
