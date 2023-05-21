package DataStructures.SelfStudy;

public class Search2DMatrix 
{   
    /*
        You are given an m x n integer matrix with the following two properties:

        - Each row is sorted in non-decreasing order.
        - The first integer of each row is greater than the last integer of the previous row.

        Given an integer target, return true if target is in matrix or false otherwise.
        You must write a solution in O(log(m * n)) time complexity. 

        Example
            Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
            Output: true
    */
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int row = 0;
        int column = matrix[0].length - 1;

        while(row < matrix.length && column >= 0)
        {
            if(target > matrix[row][column])
                row++;
            else if(target < matrix[row][column])
                column--;
            else
                return true;
        }
        return false;
    }

/******************************************************************************************************************** */
    public static void main(String[] args) 
    {
        int[][] test =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; 
        int target = 10;

        System.out.println(searchMatrix(test, target));
    }
}
