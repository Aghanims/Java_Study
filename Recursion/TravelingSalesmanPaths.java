package Recursion;

import java.util.ArrayList;

public class TravelingSalesmanPaths {
   public static final int NUM_CITIES = 3;                                // Number of cities
   public static int[][] cityDistances = new int[NUM_CITIES][NUM_CITIES]; // Distance between cities
   public static String[] cityNames = new String[NUM_CITIES];             // City names

   /* Output every possible travel path. 
      Each recursive call moves to a new city.
   */
   public static void travelPaths(ArrayList<Integer> currPath, 
                                  ArrayList<Integer> needToVisit) {
      int totalDist;     // Total distance given current path
      int tmpCity;       // Next city distance
      int i;             // Loop index

      if ( currPath.size() == NUM_CITIES ) { // Base case: Visited all cities
         totalDist = 0;                      // Return total path distance
         for (i = 0; i < currPath.size(); ++i) {
            System.out.print(cityNames[currPath.get(i)] + "   ");

            if (i > 0) {
               totalDist += cityDistances[currPath.get(i - 1)][currPath.get(i)];
            }
         }

         System.out.println("= " + totalDist);
      }
      else {                                 // Recursive case: pick next city
         for (i = 0; i < needToVisit.size(); ++i) {
            // add city to travel path
            tmpCity = needToVisit.get(i);
            needToVisit.remove(i);
            currPath.add(tmpCity);

            travelPaths(currPath, needToVisit);

            // remove city from travel path
            needToVisit.add(i, tmpCity);
            currPath.remove(currPath.size() - 1);
         }
      }
   }   
   
   public static void main (String[] args) {
      ArrayList<Integer> needToVisit = new ArrayList<Integer>(); // Cities left to visit
      ArrayList<Integer> currPath = new ArrayList<Integer>();    // Current path traveled
      
      // Initialize distances array
      cityDistances[0][0] = 0;
      cityDistances[0][1] = 960;  // Boston-Chicago
      cityDistances[0][2] = 2960; // Boston-Los Angeles
      cityDistances[1][0] = 960;  // Chicago-Boston
      cityDistances[1][1] = 0;
      cityDistances[1][2] = 2011; // Chicago-Los Angeles
      cityDistances[2][0] = 2960; // Los Angeles-Boston
      cityDistances[2][1] = 2011; // Los Angeles-Chicago
      cityDistances[2][2] = 0;
      
      cityNames[0] = "Boston";
      cityNames[1] = "Chicago";
      cityNames[2] = "Los Angeles";
      
      needToVisit.add(0); // Boston
      needToVisit.add(1); // Chicago
      needToVisit.add(2); // Los Angeles
      
      // Explore different paths   
      travelPaths(currPath, needToVisit);
   }
}
