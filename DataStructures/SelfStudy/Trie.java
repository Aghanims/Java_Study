package DataStructures.SelfStudy;

import java.util.ArrayList;
import java.util.List;

public class Trie 
{
    //implemented using array

    private TrieNode root;

    public Trie()
    {
        root = new TrieNode(' ');
    }
    
/******************************************************************************** */
    private class TrieNode
    {
        private char data;
        private TrieNode[] children;
        private boolean endOfWord;

        public TrieNode(char data)
        {
            // 'a' character has a value of 97 
            // ("any char from a - z") - 'a' == the index of the char in the array 

            this.data = data;
            children = new TrieNode[128]; //can handle most ASCII chars
            endOfWord = false;
        }
    }
/******************************************************************************** */

/*
    To insert a word, first check whether the word is in the trie so that we don’t insert duplicate word. 
    Then we loop through each character in the word. A pointer node starts from the root node. 
    If the character is not in the node‘s children, a child node is created. Then the node moves to the child node. 
    When the node is at the last character of the word, we mark the node‘s isEnd to be true.
*/
    public void insertWord(String word) 
    {
        /* 
        if(word == null || word.isEmpty())
        {
            throw new Exception("Invalid Input");
        }
        */

        //already exist
        if(search(word) == true)
        {
            System.out.println(word + " is already in the Trie");
            return;
        }

        TrieNode currentNode = root;

        for(int i = 0; i < word.length(); i++) //iterate every char of the given word
        {
            char currentChar = word.charAt(i);
           
            //Case 1: if index in the TrieNode is empty or null; then create a new trieNode and assign currentNode into it
            if(currentNode.children[currentChar] == null)
            {
                TrieNode newNode = new TrieNode(currentChar);
                currentNode.children[currentChar] = newNode; //insert the newNode to the index (specific char) in the Trie
                currentNode = newNode; //update the currentNode
            }
            else //case 2: index is already occupied so we just need to update the currentNode and proceed.
            {
                currentNode = currentNode.children[currentChar];
            }         
        }
        currentNode.endOfWord = true; //implies that the whole word is in the structure
    }


/*
    To search a word in the trie, loop through each character in the word. A pointer node starts from the root node.
    If the character is not in the node's children, the method returns false. Otherwise, the node moves to the child node. 
    When the nod is at the last character of the word, return the node's endOfWord value, which can be true of false.
*/
    public boolean search(String word)
    {
        TrieNode currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);

            if(currentNode.children[currentChar] == null)
                return false; //no char exist means no such word in the trie
            else
            {
                //traverse until word.length if there such char.
                currentNode = currentNode.children[currentChar];
            }
        }
        return currentNode.endOfWord;
    }

/* 
    To delete a word from the trie, first check wheter the word exist in the trie. If not, the method can return.
    The same as insert, loop through each character in the word. A pointer node starts from the root node. If the 
    character is not in the node's children, the method returns directly. Otherwise, the node moves to the child node.
    When the node is at the last character of the word, mark the node's "endOfWord" to be false. The word is not actually 
    deleted from the Trie. It becomes invisible.
*/
    public void deleteWord(String word)
    {
        //check wheter the word exist
        if(search(word) == false)
        {
            System.out.println(word + " does exist in Trie");
            return;
        }

        //traverse the Trie; start from the root up to word.length
        TrieNode currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);
            
            //while traversing, check wheter the index of the TrieNode is not null and matches the char from the word.
            if(currentNode.children[currentChar] == null)
            {
                return; //return directly nothing if it not matches the char index in the children
            }
            else //moves to the next childNode if matches
            {
                currentNode = currentNode.children[currentChar];
            }
        }
        currentNode.endOfWord = false;  //At the end, mark the "endOfWord" to false;  
    }

/*
    Similar to DFS of the tree, recursion is used to travers all nodes in Trie. When visiting the node, the method concatenates with
    characters from previously visited nodes with the character of the current node. When the node's "endofWord" is true, the 
    recursion reaches the last character of the wor. Add the word to the result list.
*/
    public void print()
    {
        List<String> contactenator = new   ArrayList<>();

        printUtil(root, contactenator, "");

        System.out.println(contactenator);
    }

    private void printUtil(TrieNode root, List<String> res, String prefix)
    {
        if(root == null) //base condition; already traversed to the end of the Trie;
            return;
        
        //End of the word is found
        if(root.endOfWord == true)
        {
            String word = prefix + root.data;
            res.add(word.substring(1)); //skip the root index
        }

        for(TrieNode child : root.children)
        {
            printUtil(child, res, prefix + root.data);
        }
    }

/******************************************************************* */
    public static void main(String[] args) 
    {
        Trie test = new Trie();

        test.insertWord("Gwapo si Richmond");
        test.insertWord("Asa ka padulong");
        test.insertWord("Gwapo si Kent");

        System.out.println("Word Richmond is in the Trie: " + test.search("Richmond"));

        test.print();
    }
}
