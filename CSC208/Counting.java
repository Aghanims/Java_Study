package CSC208;

public class Counting 
{
    //part 1
    public static double grainsInChessboard(int numberOfSquares)
    {
        int exponent = numberOfSquares - 1;
        
        double result = Math.pow(2, exponent);

        return result;
    }

    //part 2 
    public static int numberOfCerealBox(int featuredPlayer, int featuredSport)
    {
        int n = featuredSport;
        int k = featuredPlayer;

        //simplified using algebra ;
        /*
            from:
            result / n = ((k-1) + 1/n) 
                       = ((k-1) + 1/n) * n
                       = ((n(k - 1) + 1)/n) * n
               result  = ((n * (k - 1) + 1) 
        */
        int result = (n* (k - 1)) + 1;

        return result;
    }

    public static void main(String[] args) 
    {

        //part 1: 2^(k-1) ; where k is the number of square exist
        /*
        Consider the sequence: 2^(k-1)
            2^(1-1) = 1 //only one grain can contain on first square
            2^(2-1) = 2 // 2 grain contains on second square
            2^(3-1) = 4// 4 grain contains on third square
            .
            .
            .
            2^(64-1) = result
        */ 
        int numberOfSquare = 64;
        System.out.println(grainsInChessboard(numberOfSquare));

        
        //part 2
        /*
          Let:
            n = number of sports featured
            k = number of famous players that are featured on that sport

            result = number of boxes need to purchase that guarentees a costumer to get a player from different sport

            --> Apply pigeon hole principle to get the result
        */
        int n = 10; //number of sports
        int k = 50; //number of featured players
        int result = numberOfCerealBox(n, k); 

        System.out.println("Total number of ceral box to purchase that guarantees collection of all famous players: "
                             + result);
    }
}
