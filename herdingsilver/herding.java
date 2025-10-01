/*
ID: lurpdaderp
LANG: JAVA
TASK: herding
*/

import java.io.*;
import java.util.*;

public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

        final int N = Integer.parseInt(f.readLine());
        int[] inputCows = new int[N];

        for (int i = 0; i < N; i++) {
            inputCows[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(inputCows);

        //max moves
        int maxMoves = 0;
        int gaps = 0;
        int leftGap = 0;
        int rightGap = 0;

        for (int i = 0; i < N-1; i++) {
            gaps += inputCows[i+1] - inputCows[i] - 1;
        }

        leftGap = inputCows[1] - inputCows[0] - 1;
        rightGap = inputCows[N-1] - inputCows[N-2] - 1;

        maxMoves = gaps - Math.min(leftGap, rightGap);

        //min moves
        int minMoves = Integer.MAX_VALUE;
        int index = 0;

        int maxFilled = 0;

        for (int i = 0; i < N; i++) {
            index = i;
            while (index < N && inputCows[index] - inputCows[i] <= N - 1) {
                index ++;
            }
            int filledspots = index - i;
            maxFilled = Math.max(filledspots, maxFilled);
        }

        minMoves = N - maxFilled;

        out.println(minMoves);
        out.println(maxMoves);

        out.close();
    }
}
