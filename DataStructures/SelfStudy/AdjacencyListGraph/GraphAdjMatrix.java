package DataStructures.SelfStudy.AdjacencyListGraph;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class GraphAdjMatrix 
{
  
    private HashMap<Vertex, ArrayList<Edges>> fromEdges;
    private HashMap<Vertex, ArrayList<Edges>> toEdges;

    public GraphAdjMatrix()
    {
        fromEdges = new HashMap<Vertex, ArrayList<Edges>>();
        toEdges =  new HashMap<Vertex, ArrayList<Edges>>();
    }

    public Vertex addVertex(String vertexLabel)
    {
        Vertex newVertex = new Vertex(vertexLabel);

        fromEdges.put(newVertex, new ArrayList<Edges>());
        toEdges.put(newVertex, new ArrayList<Edges>());

        return newVertex;
    }

    public boolean hasEdge(Vertex fromVertex, Vertex toVertex)
    {
        if(!fromEdges.containsKey(fromVertex))
            return false; //fromVertex is not in the graph

        ArrayList<Edges> edges = fromEdges.get(fromVertex);
        for(Edges edge: edges) //search the specified index if it contains its partner toVertex
        {
            if(edge.toVertex == toVertex)
                return true;
            
        }
        return false;
    }

    public Edges addDirectedEdge(Vertex fromVertex, Vertex toVertex)
    {
        return addDirectedEdge(fromVertex, toVertex, 1.0); //default weight
    }

    public Edges addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight)
    {
        if(!hasEdge(fromVertex, toVertex))
            return null;
        
        Edges newEdge = new Edges(fromVertex, toVertex, weight);

        fromEdges.get(fromVertex).add(newEdge);
        toEdges.get(toVertex).add(newEdge);
    
        return newEdge;
    }

    public Edges[] addUndirectedEdge(Vertex fromVertex, Vertex toVertex) 
    {
        return addUndirectedEdge(fromVertex, toVertex, 1.0);
    }

    public Edges[] addUndirectedEdge(Vertex fromVertex, Vertex toVertex, double weight)
    {
        //adding connection to the edge of fromEdges & toEdges.
        Edges edge1 = addDirectedEdge(fromVertex, toVertex, weight);
        Edges edge2 = addDirectedEdge(toVertex, fromVertex, weight); 
        Edges[] result = {edge1 , edge2};

        return result;
    }

    public Collection<Edges> getEdges()
    {
        HashSet<Edges> edges = new HashSet<>();
        
        for(ArrayList<Edges> edgesList : fromEdges.values())
            edges.addAll(edgesList);
        
        return edges;
    }

    public Collection<Edges> getEdgesFrom(Vertex fromVertex)
    {
        return fromEdges.get(fromVertex);
    }

    public Collection<Edges> getEdgesTo(Vertex toVertex)
    {
        return toEdges.get(toVertex);
    }
    
    public Collection<Vertex> getVertices()
    {
        return fromEdges.keySet();
    }

    public Vertex getVertex(String label)
    {
        for(Vertex vertex : getVertices())
        {
            if(vertex.label.equals(label))  
                return vertex;
        
        }
        return null;
    }



/*************************************************************************************** */
    public static void main(String[] args) 
    {
        GraphAdjMatrix test = new GraphAdjMatrix();
        
        Vertex one  = test.addVertex("Richmond");
        Vertex two  = test.addVertex("John");
        Vertex three = test.addVertex("Rhea");
    
        test.addUndirectedEdge(two, three);
        test.addUndirectedEdge(one, three);

        System.out.println("Names:");
        for(Vertex vertex : test.getVertices())
        {
           System.out.print(vertex.label + " ->> ");

           for(Edges outgoingEdge : test.getEdgesTo(vertex))
                System.out.print(outgoingEdge.fromVertex.label + " ");

           System.out.println();
        }   
   
    }

}
