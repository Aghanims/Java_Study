package DataStructures.Graphs.LabExamples;

import java.util.*;
import java.io.*;


public class CountCmpnts 
{  
   public static int countConnectedComponents(String fileName)
   {
      //read file from txt
      Scanner inputStream = null;
      
      try
      {
         inputStream = new Scanner(new File(fileName));
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }

      //store the values into an Edge object
      ArrayList<Edge> createEdge = new ArrayList<>();
      ArrayList<Integer> numOfVertex = new ArrayList<>(); //count number of vertices on the graph

      while(inputStream.hasNextLine())
      {
         String line = inputStream.nextLine();
                                                   //important portion
        String[] toDigit = line.trim().split("\\s+"); //store line into a temporary container

         int fromVertex = Integer.parseInt(toDigit[0]);
         int toVertex = Integer.parseInt(toDigit[1]);

         Edge newEdge = new Edge(fromVertex, toVertex);
         createEdge.add(newEdge);

         //store each vertices
         if(!numOfVertex.contains(fromVertex))
            numOfVertex.add(fromVertex);
         if(!numOfVertex.contains(toVertex))
            numOfVertex.add(toVertex);
      }
    
      numOfVertex.sort(Comparator.naturalOrder()); //Arrange the vertices in ascending order
      int minVertex = numOfVertex.get(0); 

   /****************************************************************************************************/

      //create graph from stored edges
      HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
      for(int i = 0; i < numOfVertex.size() + 1; i++)
      {
         graph.put(i, new ArrayList<Edge>()); //initialize new Arralist object of Edge
      }
      for (Edge edge : createEdge) 
      {
         Edge firstEdge = new Edge(edge.fromVertex, edge.toVertex);
         Edge secondEdge = new Edge(edge.toVertex, edge.fromVertex);
         
         graph.get(edge.fromVertex).add(firstEdge);
         graph.get(edge.toVertex).add(secondEdge);
      }
   
/*********************************************************************************************************/
      
      //Count number of connected components
      int numOfConnectedComponent = 0;

      Queue<Integer> frontierQueue = new LinkedList<>();
      HashSet<Integer> isVisited = new HashSet<>();

      //BFS traversal
      for(int i = minVertex; i <= numOfVertex.size() + 1; i++)
      {
         if(isVisited.contains(i))  //skip iteration if already visited
            continue;

         if(!numOfVertex.contains(i)) //skip iteration if index value is not on numOfVertex
            continue;
         
         numOfConnectedComponent++;

         frontierQueue.add(i);
         isVisited.add(i);

         while(!frontierQueue.isEmpty())
         {
            int currentVertex = frontierQueue.remove();

            for (Edge vertex : graph.get(currentVertex)) 
            {
               int adjacent = vertex.toVertex;

               if(!isVisited.contains(adjacent))
               {
                  frontierQueue.add(adjacent);
                  isVisited.add(adjacent);
               }
            }
         }

      }
      inputStream.close();
      return numOfConnectedComponent;
   }
   static class Edge
   {
      public int fromVertex;
      public int toVertex;
      
      public Edge(int fromVertex, int toVertex)
      {
         this.fromVertex = fromVertex;
         this.toVertex = toVertex;
      }
   }
   

   public static void main(String[] args) 
   {
        String fileName = "D:/Coding/Richmond_Java/src/DataStructures/Graphs/LabExamples/NumOfComponent.txt"; 

        int ans = countConnectedComponents(fileName);

        System.out.println(ans);

      
   }
}

