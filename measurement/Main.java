import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int measurements = sc.nextInt();
        sc.nextLine();
        String[][] logs = new String[measurements][3];
        for (int i = 0; i < measurements; i++) {
            logs[i] = sc.nextLine().split(" ");
        }

        HashMap<String, Integer> cows = new HashMap<>();
        cows.put("Bessie", 7);
        cows.put("Elsie", 7);
        cows.put("Mildred", 7);

        Arrays.sort(logs, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        int updates = 0;
        ArrayList<String> leaderboard = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String cow = logs[i][1];
            int change = Integer.parseInt(logs[i][2]);
            cows.put(cow, cows.get(cow) + change);

            int curMaxMilk = Collections.max(cows.values());

            ArrayList<String> tempLeaderboard = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : cows.entrySet()) {
                if (entry.getValue() == curMaxMilk) {
                    tempLeaderboard.add(entry.getKey());
                }
            }

            Collections.sort(tempLeaderboard);
            Collections.sort(leaderboard);
            if (!leaderboard.equals(tempLeaderboard)) {
                updates++;
                leaderboard = new ArrayList<>(tempLeaderboard); 
            }
        }

        System.out.println(updates);
    }
}
