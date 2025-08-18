import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }

        int operations = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    operations++;
                    for (int x = 0; x <= i; x++) {
                        for (int y = 0; y <= j; y++) {
                            grid[x][y] = 1 - grid[x][y];
                        }
                    }
                }
            }
        }

        System.out.println(operations);
    }
}
