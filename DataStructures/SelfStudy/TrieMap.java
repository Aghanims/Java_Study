package DataStructures.SelfStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieMap 
{
    TrieNode root = new TrieNode(' ');

/*********************************************************** */
    private static class TrieNode
    {
        HashMap<Character, TrieNode> children;
        char data;
        boolean endOfWord;

        public TrieNode(char data)
        {
            this.data = data;
            endOfWord = false;
            children = new HashMap<>();
        }
    }
/******************************************************************* */
    
/*
    To insert a word, first check wheter the word exist in the Trie so that we don't insert a duplicate. Then
    we loop through each character in the word; by creating a pointer of 'currentNode' and updating in each iteration.
    If the character is not in the node's children, a childNode is created. Then the node moves to the child node.
    When the node is at the last character of the word, we mark the node's "endOfWord" to be true;
*/
    public void insertWord(String word)
    {
        //chech for a duplicate
        if(search(word) == true)
        {
            System.out.println(word + " is already in the Trie");
            return;
        }
    
        //traverse the word by characters
        TrieNode currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);

            if(!currentNode.children.containsKey(currentChar))
            {
               TrieNode childNode = new TrieNode(currentChar); 
               currentNode.children.put(currentChar, childNode);

               currentNode = currentNode.children.get(currentChar);
            }
            else
                currentNode = currentNode.children.get(currentChar); 
        }
        currentNode.endOfWord = true;
    }

    public boolean search(String word)
    {
        TrieNode currentNode = root; //start at the beggining

        for(int i = 0; i < word.length(); i++) //iterate the entire word
        {   
            char currentChar = word.charAt(i);

            if(!currentNode.children.containsKey(currentChar))
                return false;
            else
                currentNode = currentNode.children.get(currentChar); //update the currentNode to traverse the trie
        }
        return currentNode.endOfWord;
    }

/*
    To delete a word from the Trie, first check wheter the word exists.If not, the method can return. The same as insert, 
    loop through each character in the word. A pointer node starts from the root node. If the character is not in the node's 
    children, the method returns directly. Otherwise, the node moves to the childNode. When the node is at the last character 
    of the word, mark the node's "endOfWord" to be false.
*/
    public void deleteWord(String word)
    {
        //check if the word exists
        if(search(word) == false)
        {
            System.out.println(word + " does not exists in the Trie");
            return;
        }

        //Loop through each character in the word
        TrieNode currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);

            if(!currentNode.children.containsKey(currentChar))
                return;
            else
                currentNode = currentNode.children.get(currentChar); //update the node iterator
        }
        currentNode.endOfWord = false; //We're no actually deleting the word but just making it "invisible"
    }

    public void print()
    {
        List<String> contcatenator = new ArrayList<String>();

        printUtil(root, contcatenator, "");

        System.out.println(contcatenator);
    }

    private void printUtil(TrieNode root, List<String> concat, String prefix)
    {
        if(root.endOfWord == true) //base case: already reached the end of the word and now just need to concatenate and place in the list
        {
            String word =  prefix + root.data;
            concat.add(word.substring(1)); //skip the char of the root
        }

        for(Character currentChar : root.children.keySet()) //search the chars of the prefix in the Trie
            printUtil(root.children.get(currentChar), concat, prefix + root.data);
    }


    public List<String> autocomplete(String prefix)
    {
        //approach:
        /*
            1. get the lastNode of the prefix
            2. treat the lastNode as the root and get all the words associated with it.
         */
        TrieNode currentNode = root;
        List<String> words = new ArrayList<>();

        for(int i = 0; i < prefix.length(); i++)
        {   
            //get the last node of the prefix
            char currentChar = prefix.charAt(i);

            if(currentNode.children.containsKey(currentChar))
                currentNode = currentNode.children.get(currentChar);
            else
                return words;       
        }

        getWords(currentNode, words, prefix.substring(0, prefix.length() - 1)); //pass in the entire prefix except the last index

        return words;
    }

    private void getWords(TrieNode root, List<String> concat, String prefix)
    {
       if(root.endOfWord == true)
       {
            String word = prefix + root.data;
            concat.add(word);
       } 

       for(Character currentChar : root.children.keySet())
            getWords(root.children.get(currentChar), concat, prefix + root.data);
       
    }


/*************************************************************** */
    public static void main(String[] args) 
    {
       TrieMap test = new TrieMap();

       test.insertWord("Richmond");
       test.insertWord("Ryan");
       test.insertWord("Richard");
       test.insertWord("Julie");
       test.insertWord("Zack");
       test.insertWord("Ramon");
       test.insertWord("Zardingan");

       test.print();
       System.out.println();

       String prefix = "R";
       List<String> autocomplete  = test.autocomplete(prefix);
     

       System.out.println("Words associated with " + prefix + ": ");
       for(String finish : autocomplete)
       {
            System.out.println(finish.toLowerCase());
       }
    }
}
