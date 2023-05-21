package DataStructures.SelfStudy.Problems;

public class FindMissngNumberInArray 
{
    public static int findMissingNumber(int[] array)
    {   
        int range = array.length + 1;
        int sum = range * (range + 1) / 2; //find the sum of n numbers

        for(int value : array)
            sum = sum - value;

        return sum;
    }   



/**************************************************************** */    
    public static void main(String[] args) 
    {
        int[] test = {1, 4, 6, 10, 9, 2, 3, 7, 8};

        System.out.println("Missing number: " + findMissingNumber(test));
    }    
}
