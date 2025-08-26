import java.util.ArrayList;
import java.util.Scanner;

public class photo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] flowers = new int[n];
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            flowers[i] = Integer.parseInt(line[i]);
        }

        int averages = 0;

        for (int i = 0; i < n - 1; i++) {
            ArrayList<Double> set = new ArrayList<>();
            int x = 0;
            double sum = 0;
            for (int j = i; j < n; j++) {
                set.add((double)flowers[j]);
                sum += set.get(j - i);
                x++;
                if (set.contains(sum / (double)x)) {
                    averages++;
                }
            }
        }

        System.out.println(averages + 1);
        scanner.close();
    }
}
