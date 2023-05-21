package ExceptionHandling.CatchingMultipleException;

public class DivideByZeroException extends Exception
{
    public DivideByZeroException()
    {
        super("Dividing By Zero!");
    }

    public DivideByZeroException(String message)
    {
        super(message);
    }
}
