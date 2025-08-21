import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final long K = sc.nextLong();

        long[] days = new long[N];

        long total = K+1;

        for (int i = 0; i < N; i++) {
            days[i] = sc.nextLong();
        }

        if (N == 1) {
            System.out.println(1+K);
            return;
        }

        for (int i = 1; i < days.length; i++) {
            if (days[i] - days[i-1] < 1 + K ) {
                total += days[i] - days[i-1];
            } else {
                total += 1 + K;
            }
        }

        System.out.println(total);
    }
}