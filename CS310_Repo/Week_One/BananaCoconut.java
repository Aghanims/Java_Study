package CS310_Repo.Week_One;

public class BananaCoconut 
{
    public static void main(String[] args) 
    {
        for(String input : args)
        {
            try
            {
                int valueAsInt = Integer.parseInt(input);

                if(valueAsInt < 1)
                    System.out.print("puttputt ");
                else if(valueAsInt % 3 == 0 && valueAsInt % 7 == 0) // multiple of 3 and 7
                    System.out.print("banana-coconut ");
                else if(valueAsInt % 3 == 0) // multiple of 3
                    System.out.print("banana ");
                else if(valueAsInt % 7 == 0) // multiple of 7
                    System.out.print("coconut ");
                else 
                    System.out.print(input + " ");
            }
            catch(NumberFormatException e)
            {
                System.err.println("One or more numbers required as a command line argument.");
            }
            
        }
    }    
}
