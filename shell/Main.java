import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] moves = new int[n][3];

        for (int i = 0; i < n; i++) {
            moves[i][0] = sc.nextInt();
            moves[i][1] = sc.nextInt();
            moves[i][2] = sc.nextInt();
        }

        int maxPoints = 0;

        for (int start = 1; start <= 3; start++) {
            int[] pos = new int[4];
            pos[start] = 1;
            int points = 0;

            for (int i = 0; i < n; i++) {
                int a = moves[i][0];
                int b = moves[i][1];
                int g = moves[i][2];

                int temp = pos[a];
                pos[a] = pos[b];
                pos[b] = temp;

                if (pos[g] == 1) {
                    points++;
                }
            }

            maxPoints = Math.max(maxPoints, points);
        }

        System.out.println(maxPoints);
    }
}
