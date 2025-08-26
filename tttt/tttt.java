/*
ID: lurpdaderp
LANG: JAVA
TASK: tttt
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class tttt {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

        char[][] allPositions = new char[8][3];

        for (int i = 0 ; i < 3 ; i++) {
            allPositions[i] = f.readLine().toCharArray();
        }
        for (int i = 0 ; i < 3 ; i++) {
            char[] column = new char[3];
            for (int k = 0 ; k < 3 ; k++) {
                column[k] = allPositions[k][i];
            }
            allPositions[3 + i] = column;
        }
        for (int i = 0 ; i < 3 ; i++) {
            allPositions[6][i] = allPositions[i][i];
            allPositions[7][i] = allPositions[i][2-i];
        }

        ArrayList<String> soloWinnerList = new ArrayList<>();
        ArrayList<String> duoWinnerList = new ArrayList<>();
        int soloWinners = 0;
        int duoWinners = 0;

        for (int i = 0 ; i < allPositions.length ; i++) {
            int differents = 0;
            char[] differentLetters = new char[3];
            for (int j = 0 ; j < 3 ; j++) {
                if (allPositions[i][j] != differentLetters[0] && allPositions[i][j] != differentLetters[1] && allPositions[i][j] != differentLetters[2]) {
                    for (int k = 0 ; k < 3 ; k++) {
                        if (differentLetters[k] == '\0') {
                            System.out.println("hello");
                            differents++;
                            differentLetters[k] = allPositions[i][j];
                            break;
                        }
                    }
                }
            }
            if (differents == 1 && !soloWinnerList.contains(String.valueOf(differentLetters[0]))) {
                soloWinners++;
                soloWinnerList.add(String.valueOf(differentLetters[0]));
            }

            if (differents == 2 && !duoWinnerList.contains(String.valueOf(differentLetters[0]) + String.valueOf(differentLetters[1]))) {
                duoWinners++;
                duoWinnerList.add(String.valueOf(differentLetters[0]) + String.valueOf(differentLetters[1]));
            } 
        }

        out.println(soloWinners);
        out.println(duoWinners);
        out.close();

    }
}
