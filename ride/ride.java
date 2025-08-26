/*
ID: lurpdad1
LANG: JAVA
TASK: ride
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
    private static int cometProduct = 1;
    private static int groupProduct = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String s1 = f.readLine();
        String s2 = f.readLine();

        String result = solution(s1, s2);
        out.println(result);
        out.close();
    }
    private static String solution(String comet, String group) {
        for(int i = 0, n = comet.length() ; i < n ; i++) { 
            char com = comet.charAt(i); 
            cometProduct *= com - 'A' + 1;
        }
        for(int i = 0, n = group.length() ; i < n ; i++) { 
            char gro = group.charAt(i); 
            groupProduct *= gro - 'A' + 1;
        }
        if (cometProduct % 47 == groupProduct % 47) {
            return "GO";
        } else {
            return "STAY";
        }
    }
}