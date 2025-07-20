import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] sessions = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                sessions[i][j] = sc.nextInt();
            }
        }
        int consistentPairs = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                boolean consistent = true;
                int index1 = 0;
                int index2 = 0;
                boolean index1Smaller;
                for (int m = 0; m < n; m++) {
                    if (sessions[0][m] == i) index1 = m;
                    if (sessions[0][m] == j) index2= m;
                }
                index1Smaller = index1 < index2;
                for (int l = 0; l < sessions.length; l++) {
                    for (int m = 0; m < n; m++) {
                        if (sessions[l][m] == i) index1 = m;
                        if (sessions[l][m] == j) index2= m;
                    }
                    boolean tempIndex1Smaller = index1 < index2;
                    if (tempIndex1Smaller != index1Smaller) {
                        consistent = false;
                        break;
                    }
                    
                }
                if (consistent) consistentPairs++;
            }
            
        }

        System.out.println(consistentPairs);
    }
}