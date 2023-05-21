package CSC201.UnitOne;
//This is an extension to Module1-Problem4
public class ComplexNumber 
{
    private float real, imaginary;

    public ComplexNumber(float real, float imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public float getReal()
    {
        return real;
    }
    public float getImaginary()
    {
        return imaginary;
    }

    public void complexAddition(ComplexNumber z2)
    {
        //z1 + z2=(a1+a2) +  i*(b1+b2)
        float addReal;
        addReal = getReal() + z2.getReal();
        float addImaginary;
        addImaginary = getImaginary() + z2.getImaginary();

        System.out.println("Complex Addition Result: " + addReal + " + " + addImaginary + "i");
    }

    public void complexSubtraction(ComplexNumber z2)
    {
        //z1 - z2=(a1-a2) +  i*(b1-b2)
        float subtractReal;
        subtractReal = getReal() - z2.getReal();
        float subtractImaginary = getImaginary() - z2.getImaginary();

        System.out.println("Complex Subtraction Result: " + subtractReal + " + " + subtractImaginary + "i");
    }

    public void complexMultiplication(ComplexNumber z2)
    {
        //z1*z2 = (a1*a2 – b1*b2) + i*(a1*b2 + b1*a2)
        float multiplyReal;
        multiplyReal = (getReal() * z2.getReal()) - (getImaginary() * z2.getImaginary());
        float multiplyImaginary;
        multiplyImaginary = (getReal() * z2.getImaginary()) + (getImaginary() * z2.getReal());

        System.out.println("Complex Multiplication Result: " + multiplyReal + " + " + multiplyImaginary + "i");
    }

    public void complexDivision(ComplexNumber z2)
    {
        //z1/z2 = (a1*a2 +b1*b2)/(a2^2 + b2^2) + i*(b1*a2 – a1*b2)/(a2^2 + b2^2)
        float divideReal;
        divideReal = ((getReal() * z2.getReal()) + (getImaginary() * z2.getImaginary())) / 
                    ((z2.getReal() * z2.getReal()) + (z2.getImaginary() * z2.getImaginary()));
        float divideImaginary;
        divideImaginary = ((getImaginary() * z2.getReal()) - (getReal() * z2.getImaginary())) /
                            ((z2.getReal() * z2.getReal()) + (z2.getImaginary() * z2.getImaginary()));
        
        System.out.println("Complex Division Result: " + divideReal + " + " + divideImaginary + "i");
    }
}
