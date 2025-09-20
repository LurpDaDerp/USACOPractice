/*
ID: your_id_here
LANG: JAVA
TASK: billboard
*/

import java.io.*;
import java.util.*;

public class billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer st;

        st = new StringTokenizer(f.readLine());
        int lx1 = Integer.parseInt(st.nextToken());
        int ly1 = Integer.parseInt(st.nextToken());
        int lx2 = Integer.parseInt(st.nextToken());
        int ly2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        int cx1 = Integer.parseInt(st.nextToken());
        int cy1 = Integer.parseInt(st.nextToken());
        int cx2 = Integer.parseInt(st.nextToken());
        int cy2 = Integer.parseInt(st.nextToken());

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int x = lx1; x < lx2; x++) {
            for (int y = ly1; y < ly2; y++) {
                if (!(x >= cx1 && x < cx2 && y >= cy1 && y < cy2)) {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x + 1);
                    maxY = Math.max(maxY, y + 1);
                }
            }
        }

        if (minX == Integer.MAX_VALUE) {
            out.println(0);
        } else {
            out.println((maxX - minX) * (maxY - minY));
        }

        out.close();
    }
}
