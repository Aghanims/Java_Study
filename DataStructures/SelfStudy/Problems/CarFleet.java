package DataStructures.SelfStudy.Problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet 
{

/*
    There are n cars going to the same destination along a one-lane road. The destination is target miles away.

    You are given two integer array position and speed, both of length n, where position[i] is the position of the 
    ith car and speed[i] is the speed of the ith car (in miles per hour).

    A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. 
    The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored 
    (i.e., they are assumed to have the same position).

    A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car 
    is also a car fleet.

    If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

    Return the number of car fleets that will arrive at the destination.

 
    Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
    Output: 3
    Explanation:
        The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
        The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
        The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. 
        The fleet moves at speed 1 until it reaches target.
        Note that no other cars meet these fleets before the destination, so the answer is 3.

        [10 8][0][5 3]
*/
private static class Elements
{
    public int position;
    public int speed;

    public Elements(int position, int speed)
    {
        this.position = position;
        this.speed = speed;
    }
}

public static int carFleet(int target, int[] position, int[] speed)
{
    if(position.length == 1) return 1;

    Stack<Double> timeContainer = new Stack<>();

    //create array that combines position and speed into ordered pairs
    Elements[] combine = new Elements[position.length];
    for(int i = 0; i < position.length; i++)
        combine[i] = new Elements(position[i], speed[i]);

    //sort array in ascending order base on position
    Arrays.sort(combine, (x, y) -> x.position - y.position);
    //Comparator.comparingInt(element -> element.position

    for(int i = position.length - 1; i >= 0; i--)
    {
        double currentTime = (double) (target - combine[i].position) / combine[i].speed;

        if(!timeContainer.isEmpty() && currentTime <= timeContainer.peek())
            continue;    
        else
            timeContainer.push(currentTime);   
    }
    
    return timeContainer.size();
}

/********************************************************************************************************************** */
    public static void main(String[] args) 
    {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        int result = carFleet(12, position, speed);
        System.out.println("Number of carfleet(s): " + result);
    }    
}
