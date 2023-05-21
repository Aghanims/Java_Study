package DataStructures.Lists.LabExamples;

import java.util.LinkedList;

public class SubsetIdentifier 
{

    private LinkedList<Integer> setA;
    private LinkedList<Integer> setB;

    public SubsetIdentifier()
    {
       this(null, null);
    }

    public SubsetIdentifier(LinkedList<Integer> setA, LinkedList<Integer> setB)
    {
        this.setA = setA;
        this.setB = setB;
    }

    public boolean isSubset()
    {
        return false;
    }

    public static void main(String[] args) 
    {
        LinkedList<Integer> setA = new LinkedList<>();
    }    
}
