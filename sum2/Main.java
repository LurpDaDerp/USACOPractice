import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int complement = x - value;

            if (map.containsKey(complement)) {
                System.out.println((map.get(complement) + 1) + " " + (i + 1));
                return;
            }

            map.put(value, i);
        }
        
        System.out.println("IMPOSSIBLE");
    }
}