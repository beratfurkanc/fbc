package com.apptium.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class deneme {
     static int finalDistance = 0;
    public static void main(String[] args) {
       int numRow=3;
       int numColums=3;



        List<List<Integer>> area = new ArrayList<>();
        area.add(new ArrayList<>());
        area.add(new ArrayList<>());
        area.add(new ArrayList<>());

        area.get(0).add(1);

        area.get(0).add(0);

        area.get(0).add(0);
        area.get(1).add(1);

        area.get(1).add(0);

        area.get(1).add(0);
        area.get(2).add(1);

        area.get(2).add(9);

        area.get(2).add(1);

        System.out.println(minimumDistance(3,3,area));

    }

     public static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area){



        boolean [][] visited = new boolean[numRows][numColumns];

        int distance=0;

        if(Helper(numRows, numColumns, area, visited, 0, 0, distance)){
            return finalDistance;
        }
        else
        {
            // no path found.
            return 0;
        }
     }

     public static boolean Helper(int numRows, int numColumns, List<List<Integer>> area, boolean[][] visited, int currentRow, int currentColumn, int distance)
     {

         if (currentRow < 0 || currentColumn < 0 || currentRow >= numRows || currentColumn >= numColumns)
         {
             return false;
         }

         // check if this cell is already visited
         if (visited[currentRow][ currentColumn])
         {
             return false;
         }

         // check if the value at cell is 0 i.e. no further path
         if (area.get(numRows-1).get(numColumns-1) == 0)
         {
             return false;
         }

         // if the value is 9 i.e. the destination.
         // Found the destination, return true
         if (area.get(numRows).get(numColumns) == 9)
         {
             return true;
         }

         // This means, current cell is not visited yet and it has the value 1 i.e. path
         // this is 1 step forward toward the destination.

         // increase the distance by 1.
         distance++;

         // mark current cell as visited so that we dont come on the same cell again.
         visited[currentRow][ currentColumn] = true;

         // Go for "Breadth Firth Search" in all four direction.
         if (Helper(numRows, numColumns, area, visited, currentRow++, currentColumn, distance) ||
                 Helper(numRows, numColumns, area, visited, currentRow--, currentColumn, distance) ||
                 Helper(numRows, numColumns, area, visited, currentRow, currentColumn++, distance) ||
                 Helper(numRows, numColumns, area, visited, currentRow, currentColumn--, distance)
         )
         {
             // Set the final distance to travel if it is not set yet.
             if (finalDistance == 0)
             {
                 finalDistance = distance;
             }

             return true;
         }
         else {
             return false;
         }
     }
     }

