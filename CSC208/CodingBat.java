package CSC208;

public class CodingBat 
{
    public static boolean cigarParty(int cigars, boolean isWeekend) 
    {
        /*
            When squirrels get together for a party, they like to have cigars.
            A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. 
            Unless it is the weekend, in which case there is no upper bound on the number of cigars. 
            Return true if the party with the given values is successful, or false otherwise.
        */
        boolean result = false;

        if(isWeekend == false)
        {
            if(cigars >= 40 && cigars <= 60)
                result = true;
        }
        else //isWeekend
        {
            if(cigars >= 40)
                result = true;
        }

        return result;
    }
  
    public static boolean more20(int n) 
    {
        //Return true if the given non-negative number is 1 or 2 more than a multiple of 20.

        boolean result = (n % 20) == 1 || (n % 20) == 2;
        return result;
    }

    public static boolean twoAsOne(int a, int b, int c) 
    {
        /*
            Given three ints, a b c, return true if it is possible to add two of the ints to get the third.

            twoAsOne(1, 2, 3) → true
            twoAsOne(3, 1, 2) → true
            twoAsOne(3, 2, 2) → false
        */
        boolean result = false;

        if((a + b == c) || (a + c == b) || (c + b == a))
            result = true;

        return result;
    }

    public static int dateFashion(int you, int date) 
    {
        /* 
            You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness of your clothes, 
            in the range 0..10, and "date" is the stylishness of your date's clothes. The result getting the table is encoded as 
            an int value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 8 or more, then the result is 2 (yes). 
            With the exception that if either of you has style of 2 or less, then the result is 0 (no). Otherwise the result is 1 (maybe).

            dateFashion(5, 10) → 2
            dateFashion(5, 2) → 0
            dateFashion(5, 5) → 1
        */
        if (you <= 2 || date <= 2) 
            return 0;
        else if (you >= 8 || date >= 8) 
            return 2;
        else 
            return 1;
        
    }

    public static boolean squirrelPlay(int temp, boolean isSummer) 
    {
        /*          
            The squirrels in Palo Alto spend most of the day playing. In particular, they play if the temperature is between 60 and 90 (inclusive). 
            Unless it is summer, then the upper limit is 100 instead of 90. Given an int temperature and a boolean isSummer, return true if the 
            squirrels play and false otherwise.

            squirrelPlay(70, false) → true
            squirrelPlay(95, false) → false
            squirrelPlay(95, true) → true
        */

        if (isSummer && temp <= 100 && temp >= 60)
            return true;
        if (!(isSummer) && temp <= 90 && temp >=60)
            return true;
        else
            return false;
        
    }
    
/***************************************************************************************************** */
    public static void main(String[] args) 
    {

        //cigarParty
        System.out.println("cigarParty testResults: ");
        System.out.println(cigarParty(30, false));
        System.out.println(cigarParty(50, false));
        System.out.println(cigarParty(70, true));

        System.out.println(); 

        //more 20
        System.out.println("more20 test results: ");
        System.out.println(more20(20));
        System.out.println(more20(21));
        System.out.println(more20(22));

        System.out.println();

        //twoAsOne
        System.out.println("twoAsOne test results: ");
        System.out.println(twoAsOne(1, 2, 3));
        System.out.println(twoAsOne(3, 1, 2));
        System.out.println(twoAsOne(3, 2, 2));

        System.out.println();

        //dateFasion
        System.out.println("dateFashion test results: ");
        System.out.println(dateFashion(5, 10));
        System.out.println(dateFashion(5, 2));
        System.out.println(dateFashion(5, 5));
        
        System.out.println();

        //squirrelPlay
        System.out.println("squirrelPlay test results: ");
        System.out.println(squirrelPlay(70, false));
        System.out.println(squirrelPlay(95, false));
        System.out.println(squirrelPlay(95, true));
    }    
}
