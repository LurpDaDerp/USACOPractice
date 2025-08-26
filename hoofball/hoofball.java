/*
ID: lurpdaderp
LANG: JAVA
TASK: hoofball
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class hoofball {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));

        final int N = Integer.parseInt(f.readLine());
        String[] line = f.readLine().split(" ");

        int[] cows = new int[N];
        int[] passToIndex = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(cows);

        if (cows.length <= 3) {
            out.println(1);
            out.close();
            return;
        }
        
        int balls = 0;

        for (int i = 0; i < N; i++) {
            passToIndex[i] = -1;
        }
        
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                passToIndex[i] = 1;
                continue;
            }
            if (i == N-1) {
                passToIndex[i] = N-2;
                continue;
            }
            if (Math.abs(cows[i] - cows[i-1]) <= Math.abs(cows[i] - cows[i+1])) {
                passToIndex[i] = i-1;
            } else {
                passToIndex[i] = i+1;
            }
        }

        for (int i = 0; i < N; i++) {
            boolean cowPassedTo = false;
            for (int j = 0; j < N; j++) {
                if (passToIndex[j] == i) {
                    cowPassedTo = true;
                    break;
                }
            }
            if (!cowPassedTo) balls++;

            int j = passToIndex[i];
            int recievedI = 0;
            int recievedJ = 0;
            for (int k = 0; k < N; k++) {
                if (passToIndex[k] == i) {
                    recievedI++;
                }
                if (passToIndex[k] == j) {
                    recievedJ++;
                }
            }
            if (i < j && passToIndex[j] == i && recievedI == 1 && recievedJ == 1) {
                balls++;
            }
        }

        out.println(balls);
        out.close();
    }
}