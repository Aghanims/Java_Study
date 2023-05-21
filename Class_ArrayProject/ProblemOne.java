package Class_ArrayProject;

public class ProblemOne 
{
    public static final int SIZE = 10;

    public  static void main(String[] args)
    {
        int[] randomNum = new int[SIZE];

        //loop that creates random numbers
        System.out.println("Random numbers generated: ");
        for(int index = 0; index < randomNum.length; index++)
        {
            int createNum = (int)(Math.random() * 100); // number ranges up to 100;
            randomNum[index] = createNum;
            System.out.print(randomNum[index] + "  ");
        }
        System.out.println( );

        //display elements at even indices
        System.out.println("Elements at even indice(s): ");
        for(int index = 0; index < randomNum.length; index++)
        {
            if(index%2  == 0)
            {
                System.out.print(randomNum[index] +  "  ");
            }
        }

        System.out.println();

        //Even elements
        System.out.println("Even elements: ");
        for(int index = 0; index < randomNum.length; index++)
        {
            if(randomNum[index] %2 == 0)
            {
                System.out.print(randomNum[index] + "  ");
            }
        }
        System.out.println( );

        //Elements in reverse order
        System.out.println("Elements in reverse order:");
        for(int index = randomNum.length - 1; index >= 0; index--)
        {
           System.out.print(randomNum[index] + "  ");
        }
        System.out.println();

        //First and last elements
        System.out.println("First element: " + randomNum[0]);
        System.out.println("Last element: " + randomNum[9]);

        //Minimum and Maximum elements
        int minCandidate = randomNum[0]; // Starts with value at index 0 and update if it scans another new minimum and maximum candidate
        int maxCandidate = randomNum[0]; // throughout the array.
        for(int index = 0; index < randomNum.length; index++)
        {
            if(randomNum[index] < minCandidate)//the if statement is constantly updating the minimum element until randomNum.length
            {
                minCandidate = randomNum[index];
            }

            if(randomNum[index] > maxCandidate)
            {
                maxCandidate = randomNum[index];
            }
        }
        System.out.println("Maximum element: " + maxCandidate);
        System.out.println("Minimum element: " + minCandidate);

        //The sum of all elements
        int allSum = 0;
        for(int index = 0; index < randomNum.length; index++)
        {
            allSum = allSum + randomNum[index];
        }
        System.out.println("Sum of all elements: " + allSum);

        //Alternating sum of all elements; all even index is added, while odd is subtracted
        int allEvenIndex = 0; 
        int allOddIndex = 0;
        for(int index = 0; index < randomNum.length; index++)
        {
            if(index%2 == 0)
            {
                allEvenIndex = allEvenIndex + randomNum[index];
            }
            else
            {
                allOddIndex = allOddIndex + randomNum[index];
            }
        }
        System.out.println("Alternating sum of all elements: " + (allEvenIndex - allOddIndex));
    }

}
