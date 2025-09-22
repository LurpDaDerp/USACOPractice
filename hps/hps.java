/*
ID: lurpdaderp
LANG: JAVA
TASK: hps
*/

import java.io.*;
import java.util.*;

public class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        final int N = Integer.parseInt(f.readLine());

        char[] fPlays = new char[N];
        for (int i = 0; i < N; i++) {
            fPlays[i] = f.readLine().charAt(0);
        }

        int[] hCounts = new int[N];
        int[] pCounts = new int[N];
        int[] sCounts = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (fPlays[i] == 'H') {
                    hCounts[i] = 1;
                } else if (fPlays[i] == 'P') {
                    pCounts[i] = 1;
                } else if (fPlays[i] == 'S') {
                    sCounts[i] = 1;
                }  
            } else {
                hCounts[i] = hCounts[i-1];
                pCounts[i] = pCounts[i-1];
                sCounts[i] = sCounts[i-1];

                if (fPlays[i] == 'H') {
                    hCounts[i]++;
                } else if (fPlays[i] == 'P') {
                    pCounts[i]++;
                } else if (fPlays[i] == 'S') {
                    sCounts[i]++;
                } 
            }
        }

        int maxWins = 0;

        for (int i = 0; i < N; i++) {
            int maxFirstHalf = Math.max(Math.max(hCounts[i], pCounts[i]), sCounts[i]);
            int maxSecondHalf = Math.max(Math.max(hCounts[N-1] - hCounts[i], pCounts[N-1] - pCounts[i]), sCounts[N-1] - sCounts[i]);
            maxWins = Math.max(maxWins, maxFirstHalf + maxSecondHalf);
        }


        out.println(maxWins);
        out.close();
    }
}