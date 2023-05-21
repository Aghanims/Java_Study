package InterfaceChapter;

public class InterfaceDemo 
{
    public static void main(String[] args)
    {
        Measurable disc = new Circle(5.0);
             
        //circle
        System.out.println("Area of disc is: " + Math.round(disc.getArea()));
        System.out.println("Perimeter of disc is: " + Math.round(disc.getPerimeter()));
        //System.out.println("Circumference of disc is: " + Math.round(disc.getCircumference())); ...Illegal
        // since getCircumference is not a method of Measurable...that's why typecasting is needed.
        Circle typCast = (Circle)disc; 
        System.out.println("Circumference of disc is: " + Math.round(typCast.getCircumference()));

        
    }    
}
