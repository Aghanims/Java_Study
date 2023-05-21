package ClassNotes;
public class CarRun 
{
    //Problem No.4 Demo
    public static void main(String[] args)
    {
        Car tesla = new Car(34.8);

        System.out.println("Tesla currently has " + tesla.getGasLevel() + " gas inside the tank.\n");

        tesla.addGas(34);
        System.out.println("We now filled the tank with " + tesla.getGasLevel() + " gallons\n");
        tesla.drive(89);

        System.out.println("Fuel left after driving for 46 miles: " + tesla.getGasLevel() + " gallons");


    }
}
