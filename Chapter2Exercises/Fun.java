package Chapter2Exercises;

public class Fun 
{
    public static void main(String[] args)
    {
       Day firstDay = new Day(Week.MONDAY);
       firstDay.HowAreYou();
       Day secondDay = new Day(Week.TUESDAY);
       secondDay.HowAreYou();
       Day thirdDay = new Day(Week.WEDNESDAY);
       thirdDay.HowAreYou();
       Day fifthDay = new Day(Week.FRIDAY);
       fifthDay.HowAreYou();
       Day sixthDay = new Day(Week.SATURDAY);
       sixthDay.HowAreYou();

    }   
}
