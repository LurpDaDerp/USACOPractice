/*
ID: lurpdaderp
LANG: JAVA
TASK: mowing
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mowing {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

        int n = Integer.parseInt(f.readLine());
        int[][] grid = new int[2001][2001];
        int x = 1000;
        int y = 1000;

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid.length ; j++) {
                grid[i][j] = -1;
            }
        }
        
        String[] directions = new String[n];
        int[] distances = new int[n];
        int time = 0;

        for (int i = 0 ; i < n ; i++) {
            String[] line = f.readLine().split(" ");
            directions[i] = String.valueOf(line[0]);
            distances[i] = Integer.parseInt(line[1]);
        }

        int maxTime = Integer.MAX_VALUE;

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < distances[i] ; j++) {
                time++;
                if (directions[i].equals("N")) y -= 1;
                if (directions[i].equals("S")) y += 1;
                if (directions[i].equals("W")) x -= 1;
                if (directions[i].equals("E")) x += 1;
                
                if (grid[x][y] >= 0) {
                    if (time - grid[x][y] < maxTime) maxTime = time - grid[x][y];
                }

                grid[x][y] = time;
            }
        }

        if (maxTime == Integer.MAX_VALUE) maxTime = -1;

        out.println(maxTime);
        out.close();
    }
}