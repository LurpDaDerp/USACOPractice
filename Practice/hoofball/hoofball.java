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
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(cows);

        if (cows.length <= 3) {
            out.println(1);
            out.close();
            return;
        }

        int[] distances = new int[N-1];

        for (int i = 0; i < N-1; i++) {
            distances[i] = cows[i+1] - cows[i];
        }
        
        boolean increasingDistance = distances[1] >= distances[0];

        int needed = 1;

        int i = 0;
        while (i < distances.length-1) {
            
            increasingDistance = distances[i+1] >= distances[i];
            if (increasingDistance) {
                while (increasingDistance && i < distances.length-1) {
                    increasingDistance = distances[i+1] >= distances[i];
                    if (increasingDistance == false) {
                        if (i+1 == distances.length-1) {
                            i++;
                        }  else {
                            needed++;
                            i--;
                        } 
                    }
                    i++;
                }
            } else {
                while (!increasingDistance && i < distances.length-1) {
                    increasingDistance = distances[i+1] > distances[i];
                    if (increasingDistance == true) {
                        needed++;
                        i++;
                    }
                    i++;
                }
            }
        }

        out.println(needed);
        out.close();
    }
}