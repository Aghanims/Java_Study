package InterfaceChapter.ComparableInterface;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Students 
{

    private int Id;
    private String name;

    public Students(int Id, String name)
    {
        this.Id = Id;
        this.name = name;
    }

    public void printInfo()
    {
        System.out.println("Name: " + name);
        System.out.println("ID: " + Id);
    }

/****************************************************************************** */

    public static class sortById implements Comparator<Students>
    {
        @Override
        public int compare(Students userA, Students userB) 
        {
           return userA.name.compareTo(userB.name); //return based on lexicographical order
        }
    }

    public static class sortByName implements Comparator<Students>
    {
        @Override
        public int compare(Students userA, Students userB) 
        {    
            return userA.Id - userB.Id;
        }
    }

/************************************************************************** */
    public static void main(String[] args) 
    {
        ArrayList<Students> studentRecord = new ArrayList<>();

        studentRecord.add(new Students(7794929, "Richmond"));
        studentRecord.add(new Students(3957194, "Julie"));
        studentRecord.add(new Students(9412625, "Lilas"));
        studentRecord.add(new Students(6385267, "Junjun"));

        System.out.println("Unsorted record: ");
        for(Students user : studentRecord)
        {
            user.printInfo();
            System.out.println();
        }

        System.out.println("************************************************************************************");
        studentRecord.sort(new sortByName());

        System.out.println("Sorted by name: ");
        for(Students user : studentRecord)
        {
            user.printInfo();
            System.out.println();
        }

        System.out.println("************************************************************************************");
        //studentRecord.sort(new sortById()); 
        Collections.sort(studentRecord, new sortById());

        System.out.println("Sorted by ID: ");
        for(Students user : studentRecord)
        {
            user.printInfo();
            System.out.println();
        }
    }    
}
