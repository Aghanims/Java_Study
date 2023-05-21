package DataStructures.SelfStudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree 
{
    private TreeNode root;


/********************************************************************************** */
    private static class TreeNode
    {
        private int data; //can be generic type
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int data)
        {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }
/********************************************************************************** */

    public void iterativePrintPreOrder()
    {
        if(root == null) {return;}

        Stack<TreeNode> container = new Stack<>();

        container.push(root);
        while(!container.isEmpty())
        {
            TreeNode currentNode = container.pop();

            System.out.print(currentNode.data + " "); //can be any operation

            if(currentNode.rightNode != null)
                container.push(currentNode.rightNode);
            
            if(currentNode.leftNode != null)
                container.push(currentNode.leftNode);       
        }
    }

    public void printPreOrder(TreeNode root)
    {
        if(root == null)
            return;

        System.out.print(root.data + " ");

        printPreOrder(root.leftNode);
        printPreOrder(root.rightNode);     
    }
/******************************************************************************* */

    public void recursiveInorder(TreeNode root)
    {
        if(root == null) {return;}

        recursiveInorder(root.leftNode);
        System.out.print(root.data + " ");
        recursiveInorder(root.rightNode);
    }

    public void iterativeInorder()
    {
        if(root == null) {return;}

        Stack<TreeNode> container = new Stack<>();
        TreeNode currentNode = root;

        while(!container.isEmpty() ||  currentNode != null)
        {
            if(currentNode != null)
            {
                container.push(currentNode);
                currentNode = currentNode.leftNode;
            }
            else
            {
                currentNode = container.pop();
                System.out.println(currentNode.data + " ");
                currentNode = currentNode.rightNode;
            }
        }

    }
/************************************************************************************ */

    public void printPostOrder(TreeNode root)
    {
        if(root == null) {return;}

        printPostOrder(root.leftNode);
        printPostOrder(root.rightNode);
        
        System.out.print(root.data + " ");
    }

    public void levelOrder()
    {
        if(root == null) {return;}

        Queue<TreeNode> container = new LinkedList<>();

        container.offer(root);
        while(!container.isEmpty())
        {
            TreeNode currentNode = container.poll();

            System.out.print(currentNode.data + " ");

            if(currentNode.leftNode != null)  
                container.offer(currentNode.leftNode);
            
            if(currentNode.rightNode != null)
                container.offer(currentNode.rightNode);    
        }
    }

/************************************************************************************ */

    public int size()
    {
        return sizeUtil(root);
    }

    private int sizeUtil(TreeNode root)
    {
     //preorder traversal
        if(root == null)
            return 0;
        
        int rootCounter = 1;
        int leftSide = sizeUtil(root.leftNode);
        int rightSide = sizeUtil(root.rightNode);

        return rootCounter + leftSide + rightSide;
    }

    public int maxValue()
    {
        return maxValUtil(root);
    }

    private int maxValUtil(TreeNode root)
    {
        if(root == null) {return 0;}

        //Pre-Order traversal

        int maxVal = root.data;
        int leftChild = maxValUtil(root.leftNode);
        int rightChild = maxValUtil(root.rightNode);

        if(leftChild > maxVal)
            maxVal = leftChild;
        
        if(rightChild > maxVal)
            maxVal = rightChild;
        
        return maxVal;    
    }
/********************************************************************************* */
    /*
        Given the root of a binary tree, check wheter it is a mirror of itself
        (symmetric around its center.)
    */

    public boolean isSymmetric(TreeNode root)
    {
        Stack<TreeNode> container = new Stack<>();

        if(root == null) {return true;}

        //simultaneously iterate and compare the value of right data and left data to see if it's symmetric
        container.push(root.leftNode);
        container.push(root.rightNode);
        while(!container.isEmpty())
        {
            TreeNode rightNode = container.pop();
            TreeNode lefNode = container.pop();

            if(rightNode == null && lefNode == null) 
                continue; //there is not childNode beyond this so do not proceed pushing to stack

            if(rightNode == null || lefNode == null || rightNode.data != lefNode.data)
                return false;
            
            container.push(lefNode.leftNode);
            container.push(rightNode.rightNode);
            container.push(lefNode.rightNode);
            container.push(rightNode.leftNode);
        }
        return true;
    }


/********************************************************************************** */
    public static void main(String[] args) 
    {
        BinaryTree test = new BinaryTree();

        
        TreeNode first = new TreeNode(2); //root
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(10);
        TreeNode fourth = new TreeNode(69);
        TreeNode fifts = new TreeNode(99);
        test.root = first;

        first.leftNode = second;
        first.rightNode = third;
        second.leftNode = fourth;
        second.rightNode = null;
        third.leftNode = null;
        third.rightNode = fifts;
        
        System.out.println();
        System.out.println("Size: " + test.size());
        System.out.println("Max value: " + test.maxValue());
        System.out.print("PreOrder: " ); test.printPreOrder(first);
        System.out.println();
        System.out.print("Inorder: " ); test.recursiveInorder(first);
        System.out.println();
        System.out.print("PostOrder: "); test.printPostOrder(first);
        System.out.println();
        System.out.print("Level Order: "); test.levelOrder(); System.out.println();
        System.out.println("Symmetry test on first binary tree: " + test.isSymmetric(first));

        System.out.println();System.out.println();
/********************************************************************************************************* */

        BinaryTree symmetryTest = new BinaryTree();

        TreeNode symRoot = new TreeNode(1);
        TreeNode sym1 = new TreeNode(2);
        TreeNode sym2 = new TreeNode(2);
        TreeNode sym3 = new TreeNode(3);
        TreeNode sym4 = new TreeNode(3);
        symmetryTest.root = symRoot;

        symRoot.leftNode = sym1;
        symRoot.rightNode = sym2;
        sym1.leftNode = sym3;
        sym2.rightNode = sym4;

        System.out.println("Symmetry test on second Binary Tree: " + symmetryTest.isSymmetric(symRoot));


    }
}
