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

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < N; end++) {
            while (diamonds[end] - diamonds[start] > K) {
                start++;
            }

            int start2 = end;
            for (int end2 = end; end2 < N; end2++) {
                while (diamonds[end2] - diamonds[start2] > K) {
                    start2++;
                }
                maxLength = Math.max(maxLength, end - start + 1 + end2 - start2 + 1);
            }

        }

        out.println(maxLength);
        out.close();
    }
}