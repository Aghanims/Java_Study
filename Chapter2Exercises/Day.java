package Chapter2Exercises;

enum Week{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

public class Day 
{
    Week day;

    public Day(Week day)
    {
        this.day = day;
    }

    public void HowAreYou()
    {
        switch(day)
        {
            case MONDAY:
            {
                System.out.println("Uhhh, I hate Mondays...");
                break;
            }
            case FRIDAY:
            {
                System.out.println("Fridays are better");
                break;
            }
            case SATURDAY: case SUNDAY:
            {
                System.out.println("Weekends are the best");
                break;
            }
            default:
            {
                System.out.println("Midweek are so-so");
                break;
            }

            
        }
    }
}
