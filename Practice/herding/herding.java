/*
ID: lurpdaderp
LANG: JAVA
TASK: herding
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

        String[] line = f.readLine().split(" ");
        f.close();
        
        int cow1 = Integer.parseInt(line[0]);
        int cow2 = Integer.parseInt(line[1]);
        int cow3 = Integer.parseInt(line[2]);

        int[] cows = new int[] {cow1, cow2, cow3};

        Arrays.sort(cows);
        if (cows[2] == cows[0] + 2) {
			out.println(0);
		} else if (cows[1] == cows[0] + 2 || cows[2] == cows[1] + 2) {
			out.println(1);
		} else {
			out.println(2);
		}

		out.println(Math.max((cows[1] - cows[0]), (cows[2] - cows[1])) - 1);
		out.close();
    }
}