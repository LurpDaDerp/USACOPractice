/*
ID: lurpdaderp
LANG: JAVA
TASK: diamond
*/

import java.io.*;
import java.util.*;

public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int K = Integer.parseInt(line[1]);

        int[] diamonds = new int[N];

        for (int i = 0; i < N; i++) {
            diamonds[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(diamonds);

        int[][] maxPerDiamond = new int[N][2];

        for (int i = 0; i < N; i++) {
            maxPerDiamond[i][0] = 0;
            int j = i;
            while (j < N && diamonds[j] - diamonds[i] <= K) {
                maxPerDiamond[i][0]++;
                j++;
            }
            maxPerDiamond[i][1] = j-1;
        }

        int maxLength = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = maxPerDiamond[i][1]+1; j < N-1; j++) {
                maxLength = Math.max(maxPerDiamond[i][0] + maxPerDiamond[j][0], maxLength);
            }
        }

        out.println(maxLength);
        out.close();
    }
}