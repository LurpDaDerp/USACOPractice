import java.io.*;
import java.util.*;

public class race {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("race.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        int[] finishingSpeeds = new int[N];
        for (int i = 0; i < N; i++) {
            finishingSpeeds[i] = Integer.parseInt(br.readLine());
        }

        for (Integer finalSpeed : finishingSpeeds) {
            int timeFromStart = 0;
            int speedUp = 0;
            int slowDown = 0;
            int speed = 0;
            for (speed = 1;; speed++) {
                speedUp += speed;
                timeFromStart++;
                if (speedUp + slowDown >= K) {
                    break;
                }
                if (speed >= finalSpeed) {
                    timeFromStart++;
                    slowDown += speed;
                    if (speedUp + slowDown >= K) {
                        break;
                    }
                }
            }
            pw.println(timeFromStart);
        }

        pw.close();
        br.close();
    }
}