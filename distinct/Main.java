import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> distinct = new HashSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            distinct.add(sc.nextInt());
        }

        System.out.println(distinct.size());
    }
}