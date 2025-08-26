import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<int[]> times = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            times.add(new int[]{x, y});
        }

        Collections.sort(times, Comparator.comparingInt(a -> a[0]));

        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            ArrayList<int[]> coveredTimes = new ArrayList<>();
            int coveredTime = 0;

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                if (coveredTimes.isEmpty()) {
                    coveredTimes.add(new int[]{times.get(j)[0], times.get(j)[1]});
                } else {
                    int[] last = coveredTimes.get(coveredTimes.size() - 1);
                    int[] current = times.get(j);

                    if (last[1] < current[0]) {
                        coveredTimes.add(new int[]{current[0], current[1]});
                    } else {
                        last[1] = Math.max(last[1], current[1]);
                    }
                }
            }

            for (int[] interval : coveredTimes) {
                coveredTime += interval[1] - interval[0];
            }

            maxTime = Math.max(maxTime, coveredTime);
        }

        System.out.println(maxTime);
    }
}
