package DataStructures.SelfStudy.Problems;

import java.util.LinkedList;
import java.util.Comparator;

public class OverlappingIntervals 
{
    private LinkedList<Interval> intervalrecords = new LinkedList<>();

/****************************************************************** */
    private static class Interval
    {
        private int start;
        private int end;

        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
/****************************************************************** */

    public LinkedList<Interval> mergeOverlappingIntervals()
    {
        LinkedList<Interval> result = new LinkedList<>();

        if(intervalrecords.size() < 2) {return intervalrecords;} //either it contains only 1 or 0 intervals

        //sort in ascending order base on start interval
        intervalrecords.sort(new sortByStartInterval());

        //pull out the start and end interval of the first element to make base reference
        Interval firstIndex = intervalrecords.get(0);
        int start = firstIndex.start;
        int end = firstIndex.end;

        for(int i = 1; i < intervalrecords.size(); i++)
        {
            Interval currentInterval = intervalrecords.get(i);

            //start interval doesn't matter since they are sorted by their start interval
            if(currentInterval.start <= end)
                end = Math.max(currentInterval.end, end); 
            else
            {
                Interval newInterval = new Interval(start, end);
                result.add(newInterval);

                //this interval might have a possiblity to have an overlapped interval on another index
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }
        result.add(new Interval(start, end)); //add the last element interval

        intervalrecords = result; //newly modified record of intervals

        return result;
    }

    public void insertInterval(int start, int end)
    {   
        Interval newInterval = new Interval(start, end);
        intervalrecords.add(newInterval);

        mergeOverlappingIntervals();   
    }   

    private class sortByStartInterval implements Comparator<Interval>
    {

        @Override
        public int compare(Interval time1, Interval time2) 
        {
           return time1.start - time2.start;
        }
        
    }
/********************************************************************************************************************/ 
    /*
        Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the valid 
        position, merge all the overlapping intervals and return a list of mutually exclusive intervals.
    */
    public LinkedList<Interval> insertWithAlreadySortedInterval(Interval newInterval)
    {
        if(intervalrecords.isEmpty() || intervalrecords == null) {return intervalrecords;}

        LinkedList<Interval> result = new LinkedList<>();

        int i = 0;
        //loop for identifying the separation of interval.start from the left portion of the list
        while(i < intervalrecords.size() && intervalrecords.get(i).end < newInterval.start) 
        {
            result.add(intervalrecords.get(i));
            i++;
        }

        //while loop for overlapped intervals
        while(i < intervalrecords.size() && intervalrecords.get(i).start <= newInterval.end)
        {
            Interval currentInterval = intervalrecords.get(i);

            newInterval.start = Math.min(newInterval.start, currentInterval.start);
            newInterval.end = Math.max(newInterval.end, currentInterval.end);
            i++;
        }
        result.add(newInterval); //add the modified newInterval that handled overlapped interval to result list

        while(i < intervalrecords.size()) //loop for adding the rest of the list that is not overlapped
        {   
            result.add(intervalrecords.get(i));
            i++;
        }

        return result;
    }
    

/********************************************************************************************************************/ 
    public static void main(String[] args) 
    {
        OverlappingIntervals test = new OverlappingIntervals();

        test.insertInterval(2, 6);
        test.insertInterval(1, 3);
        test.insertInterval(8, 10);
        test.insertInterval(12, 15);
        test.insertInterval(13, 18);

        System.out.println("All inserted intervals with already merged overlapping interval: ");
        for (Interval interval : test.intervalrecords) 
        {
            System.out.print("[" + interval.start + "," + interval.end + "]  ");    
        }

        System.out.println();

        OverlappingIntervals test2 = new OverlappingIntervals();
        test2.intervalrecords.add(new Interval(0, 1));
        test2.intervalrecords.add(new Interval(3, 5));
        test2.intervalrecords.add(new Interval(6, 7));
        test2.intervalrecords.add(new Interval(9, 10));

        Interval dummy = new Interval(2, 6);
        for (Interval interval : test2.insertWithAlreadySortedInterval(dummy)) 
        {
            System.out.print("[" + interval.start + "," + interval.end + "]  ");
        }
    }
}
