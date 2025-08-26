/*
ID: lurpdaderp
LANG: JAVA
TASK: breedflip
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

public class breedflip {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

        int N = Integer.parseInt(f.readLine());
        String A = f.readLine();
        String B = f.readLine();

        int substrings = 0;

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        boolean same = true;
        for (int i = 0; i < N; i++) {
            boolean sameCur = a[i] == b[i]; 
            if (same && !sameCur) {
                substrings++;
            } 
            same = a[i] == b[i];
        }

        out.println(substrings);
        out.close();
    }
}