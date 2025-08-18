import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        int[] cows = new int[N];
        int swapsNeeded = 0;
        for (int i = 0; i < N; i++) {
            cows[i] = sc.nextInt();
        }
        
        int[] sorted = Arrays.copyOf(cows, cows.length);
        Arrays.sort(sorted);

        for (int i = 0; i < N; i++) {
            if (cows[i] != sorted[i]) swapsNeeded++;
        }

        System.out.println(swapsNeeded-1);
    }
}