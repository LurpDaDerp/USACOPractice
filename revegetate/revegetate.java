/*
ID: lurpdaderp
LANG: JAVA
TASK: revegetate
*/

import java.io.*;
import java.util.*;

public class revegetate {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int M = Integer.parseInt(line[1]);

        Map<Integer, ArrayList<Integer>> pastures = new HashMap<>();
        int[] pastureGrassTypes = new int[N + 1]; 

        for (int i = 0; i < M; i++) {
            line = f.readLine().split(" ");
            int pasture1 = Integer.parseInt(line[0]);
            int pasture2 = Integer.parseInt(line[1]);
            pastures.putIfAbsent(pasture1, new ArrayList<>());
            pastures.get(pasture1).add(pasture2);
            pastures.putIfAbsent(pasture2, new ArrayList<>());
            pastures.get(pasture2).add(pasture1);
        }

        for (int i = 1; i <= N; i++) { 
            boolean[] openSeeds = new boolean[] {true, true, true, true, true};
            if (pastures.containsKey(i)) {
                for (Integer other : pastures.get(i)) {
                    if (pastureGrassTypes[other] != 0) {
                        openSeeds[pastureGrassTypes[other]] = false;
                    }
                }
            }
            for (int j = 1; j <= 4; j++) {
                if (openSeeds[j]) {
                    pastureGrassTypes[i] = j;
                    break;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            out.print(pastureGrassTypes[i]);
        }
        out.close();
    }
}
