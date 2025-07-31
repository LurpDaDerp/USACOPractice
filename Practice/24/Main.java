import java.util.*;

public class Main {

    static int totalPaths = 0;
    static char[] directions;
    static boolean[][] squareUsed = new boolean[7][7];
    static char[] curPath = new char[48];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        directions = input.toCharArray();

        nextSquare(0, 0, 0);

        System.out.println(totalPaths);
    }

    public static void nextSquare(int x, int y, int steps) {
        if (x < 0 || y < 0 || x > 6 || y > 6) return;
        if (squareUsed[x][y]) return;

        if (x == 0 && y == 6) {
            if (steps == 48) totalPaths++;
            return;
        }

        if (steps > 48) return;

        if (isTrapped(x, y)) return;

        squareUsed[x][y] = true;

        if (directions[steps] == '?' || directions[steps] == 'R') {
            nextSquare(x + 1, y, steps + 1);
            curPath[steps] = 'R';
        }

        if (directions[steps] == '?' || directions[steps] == 'L') {
            nextSquare(x - 1, y, steps + 1);
            curPath[steps] = 'L';
        }

        if (directions[steps] == '?' || directions[steps] == 'U') {
            nextSquare(x, y - 1, steps + 1);
            curPath[steps] = 'U';
        }

        if (directions[steps] == '?' || directions[steps] == 'D') {
            nextSquare(x, y + 1, steps + 1);
            curPath[steps] = 'D';
        }

        squareUsed[x][y] = false;
    }

    public static boolean isTrapped(int x, int y) {
        boolean canGoUp = y > 0 && !squareUsed[x][y - 1];
        boolean canGoDown = y < 6 && !squareUsed[x][y + 1];
        boolean canGoLeft = x > 0 && !squareUsed[x - 1][y];
        boolean canGoRight = x < 6 && !squareUsed[x + 1][y];

        if (!canGoUp && !canGoDown && canGoLeft && canGoRight) return true;
        if (!canGoLeft && !canGoRight && canGoUp && canGoDown) return true;

        return false;
    }
}
