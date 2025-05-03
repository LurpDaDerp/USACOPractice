/*
ID: lurpdaderp
LANG: JAVA
TASK: gymnastics
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        String[] line = f.readLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        int[][] rankings = new int[k][n];
        for (int i = 0; i < k; i++) {
            line = f.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                rankings[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] pairs = new int[n*(n-1)/2][2];
        int pairIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                pairs[pairIndex][0] = rankings[0][i];
                pairs[pairIndex][1] = rankings[0][j];
                pairIndex++;
            }
        }

        int consistentPairs = 0;
        
        for (int i = 0; i < pairs.length; i++) {
            boolean consistent = true;
            for (int j = 0; j < k; j++) {
                int firstIndex = 0;
                int secondIndex = 0;
                for (int l = 0; l < n; l++) {
                    if (rankings[j][l] == pairs[i][0]) firstIndex = l;
                    if (rankings[j][l] == pairs[i][1]) secondIndex = l;
                }
                if (secondIndex < firstIndex) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) consistentPairs++;
        }

        out.print(consistentPairs);
        out.close();
    }
}