import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int G = sc.nextInt();
        final int N = sc.nextInt();

        int[][] grazeActivities = new int[G][3];
        int[][] cowActivities = new int[N][3];

        int[] grazeTimes = new int[G];

        for (int i = 0; i < G; i++) {
            grazeActivities[i][0] = sc.nextInt();
            grazeActivities[i][1] = sc.nextInt();
            grazeActivities[i][2] = sc.nextInt();
            grazeTimes[i] = grazeActivities[i][2];
        }

        Arrays.sort(grazeTimes);
        Arrays.sort(grazeActivities, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < N; i++) {
            cowActivities[i][0] = sc.nextInt();
            cowActivities[i][1] = sc.nextInt();
            cowActivities[i][2] = sc.nextInt();
        }

        int innocents = 0;
        
        for (int i = 0; i < N; i++) {
            boolean innocent = false;

            int position = Arrays.binarySearch(grazeTimes, cowActivities[i][2]);
            if (position >= 0) {
                if (Math.hypot(cowActivities[i][0] - grazeActivities[position][0], cowActivities[i][1] - grazeActivities[position][1]) > Math.abs(cowActivities[i][2] - grazeActivities[position][2])) {
                    innocent = true;
                }
            } else {
                int neededPos = -(position+1);
                int prevTime = neededPos - 1;
                int afterTime = neededPos;

                boolean prev = false;
                boolean af = false;

                if (prevTime >= 0) {
                    if (Math.hypot(cowActivities[i][0] - grazeActivities[prevTime][0], cowActivities[i][1] - grazeActivities[prevTime][1]) > Math.abs(cowActivities[i][2] - grazeActivities[prevTime][2])) {
                        prev = true;
                    }
                }
                
                if (afterTime < G) {
                    if ((Math.hypot(cowActivities[i][0] - grazeActivities[afterTime][0], cowActivities[i][1] - grazeActivities[afterTime][1]) > Math.abs(cowActivities[i][2] - grazeActivities[afterTime][2]))) {
                        af = true;
                    }
                }   

                if (prev || af) {
                    innocent = true;
                }
            }
            if (innocent) innocents++;
        }

        System.out.println(innocents);
    }
}