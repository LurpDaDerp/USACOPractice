import java.util.*;

public class Main {
    public static void main(String[] args) {
        String data = "3 3\r\n" + //
                        "D\r\n" + //
                        "WD\r\n" + //
                        "LWD\r\n" + //
                        "1 2\r\n" + //
                        "2 3\r\n" + //
                        "1 1";
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();

        final char[][] chart = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = sc.next().toCharArray();
            for (int j = 0; j <= i; j++) {
                chart[i][j] = line[j];
                if (i != j) {
                    chart[j][i] = (line[j] == 'W' ? 'L' : (line[j] == 'L' ? 'W' : 'D'));
                }
            }
        }

        final int[][] bessiePlays = new int[M][2];

        for (int i = 0; i < M; i++) {
            bessiePlays[i][0] = sc.nextInt()-1;
            bessiePlays[i][1] = sc.nextInt()-1;
        }

        for (int i = 0; i < M; i++) {
            int e1 = bessiePlays[i][0];
            int e2 = bessiePlays[i][1];

            int c = 0;
            for (int k = 0; k < N; k++) {
                if (chart[k][e1] == 'W' && chart[k][e2] == 'W') c++;
            }

            int totalCounters = 2 * N * c - c * c;
            System.out.println(totalCounters);
        }
    }
}