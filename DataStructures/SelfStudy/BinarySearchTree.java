package DataStructures.SelfStudy;

public class BinarySearchTree 
{
    private TreeNode root;

/******************************************************************************* */
    public static class TreeNode
    {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int data)
        {
            this.data = data;
        }
    }
/******************************************************************************** */

    public void insert(int value)
    {   
        TreeNode insertValue = new TreeNode(value);

        //base case
        if(root == null)
        {
            root = insertValue;
            return;
        }
        else
        {
            TreeNode currrentNode = root;

            while(currrentNode != null)
            {
                if(value < currrentNode.data)    
                {
                    if(currrentNode.leftChild == null)
                    {
                        currrentNode.leftChild = insertValue;
                        currrentNode = null;
                    }
                    else
                    {
                        currrentNode = currrentNode.leftChild;
                    }
                }
                else
                {
                    if(currrentNode.rightChild == null)
                    {
                        currrentNode.rightChild = insertValue;
                        currrentNode = null;
                    }
                    else
                    {
                        currrentNode = currrentNode.rightChild;
                    }
                }         
            }
        }
    }

    public boolean search(int value)
    {
        if(root == null)
        {
            return false;
        }

        TreeNode currentNode = root;
        
        while(currentNode != null)
        {
            if(currentNode.data == value)
                return true;

            else if(value < currentNode.data)
                currentNode = currentNode.leftChild; //traverse to the left child if value is less than the node
            
            else  //travers to the right if value is greater than the node
                currentNode = currentNode.rightChild;
        }

        return false;
    }

    public boolean remove(int value)
    {
        TreeNode parentNode = null;

        TreeNode currentNode = root;
        while(currentNode != null)
        {
            if(currentNode.data == value)
            {
                //3 cases of removal
                /*
                    *  currentNode has no child
                    *  currentNode has only 1 child
                    *  curreNode has 2 child
                 */

                //handling first case:
                if(currentNode.leftChild == null && currentNode.rightChild == null)
                {
                    if(parentNode == null) //node is the root
                        root = null;
                    else if(parentNode.rightChild == currentNode)        
                        parentNode.rightChild = null;
                    else
                        parentNode.leftChild = null;

                    return true;
                }

                //handling second case
                else if(currentNode.leftChild != null && currentNode.rightChild == null)
                {
                    if(parentNode == null) //root removal
                        root = null;
                    else if(parentNode.leftChild == currentNode)
                        parentNode.leftChild = currentNode.leftChild;
                    else
                        parentNode.rightChild = currentNode.leftChild;
                    
                    return true;
                }   
                else if(currentNode.leftChild == null && currentNode.rightChild != null)
                {
                    if(parentNode == null) //root removal
                        root = null;
                    else if(parentNode.rightChild == currentNode)
                        parentNode.rightChild = currentNode.rightChild;
                    else 
                        parentNode.rightChild = currentNode.rightChild;
                    
                    return true;
                }

                //handling third case
                else
                {
                    TreeNode successor = currentNode.rightChild; // least value (dig to currentNode.left) of the right subtree

                    while(successor.leftChild != null)
                    {
                        successor = successor.leftChild;
                    }

                    currentNode.data = successor.data; //swap the node to be removed to the successorNode
                    
                    //purpose: update the parent node and the currentNode so that another loop with occur to remove successor node
                    parentNode = currentNode;
                    currentNode = currentNode.rightChild;
                    value  = successor.data; //new loop will occur
                }

            }
            else if(value > currentNode.data)
            {
                //search the right of the tree while updating the parent node
                parentNode = currentNode;
                currentNode = currentNode.rightChild;
            }
            else
            {
                parentNode = currentNode;
                currentNode = currentNode.leftChild;
            }
        }

        return false;
    }

    public void printPreOrder(TreeNode root)
    {
        if(root == null)
            return;
        
        System.out.print(root.data + " "); 

        printPreOrder(root.leftChild);
        printPreOrder(root.rightChild);
    }

    public void printInOrder(TreeNode root)
    {
        if(root == null)
            return;

        printInOrder(root.leftChild);
        System.out.print(root.data + " ");
        printInOrder(root.rightChild);
    }

    public void printPostOrder(TreeNode root)
    {
        if(root == null)
            return;
        
        printPostOrder(root.leftChild);
        printPostOrder(root.rightChild);
        System.out.print(root.data + " ");
    }

/******************************************************************************** */
    public static void main(String[] args) 
    {
        
        BinarySearchTree test = new BinarySearchTree();

        test.insert(98);
        test.insert(56);
        test.insert(89);
        test.insert(101);
        test.insert(896);
        test.insert(47);
        test.insert(99);
        test.insert(1000);
        test.insert(46);
        test.insert(78);

        System.out.println(BSTPrint.treeToString(test.root));
        System.out.println("Value 101 is in the binary tree: " + test.search(101));
        System.out.println("Value 69 is in the binary tree: " + test.search(69));

        System.out.print("Print in pre-order traversal: ");
        test.printPreOrder(test.root);
        System.out.println();
        System.out.print("Print in In-Order traversal: ");
        test.printInOrder(test.root);
        System.out.println();
        System.out.print("Print in Post-Order traversal: ");
        test.printPostOrder(test.root);
    }

}
