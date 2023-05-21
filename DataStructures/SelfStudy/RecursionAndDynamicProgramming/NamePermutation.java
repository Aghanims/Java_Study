package DataStructures.SelfStudy.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class NamePermutation 
{

    public static void printNameCombinations(ArrayList<String> permList, ArrayList<String> nameList)
    {
        if(nameList.isEmpty())
        {
            for(int i = 0; i < permList.size(); i++)
            {
                System.out.print(permList.get(i));

                if(i < permList.size() - 1)
                    System.out.print(", ");     
            }
            System.out.println();
        }
        else
        {
            for(int i = 0; i < nameList.size(); i++)
            {
                ArrayList<String> tempPermList = new ArrayList<>(permList);
                tempPermList.add(nameList.get(i));

                ArrayList<String> tempNameList = new ArrayList<>(nameList);
                tempNameList.remove(nameList.get(i));

                printNameCombinations(tempPermList, tempNameList);
            }
        }
    }

/*************************************************************/
    public static void main(String[] args) 
    {
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> combinationList = new ArrayList<>();

        Scanner nameInput = new Scanner(System.in);
        String name;

        while(true)
        {
            name = nameInput.nextLine();

            if(name.equals("-1"))
                break;
            
            nameList.add(name);
        }

        printNameCombinations(combinationList, nameList);

        nameInput.close();
    }    
}
