package DataStructures.SelfStudy.Problems;

import java.util.*;

public class PascalsTriangle 
{
    /* 
        Given an integer numRows, return the first numRows of Pascal's triangle.
        
        Example 1:
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]


        Example 2:
        Input: numRows = 1
        Output: [[1]]
    */
    public static List<List<Integer>> generatePascalsTriangle(int numRows)
    {
        /*
            numRows = 5

            1
            1   1
            1   2   1
            1   3   3   1
            1   4   6   4   1 

            observations:
                1. each rows starts and ends with 1
                2. every value at index 'i' except col[0] and col[size - 1] is the sum of prev[index - 1] and prevCol[index]
        */
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());

        //starting point ; the very top of the pyramid 
        triangle.get(0).add(1);

        //iterate the rows starting from index 1 and generate value for every column
        for(int row = 1; row < numRows; row++)
        {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(row - 1);

            curRow.add(1);
            for(int col = 1; col < prevRow.size(); col++)
                curRow.add(prevRow.get(col - 1) + prevRow.get(col));

            curRow.add(1);

            triangle.add(curRow);
        }

        return triangle;
    }

    public static void main(String[] args)
    {
        int numOfRows = 5;
        System.out.println(generatePascalsTriangle(numOfRows));
    }
}
