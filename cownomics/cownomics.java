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

public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));

        String[] line = f.readLine().split(" ");
        int cows = Integer.parseInt(line[0]); // number of cows
        int length = Integer.parseInt(line[1]); // number of genes

        String[] spotty = new String[cows];
        String[] plain = new String[cows];
        for (int i = 0; i < cows; i++) {
            spotty[i] = f.readLine();
        }
        for (int i = 0; i < cows; i++) {
            plain[i] = f.readLine();
        }
        int triplets = 0;
        int positions = 0;
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                for (int k = j+1; k < length; k++) {
                    positions++;
                    String[] spottyGenes = new String[cows];
                    String[] plainGenes = new String[cows];
                    for (int x = 0; x < cows; x++) {
                        spottyGenes[x] = "" + spotty[x].charAt(i) + spotty[x].charAt(j) + spotty[x].charAt(k);
                    }
                    for (int x = 0; x < cows; x++) {
                        plainGenes[x] = "" + plain[x].charAt(i) + plain[x].charAt(j) + plain[x].charAt(k);
                    }
                    boolean valid = true;
                    for (int x = 0; x < cows; x++) {
                        if (!valid) {
                            
                            break;
                        }
                        for (int y = 0; y < cows; y++) {
                            if (spottyGenes[x].equals(plainGenes[y])) {
                                valid = false;
                                triplets++;
                                break;
                            }
                        }
                    }
                }
            }        
        }
        out.println(positions-triplets);
        out.close();
    }
}