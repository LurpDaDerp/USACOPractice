import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] cows = new int[n][2];

        for (int i = 0; i < n; i++) {
            cows[i][0] = sc.nextInt(); 
            cows[i][1] = sc.nextInt(); 
        }

        Arrays.sort(cows, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        long time = 0;
        for (int i = 0; i < n; i++) {
            if (time < cows[i][0]) {
                time = cows[i][0];
            }
            time += cows[i][1];
        }

        System.out.println(time);
    }
}
