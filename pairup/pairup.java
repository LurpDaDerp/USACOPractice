/*
ID: lurpdaderp
LANG: JAVA
TASK: pairup
*/

import java.io.*;
import java.util.*;

public class pairup {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));

        final int N = Integer.parseInt(f.readLine());

        int[][] cowOutputs = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] line = f.readLine().split(" ");
            cowOutputs[i][0] = Integer.parseInt(line[0]);
            cowOutputs[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(cowOutputs, (a, b) -> Integer.compare(a[1], b[1]));

        int maxSum = 0;

        int start = 0;
        int end = N-1;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, cowOutputs[start][1] + cowOutputs[end][1]);

            cowOutputs[start][0]--;
            cowOutputs[end][0]--;
            if (cowOutputs[start][0] == 0) {
                start++;
            }
            if (cowOutputs[end][0] == 0) {
                end--;
            }
        }

        out.println(maxSum);
        out.close();
    }
}