package CSC201.UnitThree;
//Unit #3, Problem #2
//Algorithm
/*
    - Create two int instance variables: "numberOfWheels" and "weight"
    -  a constructor that have the same name to the instance variables as its parameter
    - Create a default constructor; which will initially assign numberOfWheels = 100, and weight = 1000
        this construtor should invoke the other constructor.
    - test the class in another separate program.

Specific:
[A] Create a class called Cycle
    •Declare integer instance variables numberOfWheels and weight as private.
    •Include a toString() method in the Cycle class.  No set or get methods are included.
    •Create a constructor with two parameters, using the same variable names numberOfWheels and weight in the parameter list. Complete the constructor as necessary.
    •Create a separate application to test the class.
        o	Create an object of the Cycle class.
        o	Display the properties of the object.

[B] Add a default constructor
    •Edit the default constructor such that the default constructor will invoke the existing constructor with the default values of 100 to represent the numberOfWheels, and 1000 to represent the weight. Invoke the constructor using the “this” reference. 
        oCreate the second constructor which will receive the two arguments.
    •Create a separate application to test the class.
        oCreate an object of the Cycle class.
        oDisplay the properties of the object.
 */
public class Cycle 
{
   private int numberOfWheels;
   private int weight;

   public Cycle(int numberOfWheels, int weight)
   {
        this.numberOfWheels = numberOfWheels;
        this.weight = weight;
   }

   //default constructo
   public Cycle()
   {
       this(100, 1000);
   }

   public String toString()
   {
        return "number of Wheels: " + numberOfWheels + "\n" +
                "Weight: " + weight;
   }
}
