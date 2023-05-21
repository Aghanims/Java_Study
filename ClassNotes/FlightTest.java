package ClassNotes;
public class FlightTest
{
    public static void main(String[] args)
    {
        //ProblemNo.1
        Flight flightTest = new Flight("Hummingbird", "RG7985", "United States", "Japan");

        flightTest.setAirlineName("Space Cowboys");
        flightTest.setFlightNumber("SP1457");
        flightTest.setOrigin("Japan");
        flightTest.setDestination("Quadrant IV, Mars");

        flightTest.getAirlineName();
        flightTest.getFlightNumber();
        flightTest.getOrigin();
        flightTest.getDestination();

        System.out.println();

        flightTest.flightDiplay();

       
    }   
}
