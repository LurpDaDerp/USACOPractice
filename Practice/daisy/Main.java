import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] flowerPetals = new int[n];
        for (int i = 0; i < n; i++) {
            flowerPetals[i] = sc.nextInt();
        }
        int averages = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> flowers = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    flowers.add(flowerPetals[k]);
                }
                int sum = 0;
                for (Integer petals : flowers) {
                    sum += petals;
                }
                if (sum % flowers.size() == 0) {
                    if (flowers.contains(sum / flowers.size())) averages ++;
                }
                
            }
        }

        System.out.println(averages);
    }
}