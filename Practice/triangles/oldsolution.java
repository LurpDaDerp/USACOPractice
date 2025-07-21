/*
ID: lurpdaderp
LANG: JAVA
TASK: triangles
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

        int n = Integer.parseInt(f.readLine());
        int[][] posts = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = f.readLine().split(" ");
            posts[i][0] = Integer.parseInt(line[0]);
            posts[i][1] = Integer.parseInt(line[1]);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (posts[j][0] == posts[i][0]) {
                    int base = Math.abs(posts[j][1] - posts[i][1]);
                    for (int k = 0; k < n; k++) {
                        if (posts[k][1] == posts[j][1] || posts[k][1] == posts[i][1]) {
                            int height = Math.abs(posts[k][0] - posts[i][0]);
                            if (base * height > maxArea) maxArea = (base * height);
                        }
                    }
                }
            }
        }

        out.print(maxArea);
        out.close();
    }
}
