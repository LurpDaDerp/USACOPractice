/*
ID: lurpdaderp
LANG: JAVA
TASK: diamond
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        String[] line = f.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] diamonds = new int[n];

        for (int i = 0; i < n; i++) {
            diamonds[i] = Integer.parseInt(f.readLine());
        }

        int max = 1;
        int finalmax = 0;

        Arrays.sort(diamonds);

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (Math.abs(diamonds[i]-diamonds[j]) <= k) {
                    max++;
                }
            }
            if (max > finalmax) finalmax = max;
            max = 1;
        }
        out.print(finalmax);
        
        out.close();
    }
}