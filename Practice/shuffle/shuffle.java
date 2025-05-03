/*
ID: lurpdaderp
LANG: JAVA
TASK: shuffle
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class shuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        String line = f.readLine();
        int numberCows = Integer.parseInt(line);

        line = f.readLine();
        String[] content = line.split(" ");
        int[] shuffles = new int[numberCows];
        for (int i = 0 ; i < numberCows ; i++) {
            shuffles[i] = Integer.parseInt(content[i]);
        }

        line = f.readLine();
        content = line.split(" ");
        int[] cows = new int[numberCows];
        for (int i = 0 ; i < numberCows ; i++) {
            cows[i] = Integer.parseInt(content[i]);
        }

        int[] tempOrder = new int[numberCows];
        
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < numberCows ; j++) {
                
                tempOrder[j] = cows[shuffles[j]-1];
            }
            for (int j = 0 ; j < numberCows ; j++) {
                cows[j] = tempOrder[j];
            }
        }
        
        for (int i = 0 ; i < numberCows ; i++) {
            out.println(cows[i]);
        }

        out.close();

    }
}
