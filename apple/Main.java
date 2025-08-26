import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] weights = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            totalSum += weights[i];
        }

        int minDifference = Integer.MAX_VALUE;
        

        int total = 1 << n;
        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            int tempSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(weights[i]);
                }
            }
            for (Integer j : subset) {
                tempSum += j;
            }
            if (Math.abs(totalSum - tempSum - tempSum) < minDifference) minDifference = Math.abs(totalSum - tempSum - tempSum);
        }

        System.out.println(minDifference);
    }
}