package CSC201.UnitSix;

//Problem#1
public abstract class PayCalculator 
{
    protected double payRate; //given in dollars per hour
    
    public PayCalculator()
    {
        payRate = 0.0;
    }

    public PayCalculator(double payRate)
    {
        this.payRate = payRate;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public double computePay(double hours)
    {
        return hours * payRate;
    }
}
