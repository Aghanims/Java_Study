package Class_ArrayProject;

public class ProblemThreeDemo 
{
    public static void main(String[] args) 
    {
        ProblemThree nameHolder = new ProblemThree(10);
        nameHolder.readInput();
        System.out.println();
        nameHolder.writeOutput();

        nameHolder.setInformation(2, "Brian", "Diaz", 223456);
        System.out.println();

        nameHolder.writeOutput();
    }
}
