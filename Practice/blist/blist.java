/*
ID: lurpdaderp
LANG: JAVA
TASK: blist
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class blist {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

        int cows = Integer.parseInt(f.readLine());
        int[] startTimes = new int[cows];
        int[] endTimes = new int[cows];
        int[] buckets = new int[cows];

        for (int i = 0 ; i < cows ; i++) {
            String[] line = f.readLine().split(" ");
            startTimes[i] = Integer.parseInt(line[0]);
            endTimes[i] = Integer.parseInt(line[1]);
            buckets[i] = Integer.parseInt(line[2]);
        }

        int bucketsNeeded = 0;
        int bucketsInUse = 0;

        for (int time = 0 ; time < 1000 ; time++) {
            for (int i = 0 ; i < cows ; i++) {
                if (startTimes[i] == time) {
                    bucketsInUse += buckets[i];
                }
                if (bucketsInUse > bucketsNeeded) bucketsNeeded = bucketsInUse;
                if (endTimes[i] == time) {
                    bucketsInUse -= buckets[i];
                }
            }
        }
 

        out.println(bucketsNeeded);
        out.close();

    }
}
