package DataStructures.BinaryTree.LabExamples.CountValuesInTree;

class Main
{

    private static int helper(TreeNode node, int val) //utility
    {
        //If node is null, return 0;
        if(node==null)
            return 0;

        //If this node is greater than the val, add 1
        //int ans = node.getData()>val?1:0;
        int ans = 0;
        if(node.getData() >= val)
           ans++;
        else
            ans = ans + 0;

        //Count of nodes greater than val in left and right subtrees
        int lefty = helper(node.getLeft(),val);
        int righty = helper(node.getRight(),val);

        //Return the total answer
        return ans+lefty+righty;
    }

    public static int countAboveBenchmark(MyTree mt, int val)
    {
        //If tree is null, return 0
        if(mt == null)
            return 0;

        //Invoke the recursive helper function
        return helper(mt.getRoot(),val);
    }

    public static int countLeaf(TreeNode root)
    {
        if(root  == null)
            return 0;

        int counter = 0;
        if(root.getLeft() == null && root.getRight() == null) //leaf nodes has no le
        {
            counter++;
        }

        int leftChild = countLeaf(root.getLeft());
        int rightChild = countLeaf(root.getRight());

        return counter + leftChild + rightChild;
    }

    public static void main(String[] args) 
    {
        int benchMark = 4;

        MyTree mt = new MyTree();
        mt.add(100);
        mt.add(3);
        mt.add(15);
        mt.add(0);
        mt.add(-12);
        mt.add(24);

        System.out.println(BSTPrint.treeToString(mt.getRoot()));
        System.out.println();

        System.out.println("Values greater than " + benchMark + ": " + countAboveBenchmark(mt, benchMark));      
        System.out.println("Number of Leaf Nodes: " + countLeaf(mt.getRoot()));
    }
}
