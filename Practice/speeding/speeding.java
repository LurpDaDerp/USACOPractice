/*
ID: lurpdaderp
LANG: JAVA
TASK: speeding
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class speeding {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        String line = f.readLine();
        String[] lineInfo = line.split(" ");
        int n = Integer.parseInt(lineInfo[0]);
        int m = Integer.parseInt(lineInfo[1]);

        int[] roadLength = new int[n];
        int[] roadSpeed = new int[n];
        int[] cowLength = new int[m];
        int[] cowSpeed = new int[m];    

        for (int i = 0 ; i < n ; i++) {
            line = f.readLine();
            lineInfo = line.split(" ");
            roadLength[i] = Integer.parseInt(lineInfo[0]);
            roadSpeed[i] = Integer.parseInt(lineInfo[1]);
        }

        for (int i = 0 ; i < m ; i++) {
            line = f.readLine();
            lineInfo = line.split(" ");
            cowLength[i] = Integer.parseInt(lineInfo[0]);
            cowSpeed[i] = Integer.parseInt(lineInfo[1]);
        }

        int[] cowSpeeds = new int[100];
        int[] roadSpeeds = new int[100];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < roadLength[i]; j++) {
                roadSpeeds[index++] = roadSpeed[i];
            }
        }

        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < cowLength[i]; j++) {
                cowSpeeds[index++] = cowSpeed[i];
            }
        }
        
        int maxOver = 0;

        for (int i = 0 ; i < 100 ; i++) {
            if (cowSpeeds[i] - roadSpeeds[i] > maxOver) maxOver = cowSpeeds[i] - roadSpeeds[i];
        }

        out.println(maxOver);
        out.close();

    }
}
