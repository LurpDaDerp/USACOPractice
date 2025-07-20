import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lx1 = sc.nextInt();
        int ly1 = sc.nextInt();
        int lx2 = sc.nextInt();
        int ly2 = sc.nextInt();

        int cx1 = sc.nextInt();
        int cy1 = sc.nextInt();
        int cx2 = sc.nextInt();
        int cy2 = sc.nextInt();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int x = lx1; x < lx2; x++) {
            for (int y = ly1; y < ly2; y++) {
                if (!(x >= cx1 && x < cx2 && y >= cy1 && y < cy2)) {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x + 1);
                    maxY = Math.max(maxY, y + 1);
                }
            }
        }

        if (minX == Integer.MAX_VALUE) {
            System.out.println(0); 
        } else {
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}
