package CSC201.UnitOne;

/*
    Scope: Simulates a broken GPS where it randomly chooses direction every 5 minutes

                        North (plus 1 on "y")
                                 ^
                                 |
      (minus 1 on "x")West <---     ---> East (plus 1 on "x")
                                 |
                         South(minus 1 on "y")
    Algorithm:
    * Each direction represents a value (like in a coordinate plane)
        - We have our driver at (x,y)
        - we add or subtract our ordered pairs every time the GPS changes direction 
        - The GPS randomly changes direction every 5 minutes
    * Record the the values on the ordered pair every 60 minutes(1hour)
 */
public class Mod1Problem3 
{
    public static void main(String[] args)
    {
        int x, y;
        //initial location
        x = 0;
        y = 0;

        System.out.println("Initial Position: (" + x + "," + y + ")" );
        for(int gps = 0; gps <= 60; gps++)
        {
            double directionChanger = Math.random() * 3; 
            /*  0 - west
                1 - south
                2 - east
                3 - north
            */
            if((gps % 5) == 0) //changes direction every 5 minutes
            {
                if(Math.round(directionChanger) == 0)
                    x = x - 1;
                else if(Math.round(directionChanger) == 1)
                    y = y - 1;
                else if(Math.round(directionChanger) == 2)
                    x = x + 1;
                else if(Math.round(directionChanger) == 3)
                    y = y + 1;
            }
        }
        System.out.println("Position after an hour: (" + x + "," + y + ")" );
    }    
}
