package DataStructures.SelfStudy.Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph1
{
    private LinkedList<Integer>[] adjacent;
    public int numOfEdges;
    public int numOfVertex;

    public Graph1(int numOfVertex)
    {
        adjacent = new LinkedList[numOfVertex];
        numOfEdges = 0;
        this.numOfVertex = numOfVertex;

        for(int i = 0; i < numOfVertex; i++)
            adjacent[i] = new LinkedList<>(); 
    }

    public void addEdge(int fromVertex, int toVertex)
    {
        adjacent[fromVertex].add(toVertex);
        adjacent[toVertex].add(fromVertex);
        numOfEdges++;
    }
    
    public void BFS(int startVertex)
    {
        boolean[] visited = new boolean[numOfVertex];
        Arrays.fill(visited, false); //populate the array with false value

        Queue<Integer> frontierQueue = new LinkedList<>();

        frontierQueue.offer(startVertex);
        visited[startVertex] = true;

        while(!frontierQueue.isEmpty())
        {
            int currentVertex = frontierQueue.poll();
            System.out.print(currentVertex + " ");

            for(Integer edges : adjacent[currentVertex])
            {
                if(!visited[edges])
                {
                    visited[edges] = true;
                    frontierQueue.offer(edges);
                }
            }
        }
    }


    public void DFS(int startVertex)
    {
        boolean[] visited = new boolean[numOfVertex];
        Arrays.fill(visited, false);

        Stack<Integer> vertexStack = new Stack<>();

        vertexStack.push(startVertex);
        while(!vertexStack.isEmpty())
        {
            int currentVertex = vertexStack.pop();

            if(!visited[currentVertex])
            {
                visited[currentVertex] = true;

                System.out.print(currentVertex + " ");

                for(Integer edges : adjacent[currentVertex])
                {
                   vertexStack.push(edges);
                }
            }
        }

    }

/********************************************************************** */
    //recursive DFS
    public void RecursiveDFS()
    {
        boolean[] visitor = new boolean[numOfVertex];
        Arrays.fill(visitor, false); //populate visitor array with false

        for(int i = 0; i < numOfVertex; i++)
        {
            if(!visitor[i]) //if the current vertex is not visited
                RecursiveDFSUtil(i, visitor);
        }
    }

    public void RecursiveDFSUtil(int currentVertex, boolean[] visitor)
    {
        visitor[currentVertex] = true;

        System.out.print(currentVertex + " ");

        for(Integer edges : adjacent[currentVertex])
        {
            if(!visitor[edges]) //recursion until adjacent vertex is visited
              RecursiveDFSUtil(edges, visitor);
        }
    }

/************************************************************* */
    public void diplayGraph()
    {
        for(int i = 0; i < numOfVertex; i++)
        {
            System.out.print(i + " --> ");

            for(Integer edges : adjacent[i])
            {
                System.out.print(edges + " ");
            }
            System.out.println();
        }
    }


/********************************************************* */

    public static void main(String[] args) 
    {
        Graph1 test = new Graph1(8);

        test.addEdge(0, 5);
        test.addEdge(1, 3);
        test.addEdge(4, 1);
        test.addEdge(5, 3);
        test.addEdge(2, 0);
        test.addEdge(6, 1);
        test.addEdge(2, 6);
        test.addEdge(5, 6);

        test.diplayGraph();

        System.out.print("BFS print: ");
        test.BFS(5);

        System.out.println();

        System.out.print("DFS print: ");
        test.DFS(5);

        System.out.println();

        System.out.print("DFS recursion: ");
        test.RecursiveDFS();
    }
}
