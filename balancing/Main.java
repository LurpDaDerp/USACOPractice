import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[][] cows = new int[n][2];

        for (int i = 0; i < n; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
        }
        int minMax = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int xLine = cows[i][0]+1;
            for (int j = 0; j < n; j++) {
                int yLine = cows[j][1]+1;
                int northWest = 0;
                int northEast = 0;
                int southWest = 0;
                int southEast = 0;
                for (int k = 0; k < n; k++) {
                    if (cows[k][0] < xLine) {
                        if (cows[k][1] < yLine) southWest++;
                        if (cows[k][1] > yLine) southEast++;
                    }
                    if (cows[k][0] > xLine) {
                        if (cows[k][1] < yLine) northWest++;
                        if (cows[k][1] > yLine) northEast++;
                    }
                }
                int max = Math.max(Math.max(northEast, northWest), Math.max(southEast, southWest));
                minMax = Math.min(max, minMax);
            }
        }

        System.out.println(minMax);
    }
}