package DataStructures.BinaryTree.LabExamples.BinaryExpressionTree;

/*
   TreeNode.java: TreeNode class.
*/

public class TreeNode implements NodeInterface<String>
   {
      private String value; 
      private TreeNode left, right;
   
      public TreeNode(String initValue)
      { 
         value = initValue; 
         left = null; 
         right = null; 
      }
   
      public TreeNode(String initValue, TreeNode initLeft, TreeNode initRight)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
      }
   
      public String getData()
      { 
         return value; 
      }
   
      public TreeNode getLeft() 
      { 
         return left; 
      }
   
      public TreeNode getRight() 
      { 
         return right; 
      }
   
      public void setValue(String theNewValue) 
      { 
         value = theNewValue; 
      }
   
      public void setLeft(TreeNode theNewLeft) 
      { 
         left = theNewLeft;
      }
   
      public void setRight(TreeNode theNewRight)
      { 
         right = theNewRight;
      }
   }
