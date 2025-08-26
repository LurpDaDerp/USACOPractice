import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt(); 
        int N = sc.nextInt();
        int rF = sc.nextInt();
        int rB = sc.nextInt();

        int[][] restStops = new int[N][2];
        for (int i = 0; i < N; i++) {
            restStops[i][0] = sc.nextInt(); 
            restStops[i][1] = sc.nextInt(); 
        }

        ArrayList<int[]> bestStops = new ArrayList<>();
        int maxTasty = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (restStops[i][1] > maxTasty) {
                bestStops.add(restStops[i]);
                maxTasty = restStops[i][1];
            }
        }
        Collections.reverse(bestStops);

        long total = 0;
        long prevStop = 0;
        for (int[] stop : bestStops) {
            long leadTime = (long)(stop[0] - prevStop) * (rF - rB);
            total += leadTime * stop[1];
            prevStop = stop[0];
        }

        System.out.println(total);
    }
}