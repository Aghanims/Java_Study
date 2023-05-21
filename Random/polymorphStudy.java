package Random;

public class polymorphStudy 
{
    public static void main(String[] args)
    {
        //Polymorphism Demonstration
        //An array of type base class, and creates object of derived classes.
        Person[] people = new Person[4];

        people[0] = new Undergraduate("Slark", 1803117, 2);
        people[1] = new Undergraduate("Jakiro", 2314284, 1);
        people[2] = new Student("Rubick", 2842814);
        people[3] = new Undergraduate("Riki", 3563257, 1);

        for(Person tawo: people)
        {
            tawo.writeOutput(); //Even though "tawo" is of type Person,  the writeOutput method associated with Undergraduated or Student
            System.out.println(); //is invoked depending upon shich class was used to create the object.
        }


    }
}
