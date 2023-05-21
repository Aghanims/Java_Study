package InterfaceChapter;

public class Rectangle extends ShapeBasics implements RectangleInterface
{
    private int height;
    private int width;

    //constructors
    public Rectangle()
    {
        this(0, 0, 0);
    }
    public Rectangle(int offset, int height, int width)
    {
        super(offset);
        this.height = height;
        this.width = width;
    }
    //Mutator from Rectangle Interface
    public void set(int newHeight, int newWidth)
    {
        height = newHeight;
        width = newWidth;
    }

    public void drawHere()
    {
        drawHorizantalLine();
        drawSides();
        drawHorizantalLine();
    }

    //helping methods (private)
    private void drawHorizantalLine()
    {
        skipSpaces(getOffset());
        
        for(int count = 0; count < width; count++)
            System.out.print('-');
        System.out.println();
    }
    private void drawSides()
    {
        for(int count = 0; count < (height - 2); count++)
            drawOneLineSides();
    }
    private void drawOneLineSides()
    {
        skipSpaces(getOffset());
        System.out.print('|');
        skipSpaces(width - 2);
        System.out.println('|');
    }

    //Writes indicated number of spaces.
    private static void skipSpaces(int number)
    {
        for(int count = 0; count < number; count++)
            System.out.print(' ');
    }

    

}
