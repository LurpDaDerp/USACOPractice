import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        int[] originalCows = new int[N];
        int[] requiredCows = new int[N];

        for (int i = 0; i < N; i++) {
            originalCows[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            requiredCows[i] = sc.nextInt();
        }

        long totalCount = 0;

        Map<Integer, List<Integer>> originalPositions = new HashMap<>();
        Map<Integer, List<Integer>> requiredPositions = new HashMap<>();

        for (int i = 0; i < N; i++) {
            originalPositions.computeIfAbsent(originalCows[i], k -> new ArrayList<>()).add(i);
            requiredPositions.computeIfAbsent(requiredCows[i], k -> new ArrayList<>()).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> species : originalPositions.entrySet()) {
            List<Integer> startingPositions = originalPositions.get(species.getKey());
            List<Integer> validPositions = requiredPositions.get(species.getKey());

            if (validPositions == null) continue;
            
            for (int original : startingPositions) {
                for (int target : validPositions) {
                    totalCount += countReversals(target, original, N);
                }
            }
        }

        System.out.println(totalCount);
    }

    static long countReversals(int target, int start, int N) {
        int sum = target + start; 
        int min = Math.min(target, start);
        int max = Math.max(target, start);

        int left = Math.max(max, sum - min);
        int right = Math.min(sum, N - 1);

        if (left > right) return 0;
        return right - left + 1;
    }
}