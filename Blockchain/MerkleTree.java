package Blockchain;

import java.util.Iterator;

/**
 * Program for fast verification of transaction.
 */
public class MerkleTree
{
    /**
     * Nested class that represents as a string node of the tree from a hashed transaction.
     * 
     * @param <T> is the type of data of a node. This node will be used to contain information of a transaction.
     */
    private static class Node<T extends Comparable<T>> implements Comparable<Node<T>>
    {
        /**
         * Data of the node. For the Merkle tree, the data is exlusive for Transaction.
         */
        private T data;

        /**
         * Left child of the current node.
         */
        private Node<T> left;

        /**
         * Right child of the current node.
         */
        private Node<T> right;

        /**
         * Utilized for building the binary search tree.
         */
        private int dummyHolder;

        /**
         * Constructor that sets a specified dummy value and everything else to null.
         * 
         * @param dummyValue for building the initial binary tree.
         */
        public Node(int dummyValue)
        {
            data = null;
            left = null;
            right = null;
            this.dummyHolder = dummyValue;
        }

        @Override
        public int compareTo(Node<T> o) 
        {
            return data.compareTo(o.data);
        }
    }    


    /**
     * The root of the tree.
     */
    private Node<String> root;

    /**
     * The distance from root to the furthest leaf node.
     */
    private int treeHeight;

    /**
     * The total number of inner nodes (nodes that have atleast 1 children).
     */
    private int innerNodesTotal;

    /**
     * Structure an inverted binary tree where each transaction of the block wil be represented as a node of the tree.
     * 
     * @param block is the Block that the Merkle Tree will be created for.
     */
    public MerkleTree(Block block)
    {
        //Generate a list of dummy that serves as a placeholder for the binary search tree.
        int totalNumOfNodes = 0;
        if((Math.log(block.numOfTransactions()) / Math.log(2)) == (int)(Math.log(block.numOfTransactions()) / Math.log(2)))
            totalNumOfNodes = (2 * block.numOfTransactions()) - 1;
        else 
        {
            int leafCount = (int) Math.pow(2, (int)Math.ceil(Math.log(block.numOfTransactions()) / Math.log(2)));
            totalNumOfNodes = (2 * leafCount) - 1;
        }

        SinglyLinkedList<Integer> dummyValues = new SinglyLinkedList<>();
        for(int i = 0; i < totalNumOfNodes; i++)
            dummyValues.add(i + 1);
 

        //Build a dummy tree.
        root = buildATree(dummyValues, 0, dummyValues.size() - 1);

        //Generate the cryptographic hash of all Transaction contained in the block and store them in the array.
        Iterator<Transaction> iterator = block.iterator();
        SinglyLinkedList<String> hashes = new SinglyLinkedList<>();
        while(iterator.hasNext())
        {
            String hashValue = Utilities.cryptographicHashFunction(iterator.next().toString());  
            hashes.add(hashValue);
        }

        //If the number of hashes is not a power 2, then append dummy nodes such that the overall element is now then a power of 2.
        if((Math.log(hashes.size() / Math.log(2)) != (int)(Math.log(hashes.size()) / Math.log(2))))
        {
            int nextPower = (int)Math.ceil(Math.log(hashes.size()) / Math.log(2));
            int numToAppend = ((int)Math.pow(2, nextPower)) - hashes.size();

            while(numToAppend > 0)
            {
                hashes.add(Utilities.cryptographicHashFunction("DUMMY"));
                numToAppend--;
            }
        }

        //Load all cyptographic hashes from transactions into the leaves of the tree.
        //The height of the tree is simultaneously recorded with addLeafHash();
        //Create a node pass it in to addLeafHash(). Make use of dummyHolder variable to record number of inner nodes.
        Node<String> innerNodeCounter = new Node<>(0);
        treeHeight = addLeafHash(root, hashes, innerNodeCounter) - 1;
        innerNodesTotal = innerNodeCounter.dummyHolder;

        //Build a chain of cryptographic hashes using the leaves all the way up to the root.
        //Insert all newly added hashes to BFS list.
        buildHashChain(root);

        //Send the hash of the root back to the block.
        block.setRootHash(root.data);
    }

    /**
     * Determine the distance from the root to the furthest leaf.
     * 
     * @return the height of the tree.
     */
    public int height()
    {
        return treeHeight;
    }

    /**
     * Determines the total number of nodes that has atleast 1 children (nodes that is not a leaf).
     * 
     * @return the number of inner nodes in the tree.
     */
    public int innerNodes()
    {
        return innerNodesTotal;
    }

    /**
     * Gives a list of the nodes of the Merkle tree in level-order fashion.
     * 
     * @return a list of the hash codes contained in the tree by walking the tree in a level-order.
     */
    public SinglyLinkedList<String> breadthFirstTraversal()
    {
        SinglyLinkedList<Node<String>> queue = new SinglyLinkedList<>();
        SinglyLinkedList<String> breadthList = new SinglyLinkedList<>();

        addLevelOrderNode(root, queue, breadthList);

        return breadthList;
    }

    /**
     * Load all the nodes contained in the Merkle tree where the order of nodes is dependent on the specified order.
     * 
     * @param order is an enumeration representing the three possible depth-first traversals.
     * @return a list of the hash codes contained in the tree by walking the tree in a certain order.
     */
    public SinglyLinkedList<String> depthFirstTraversal(Order order)
    {
        SinglyLinkedList<String> result = new SinglyLinkedList<>();

        if(order == Order.PREORDER)
            preOrder(root, result);
        else if(order == Order.INORDER)
            inOrder(root, result);
        else 
            postOrder(root, result);

        return result;
    }

    /**
     * Retrieve all necessary proof hashes in order to verify a transaction exists in a block.
     * 
     * @param t is the transaction to be proven.
     * @return a list of the hash codes that are required to prove that a transaction is contained in the block that this Merkle Tree encodes.
     *     The root hash code must NOT be added to this list because it's already stored inside each Block.
     */
    public SinglyLinkedList<String> extractProof(Transaction t)
    {
        String hashVal = Utilities.cryptographicHashFunction(t.toString());
        
        Node<String> dummyRoot = root;

        SinglyLinkedList<String> proofs = new SinglyLinkedList<>();
        addProofs(dummyRoot, proofs, hashVal);

        return proofs;
    }

    /**
     * Add all the necessary hashes to the specified list of proofs in order to validate that the specified transaction exists in the block.
     * 
     * @param dummyRoot is a copy of the root of the Merkle tree that holds all the chains of nodes.
     * @param proofs is the list where the necesarry proofs wil be added.
     * @param validate is the hash of the transaction.
     */
    private void addProofs(Node<String> dummyRoot, SinglyLinkedList<String> proofs, String validate)
    {
        if(dummyRoot == null)
            return;
            
        addProofs(dummyRoot.left, proofs, validate);
        addProofs(dummyRoot.right, proofs, validate);

        if(dummyRoot.left != null && dummyRoot.left.data.equals(validate))
        {
            proofs.add(dummyRoot.right.data);
            dummyRoot.data = validate;
        }
        else if(dummyRoot.right != null && dummyRoot.right.data.equals(validate))
        {
            proofs.add(dummyRoot.left.data);
            dummyRoot.data = validate;
        }
    }

    /**
     * Add all nodes form the Merkle tree to the specified list in preorder travseral fashion.
     * 
     * @param root of the Merkle tree.
     * @param list to be loaded with nodes from the Merkle tree.
     */
    private void preOrder(Node<String> root, SinglyLinkedList<String> list)
    {
        if(root == null)
            return;

        list.add(root.data);

        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * Load all nodes in the Merkle tree to the specified list in inorder traversal fashion.
     * 
     * @param root of the Merkle tree.
     * @param list to be loaded with nodes from the Merkle tree.
     */
    private void inOrder(Node<String> root, SinglyLinkedList<String> list)
    {
        if(root == null)
            return;

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    /**
     * Add all nodes in the Merkle tree to the specified list in post-order travsersal fashion.
     * 
     * @param root of the Merkle tree.
     * @param list to be loaded with nodes from the Merkle tree.
     */
    private void postOrder(Node<String> root, SinglyLinkedList<String> list)
    {
        if(root == null)
            return;
        
        postOrder(root.left, list);
        postOrder(root.right, list);

        list.add(root.data);
    }
    
    /**
     * Add all of the initial transaction from the block to the leaves of the tree while also keeping track of the inner nodes. 
     * 
     * @param root is the head of the tree that holds all the nodes together.
     * @param hashes is the list that contains all the hashes of each transsaction in the block.
     * @param innerNodeCounter is utilized to record the number of inner nodes in the tree.
     * @return The number of inner nodes in the Merkle tree.
     */
    private int addLeafHash(Node<String> root, SinglyLinkedList<String> hashes, Node<String> innerNodeCounter)
    {
        if(root == null)
            return 0;

        //If the current node has atleast 1 chilren, then it is an inner node (inner node ++)
        if(root.left != null || root.right != null)
            innerNodeCounter.dummyHolder += 1;
        
        //If a leaf node is found, then place the cryptographic hash.
        if(root.left == null && root.right == null)
            root.data = hashes.remove(0);

        int leftHeight = addLeafHash(root.left, hashes, innerNodeCounter);
        int rightHeight = addLeafHash(root.right, hashes, innerNodeCounter);

        //While adding hashes on leaf, simultaneously record the height.
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Builds a tree by initializing it in the memory.
     * 
     * @param dummyValues is the list of dummy number that is used for creating the binary tree.
     * @param start is left boundary to be used for determining the left subtree.
     * @param end is the right boundary to used for identifying the right subtree.
     * @return A node of the tree.
     */
    private Node<String> buildATree(SinglyLinkedList<Integer> dummyValues, int start, int end)
    {
        if(start > end)
            return null;

        int midIndex = (start + end) / 2;

        Integer newVal = dummyValues.get(midIndex);
        Node<String> newRoot = new Node<String>(newVal);

        newRoot.left = buildATree(dummyValues, start, midIndex - 1);
        newRoot.right = buildATree(dummyValues, midIndex + 1, end);
        return newRoot;
    }

    /**
     * Using the leaf nodes, continue XOR-ing all the child nodes to the top of the tree (root).
     * 
     * @param root is the head of the Merkle tree.
     * @return A string that represents an XOR value of two Strings from the children.
     */
    private String buildHashChain(Node<String> root)
    {
        if(root == null)
            return null;

        //Leaf node
        if(root.left == null && root.right == null)
            return root.data; 

        String left = buildHashChain(root.left);
        String right = buildHashChain(root.right);

        //Store the XOR hash value to the current root.
        root.data = Utilities.cryptographicHashFunction(left, right);

        return Utilities.cryptographicHashFunction(left, right);   
    }

    /**
     * Helper method for loading all nodes level-by-level in the breadthList.
     * 
     * @param root of the Merkle tree.
     * @param queue is the buffer for node access in each level.
     * @param breadthList is the list to be laoded and modified with nodes from the Merkle tree.
     */
    private void addLevelOrderNode(Node<String> root, SinglyLinkedList<Node<String>> queue, SinglyLinkedList<String> breadthList)
    {
        if(root.left != null)
            queue.add(root.left);

        if(root.right != null)
            queue.add(root.right);

        breadthList.add(root.data);

        if(queue.isEmpty())
            return;   

        addLevelOrderNode(queue.remove(0), queue, breadthList);
    }

    /**
     * Main method for debugging purposes.
     * 
     * @param args command line not in used.
     */
    public static void main(String[] args) 
    {
        Transaction transac1 = new Transaction("Bhoxz", "Jolan", 200, 9);
        Transaction transac2 = new Transaction("Richmond", "Eunice", 900, 5);
        Transaction transac3 = new Transaction("Aghanims", "REaper", 200, 4);
        Transaction transac4 = new Transaction("Galan", "Balor", 678, 2);
        Transaction transac5 = new Transaction("Rachel", "Galan", 123, 1);
        
        Block test = new Block();
        test.addTransaction(transac1);
        test.addTransaction(transac2);
        test.addTransaction(transac3);
        test.addTransaction(transac4);
        test.addTransaction(transac5);

        MerkleTree test1 = new MerkleTree(test);

        System.out.println("Dummy hash: " + Utilities.cryptographicHashFunction("DUMMY"));
        System.out.println(test1.height());
        System.out.println(test1.innerNodes());
        System.out.println();   

        System.out.println();

        Order order = Order.PREORDER;
        System.out.println("DFS traversal: " + order);
        SinglyLinkedList<String> depthSearch = test1.depthFirstTraversal(order);
        for (String node : depthSearch) 
            System.out.println(node); 

        System.out.println();

        // System.out.println("BFS travseral: ");
        // SinglyLinkedList<String> list = test1.breadthFirstTraversal();
        // Iterator<String> loop = list.iterator();
        // while(loop.hasNext())
        // {
        //     System.out.println(loop.next());
        // }

        System.out.println("Extract proof: ");
        SinglyLinkedList<String> isProven = test1.extractProof(transac3);
        for (String string : isProven) 
        {
            System.out.println(string);    
        }

        System.out.println();
      
        boolean proofTest = Utilities.verifyTransaction(transac3, isProven, test.getRootHash());
        System.out.println(proofTest);
        
    }

}
