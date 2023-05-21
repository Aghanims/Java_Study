package Recursion;

public class RecursiveCountdown 
{
    public static void main(String[] args) 
    {
        countDown(10);
    }   
    
    public static void countDown(int num)
    {
        if(num <= 0)
        {
            System.out.println();
        }
        else
        {
            System.out.println(num);
            countDown(num -1);
        }
    }
}
