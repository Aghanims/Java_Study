package ClassNotes;
public class Flight
//problemNo.1
{
    private String airlineName;
    private String flightNumber;
    private String origin;
    private String destination;

    public Flight()
    {
        airlineName = "unknown";
        flightNumber = "unknown";
        origin = "unknown";
        destination = "unknown";
    }

    public Flight(String airlineName, String flightNumber, String origin, String destination)
    {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }


    //Accessors
    public void getAirlineName()
    {
        System.out.println(airlineName);
    }

    public void getFlightNumber()
    {
        System.out.println(flightNumber);
    }

    public void getOrigin()
    {
        System.out.println(origin);
    }

    public void getDestination()
    {
        System.out.println(destination);
    }

    //Mutators
    public void setAirlineName(String newName)
    {
        airlineName = newName;
    }

    public void setFlightNumber(String newFlightNumber)
    {
        flightNumber = newFlightNumber;
    }

    public void setOrigin(String newOrigin)
    {
        origin = newOrigin;
    }

    public void setDestination(String newDestination)
    {
        destination = newDestination;
    }

    //flight diplay
    public void flightDiplay()
    {
        System.out.println(airlineName + " airline flight information: ");
        System.out.println("Flight number: " + flightNumber);
        System.out.println("Flight origin: " + origin);
        System.out.println("Destination: "+ destination);
    }


}
