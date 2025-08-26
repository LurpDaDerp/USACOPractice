/*
ID: lurpdaderp
LANG: JAVA
TASK: censor
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class censor {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

        String line1 = f.readLine();
        String toRemove = f.readLine();
        String build = "";

        char[] original = line1.toCharArray();
        char[] answer = new char[original.length];

        String currentSubstring = "";

        int x = 0;

        for (int i = 0 ; i < original.length ; i++) {
            answer[x] = original[i];
            currentSubstring = "";
            if (x > toRemove.length() - 2) {
                for (int j = 0; j < toRemove.length(); j++) {
                    currentSubstring = currentSubstring + answer[x - toRemove.length() + 1 + j];
                    
                }
            }
            if (currentSubstring.equals(toRemove)) {
                for (int j = 0; j < toRemove.length(); j++) {
                    answer[x-j] = '\0';
                }
                x -= toRemove.length();
            }
            x++;
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != '\0') out.print(answer[i]);
        }

        out.close();
    }
}