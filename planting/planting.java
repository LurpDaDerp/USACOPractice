/*
ID: lurpdaderp
LANG: JAVA
TASK: planting
*/

import java.io.*;
import java.util.*;

public class planting {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));

        final int N = Integer.parseInt(f.readLine());

        Map<Integer, ArrayList<Integer>> fieldConnections = new HashMap<>();

        
        for (int i = 0; i < N - 1; i++) {
            String[] line = f.readLine().split(" ");
            int field1 = Integer.parseInt(line[0]);
            int field2 = Integer.parseInt(line[1]);

            fieldConnections.putIfAbsent(field1, new ArrayList<>());
            fieldConnections.get(field1).add(field2);

            fieldConnections.putIfAbsent(field2, new ArrayList<>());
            fieldConnections.get(field2).add(field1);
        }

        int maxConnections = 0;

        for (ArrayList<Integer> connections : fieldConnections.values()) {
            maxConnections = Math.max(maxConnections, connections.size());
        }

        out.println(maxConnections+1);
        out.close();
    }
}