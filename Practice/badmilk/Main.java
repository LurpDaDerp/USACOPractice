import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int D = sc.nextInt();
        final int S = sc.nextInt();

        int[][] drinkLogs = new int[D][3];
        int[][] sickLogs = new int[S][2];

        for (int i = 0; i < D; i++) {
            drinkLogs[i][0] = sc.nextInt();
            drinkLogs[i][1] = sc.nextInt();
            drinkLogs[i][2] = sc.nextInt();
        }

        
        for (int i = 0; i < S; i++) {
            sickLogs[i][0] = sc.nextInt();  
            sickLogs[i][1] = sc.nextInt();     
               
        }

        ArrayList<Integer>[] possibleBadMilks = new ArrayList[S];
        for (int i = 0; i < S; i++) {
            possibleBadMilks[i] = new ArrayList<>();
        }

        for (int i = 0; i < sickLogs.length; i++) {
            for (int j = 0; j < drinkLogs.length; j++) {
                if (drinkLogs[j][0] == sickLogs[i][0]) {
                    if (drinkLogs[j][2] < sickLogs[i][1]) {
                        int possibleMilk = drinkLogs[j][1];
                        possibleBadMilks[i].add(possibleMilk);
                    }
                }
            }
        }

        Set<Integer> badMilks = new HashSet<>(possibleBadMilks[0]); 
        for (int i = 1; i < possibleBadMilks.length; i++) {
            badMilks.retainAll(possibleBadMilks[i]);
        }

        int dosesNeeded = 0;
        ArrayList<Integer> sickPpl = new ArrayList<>();

        for (int i = 0; i < D; i++) {
            if (badMilks.contains(drinkLogs[i][1])) {
                if (!sickPpl.contains(drinkLogs[i][0])) {
                    sickPpl.add(drinkLogs[i][0]);
                    dosesNeeded ++;
                }
            }
        }

        System.out.println(dosesNeeded);
    }
}