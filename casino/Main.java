import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = sc.nextInt();
            final int M = sc.nextInt();
            int sum = 0;
            int[][] cards = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    cards[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        sum += Math.abs(cards[i][k] - cards[j][k]);
                    }
                }
            }
            System.out.println(sum);
        }

        
    }
}