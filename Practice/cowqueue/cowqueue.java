import java.io.*;
import java.util.*;

public class cowqueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        int n = Integer.parseInt(br.readLine());
        int[][] cows = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        long time = 0;
        for (int i = 0; i < n; i++) {
            if (time < cows[i][0]) {
                time = cows[i][0];
            }
            time += cows[i][1];
        }

        out.println(time);
        out.close();
        br.close();
    }
}
