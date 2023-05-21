package DataStructures.SelfStudy.AdjacencyListGraph;

public class Edges 
{
    public Vertex fromVertex;
    public Vertex toVertex;
    public double weight;

    public Edges(Vertex fromVertex, Vertex  toVertex, double weight)
    {   
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }
}
