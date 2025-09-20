/*
ID: lurpdaderp
LANG: JAVA
TASK: bcount
*/

import java.io.*;
import java.util.*;

public class bcount {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int Q = Integer.parseInt(line[1]);

        int[] cows = new int[N];
        int[] breed1Counts = new int[N];
        int[] breed2Counts = new int[N];
        int[] breed3Counts = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(f.readLine());
            if (i == 0) {
                if (cows[i] == 1) {
                    breed1Counts[i] = 1;
                } else if (cows[i] == 2) {
                    breed2Counts[i] = 1;
                } else if (cows[i] == 3) {
                    breed3Counts[i] = 1;
                }
            } else {
                breed1Counts[i] = breed1Counts[i-1];
                breed2Counts[i] = breed2Counts[i-1];
                breed3Counts[i] = breed3Counts[i-1];
                if (cows[i] == 1) {
                    breed1Counts[i] = breed1Counts[i] + 1;
                } else if (cows[i] == 2) {
                    breed2Counts[i] = breed2Counts[i] + 1;
                } else if (cows[i] == 3) {
                    breed3Counts[i] = breed3Counts[i] + 1;
                }
            }
        }


        int[][] queries = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            line = f.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1; 
            int b = Integer.parseInt(line[1]) - 1;

            int b1, b2, b3;
            if (a == 0) {
                b1 = breed1Counts[b];
                b2 = breed2Counts[b];
                b3 = breed3Counts[b];
            } else {
                b1 = breed1Counts[b] - breed1Counts[a-1];
                b2 = breed2Counts[b] - breed2Counts[a-1];
                b3 = breed3Counts[b] - breed3Counts[a-1];
            }

            out.println(b1 + " " + b2 + " " + b3);
        }
        
        out.close();
    }
}