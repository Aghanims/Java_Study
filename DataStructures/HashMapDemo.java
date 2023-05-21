package DataStructures;

import java.util.HashMap;

public class HashMapDemo 
{
    public static void main(String[] args) 
    {
        HashMap<String, Integer> mountains = new HashMap<>();    

        mountains.put("Everest", 29029);
        mountains.put("K2", 28251);
        mountains.put("Kangchenjunga", 28169);
        mountains.put("Pinatubo", 20335);

        printMap(mountains);

        System.out.println("Pinatubo in the map: " + mountains.containsKey("Pinatubo"));
        System.out.println();
        System.out.println("Changing height of Pinatubo");
        mountains.put("Pinatubo", 20320); //overwrites  the old value for Denali.

        printMap(mountains);

        System.out.println("Removing Kangchenjunga");
        mountains.remove("Kangchenjunga");
        printMap(mountains);
        
    }

    public static void printMap(HashMap<String, Integer> map)
    {
        System.out.println("Map contains: ");
        for(String keyMountainName: map.keySet())
        {
            Integer height = map.get(keyMountainName);

            System.out.println(keyMountainName + " --> " + height.intValue() + " feet.");
        }
        System.out.println();
    }
}
