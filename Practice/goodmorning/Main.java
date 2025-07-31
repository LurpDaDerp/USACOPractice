import java.util.*;

public class Main {

    static int finalClosest;

    static int[][] keypad = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {-1, 0, -1}  
    };

    static int[] digit1Index;
    static int[] digit2Index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        
        int[] targets = new int[testcases];
        for (int i = 0; i < testcases; i++) {
            targets[i] = sc.nextInt();
        }
       

        for (int i = 0; i < testcases; i++) {
            finalClosest = -1;
            nextKey(0, 0, targets[i]);
            System.out.println(finalClosest);
        }
    }

    public static void nextKey(int curKeyIndex, int curKeyNumber, int target) {
        if (!keyValid(curKeyNumber)) return;

        if (curKeyIndex == 4) return;

        if (finalClosest == -1 || Math.abs(target - finalClosest) > Math.abs(target - curKeyNumber)) {
            finalClosest = curKeyNumber;
        }

        for (int i = 0; i < 10; i++) {
            nextKey(curKeyIndex + 1, curKeyNumber * 10 + i, target);
        }
    }

    public static boolean keyValid(int curKey) {
        if (curKey == 0) return true;

        String s = Integer.toString(curKey);
        for (int i = 0; i < s.length() - 1; i++) {
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i + 1) - '0';

            int[] pos1 = getPosition(d1);
            int[] pos2 = getPosition(d2);

            if (pos2[0] < pos1[0] || pos2[1] < pos1[1]) {
                return false;
            }
        }

        return true;
    }

    public static int[] getPosition(int digit) {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] == digit) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
