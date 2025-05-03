/*
ID: lurpdaderp
LANG: JAVA
TASK: measurement
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class measurement {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int measurements = Integer.parseInt(f.readLine());
        ArrayList<String> logs = new ArrayList<>();
        HashMap<String, Integer> cows = new HashMap<>();
        for (int i = 0 ; i < measurements ; i++) {
            String log = f.readLine();
            logs.add(log);
            String[] line = log.split(" ");
            cows.put(line[1], 7);
        }

        int displayChanges = 0;
        ArrayList<String> leaderboard = new ArrayList<>();
        for (String key : cows.keySet()) {
            leaderboard.add(key);
        }

        for (int time = 0; time < 100; time++) {
            for (int j = 0; j < logs.size(); j++) {
                String[] x = logs.get(j).split(" ");
                if (time == Integer.parseInt(x[0])) {
                    cows.put(x[1], cows.get(x[1]) + Integer.parseInt(x[2]));
                    int leaderboardSize = leaderboard.size();
                    String leaderboardFirst = leaderboard.get(0);
                    leaderboard.clear();

                    int curMax = 0;
                    for (String key : cows.keySet()) {
                        if (cows.get(key) > curMax) curMax = cows.get(key);
                    }
                    for (Map.Entry<String, Integer> entry : cows.entrySet()) {
                        if (Objects.equals(entry.getValue(), curMax)) {
                            leaderboard.add(entry.getKey());
                        }
                    }
                    if (leaderboardSize != leaderboard.size() || !leaderboard.get(0).equals(leaderboardFirst)) displayChanges++;
                }
                
            }
        }

        
        out.println(displayChanges);
        out.close();
    }
}