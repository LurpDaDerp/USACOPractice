import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] road = new int[100];
        int[] cow = new int[100];

        int position = 0;
        for (int i = 0; i < n; i++) {
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for (int j = 0; j < length; j++) {
                road[position] = speed;
                position++;
            }
        }
        position = 0;
        for (int i = 0; i < m; i++) {
            int length = sc.nextInt();
            int speed = sc.nextInt();
            for (int j = 0; j < length; j++) {
                cow[position] = speed;
                position++;
            }
        }

        int maxOverSpeed = 0;

        for (int i = 0; i < road.length; i++) {
            if (cow[i] - road[i] > maxOverSpeed) maxOverSpeed = cow[i]-road[i];
        }

        System.out.println(maxOverSpeed);
    }
}