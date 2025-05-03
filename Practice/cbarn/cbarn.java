/*
ID: lurpdaderp
LANG: JAVA
TASK: cbarn
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class cbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        int doors = Integer.parseInt(f.readLine());
        int[] cowsPerRoom = new int[doors];
        for (int i = 0 ; i < doors ; i++) {
            cowsPerRoom[i] = Integer.parseInt(f.readLine());
        }

        int minDistance = Integer.MAX_VALUE;
        int distance = 0;

        for (int i = 0 ; i < doors ; i++) {
            distance = 0;
            for (int j = i ; j < i + doors ; j++) {
                distance += cowsPerRoom[j-i] * (j % doors);
            }
            if (distance < minDistance) minDistance = distance;
        }

        out.println(minDistance);
        out.close();

    }
}
