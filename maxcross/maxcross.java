/*
ID: lurpdaderp
LANG: JAVA
TASK: maxcross
*/

import java.io.*;
import java.util.*;

public class maxcross {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int K = Integer.parseInt(line[1]);
        final int B = Integer.parseInt(line[2]);

        boolean[] working = new boolean[N];
        for (int i = 0; i < N; i++) {
            working[i] = true;
        }

        for (int i = 0; i < B; i++) {
            int pos = Integer.parseInt(f.readLine());
            working[pos-1] = false;
        }

        int[] notWorkingCounts = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (!working[i]) {
                    notWorkingCounts[i] = 1;
                }
            } else {
                notWorkingCounts[i] = notWorkingCounts[i-1];
                if (!working[i]) {
                    notWorkingCounts[i] ++;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N-K; i++) {
            if (notWorkingCounts[i+K] - notWorkingCounts[i] < min) {
                min = notWorkingCounts[i+K] - notWorkingCounts[i];
            }
        }

        out.println(min);
        out.close();
    }
}