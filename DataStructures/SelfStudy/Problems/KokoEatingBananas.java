package DataStructures.SelfStudy.Problems;

public class KokoEatingBananas 
{

    /*
        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
        The guards have gone and will come back in h hours.

        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and 
        eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will 
        not eat any more bananas during this hour.

        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

        Return the minimum integer k such that she can eat all the bananas within h hours.

        Example: 
            Input: piles = [3,6,7,11], h = 8
            Output: 4
    */
    public static int minEatingSpeed(int[] piles, int h)
    {
        //initialize the left and right boundaries
        int start = 1;
        int end = 1;    
        for(int pile : piles)
            end = Math.max(end, pile);

        while(start < end)
        {
            //get middle value between start and end
            int middle = (start + end) / 2;

            //hourSpent represents the total hour Koko spents
            int hourSpent = 0;

            for(int pile : piles)
                hourSpent += Math.ceil((double)pile / middle);

            //search for better results
            if(hourSpent <= h)
                end = middle;
            else
                start = middle + 1;
        }
        return end;

    }
    
/****************************************************************************************************************** */
    public static void main(String[] args) 
    {
        int[] piles = {3,6,7,11};
        int h = 8;

        int result = minEatingSpeed(piles, h);
        System.out.println(result);

        int[] test = {19, 17, 20, 15, 11, 11};
        int dueDate = 20;

        int result2 = minEatingSpeed(test, dueDate);
        System.out.println(result2);

    }
}
