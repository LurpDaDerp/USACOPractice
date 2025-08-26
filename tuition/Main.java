import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Long> offers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            offers.add(sc.nextLong());
        }

        Collections.sort(offers);

        long maxRevenue = 0;
        long bestTuition = 0;

        for (int i = 0; i < n; i++) {
            long tuition = offers.get(i);
            int students = n - i;
            long revenue = tuition * students;

            if (revenue > maxRevenue || (revenue == maxRevenue && tuition < bestTuition)) {
                maxRevenue = revenue;
                bestTuition = tuition;
            }
        }

        System.out.println(maxRevenue + " " + bestTuition);
    }
}
