package DataStructures.SelfStudy.Problems;

import java.util.Stack;

public class ParenthesisChecker 
{

    public static boolean isValid(String string)
    {
        Stack<Character> container = new Stack<>();

        for(int i = 0; i < string.length(); i++) 
        {
            char ch = string.charAt(i);

            if(ch == '{' || ch == '[' || ch == '(') 
            {
                container.push(ch); //push all opening of a parenthesis Like  "{ [ ( ) ] }"
            }
            else if(ch == '}' || ch == ']' || ch == ')') //compare the open and close parens if it matches; return false if not
            {
                if(container.isEmpty())
                    return false; // return false because no open paren detected
                
                char openParens = container.pop(); // get the open parens element from the stack to be compared

                if(!(openParens == '(' && ch == ')' 
                    || openParens == '{' && ch == '}'
                    || openParens == '[' && ch == ']'))
                {
                    return false; // not matched
                }
            }
        }

        return container.size() == 0;
    }



/************************************************************** */
    public static void main(String[] args) 
    {   
        String test = "{()}";

        System.out.println(isValid(test));
    }    
}
