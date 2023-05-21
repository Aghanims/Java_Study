package CSC208;

import java.math.BigInteger;

public class AdvanceCounting 
{
    
    public static BigInteger possiblePassWordCombinations(int passwordLength)
    {
        //Digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } 
        // Letters = { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z }
        //Special characters = { *, &, $, # }

        //generalized product rule 
        /*
            n = total number of digits,length and special characters = 40
            r = passwordLength

            n! / (n - r)!
        */
        int n = 40;
        int r = passwordLength;

        //using BigInteger to handle arbitrary numbers; for some reason java will return negatives and zero when values are too big.
        BigInteger result = factorial(n).divide(factorial(n - r));

        return result;
    }

    private static BigInteger factorial(int number)
    {
        if(number < 0) 
            return BigInteger.ZERO;
        else if (number ==0)
            return BigInteger.ONE;
        else 
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
    }
    
/****************************************************************************************************** */   

    public static double grainsInChessboard(int numberOfSquares)
    {
        int exponent = numberOfSquares - 1;
        
        double result = Math.pow(2, exponent);

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
            2^(64-1) = total number of square in the chessboard, since chessboard has 64 squares
        */ 
        int numberOfSquare = 64;
        System.out.println(grainsInChessboard(numberOfSquare));

        
        //advance counting
        System.out.println(possiblePassWordCombinations(6));
       
    }
}
