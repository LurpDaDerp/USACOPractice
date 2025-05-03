/*
ID: lurpdaderp
LANG: JAVA
TASK: cownomics
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        String[] line = f.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        String[] spotted = new String[n];
        String[] normal = new String[n];

        for (int i = 0; i < n; i++) spotted[i] = f.readLine();
        for (int i = 0; i < n; i++) normal[i] = f.readLine();

        int positions = 0;

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boolean distinct = true;
            ArrayList<Character> spottedChars = new ArrayList<>();
            ArrayList<Character> normalChars = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                spottedChars.add(spotted[j].charAt(i));
                normalChars.add(normal[j].charAt(i));
            }
            for (char x : spottedChars) {
                for (char y : normalChars) {
                    if (x == y) distinct = false;
                }
            }
            if (distinct) positions++;
        }

        
        out.println(positions);
        out.close();
    }
}