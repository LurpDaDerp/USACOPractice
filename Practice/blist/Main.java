import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] cows = new int[n][3];
        for (int i = 0; i < n; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
            cows[i][2] = sc.nextInt();
        }

        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return Integer.compare(arr1[1], arr2[1]);
            }
        });

        int maxBuckets = 0;

        for (int i = 0; i < cows[cows.length-1][1]; i++) {
            int bucketsNeeded = 0;
            for (int j = 0; j < cows.length; j++) {
                if (i < cows[j][1] && i >= cows[j][0]) {
                    bucketsNeeded += cows[j][2];
                }
            }
            if (bucketsNeeded > maxBuckets) maxBuckets = bucketsNeeded;
        }

        System.out.println(maxBuckets);
    }
}