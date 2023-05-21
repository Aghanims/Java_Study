package DataStructures.SelfStudy.RecursionAndDynamicProgramming;

public class Fibonacci 
{

    private static int fibonacci(int nth)
    {
        if(nth == 0)
            return 0;

        if(nth == 1)
            return 1;

        int left = fibonacci(nth - 1);
        int right = fibonacci(nth -2);

        return left + right;
    }

    public static void printFibonacci(int nth)
    {
        for(int i = 0; i <= nth; i++)
            System.out.print(fibonacci(i) + " ");
    }   


/*********************************************************************** */
    //Bottom-up approach (Tabulation)

    private static int[] BottomUpFibonacci(int nth)
    {
        int[] table = new int[nth + 1]; 

        table[0] = 0;
        table[1] = 1;

        for(int i = 2; i < table.length; i++)
            table[i] = table[i - 2] + table[i - 1];
        
        return table;
    }

    public static void printBottomUpFibonacci(int nth)
    {
        int[] table = BottomUpFibonacci(nth);

        for(int i = 0; i < table.length; i++)
            System.out.print(table[i] + " ");
    }

/*********************************************************************** */
    //Top-down approach (Memoization)

    private static int topDownFibonacci(int[] memo, int nth)
    {
        if(memo[nth] == 0) //the condition of checking whether the process is already done
        {
            if(nth < 2) //the base case
                memo[nth] = nth; // do nothing if fibonacci is either 1 or 0
            else
            {
                int left = topDownFibonacci(memo, nth -1); //the main recursion
                int right =  topDownFibonacci(memo, nth - 2);

                memo[nth] = left + right;
            }
        }

        return memo[nth]; //store the already process sub-problem to not repeat recursion
    }   

    public static void printTopDownFibonacci(int nth)
    {
        int[] memo = new int[nth + 1];

        topDownFibonacci(memo, nth);

        for(int i = 0; i < memo.length; i++)
            System.out.print(memo[i] + " ");
    }

/********************************************************************* */
    public static void main(String[] args) 
    {
        int nthFobancci = 20;

        System.out.println("Printing the " + nthFobancci + "th Fibonacci");
        printFibonacci(nthFobancci);

        System.out.println();
        System.out.println("Printing " + nthFobancci + " th Fibonacci using Bottom-up approach:");
        printBottomUpFibonacci(nthFobancci);

        System.out.println();
        System.out.println("Printing " + nthFobancci + " th Fibonacci using top-down approach:");
        printTopDownFibonacci(nthFobancci);
    }
}
