/*
ID: your_id_here
LANG: JAVA
TASK: paint
*/

import java.io.*;
import java.util.*;

public class paint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int length1 = b - a;
        int length2 = d - c;

        int totalLength = length1 + length2;

        int overlap = Math.max(0, Math.min(b, d) - Math.max(a, c));
        out.println(totalLength - overlap);

        out.close();
        br.close();
    }
}
