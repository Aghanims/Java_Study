package DataStructures.Graphs.LabExamples;

import java.util.*;
import java.io.*;

public class ReadGraphFile 
{
    //my Version of ConnectedComponents counter
    public static void main(String[] args) 
    {

        String fileName = "D:/Coding/Richmond_Java/src/DataStructures/Graphs/LabExamples/NumOfComponent.txt";
        
        Scanner inputStream = null;

        try
        {
            inputStream = new Scanner(new File(fileName));  //read the file from txt
        }   
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(0);
        } 
//******************************************************************************************** */
        ArrayList<Integer> numOfVertex = new ArrayList<>(); //count number of vertex
        ArrayList<Edge> createEdge = new ArrayList<>();  //represents adjacent edges

        while(inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();

            String[] toDigit = line.trim().split("  ");

            int num1 = Integer.parseInt(toDigit[0]);
            int num2 = Integer.parseInt(toDigit[1]);

            if(!numOfVertex.contains(num1))
                numOfVertex.add(num1);
            if(!numOfVertex.contains(num2))
                numOfVertex.add(num2);

            Edge newEdge = new Edge(num1, num2);
            createEdge.add(newEdge);
        }

        
        numOfVertex.sort(Comparator.naturalOrder());
        int minNum = numOfVertex.get(0);
/* 
        System.out.println("Inside numOfVertex");
        for (Integer arrayList : numOfVertex) 
        {
            System.out.println(arrayList);

            
        }
        System.out.println("Min number" + numOfVertex.get(0));
*/
/*******************************************************************************************************/
        HashMap<Integer, ArrayList<Edge>> graphing = new HashMap<>();
        for(int i = 0; i < numOfVertex.size() + 1; i++)
        {
            graphing.put(i, new ArrayList<Edge>());
        }
        for (Edge edge : createEdge) 
        {
            Edge newEdge = new Edge(edge.fromVertex, edge.toVertex);
            Edge secondEdge = new Edge(edge.toVertex, edge.fromVertex);

            graphing.get(edge.fromVertex).add(newEdge);
            graphing.get(edge.toVertex).add(secondEdge);
        }


/* 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //create a graph

        for(int i = 0; i < numOfVertex.size() + 1; i++)
        {
            graph.add(new ArrayList<>()); //initialize object of arraylist  to accommodate the adjacent vertices
        }

        for (Edge edge : createEdge) //insert edges to the graph
        {
            graph.get(edge.fromVertex).add(edge.toVertex);
            graph.get(edge.fromVertex).add(edge.toVertex);
        }
*/
/**********************************************************************************************************/

        //iterate the graph to count number of connected components
        int numOfConnectedComponent = 0;

        //boolean[] isVisited = new boolean[numOfVertex.size() + 1]; 
        //Arrays.fill(isVisited, false);

        Queue<Integer> fronterQueue = new LinkedList<>();
        HashSet<Integer> discoveredSet = new HashSet<>();

        //BFS traversal
        for(int i = minNum; i <= numOfVertex.size() + 1; i++ )
        {
            if(discoveredSet.contains(i))
                continue;
            
            if(!numOfVertex.contains(i))
                continue;

            numOfConnectedComponent++;

            fronterQueue.add(i);
            discoveredSet.add(i);

            while(!fronterQueue.isEmpty())
            {
                int currentVertex = fronterQueue.remove();

                //System.out.println(currentVertex);

                for (Edge vertex : graphing.get(currentVertex))//int vertex : graph.get(currentVertex)
                {
                    int adjacent = vertex.toVertex;

                    if(!discoveredSet.contains(adjacent))
                    {
                        //isVisited[vertex] = true;
                        fronterQueue.add(vertex.toVertex);
                        discoveredSet.add(vertex.toVertex);
                    }    
                }
            }   
        }
        
        System.out.println("Number of connected components");
        System.out.println(numOfConnectedComponent);

        inputStream.close();
    }

    static class Edge
    {
        int fromVertex;
        int toVertex;

        public Edge(int fromVertex, int toVertex)
        {
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
        }
    }
}
