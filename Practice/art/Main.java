import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        int[][] canvas = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                canvas[i][j] = line.charAt(j) - '0';
            }
        }

        Map<Integer, int[][]> rectangles = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rectangles.put(canvas[i][j], new int[][] {{N - 1, N - 1}, {0, 0}});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int minXIndex = Math.min(i, rectangles.get(canvas[i][j])[0][0]);
                int minYIndex = Math.min(j, rectangles.get(canvas[i][j])[0][1]);
                int maxXIndex = Math.max(i, rectangles.get(canvas[i][j])[1][0]);
                int maxYIndex = Math.max(j, rectangles.get(canvas[i][j])[1][1]);
                for (int k = i; k < N; k++) {
                    for (int l = j; l < N; l++) {
                        if (canvas[k][l] == canvas[i][j]) {
                            maxXIndex = Math.max(maxXIndex, k);
                            maxYIndex = Math.max(maxYIndex, l);
                        }
                    }
                }
                int[][] coordinates = new int[][] {{minXIndex, minYIndex}, {maxXIndex, maxYIndex}};
                rectangles.put(canvas[i][j], coordinates);
            }
        }

        Set<Integer> presentColors = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (canvas[i][j] != 0) {
                    presentColors.add(canvas[i][j]);
                }
            }
        }

        Set<Integer> cannotBeFirst = new HashSet<>();

        for (Integer color1 : presentColors) {
            int[][] r1 = rectangles.get(color1);
            int minX = r1[0][0];
            int minY = r1[0][1];
            int maxX = r1[1][0];
            int maxY = r1[1][1];

            for (int i = minX; i <= maxX; i++) {
                for (int j = minY; j <= maxY; j++) {
                    if (canvas[i][j] != color1) {
                        cannotBeFirst.add(canvas[i][j]);
                    }
                }
            }
        }

        int result = presentColors.size() - cannotBeFirst.size();
        System.out.println(result);
    }
}
