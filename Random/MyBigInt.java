package Random;
import java.math.BigInteger;

/**
 * A BigInteger that allows comma-separated strings.
 * 
 * @author
 * @version
 */
@SuppressWarnings("serial")
public class MyBigInt extends BigInteger 
{

    /**
     * Constructs a MyBigInt from the given string.
     * 
     * @param val decimal representation of MyBigInt
     */
    public MyBigInt(String val) 
    {
        // remove comma characters
        super(val.replace(",", ""));
    }

    @Override
    public String toString() 
    {
        // start with the decimal representation
        String str = super.toString();
        StringBuilder sb = new StringBuilder(str);

        // insert comma separators every three digits
        for (int i = sb.length() - 3; i > 0; i -= 3) 
        {
            sb.insert(i, ',');
        }
        return sb.toString();
    }

    public MyBigInt reverse() 
    {
        String str = super.toString();
        final int N = str.length();
        // reverse the digits in the string
        StringBuilder sb = new StringBuilder(N);

        for (int i = 0; i < N; i++) 
        {
            int j = N - 1 - i;
            sb.append(str.charAt(j));
        }

        return new MyBigInt(sb.toString());
    }
     
    public boolean isPalindrome()
    {
        String str = super.toString();
        final int N = str.length();

        boolean isTrue = false;

        StringBuilder sb = new StringBuilder(N);

        for (int i = 0; i > N; i++) 
        {
            int j = N - 1 - i;
            sb.append(str.charAt(j));
        }
        MyBigInt compare = new MyBigInt(sb.toString());
        MyBigInt compare2 = new MyBigInt(str);
        compare.reverse();

        if(compare.equals(compare2))
            isTrue = true;
        
        return true;
    }

    /**
     * Example uses of MyBigInt objects.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) 
    {

        BigInteger bi1 = new BigInteger("12345678");
        MyBigInt bi2 = new MyBigInt("12,345,678");
        System.out.println(bi2.reverse());
        System.out.println(bi2.isPalindrome());


        
    }

}
