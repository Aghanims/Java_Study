package DataStructures.BinaryTree.LabExamples.MyIntBST;

/**
*
*
* MyIntBSTTree.txt: the template file of MyIntBSTTree.java
* Student tasks: implement tasks #1 and #2 as specified in this file
*/

import java.util.*;

public class MyIntBSTTree
{  
   private Node root;
   
   public MyIntBSTTree()
   {
      root=null;
   }
   
   public int height()
   {
      // *** Student task ***  
      /* Requirements: 
        The height of a binary tree is the largest number of edges in a path from the root node to a leaf node. 
        Essentially, it is the height of the root node. Note that if a tree has only one node, then that node 
        is at the same time the root node and the only leaf node, so the height of the tree is 0, similary, 
        the height of a tree with only two nodes is 1. Implement this method to return height of the tree

       *** Enter your code below *** 
     */
      return countHeight(getRoot());
      
   }
   
   private int countHeight(Node root) //utility
   {
      if(root == null)
         return -1;
      
      int leftHeight = countHeight(root.getLeft()); //find height of the left child
      int rightHeight = countHeight(root.getRight()); // find height of the right child
      
      int biggerNum; 
      
      if(leftHeight >= rightHeight )
         biggerNum = leftHeight;
      else
         biggerNum = rightHeight;
         
         
      return biggerNum + 1; // additional one is needed to accomodate the root node
   }
   
   private int comparisonTraversal(Node root, Node beingCompared) //utility
   {
      //count number of comparsisons

      if(root == null)
         return 0;
         
      int count = 1; //start by comparing the root node
      int leftChild = 0;
      int rightChild = 0;
      
      if(beingCompared.getData() < root.getData())
         leftChild = comparisonTraversal(root.getLeft(), beingCompared);
      
      if(beingCompared.getData() > root.getData())
         rightChild = comparisonTraversal(root.getRight(), beingCompared);
          
      return leftChild + rightChild + count;
   }
   
  
   public int comparisons(Node node)
   {
      // *** Student task ***  
      /* Requirements: 
        Count and return how many comparisons performed to search for the argument node

       *** Enter your code below *** 
     */
     
      return comparisonTraversal(root, node);
   }
   
   private int valComparisonTraversal(Node root, int comparedValue)
   {
      if(root == null)
         return 0;
      
      int counter = 1;
      int leftChild = 0;
      int rightChild = 0;
      
      if(comparedValue < root.getData())
         leftChild = valComparisonTraversal(root.getLeft(), comparedValue);
      
      if(comparedValue > root.getData())
         rightChild = valComparisonTraversal(root.getRight(), comparedValue);
      
      return leftChild + rightChild + counter;
   }
   
   public int comparisons(int val)
   {

      // *** Student task ***  
      /* Requirements: 
       Overloaded method - Count and return how many comparisons performed to search for the node whose data equals the argument val.

       *** Enter your code below *** 
     */
      
      return valComparisonTraversal(root, val);
   }
   
   
   private Node rootFinder(ArrayList<Node> tree, int start, int end)//utility
   {
      /*
         balanced BST has a balance factor of <=1
      */
      
      if(start > end)
         return null;
         
      //divide the array into two; mid index will be the root
      int root = start + (end -start) / 2;  
      
      Node currentNode = tree.get(root);
      
      //recursively assign left side of the array as the left child; and right side for the right child
      Node leftChild = rootFinder(tree, start, root-1);
      currentNode.setLeft(leftChild);
      
      Node rightChild = rootFinder(tree, root+1, end);
      currentNode.setRight(rightChild);
      
      
      return currentNode; 
   }
   
   private void buildATree(Node root, ArrayList<Node> tree)
   {
      if(root == null)
         return;
      
      buildATree(root.getLeft(), tree);
      tree.add(root);
      buildATree(root.getRight(), tree);
   }
   
   public MyIntBSTTree buildBalancedTree()
   {
     
     // *** Student task ***  
      /* Requirements: 
         This method builds a balanced tree with values from the int arr and returns the new tree.
         The original tree remains unchanged after calling this method.
       *** Enter your code below *** 
     */
   
      ArrayList<Node> container = new ArrayList<Node>();
      buildATree(root, container); //stroring the values in the tree to the ArrayList
      
      //retrieving number of elements
      int numOfElements = container.size();
      
      MyIntBSTTree balancedTree = new MyIntBSTTree(); //creating object for the new balanced tree
      balancedTree.setRoot(rootFinder(container, 0, numOfElements-1));
      
      return balancedTree;
   }
   
   public void setRoot(Node node)
   {
      root = node;
   }

   public MyIntBSTTree buildWorstTree()
   {
     
     // *** Student task ***  
      /* Requirements: 
         Build and return a tree whose height is arr.length - 1
         The original tree remains unchanged after calling this method.
       *** Enter your code below *** 
     */
      
      ArrayList<Node> container = new ArrayList<>(); //for storing values from the tree
      buildATree(root, container); //store tree values to the container
      
      int numOfElements = container.size();
      
      MyIntBSTTree worstTree = new MyIntBSTTree();
      for(int i = 0; i < numOfElements; i++)
      {
         worstTree.add(container.get(i).getData());
      }
      
      return worstTree;
   }

   
   // **** DO NOT MODIFY CODE BEYOND THIS POINT ***
   public Node getRoot()
   {
      return root;
   }
   public void add(int data) {
       root = addHelper(root, data);
   }

   private Node addHelper(Node node, int data) 
   {//add node helper
       if (node == null)
       {
          node = new Node(data);
       }
       else if (data <= node.getData()){
           node.setLeft(addHelper(node.getLeft(), data));
       }
       else
       {
           node.setRight(addHelper(node.getRight(), data));//System.out.println(data);
       }
       return node;
   }
 
}

