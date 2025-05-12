/*
ID: lurpdaderp
LANG: JAVA
TASK: circlecross
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class circlecross {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        String paths = f.readLine();
        ArrayList<Character> points = new ArrayList<>();
        ArrayList<Character> used = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            points.add(paths.charAt(i));
        }

        int crosses = 0;
        for (char letter = 'A' ; letter <= 'Z' ; letter ++) {
            ArrayList<Integer> index = new ArrayList<>();
            for (int i = 0 ; i < points.size() ; i++) {
                if (points.get(i) == letter) {
                    index.add(i);
                } 
            }
            for (char x = 'A'; x <= 'Z'; x++) {
                int appearances = 0;
                for (int iterate = index.get(0) + 1 ; iterate < index.get(1) ; iterate++) {
                    if (points.get(iterate) == x) appearances++;
                }
                if (appearances == 1) crosses++;
            }
        }

        
        out.println(crosses/2);
        out.close();
    }
}