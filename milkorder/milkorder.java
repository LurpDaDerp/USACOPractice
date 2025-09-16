/*
ID: lurpdaderp
LANG: JAVA
TASK: milkorder
*/

import java.io.*;
import java.util.*;

public class milkorder {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int M = Integer.parseInt(line[1]);
        final int K = Integer.parseInt(line[2]);

        int[] orderCows = new int[M];
        line = f.readLine().split(" "); 
        for (int i = 0; i < M; i++) {
            orderCows[i] = Integer.parseInt(line[i]);
        }

        int[] setPostitions = new int[N];

        for (int i = 0; i < K; i++) {
            line = f.readLine().split(" ");
            setPostitions[Integer.parseInt(line[1])-1] = Integer.parseInt(line[0]);
        }

        int bestIndex = N-1;
        for (int i = M-1; i >=0; i--) {
            boolean overlap = false;
            for (int j = N-1; j >= 0; j--) {
                if (setPostitions[j] == orderCows[i]) {
                    bestIndex = j;
                    overlap = true;
                    if (orderCows[i] == 1) {
                        
                    }
                }
            }
            while (setPostitions[bestIndex] != 0 && !overlap) {
                bestIndex--;
            }
            setPostitions[bestIndex] = orderCows[i];
            bestIndex--;
        }

        int smallestIndex = 0;
        for (int i = 0; i < N; i++) {
            if (setPostitions[i] == 0) {
                smallestIndex = i+1;
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            if (setPostitions[i] == 1) {
                smallestIndex = i+1;
                break;
            }
        }

        out.println(smallestIndex);
    
        out.close();
    }
}