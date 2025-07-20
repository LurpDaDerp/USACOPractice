//test
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sheetx1 = sc.nextInt();
        int sheety1 = sc.nextInt(); 
        int sheetx2 = sc.nextInt();
        int sheety2 = sc.nextInt();

        int block1x1 = sc.nextInt();
        int block1y1 = sc.nextInt(); 
        int block1x2 = sc.nextInt();
        int block1y2 = sc.nextInt();

        int block2x1 = sc.nextInt();
        int block2y1 = sc.nextInt(); 
        int block2x2 = sc.nextInt();
        int block2y2 = sc.nextInt();

        int sheetArea = (sheetx2 - sheetx1) * (sheety2 - sheety1);

        int b1x1 = Math.max(sheetx1, block1x1);
        int b1y1 = Math.max(sheety1, block1y1);
        int b1x2 = Math.min(sheetx2, block1x2);
        int b1y2 = Math.min(sheety2, block1y2);

        int block1Area = Math.max(0, b1x2 - b1x1) * Math.max(0, b1y2 - b1y1);

        int b2x1 = Math.max(sheetx1, block2x1);
        int b2y1 = Math.max(sheety1, block2y1);
        int b2x2 = Math.min(sheetx2, block2x2);
        int b2y2 = Math.min(sheety2, block2y2);

        int block2Area = Math.max(0, b2x2 - b2x1) * Math.max(0, b2y2 - b2y1);

        int overlapX1 = Math.max(b1x1, b2x1);
        int overlapY1 = Math.max(b1y1, b2y1);
        int overlapX2 = Math.min(b1x2, b2x2);
        int overlapY2 = Math.min(b1y2, b2y2);

        int overlapArea = 0;
        if (overlapX2 > overlapX1 && overlapY2 > overlapY1) {
            overlapArea = (overlapX2 - overlapX1) * (overlapY2 - overlapY1);
        }

        int covered = block1Area + block2Area - overlapArea;

        if (covered >= sheetArea) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
