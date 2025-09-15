/*
ID: lurpdaderp
LANG: JAVA
TASK: taming
*/

import java.io.*;
import java.util.*;

public class taming {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("taming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

        final int N = Integer.parseInt(f.readLine());
        int[] logs = new int[N];
        String[] line = f.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            logs[i] = Integer.parseInt(line[i]);
        }

        if (logs[0] == -1) logs[0] = 0;
        else if (logs[0] != 0) {
            out.println(-1);
            out.close();
            return;
        }

        boolean impossible = false;

        for (int i = N - 1; i >= 0 && !impossible; i--) {
            if (logs[i] != -1) {
                int v = logs[i];
                for (int k = 0; k <= v; k++) {
                    int idx = i - k;
                    if (idx < 0) {
                        impossible = true; 
                        break;
                    }
                    int expected = v - k;
                    if (logs[idx] == -1) {
                        logs[idx] = expected;
                    } else if (logs[idx] != expected) {
                        impossible = true;
                        break;
                    }
                }
            }
        }

        if (impossible) {
            out.println(-1);
            out.close();
            return;
        }

        int minBreakouts = 0;
        int freeDays = 0;
        for (int i = 0; i < N; i++) {
            if (logs[i] == 0) minBreakouts++;
            else if (logs[i] == -1) freeDays++;
        }
        int maxBreakouts = minBreakouts + freeDays;

        out.println(minBreakouts + " " + maxBreakouts);
        out.close();
    }
}
