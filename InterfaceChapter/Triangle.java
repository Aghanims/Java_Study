package InterfaceChapter;

/*
    Class for drawing triangles on the screen usng keyboard characters. 
    A triangle points up. It's size is determined by the length of its base,
    which must be an odd integer. Inherits getOffset, setOffsef, and drawAt from 
    the class ShapeBasics.
*/
public class Triangle extends ShapeBasics implements TriangleInterface
{
    private int base;

    //constructor
    public Triangle()
    {
        super();
        base = 0;
    }
    public Triangle(int offset, int base)
    {
        super(offset);
        this.base = base;
    }

    //Precondition: newBase is odd
    public void set(int newBase)
    {
        base = newBase;
    }

    public void drawHere()
    {
        drawTop();
        drawBase();
    }

    //helping methods
    private void drawBase()
    {
        skipSpaces(getOffset());
        for(int count = 0; count < base; count++)
            System.out.print('*');
        System.out.println();
    }
    private void drawTop()
    {
        //startOfLine == number of spaces to thee first '*' on a line
        //Initially set to the number of spaces vefore the topmost '*'
        int startOfLine = getOffset() + base / 2;
        skipSpaces(startOfLine);
        System.out.println('*'); //top '*'
        int lineCount = base / 2 - 1; // height above the base
        
        //insideWidth == number of spaces between the two '*'s on a line
        int insideWidth = 1;
        for(int count = 0; count < lineCount; count++)
        {
            //Down one line, so the first '*' is one more spaces to the left.
            startOfLine--;
            skipSpaces(startOfLine);
            System.out.print('*');
            skipSpaces(insideWidth);
            System.out.println('*');

            //down one line, so the inside is 2 spaces wider.
            insideWidth = insideWidth +2;
        }
    }

    private static void skipSpaces(int number)
    {
        for(int count = 0; count < number; count++)
            System.out.print(' ');
    }
}


