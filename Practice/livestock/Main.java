import java.util.*;

public class Main {

    static int n;
    static String[][] constraints;
    static String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
    static ArrayList<String> order = new ArrayList<>();
    static boolean[] used = new boolean[8];
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        constraints = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            constraints[i][0] = line[0];
            constraints[i][1] = line[line.length - 1];
        }

        Arrays.sort(cows); 
        nextCow(0);
    }

    public static void nextCow(int position) {
        if (found) return;

        if (position == 8) {
            if (orderValid(order)) {
                for (String cow : order) {
                    System.out.println(cow);
                }
                found = true;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (used[i]) continue;

            order.add(cows[i]);
            used[i] = true;

            nextCow(position + 1);

            used[i] = false;
            order.remove(order.size() - 1);
        }
    }

    public static boolean orderValid(ArrayList<String> ordering) {
        for (String[] constraint : constraints) {
            String a = constraint[0];
            String b = constraint[1];

            int indexA = ordering.indexOf(a);
            int indexB = ordering.indexOf(b);

            if (indexA == -1 || indexB == -1) continue;

            if (Math.abs(indexA - indexB) != 1) return false;
        }
        return true;
    }
}
