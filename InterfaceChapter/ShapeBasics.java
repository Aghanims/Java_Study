package InterfaceChapter;

/*
    Class for drawing simple shapes on the screen using keyboard characters. This class will drawn an asterisk on the screen as a test. 
    It is not intended to create a "real" shape, but rather to be used as a base class for other classes of shapes.
*/
public abstract class ShapeBasics implements ShapeInterface
{
    //Since this is an abstract class, it cannot create an object of this type
    
    private int offset;

    //constructors
    public ShapeBasics()
    {
        this(0);
    }
    public ShapeBasics(int offset)
    {
        this.offset = offset;
    }

    //mutator
    public void setOffset(int newOffset)
    {
        offset = newOffset;
    }
    
    //Accessor
    public int getOffset()
    {
        return offset;
    }

    public void drawAt(int lineNumber)
    {
        for(int count = 0; count < lineNumber; count++)
        {
            System.out.println();
        }
        drawHere();
    }

    public abstract void drawHere(); //Abstract method MUST always be overriden by a non-abstract derived class

}
