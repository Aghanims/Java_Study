package DataStructures.SelfStudy.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduler 
{
    /*
        There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
        You are given an array prerequisites where prerequisites[i] = [a(subi), b(subi)] indicates that you must take course b(subi) first if you 
        want to take course a(subi).

        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
        Return true if you can finish all courses. Otherwise, return false.

        Example 1:

        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0. So it is possible.
        Example 2:

        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.  
    */

    public static boolean canFinish(int courses, int[][] prerequisites)
    {
        /*
            Idea: Use topological sort to verify if its possible to finish all courses (no cycle)
            Algo: 
                - Have the graph ready
                - retrieve the value that has 0 inDegrees (0 vertex that's pointing it)
                - Use BFS or DFS to to start the sort process
        */

        //Create a Directed Graph where Prerequisites(fromVertex) are pointign to Courses(toVertex)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //Magnitude of vertex are pointer per vertex
        int[] inDegrees = new int[courses];

        //Containing all vertices that are sorted topologically.
        List<Integer> topologicalSortResult = new ArrayList<>();

        //create object and initialize
        for(int i = 0; i < courses; i++)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            //each pair is an edge
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            //map the pair on the graph
            adj.get(prerequisite).add(course);

            //record all vertices that have indegree
            inDegrees[course]++;
        }

        Queue<Integer> hasNotIndegree = new LinkedList<>();
        for(int i = 0; i < inDegrees.length; i++)
        {
            int currVertexDegree = inDegrees[i];
            if(currVertexDegree == 0)
                hasNotIndegree.offer(i); //place vertex with not degree to queue to start immediately
        }

        while(!hasNotIndegree.isEmpty())
        {
            int currentVertex = hasNotIndegree.poll();
            
            topologicalSortResult.add(currentVertex);

            for(Integer nextVertex : adj.get(currentVertex))
            {
                inDegrees[nextVertex]--;
                if(inDegrees[nextVertex] == 0)
                    hasNotIndegree.offer(nextVertex);
            }
        }

        return topologicalSortResult.size() == courses;
    }

    public static void main(String[] args) 
    {
        int numCourse = 2;
        int[][] prerequisites = {{1, 0}};

        boolean result = canFinish(numCourse, prerequisites);
        System.out.println(result);
    }
}
