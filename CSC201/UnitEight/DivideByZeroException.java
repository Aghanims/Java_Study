package CSC201.UnitEight;

public class DivideByZeroException extends Exception
{
    public DivideByZeroException()
    {
        super("Cannot have a zero denominator");
    }

    public DivideByZeroException(String message)
    {
        super(message);
    }
}
