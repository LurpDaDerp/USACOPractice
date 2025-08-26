import java.util.*;

public class Main {

    static int[][] cows;
    static int[][] airConditioners;
    static boolean[] used;
    static int minCost = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        cows = new int[n][3];
        airConditioners = new int[m][4];
        used = new boolean[m];
        Arrays.fill(used, false);

        for (int i = 0; i < n; i++) {
            cows[i][0] = sc.nextInt();
            cows[i][1] = sc.nextInt();
            cows[i][2] = sc.nextInt();
        } 
        for (int i = 0; i < m; i++) {
            airConditioners[i][0] = sc.nextInt();
            airConditioners[i][1] = sc.nextInt();
            airConditioners[i][2] = sc.nextInt();
            airConditioners[i][3] = sc.nextInt();
        }  

        ArrayList<int[]> inUse = new ArrayList<>();


        nextCombination(0, 0, inUse);

        System.out.println(minCost);
    }

    public static void nextCombination(int index, int curCost, ArrayList<int[]> curComp) {
        if (cowSatisfied(curComp)) minCost = Math.min(curCost, minCost);
        for (int i = 0; i < airConditioners.length; i++) {
            if (used[i]) continue;
            curComp.add(airConditioners[i]);
            used[i] = true;
            nextCombination(index+1, curCost + airConditioners[i][3], curComp);
            used[i] = false;
            curComp.remove(curComp.size()-1);
        }
    }

    public static boolean cowSatisfied(ArrayList<int[]> curComp) {
        int[] stallTemps = new int[101]; 
        Arrays.fill(stallTemps, 0);

        for (int[] ac : curComp) {
            int start = ac[0];
            int end = ac[1];
            int temp = ac[2];
            for (int i = start; i <= end; i++) {
                stallTemps[i] -= temp;
            }
        }

        for (int[] cow : cows) {
            int start = cow[0];
            int end = cow[1];
            int required = -cow[2];
            for (int i = start; i <= end; i++) {
                if (stallTemps[i] > required) {
                    return false;
                }
            }
        }

        return true;
    }
}