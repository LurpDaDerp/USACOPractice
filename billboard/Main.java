import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int board1x1 = sc.nextInt();
        int board1y1 = sc.nextInt();
        int board1x2 = sc.nextInt();
        int board1y2 = sc.nextInt();
        int board2x1 = sc.nextInt();
        int board2y1 = sc.nextInt();
        int board2x2 = sc.nextInt();
        int board2y2 = sc.nextInt();

        int truckx1 = sc.nextInt();
        int trucky1 = sc.nextInt();
        int truckx2 = sc.nextInt();
        int trucky2 = sc.nextInt();

        int board1Overlap = 0;
        int board2Overlap = 0;
        int board1Area = (board1x2 - board1x1) * (board1y2 - board1y1);
        int board2Area = (board2x2 - board2x1) * (board2y2 - board2y1);

        int x_overlap = Math.max(0, Math.min(board1x2, truckx2) - Math.max(board1x1, truckx1));
        int y_overlap = Math.max(0, Math.min(board1y2, trucky2) - Math.max(board1y1, trucky1));
        int overlapArea1 = x_overlap * y_overlap;

        x_overlap = Math.max(0, Math.min(board2x2, truckx2) - Math.max(board2x1, truckx1));
        y_overlap = Math.max(0, Math.min(board2y2, trucky2) - Math.max(board2y1, trucky1));
        int overlapArea2 = x_overlap * y_overlap;

        System.out.println(board1Area + board2Area - overlapArea1 - overlapArea2);

        System.out.println();
    }
}