import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3]; 
        for (int i = 0; i < 3; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        Set<Character> individualWins = new HashSet<>();
        Set<String> teamWins = new HashSet<>();

        int[][][] lines = {
            {{0,0}, {0,1}, {0,2}},
            {{1,0}, {1,1}, {1,2}},
            {{2,0}, {2,1}, {2,2}},
            {{0,0}, {1,0}, {2,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,2}, {1,2}, {2,2}},
            {{0,0}, {1,1}, {2,2}},
            {{0,2}, {1,1}, {2,0}}
        };

        for (int[][] line : lines) {
            char a = board[line[0][0]][line[0][1]];
            char b = board[line[1][0]][line[1][1]];
            char c = board[line[2][0]][line[2][1]];

            Set<Character> unique = new HashSet<>();
            unique.add(a);
            unique.add(b);
            unique.add(c);

            if (unique.size() == 1) {
                individualWins.add(a);
            } else if (unique.size() == 2) {
                Map<Character, Integer> freq = new HashMap<>();
                freq.put(a, freq.getOrDefault(a, 0) + 1);
                freq.put(b, freq.getOrDefault(b, 0) + 1);
                freq.put(c, freq.getOrDefault(c, 0) + 1);

                if (freq.containsValue(2) && freq.containsValue(1)) {
                    List<Character> sorted = new ArrayList<>(unique);
                    Collections.sort(sorted);
                    teamWins.add("" + sorted.get(0) + sorted.get(1));
                }
            }
        }

        System.out.println(individualWins.size() + "\n" + teamWins.size());
    }
}
