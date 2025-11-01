/*
ID: lurpdaderp
LANG: JAVA
TASK: haybales
*/

import java.io.*;
import java.util.*;

public class haybales {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int Q = Integer.parseInt(line[1]);

        int[] positions = new int[N];

        line = f.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(positions);

        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            line = f.readLine().split(" ");
            queries[i][0] = Integer.parseInt(line[0]);
            queries[i][1] = Integer.parseInt(line[1]);

            int query1 = Arrays.binarySearch(positions, queries[i][0]);
            int query2 = Arrays.binarySearch(positions, queries[i][1]);

            if (query1 < 0) {
                query1 = -1 * query1 - 1;
            } 

            if (query2 < 0) {
                query2 = -1 * query2 - 2;
            } 

            System.out.println(query1 + " " + query2);

            out.println(query2 - query1 + 1);
        }
        out.close();
    }
}