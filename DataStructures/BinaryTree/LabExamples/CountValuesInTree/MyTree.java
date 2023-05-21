package DataStructures.BinaryTree.LabExamples.CountValuesInTree;

public class MyTree 
{
    private TreeNode root;

    public MyTree()
    {
        root = null;
    }

    public void add(int data)
    {
        TreeNode newNode = new TreeNode(data);

        if(root==null)
        {
            root = newNode;
            return;
        }
        TreeNode temp = root;

        while(true)
        {
            if(newNode.getData()<temp.getData())
            {
                if(temp.getLeft()==null)
                {
                    temp.setLeft(newNode);
                    break;
                }
                temp = temp.getLeft();
            }
            else
            {
                if(temp.getRight()==null)
                {
                    temp.setRight(newNode);
                    break;
                }
                temp = temp.getRight();
            }
        }
    }

    public TreeNode getRoot()
    {
        return this.root;
    }
}
