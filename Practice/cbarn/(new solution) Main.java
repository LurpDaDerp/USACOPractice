import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int travelledDistance = 0;
            for (int j = i; j < i + n; j++) {
                travelledDistance += r[j % n] * (j-i);
            }
            if (travelledDistance < minDistance) minDistance = travelledDistance;
        }

        System.out.println(minDistance);
    }
}
