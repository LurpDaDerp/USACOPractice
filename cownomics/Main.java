import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] normalGenes = new String[n];
        String[] spottyGenes = new String[n];
        for (int i = 0; i < n; i++) {
            normalGenes[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            spottyGenes[i] = sc.nextLine();
        }

        int possiblePositions = 0;
        for (int i = 0; i < m; i++) {
            boolean possiblePosition = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (normalGenes[j].charAt(i) == spottyGenes[k].charAt(i)) possiblePosition = false;
                }
            }
            if (possiblePosition) possiblePositions++;
        }

        System.out.println(possiblePositions);
    }
}