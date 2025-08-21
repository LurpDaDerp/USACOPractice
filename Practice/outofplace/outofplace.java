import java.io.*;
import java.util.*;

public class outofplace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        final int N = Integer.parseInt(br.readLine());
        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }

        int[] sorted = Arrays.copyOf(cows, cows.length);
        Arrays.sort(sorted);

        int swapsNeeded = 0;
        for (int i = 0; i < N; i++) {
            if (cows[i] != sorted[i]) swapsNeeded++;
        }

        pw.println(swapsNeeded - 1);

        pw.close();
        br.close();
    }
}