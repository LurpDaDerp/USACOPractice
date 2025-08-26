import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int length1 = b-a;
        int length2 = d-c;

        int totalLength = length1 + length2;

        int overlap = Math.max(0, Math.min(b, d) - Math.max(a, c));
        System.out.println(totalLength-overlap);
    }
}