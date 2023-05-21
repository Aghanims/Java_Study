package ClassNotes;
import java.util.ArrayList;

public class Temp 
{
    public static void main(String[] args)
    {
        ArrayList<Integer> nums;
        nums = new ArrayList<Integer>();

        nums.add(74);
        nums.add(11);
        nums.add(21);
        nums.add(59);
        nums.add(0, 11);
        nums.set(1, 59);

        System.out.println(nums.size());
        System.out.println(nums.get(0));
        System.out.println(nums.toString());

        /*
        Both outputs on line represents the array size, however unlike the normal array, 
        we manually instantiated the length of the array and set values according to that length, whereas in ArrayList,
          we just need to put the value on each variable by using the method add(), and the size will automatically update.
        
        */
    }
}
