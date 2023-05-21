package ClassNotes;
public class Car 
{
    //Problem No.4

    private double fuelEffeciency;
    private double fuel = 0; // initial fuel level

    public Car(double fuelEffeciency)
    {
        this.fuelEffeciency = fuelEffeciency;
    }

    public double addGas(double fuel)
    {
        return this.fuel = fuel;   
    }

    public double getGasLevel()
    {
        return fuel;
    }

    public void drive(double miles)
    {
        // MPG = miles / gallon(s)
        fuel = Math.round(fuel - (miles / fuelEffeciency));
    }

}
