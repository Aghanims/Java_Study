package DataStructures.BinaryTree.LabExamples.BinaryExpressionTree;

import java.util.Stack;
import java.util.StringTokenizer;

public class BXT 
{
    /*

        Student tasks: implement tasks as specified in this file

        Note: BXT Represents a binary expression tree.
        BXT can build itself from a postorder expression.  
        It can evaluate and print itself. It also prints an inorder string and a preorder string.  
    */
   private TreeNode root;

   public BXT()
   {
      root = null;
   }
   public TreeNode getRoot()
   {
      return root;
   }
   
   //Postfix Example: 2 3 + 5 / 4 5 - *
   public void buildTree(String str)
   {
      // *** Student task ***  
      /* 
	     The argument string is in postfix notation. 
        Build the tree as specified in the document 
        *** Enter your code below ***
      */

      /* 
      Stack<TreeNode> tempContainer = new Stack<TreeNode>(); 
      TreeNode temp, firstOp, secondOp; 

      for (int i = 0; i < str.length(); i++) 
      { 
        

          // If charcter is operand, push into stack 
          if (!(isOperator(str.charAt(i)))) 
          { 
             String value = String.valueOf(str.charAt(i));

              temp = new TreeNode(value); 

              tempContainer.push(temp); 
          } 
          else // character is operator 
          { 
              String operator = String.valueOf(str.charAt(i));
              //temp = new TreeNode(operator); 

              // Pop two top nodes 
              // Store top 
              firstOp = tempContainer.pop();      // Remove top 
              secondOp = tempContainer.pop(); 

              //  make them children 
              TreeNode tree = new TreeNode(operator, secondOp, firstOp);
              
         
              // Add this subexpression to stack 
              tempContainer.push(tree); 


                  //  only element will be root of expression tree 
               temp = tempContainer.peek(); 
               tempContainer.pop(); 

               //root = temp;
               //return temp; 
          }
         */ 

         Stack<TreeNode> tempContainer = new Stack<TreeNode>(); 
         StringTokenizer token = new StringTokenizer(str);

         while(token.hasMoreTokens()) 
         { 
            String temp = token.nextToken(); 

            if(!(isOperator(temp))) //operand
            { 
               tempContainer.push(new TreeNode(temp)); 
            } 
            else //operation
            { 
               //pop operands 
               TreeNode tree1 = tempContainer.pop(); 
               TreeNode tree2 = tempContainer.pop(); 

               TreeNode tree = new TreeNode(temp, tree2, tree1); 

               tempContainer.push(tree); 
            } 
         } 
         root = tempContainer.pop();

         
   } 

      
   
   
   //utiliy method
   private double evaluateSubtree(TreeNode root) //recursion
   {

      if(root == null) //base case: invalid input
         return 0;

      // the leaves of a binary expression tree are operands
      if(root.getLeft() == null && root.getRight() == null)
        return Double.valueOf(root.getData()); //convert leaves(String) into double

      //recursively evaluate left and right child 
      double leftChild = evaluateSubtree(root.getLeft());
      double rightChild = evaluateSubtree(root.getRight());

      //apply the operator at the root to the values obtained in the previous step
      return calculateTerm(root.getData(), leftChild, rightChild);

   }

   public double evaluateTree()
   {
      /* 
	     Do this recursively.  If the node is an operator, recursively evaluate the left child 
        and the right child, and return the result.  Else the node is a number, so it can 
        be converted into a double, and returned. 
        *** Enter your code below ***
     */

     return evaluateSubtree(root);

   }

   //utility method
   private boolean isOperator(String c)
   {
      /* 
      if(c.equals('+') || c.equals('-' ) || c.equals('*' ) || c.equals('/') || c.equals('%'))
         return true;
      else 
         return false;
      */

      String str = "+-*/%";
         return str.contains(c);
   }
   

   //utiity method
   private double calculateTerm(String operator, double lefOperand, double rightOperand)
   {
      if(operator.equals("+"))
         return lefOperand + rightOperand;
      else if(operator.equals("-"))
         return lefOperand - rightOperand;
      else if(operator.equals("*"))
         return lefOperand * rightOperand;
      else if(operator.equals("/"))
         return lefOperand / rightOperand;   
      else
         return lefOperand % rightOperand;
   }
   
   private String concatInfix(TreeNode root) //<left><root><right>
   {
      if (root == null) 
         return "";

      StringBuilder combine = new StringBuilder();

      String leftChild = concatInfix(root.getLeft());
      combine.append(leftChild);

      combine.append(root.getData() + " ");

      String rightChild = concatInfix(root.getRight());
      combine.append(rightChild);

      return combine.toString();
   }
   
   public String infix()
   { 
      // *** Student task ***  
      /* S
	   Infix is characterized by the placement of operators between operands; 
        *** Enter your code below ***
     */
     
      return concatInfix(root);
   }

   private String concatprefix(TreeNode root) //<root><left><right>
   {
      if (root == null) 
         return "";

      StringBuilder combine = new StringBuilder();

      combine.append(root.getData() + " ");

      String leftChild = concatprefix(root.getLeft());
      combine.append(leftChild);

      String rightChild = concatprefix(root.getRight());
      combine.append(rightChild);

      return combine.toString();
   
   }
   
   public String prefix()
   {
      // *** Student task ***  
      /* 
	    Prefix expression notation requires that all operators precede the two operands that they work on; 
        *** Enter your code below ***
     */
     
     return concatprefix(root);
      
   }
   
   private String concatpostfix(TreeNode root) //<left><right><root>
   {

      if (root == null) 
      return "";

      StringBuilder combine = new StringBuilder();

      String leftChild = concatpostfix(root.getLeft()); //left
      combine.append(leftChild);

      String rightChild = concatpostfix(root.getRight()); //right
      combine.append(rightChild);

      combine.append(root.getData() + " "); //root

      return combine.toString();
   }

   public String postfix()
   {
      // *** Student task ***  
      /* 
	    Postfix requires that its operators come after the corresponding operands
        *** Enter your code below ***
     */
     return concatpostfix(root);
   }

}
