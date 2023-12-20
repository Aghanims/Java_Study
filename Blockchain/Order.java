package Blockchain;

/**
 * Enumaration of various traversals of the Merkle tree. 
 */
public enum Order
{
    /**
     * A depth-first-search traversal where the root node is the first to be scanned.
     */
    PREORDER, 
    /**
     * A depth-first-search traversal where the root node is the middle to be scanned.
     */
    INORDER, 
    /**
     * A depth-first-search traversal where the root node is the last to be scanned.
     */
    POSTORDER;
}
