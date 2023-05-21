package DataStructures.Graphs.LabExamples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CountingComponents 
{

	public static int countConnectedComponents(String fileName) throws IOException
	{
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		
		// Files.readAllLines -> To read a text file line by line into a List

		ArrayList<Pair> edges = new ArrayList<>(); // It will store all the edges
		int n = 0;                             
		// n = number of nodes
		// n will be the max node value present in the input 
		for(String s : lines)
		{
			 String strs[] = s.trim().split(" ");
			 // It split the complete String into individual String which are seprated by " "
			 
			 int u = Integer.parseInt(strs[0]);
			 int v = Integer.parseInt(strs[1]);
			 // u,v implies there is an edge between node u and node v
			 n = Math.max(n,u);
			 n = Math.max(n,v);
			 edges.add(new Pair(u,v));
		}

		//list that represents a graph
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		// For each node it will store all nodes connected to it
		for(int i = 0; i <= n; i++)
		{
			list.add(new ArrayList<Integer>()); //add object in each vertex
		}
		for(Pair p : edges)
		{
			list.get(p.x).add(p.y);
			list.get(p.y).add(p.x);
		}

		boolean visited[] = new boolean[n+1];
		// It is an array which tells whether node is visited or not
		int count = 0;   // count of total number of connected component;
		Arrays.fill(visited,false);

		for(int v = 1; v <= n; v++)
		{  
			if(visited[v]) //skip iteration for those already visited vertex
				continue;

			count += 1;

			//BFS
			visited[v] = true;
			Queue<Integer> queue = new LinkedList<>(); //frontierQueue
			queue.add(v);
			while (!queue.isEmpty()) 
			{
				int num = queue.remove();
				
				for(Integer node : list.get(num)) //iterate adjacent node of each vertex
				{

					//normal operation procedure

					if(!visited[node])
					{
						visited[node] = true;
						queue.add(node);
					}
				}
			}
		}
		return count;
	}

	static class Pair
	{    // This is a Pair class
		int x;
		int y;
		Pair(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}



	public static void main(String[] args)throws IOException
	{ 
		String file = "D:/Coding/Richmond_Java/src/DataStructures/Graphs/abExamples/NumOfComponent.txt";  // This is a random file name
		int ans = 	countConnectedComponents(file);

		System.out.println(ans);
	}

}
