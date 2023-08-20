import java.util.Stack;

public class TreeTest 
{
    TreeNode root;

    public TreeTest(int rootValue)
    {
        this.root = new TreeNode(rootValue);
    }

/****************************************** */
    public class TreeNode
    {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value)
        {
            this.value = value;
        }
    }
/****************************************** */

    /*
        Definition of a binary search tree:
        
            * all left subtree have lesser values than its parent node
            * all right subtree have greater values than its parent node

                6
            4       8
          3   5   7   10
    */


    public void insert(int value)
    {
        TreeNode newNode = new TreeNode(value);

        if(root == null)
        {
            root = newNode;
            return;
        }

        TreeNode currNode = root;
        while(currNode != null)
        {
            if(value < currNode.value)
            {
                if(currNode.left == null)
                {
                    currNode.left = newNode;
                    currNode = null; //eliminate the loop
                }
                else 
                    currNode = currNode.left;
            }
            else if(value > currNode.value)
            {
                if(currNode.right == null)
                {
                    currNode.right = newNode;
                    currNode = null;
                }
                else 
                    currNode = currNode.right;
            }
        }
    }

    public boolean contains(int value)
    {
        if(root == null) {return false;}

        TreeNode currNode = root;
        while(currNode != null)
        {
            if(value < currNode.value)
                currNode = currNode.left;
            else if(value > currNode.value)
                currNode = currNode.right;
            else // if value == currNode.value
                return true;
        }

        return false;
    }

    public void remove(int data)
    {   
        if(root.value == data) 
        {
            root = null;
            return;
        }

        TreeNode parentNode = null;
        TreeNode currNode = root;
        while(currNode != null)
        {
            /*
                Cases: for removing a node:
                    -   if node has zero children; then directly point parentNode.left or parentNode.right = null
                    -   if node has one child; then point parentNode right or left to child of the curreNode
                    -   If not has 2 children; then we need to find a successor (left most child of the right subtree) ans swap to currNode
            */
            if(currNode.value == data)
            {
                //First case:
                if(currNode.left == null && currNode.right == null)
                {   
                    if(parentNode.left == currNode)
                        parentNode.left = null;
                    else if(parentNode.right == currNode)
                        parentNode.right = null;

                    return;
                }

                //Second case:
                else if(currNode.left == null && currNode.right != null)
                {
                    if(parentNode.left == currNode)
                        parentNode.left = currNode.right;
                    else if(parentNode.right == currNode)
                        parentNode.right = currNode.right;
                    
                    return;
                }
                else if(currNode.left != null && currNode.right == null)
                {
                    if(parentNode.left == currNode)
                        parentNode.left = currNode.left;
                    else if(parentNode.right == currNode)
                        parentNode.right = currNode.left;

                    return;
                }

                //Third case:
                else
                {
                    TreeNode successor = currNode.right;

                    while(successor.left != null)
                        successor = successor.left;                  

                    currNode.value = successor.value;

                    parentNode = currNode;
                    currNode = currNode.right;
                    data = successor.value;
                }

            }
            else if(data < currNode.value)
            {
                parentNode = currNode;
                currNode = currNode.left;
            }
            else // value > currNode.value
            {
                parentNode = currNode;
                currNode = currNode.right;
            }
        }
    }

    public void printPreOrder()
    {
        Stack<TreeNode> buffer = new Stack<>();

        buffer.push(root);
        while(!buffer.isEmpty())
        {
            TreeNode curNode = buffer.pop();

            System.out.print(curNode.value + " ");

            if(curNode.right != null)
                buffer.push(curNode.right);
            
            if(curNode.left != null)
                buffer.push(curNode.left);
        }
    }

    public void printInOrder()
    {

    }

    public void printPostOrder()
    {

    }

    public void printLevelOrder()
    {

    }

    public static void main(String[] args) 
    {
        TreeTest test = new TreeTest(6);

        test.insert(4);
        test.insert(50);
        test.insert(12);
        test.insert(5);
        test.insert(100);

        test.printPreOrder();
        System.out.println();

        test.remove(50);
        test.printPreOrder();


        System.out.println("\n" + test.contains(5));
        System.out.println(test.contains(20));
        
    }
}
