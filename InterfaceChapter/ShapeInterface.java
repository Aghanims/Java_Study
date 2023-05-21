package InterfaceChapter;

//interface does not declare private method and variables, as well as constructors.

public interface ShapeInterface
{
    //Sets offset for the shape
    public void setOffset(int newOffset);  
    
    //return the offset for the shape
    public int getOffset();

    //draws the shape at lineNumber lines down from the current line.
    public void drawAt(int lineNumber);

    //Draws the shape at the current line.
    public void drawHere();
}
