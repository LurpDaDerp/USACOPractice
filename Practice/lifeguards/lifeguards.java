/*
ID: lurpdaderp
LANG: JAVA
TASK: lifeguards
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        int n = Integer.parseInt(f.readLine());
        ArrayList<int[]> coveredTimes = new ArrayList<>();

        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] line = f.readLine().split(" ");
            times[i][0] = Integer.parseInt(line[0]);
            times[i][1] = Integer.parseInt(line[1]);
        }

        int maxTime = 0;
        
        int firedIndex = 0;
        for (firedIndex = 0; firedIndex < n; firedIndex++) {
            
            int curTime = 0;
            coveredTimes.clear();
            for (int i = 0; i < n; i++) {
                if (i == firedIndex) continue;
                coveredTimes.add(new int[] { times[i][0], times[i][1] });
            }
            Collections.sort(coveredTimes, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });
            for (int i = 0; i < coveredTimes.size()-1; i++) {
                if (coveredTimes.get(i)[1] >= coveredTimes.get(i+1)[0]) {
                    coveredTimes.get(i+1)[0] = coveredTimes.get(i)[0];
                    coveredTimes.get(i)[0] = 0;
                    coveredTimes.get(i)[1] = 0;
                }
            }
            for (int i = 0; i < coveredTimes.size(); i++) {
                curTime += coveredTimes.get(i)[1] - coveredTimes.get(i)[0];
                if (curTime >  maxTime) maxTime = curTime;
            }
            
        }
            
        

        out.println(maxTime);
        out.close();
    }
}