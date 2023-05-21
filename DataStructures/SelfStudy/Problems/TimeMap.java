package DataStructures.SelfStudy.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap 
{

    /*
        Design a time-based key-value data structure that can store multiple values for the same key at different time 
        stamps and retrieve the key's value at a certain timestamp.

        Implement the TimeMap class:

        - TimeMap() Initializes the object of the data structure.
        - void set(String key, String value, int timestamp) Stores the key key with the value value at the given time 
            timestamp.
        - String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
    */
    private static class Pair
    {
        public String value;
        public int timeStamp;
        
        public Pair(String value, int timeStamp)
        {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private HashMap<String, List<Pair>> map = new HashMap<>();
    
    public TimeMap()
    {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timeStamp)
    {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());

        map.get(key).add(new Pair(value, timeStamp));
    }

    public String get(String key, int timeStamp)
    {
        if(!map.containsKey(key))
            return "";

        List<Pair> list = map.get(key);

        return  binarySearch(list, timeStamp);
    }

    private String binarySearch(List<Pair> list, int timeStamp)
    {
        int start = 0;
        int end = list.size() - 1;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            if(list.get(mid).timeStamp == timeStamp)
                return list.get(mid).value;
            else if(list.get(mid).timeStamp >= timeStamp)
                end = mid - 1;
            else
                start = mid + 1;
        }   
        return "";
    }
    
/**************************************************************************************************************** */
    public static void main(String[] args) 
    {
        TimeMap test = new TimeMap();

        test.set("foo", "Richmond", 1);
        test.set("foo", "Lina", 4);  
        test.set("foo", "Marci", 9);
        test.set("foo", "Maiden", 10);
        test.set("ree", "Clint", 1);

        String result = test.get("ree", 1);
        System.out.println(result);
    }   
}
