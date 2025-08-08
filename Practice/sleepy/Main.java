import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = sc.nextInt();
        }

        int temp = cows[N-1];
        int sortedSuffix = 1;
        for (int i = N-2; i >=0; i--) {
            if (cows[i] < temp) sortedSuffix++; else break;
            temp = cows[i];
        }

        System.out.println(N-sortedSuffix);
    }
}