import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "3\r\n" + //
                        "1 3 2\r\n" + //
                        "3 2 1";
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        int[] originalCows = new int[N];
        int[] requiredCows = new int[N];

        ArrayList<Integer> originals = new ArrayList<>();

        int[][] originalPosRequiredPos = new int[N][2];

        for (int i = 0; i < N; i++) {
            originalCows[i] = sc.nextInt();
            originalPosRequiredPos[i][0] = i;
            originals.add(originalCows[i]);
        }

        for (int i = 0; i < N; i++) {
            requiredCows[i] = sc.nextInt();
            originalPosRequiredPos[originals.indexOf(requiredCows[i])][1] = i;
        }

        long totalChecked = 0;

        for (int i = 0; i < N; i++) {
            totalChecked += Math.min(Math.min(originalPosRequiredPos[i][0], originalPosRequiredPos[i][1]) + 1, N - Math.max(originalPosRequiredPos[i][0], originalPosRequiredPos[i][1]));
        }

        System.out.println(totalChecked);
    }
}