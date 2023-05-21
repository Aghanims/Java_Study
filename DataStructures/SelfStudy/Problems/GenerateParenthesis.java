package DataStructures.SelfStudy.Problems;

import java.util.List;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParenthesis 
{

    /*
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        Example:
            Input: n = 3
            Output: ["((()))","(()())","(())()","()(())","()()()"]  
    */
    
    //global stack
    private Stack<Character> parenthesis = new Stack<>();
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n)
    {
        backTrack(0, 0, n);
        return result;
    }


    private void backTrack(int open, int close, int n)
    {
        //base case
        if(open == close && close == n)
        {
            String currentResult = "";

            Iterator value = parenthesis.iterator();
            while(value.hasNext())
                currentResult += value.next();      
            
            result.add(currentResult);
        }

        //case1: only add '(' no greater than n
        if(open < n)
        {
            parenthesis.push('(');
            backTrack(open + 1, close, n);
            parenthesis.pop(); //needed as the stack being used is global
        }

        //case2: only add ')' no greater than '('
        if(close < open)
        {
            parenthesis.push(')');
            backTrack(open, close + 1, n);
            parenthesis.pop();
        }
    }


/****************************************************************************************************************** */
    public static void main(String[] args) 
    {
        GenerateParenthesis test = new GenerateParenthesis();

        List<String> result = test.generateParenthesis(3);

        System.out.println(Arrays.toString(result.toArray()));
    }    
}
