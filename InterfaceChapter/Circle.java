package InterfaceChapter;

public class Circle implements Measurable
{
    private double myRadius;

    //Constructor
    public Circle(double radius)
    {
        myRadius = radius;   
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * myRadius;
    }
    public double getCircumference()
    {
        return getPerimeter();
    }
    public double getArea()
    {
        return Math.PI * myRadius * myRadius;
    }
}
