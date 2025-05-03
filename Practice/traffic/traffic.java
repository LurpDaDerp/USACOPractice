/*
ID: lurpdaderp
LANG: JAVA
TASK: traffic
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class traffic {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

        int n = Integer.parseInt(f.readLine());

        String[] ramps = new String[n];
        int[] lowerRanges = new int[n];
        int[] upperRanges = new int[n]; 

        for (int i = 0 ; i < n ; i++) {
            String[] line = f.readLine().split(" ");
            ramps[i] = line[0];
            lowerRanges[i] = Integer.parseInt(line[1]);
            upperRanges[i] = Integer.parseInt(line[2]);
        }

        int lowerMax = 0;
        int upperMin = 1000;

        for (int i = n-1 ; i >= 0 ; i--) {
            if (ramps[i].equals("none")) {
                if (lowerRanges[i] > lowerMax) lowerMax = lowerRanges[i];
                if (upperRanges[i] < upperMin) upperMin = upperRanges[i];
            }
            if (ramps[i].equals("off")) {
                lowerMax += lowerRanges[i];
                upperMin += upperRanges[i];
            }
            if (ramps[i].equals("on")) {
                lowerMax -= upperRanges[i];
                upperMin -= lowerRanges[i];
            }
        }

        String line1 = lowerMax + " " + upperMin;

        lowerMax = 0;
        upperMin = 1000;

        for (int i = 0 ; i < n ; i++) {
            if (ramps[i].equals("none")) {
                if (lowerRanges[i] > lowerMax) lowerMax = lowerRanges[i];
                if (upperRanges[i] < upperMin) upperMin = upperRanges[i];
            }
            if (ramps[i].equals("on")) {
                lowerMax += lowerRanges[i];
                upperMin += upperRanges[i];
            }
            if (ramps[i].equals("off")) {
                lowerMax -= upperRanges[i];
                upperMin -= lowerRanges[i];
            }
        }

        String line2 = lowerMax + " " + upperMin;
        

        out.printf(line1 + "\n");
        out.printf(line2);
        out.close();

    }
}
 