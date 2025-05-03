/*
ID: lurpdaderp
LANG: JAVA
TASK: blocks
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int n = Integer.parseInt(f.readLine());
        String[][] blocks = new String[n][2];

        HashMap<Character, Integer> letters = new HashMap<>();


        for (Character ch = 'a'; ch <= 'z'; ++ch) {
            letters.put(Character.valueOf(ch), 0); 
        }
        

        for (int i = 0 ; i < n ; i++) {
            String[] line = f.readLine().split(" ");
            for (int j = 0 ; j < 2 ; j++) {
                blocks[i][j] = line[j];
            }
        }

        for (int i = 0 ; i < n ; i++) {
            char[] word1 = blocks[i][0].toCharArray();
            char[] word2 = blocks[i][1].toCharArray();
            int[] letterCounts1 = new int[26];
            int[] letterCounts2 = new int[26];
            for (int k = 0 ; k < word1.length ; k++) {
                letterCounts1[word1[k]-'a']++;
            }
            for (int k = 0 ; k < word2.length ; k++) {
                letterCounts2[word2[k]-'a']++;
            }
            for (int k = 0 ; k < 26 ; k++) {
                letters.put((char)('a' + k), letters.get((char)('a' + k)) + Math.max(letterCounts1[k], letterCounts2[k]));
            }
        }

        int i = 0;
        int size = letters.size();

        for (Character ch : letters.keySet()) {
            out.print(letters.get(ch).toString());
            i++;
            if (i < size) {
                out.print("\n");
            }
        }

        out.close();

    }
}
