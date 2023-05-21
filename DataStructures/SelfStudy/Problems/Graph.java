package DataStructures.SelfStudy.Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class Graph 
{
    
    private HashMap<Vertex, ArrayList<Edge>> fromEdges;
    private HashMap<Vertex, ArrayList<Edge>> toEdges;

    public Graph()
    {
        fromEdges = new HashMap<>();
        toEdges = new HashMap<>();
    }

    public Vertex addVertex(String label)
    {
        Vertex newVertex = new Vertex(label);

        fromEdges.put(newVertex, new ArrayList<>());
        toEdges.put(newVertex, new ArrayList<>());

        return newVertex;
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex)
    {
        return addDirectedEdge(fromVertex, toVertex, 1.0);
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight)
    {
        if(hasEdge(fromVertex, toVertex))
            return null; //edge already exist

        Edge newEdge = new Edge(fromVertex, toVertex, weight);

        fromEdges.get(fromVertex).add(newEdge);
        toEdges.get(toVertex).add(newEdge);
    
        return newEdge;
    }

    public Edge[] addUndirectedEdge(Vertex fromVertex, Vertex toVertex)
    {
        return addUndirectedEdge(fromVertex, toVertex, 1.0); //set 1.0 as a default weight
    }

    public Edge[] addUndirectedEdge(Vertex fromVertex, Vertex toVertex, double weight)
    {
        Edge edge1 = addDirectedEdge(fromVertex, toVertex, weight);
        Edge edge2 = addDirectedEdge(toVertex, fromVertex, weight);
        
        Edge[] result = {edge1, edge2};

        return result;
    }

/************************************************************* */
    private static class Vertex
    {
        String label;

        public Vertex(String label)
        {
            this.label = label;
        }
    }    

    private static class Edge
    {
        Vertex fromVertex;
        Vertex toVertex;
        double weight; 

        public Edge(Vertex fromVertex, Vertex toVertex, double weight)
        {
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
            this.weight = weight;
        }
    }
/************************************************************* */

    public boolean hasEdge(Vertex fromVertex, Vertex toVertex)
    {
        if(!fromEdges.containsKey(fromVertex))
            return false; //fromVertex does not exist in the graph
        
        ArrayList<Edge> ListOfEdges = fromEdges.get(fromVertex);
        for(Edge edges : ListOfEdges)
        {
            if(edges.toVertex == toVertex)
                return true;
        }
        return false;
    }

/****************************************************************** */

    //All about edge method

    public Collection<Edge> getEdges() 
    {
        HashSet<Edge> recordEdges = new HashSet<>();

        for(ArrayList<Edge> edgeList : fromEdges.values())
            recordEdges.addAll(edgeList);
        
        return recordEdges;
    }

    //could also return as "ArrayList<Edge>"
    public Collection<Edge> getEdgesFrom(Vertex fromVertex) 
    {
        return fromEdges.get(fromVertex);
    }

    public Collection<Edge> getEdgesTo(Vertex toVertex)
    {
        return toEdges.get(toVertex);
    }

/************************************************************************* */

    //All about Vertex methods

    public Collection<Vertex> getVertices()
    {
        return fromEdges.keySet();
    }

    //return a vertex from the given label
    public Vertex getVertex(String label)
    {
        for(Vertex vertex : getVertices())
        {
            if(vertex.label.equals(label))
                return vertex; 
        }
        return null;
    }

/************************************************************************* */

    public void BFS(Vertex startVertex)
    {
        HashSet<Vertex> visited = new HashSet<>();
        Queue<Vertex> frontierQueue = new LinkedList<Vertex>();

        frontierQueue.add(startVertex);
        visited.add(startVertex);

        while(!frontierQueue.isEmpty())
        {
            Vertex currentVertex = frontierQueue.poll();

            System.out.print(currentVertex.label + " ");

            for(Edge edges : fromEdges.get(currentVertex)) //traverse adjacent vertices
            {
                Vertex adjacentVertex = edges.toVertex;

                if(!visited.contains(adjacentVertex))
                {
                    frontierQueue.add(adjacentVertex);
                    visited.add(adjacentVertex);
                }
            }
        }
    }

    public void DFS(Vertex startVertex)
    {
        HashSet<Vertex> visited = new HashSet<>();
        Stack<Vertex> stackVertex = new Stack<>();

        stackVertex.add(startVertex);
        while(!stackVertex.isEmpty())
        {
            Vertex currentVertex = stackVertex.pop();

            if(!visited.contains(currentVertex))
            {
                visited.add(currentVertex);

                System.out.print(currentVertex.label + " ");

                for(Edge edges : fromEdges.get(currentVertex))
                {
                    Vertex adjacentVertex = edges.toVertex;
                    stackVertex.add(adjacentVertex);
                }
            }
        }
    }

/************************************************************************************* */

    public int connectedComponents()
    {
        int numOfComponents = 0;

        HashSet<Vertex> visited = new HashSet<>();

        for(Vertex vertex : fromEdges.keySet())
        {
            if(!visited.contains(vertex))
            {
                numOfComponents++;
                numOfComponentsUtil(vertex, visited);
            }
        }

        return numOfComponents;
    }
    
    private void numOfComponentsUtil(Vertex currentVertex, HashSet<Vertex> visited)
    {
        visited.add(currentVertex);

        for(Edge edges : fromEdges.get(currentVertex))
        {
            Vertex adjacentVertex = edges.toVertex;

            if(!visited.contains(adjacentVertex))
                numOfComponentsUtil(adjacentVertex, visited);
        }
    }

/************************************************************************* */
    public void recursiveDFS() 
    {
        HashSet<Vertex> visited = new HashSet<>();

        //this iteration considers the entire vertex; including connected components
        for(Vertex currentVertex : fromEdges.keySet()) 
        {
            if(!visited.contains(currentVertex))
                recursiveDFSUtil(currentVertex, visited);
        }
    }

    private void recursiveDFSUtil(Vertex currentVertex, HashSet<Vertex> visited)
    {
        visited.add(currentVertex);

        System.out.print(currentVertex.label + " ");

        for(Edge edges : fromEdges.get(currentVertex))
        {
            Vertex adjacentVertex = edges.toVertex;

            if(!visited.contains(adjacentVertex))
                recursiveDFSUtil(adjacentVertex, visited);
        }
    }

/******************************************************************** */
    public static void main(String[] args) 
    {
        Graph test = new Graph();

        Vertex Dipolog = test.addVertex("Dipolog");
        Vertex Dapitan = test.addVertex("Dapitan");
        Vertex Sindangan = test.addVertex("Sindangan");
        Vertex Manukan = test.addVertex("Manukan");
        Vertex Katipunan = test.addVertex("Katipunan");
        Vertex Liloy = test.addVertex("Liloy");

        Vertex NewYork = test.addVertex("New York");
        Vertex Boston = test.addVertex("Boston");

        test.addUndirectedEdge(Dipolog, Dapitan);
        test.addUndirectedEdge(Dipolog, Manukan);
        test.addUndirectedEdge(Sindangan, Manukan);
        test.addUndirectedEdge(Katipunan, Sindangan);
        test.addUndirectedEdge(Katipunan, Liloy);
        test.addUndirectedEdge(NewYork, Boston);

        for(Vertex vertex : test.getVertices())
        {
            System.out.println("Location that can travel from: " + vertex.label);

            //display places that can go from the current vertex
            for(Edge lugarNaMaadutan : test.getEdgesFrom(vertex))
                System.out.println(" --> " + lugarNaMaadutan.toVertex.label);
            
            System.out.println();
        }

        System.out.print("BFS print: ");
        test.BFS(Dipolog);
        System.out.println();
        System.out.print("BFS on different component: ");
        test.BFS(Boston);
        System.out.println();
        System.out.print("DFS print: ");
        test.DFS(Dipolog);
        System.out.println();
        System.out.println();
        System.out.print("Recursive DFS print: ");
        test.recursiveDFS();
        
        System.out.println();
        System.out.print("Total number of connected components: " + test.connectedComponents());
    }
}
