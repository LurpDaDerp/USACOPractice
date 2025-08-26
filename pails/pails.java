/*
ID: lurpdaderp
LANG: JAVA
TASK: pails
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class pails {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        String[] line = f.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);
        int max = 0;

        for (int i = 0 ; i <= m/x ; i++) {
            int cur = x * i;
            while (cur <= m-y) {
                cur += y;
            }
            if (cur > max) max = cur;
        }

        out.print(max);

        out.println("");
        out.close();
    }
}
