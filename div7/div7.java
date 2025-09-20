/*
ID: lurpdaderp
LANG: JAVA
TASK: div7
*/

import java.io.*;
import java.util.*;

public class div7 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));

        final int N = Integer.parseInt(f.readLine());

        int[] cows = new int[N];

        int[] sums = new int[N];

        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(f.readLine()); 
            if (i == 0) {
                sums[i] = cows[i];
            } else {
                sums[i] = cows[i] + sums[i-1];
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if ((sums[j] - sums[i]) % 7 == 0) {
                    if (j-i > max) max = j-i;
                }
            }
        }

        out.println(max);
        out.close();
    }
}