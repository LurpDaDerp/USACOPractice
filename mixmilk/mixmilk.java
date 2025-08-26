/*
ID: lurpdaderp
LANG: JAVA
TASK: mixmilk
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));


        String[] line1 = f.readLine().split(" ");
        String[] line2 = f.readLine().split(" ");
        String[] line3 = f.readLine().split(" ");

        int[] capacities = new int[3];
        int[] amounts = new int[3];
        capacities[0] = Integer.valueOf(line1[0]);
        capacities[1] = Integer.valueOf(line2[0]);
        capacities[2] = Integer.valueOf(line3[0]);
        amounts[0] = Integer.valueOf(line1[1]);
        amounts[1] = Integer.valueOf(line2[1]);
        amounts[2] = Integer.valueOf(line3[1]);

        for (int i = 0 ; i < 100 ; i++) {
            if (amounts[((i) % 3)] + amounts[((i+1) % 3)] <= capacities[((i+1) % 3)]) {
                amounts[((i+1) % 3)] += amounts[((i) % 3)];
                amounts[((i) % 3)] = 0;
            } else {
                amounts[((i) % 3)] -= capacities[((i+1) % 3)] - amounts[((i+1) % 3)];
                amounts[((i+1) % 3)] = capacities[((i+1) % 3)];
            }
        
        }

        out.println(amounts[0]);
        out.println(amounts[1]);
        out.println(amounts[2]);
        out.close();

    }
}
