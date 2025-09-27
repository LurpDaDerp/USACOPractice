import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = sc.nextInt();
            final int M = sc.nextInt();

            int[] remainders = new int[2*N];

            for (int i = 0; i < N; i++) {
                remainders[i] = sc.nextInt() % M;
            }

            for (int i = N; i < 2*N; i++) {
                remainders[i] = remainders[i-N]+M;
            }

            Arrays.sort(remainders);

            long[] sums = new long[2*N + 1];
            for (int i = 0; i < 2*N; i++) {
                sums[i+1] = sums[i] + remainders[i];
            }

            long minCost = Long.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                int l = i, r = i + N - 1;
                int midIndex = (l + r) / 2;
                int median = remainders[midIndex];

                long leftCost  = (long) median * (midIndex - l + 1) - (sums[midIndex+1] - sums[l]);
                long rightCost = (sums[r+1] - sums[midIndex+1]) - (long) median * (r - midIndex);
                long cost = leftCost + rightCost;
                minCost = Math.min(minCost, cost);
            }

            System.out.println(minCost);
        }
    }
}
