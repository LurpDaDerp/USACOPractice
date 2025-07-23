import java.util.*;

public class Main {

    static int n;
    static char[][] grid;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        grid = new char[n][n];
        memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
            Arrays.fill(memo[i], -1);
        }

        System.out.println(nextSquare(n-1, n-1));
        
    }

    public static int nextSquare(int x, int y) {

        if (x < 0 || y < 0) return 0;

        if (grid[x][y] == '*') return 0;

        if (x == 0 && y == 0) return 1;
        
        if (memo[x][y] != -1) return memo[x][y];

        int fromTop = nextSquare(x-1, y);
        int fromLeft = nextSquare(x, y-1);

        return memo[x][y] = (fromTop + fromLeft) % 1000000007;
    }
}