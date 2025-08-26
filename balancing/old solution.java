/*
ID: lurpdaderp
LANG: JAVA
TASK: balancing
*/

//OLD SOLUTION

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class balancing {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        String[] line = f.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int[] x = new int[n];
        int[] y = new int[n];
        
        for (int i = 0; i < n; i++) {
            String[] coords = f.readLine().split(" ");
            x[i] = Integer.parseInt(coords[0]);
            y[i] = Integer.parseInt(coords[1]);
        }

        int maxX = 0, maxY = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] > maxX) maxX = x[i];
            if (y[i] > maxY) maxY = y[i];
        }
        int min = Integer.MAX_VALUE;
        int[][] grid = new int[maxX + 1][maxY + 1];
        for (int i = 1; i < maxX+1; i+=2) {
            for (int j = 1; j < maxY+1; j+=2) {
                int quadrant1 = 0, quadrant2 = 0, quadrant3 = 0, quadrant4 = 0;
                for (int k = 0; k < n; k++) {
                    if (x[k] < i && y[k] < j) {
                        quadrant1++;
                    } else if (x[k] < i && y[k] >= j) {
                        quadrant2++;
                    } else if (x[k] >= i && y[k] >= j) {
                        quadrant3++;
                    } else {
                        quadrant4++;
                    }
                }
                int quadrantMax = Math.max(Math.max(quadrant1, quadrant2), Math.max(quadrant3, quadrant4));
                if (quadrantMax < min) {
                    min = quadrantMax;
                }
                
            }
        }

        out.println(min);
        out.close();
    }
}
