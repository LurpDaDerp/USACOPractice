import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int W = sc.nextInt();
            int H = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();

            int existingWidth = x2 - x1;
            int existingHeight = y2 - y1;

            int answer = Integer.MAX_VALUE;

            if (w <= x1) answer = 0;
            else if (w <= W - x2) answer = 0;
            else if (w + existingWidth <= W)
                answer = Math.min(answer, Math.min(w - x1, x2 - (W - w)));

            if (h <= y1) answer = 0;
            else if (h <= H - y2) answer = 0;
            else if (h + existingHeight <= H)
                answer = Math.min(answer, Math.min(h - y1, y2 - (H - h)));

            if (answer == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        }
    }
}
