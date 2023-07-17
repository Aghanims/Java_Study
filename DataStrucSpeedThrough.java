import java.util.ArrayList;

public class DataStrucSpeedThrough 
{
    
    public static void main(String[] args) 
    {
            // ArrayList<String> studyArrayList = new ArrayList<>();    
        // studyArrayList.add("Virginia"); //Add element to the end of the list - append
        // studyArrayList.add(3, "Washington"); //Add element to the specified index in the list
        // studyArrayList.clear(); // remove all elements from the list
        // studyArrayList.get(2); //returns the value of the specified index in the list
        // studyArrayList.remove(2); // remove and element with the specified index from the list
        // studyArrayList.contains("Virginia"); // returns a boolean if an element exists in the list
        // studyArrayList.size(); // returns the number of elements in the list
        // studyArrayList.set(3, "Texas");
        // studyArrayList.isEmpty();

        /********************************************************** */
        String name = "Bhoxz:Aghanims:Hymen";

        char[] formal = name.toCharArray();
        formal[2] = 'a';

        String newName = new String(formal);
        System.out.println(newName);

        System.out.println(name.length());
        name.toUpperCase();
        name.equals("Bhoxz");
        
        String[] separate = name.split(":");
        for(String content : separate)
        {
            System.out.format("Name: %s\n",content);
        }
      


        
    }
}
