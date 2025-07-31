import java.util.*;

public class Main {

    static List<Integer> positions;
    static Set<Integer> positionSet;
    static int maxExplosions = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            positions.add(sc.nextInt());
        }

        Collections.sort(positions);
        positionSet = new HashSet<>(positions);  

        for (int i = 0; i < positions.size(); i++) {
            int start = positions.get(i);
            Set<Integer> visited = new HashSet<>();
            visited.add(start);
            List<Integer> exploding = new ArrayList<>();
            exploding.add(start);
            explode(true, 1, 1, exploding, visited);
        }

        System.out.println(maxExplosions);
    }

    public static void explode(boolean possible, int radius, int curExplosions, List<Integer> curExploding, Set<Integer> visited) {
        if (!possible) {
            maxExplosions = Math.max(maxExplosions, curExplosions);
            return;
        }

        boolean nextPossible = false;
        List<Integer> nextExploding = new ArrayList<>();
        Set<Integer> newVisited = new HashSet<>(visited);

        for (int pos : curExploding) {
            for (int offset = 1; offset <= radius; offset++) {
                int left = pos - offset;
                int right = pos + offset;

                if (positionSet.contains(left) && !newVisited.contains(left)) {
                    nextExploding.add(left);
                    newVisited.add(left);
                    curExplosions++;
                    nextPossible = true;
                }

                if (positionSet.contains(right) && !newVisited.contains(right)) {
                    nextExploding.add(right);
                    newVisited.add(right);
                    curExplosions++;
                    nextPossible = true;
                }
            }
        }

        explode(nextPossible, radius + 1, curExplosions, nextExploding, newVisited);
    }
}
