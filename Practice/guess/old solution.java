/*
ID: lurpdaderp
LANG: JAVA
TASK: guess
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class guess {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("guess.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

        ArrayList<String[]> animals = new ArrayList<>();
        int n = Integer.parseInt(f.readLine());
        for (int i = 0 ; i < n ; i++) {
            animals.add(f.readLine().split(" "));
        }

        int maxYes = 0;

        for (int i = 0; i < animals.size(); i++) {
            for (int j = i+1 ; j < animals.size() ; j++) {
                int commonChar = 0;
                for (int k = 2 ; k < animals.get(i).length ; k++) {
                    for (int l = 2; l < animals.get(j).length; l++) {
                        if (animals.get(i)[k].equals(animals.get(j)[l])) {
                            commonChar++;
                        } 
                    }
                    
                }
                if (commonChar > maxYes) maxYes = commonChar;
            }
         }

        out.println(maxYes+1);
        out.close();
    }
}
