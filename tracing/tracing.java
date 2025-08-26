/*
ID: lurpdaderp
LANG: JAVA
TASK: tracing
*/

import java.io.*;
import java.util.*;

public class tracing {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("tracing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));

        String[] first = f.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int T = Integer.parseInt(first[1]);

        int[] finalState = new int[N];
        String s = f.readLine();
        for (int i = 0; i < N; i++) {
            finalState[i] = s.charAt(i) - '0';
        }

        int[][] events = new int[T][3];
        for (int i = 0; i < T; i++) {
            String[] parts = f.readLine().split(" ");
            events[i][0] = Integer.parseInt(parts[0]); 
            events[i][1] = Integer.parseInt(parts[1]) - 1; 
            events[i][2] = Integer.parseInt(parts[2]) - 1; 
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        Set<Integer> possibleStarts = new HashSet<>();
        int minK = Integer.MAX_VALUE;
        int maxK = 0;

        for (int p0 = 0; p0 < N; p0++) {
            if (finalState[p0] == 0) continue;

            for (int K = 0; K <= T; K++) {
                int[] infected = new int[N];
                int[] handshakes = new int[N];
                infected[p0] = 1;

                for (int[] e : events) {
                    int a = e[1];
                    int b = e[2];

                    boolean aInfectedBefore = infected[a] == 1;
                    boolean bInfectedBefore = infected[b] == 1;

                    if (aInfectedBefore) handshakes[a]++;
                    if (bInfectedBefore) handshakes[b]++;

                    if (aInfectedBefore && handshakes[a] <= K) {
                        infected[b] = 1;
                    }
                    if (bInfectedBefore && handshakes[b] <= K) {
                        infected[a] = 1;
                    }
                }

                if (Arrays.equals(infected, finalState)) {
                    possibleStarts.add(p0);
                    minK = Math.min(minK, K);
                    maxK = Math.max(maxK, K);
                }
            }
        }

        String maxKStr = (maxK == T) ? "Infinity" : String.valueOf(maxK);

        out.println(possibleStarts.size() + " " + minK + " " + maxKStr);
        out.close();
    }
}
