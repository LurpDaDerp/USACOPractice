import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

        final int N = Integer.parseInt(br.readLine());
        int[] cows = new int[N];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(tokens[i]);
        }

        int temp = cows[N - 1];
        int sortedSuffix = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (cows[i] < temp) sortedSuffix++;
            else break;
            temp = cows[i];
        }

        out.println(N - sortedSuffix);
        out.close();
    }
}