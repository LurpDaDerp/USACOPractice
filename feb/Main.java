import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        char[] msg = S.toCharArray();

        int fixed = 0;
        for (int i = 0; i < N - 1; i++) {
            if (msg[i] != 'F' && msg[i] == msg[i + 1]) fixed++;
        }

        int startIndex = 0;
        while (startIndex < N && msg[startIndex] == 'F') startIndex++;
        int endIndex = N - 1;
        while (endIndex >= 0 && msg[endIndex] == 'F') endIndex--;

        if (startIndex == N) {
            System.out.println(N);
            for (int i = 0; i <= N - 1; i++) System.out.println(i);
            return;
        }

        int minVal = fixed;
        int maxVal = fixed;
        int step = 1; 

        if (startIndex > 0) {
            int len = startIndex;
            maxVal += len;
        }
        if (endIndex < N - 1) {
            int len = N - 1 - endIndex;
            maxVal += len;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            if (msg[i] == 'F') {
                int j = i;
                while (j <= endIndex && msg[j] == 'F') j++;
                int len = j - i;
                char left = msg[i - 1];
                char right = msg[j];

                int segMin, segMax, segStep;
                if (left == right) {
                    if (len % 2 == 0) {
                        segMin = 1; segMax = len + 1; segStep = 2;
                    } else {
                        segMin = 0; segMax = len + 1; segStep = 2;
                    }
                } else {
                    if (len % 2 == 0) {
                        segMin = 0; segMax = len; segStep = 2;
                    } else {
                        segMin = 1; segMax = len; segStep = 2;
                    }
                }

                int newMin, newMax, newStep;

                if (minVal == maxVal) {
                    newMin = minVal + segMin;
                    newMax = minVal + segMax;
                    newStep = segStep;
                } else if (segMin == segMax) {
                    newMin = minVal + segMin;
                    newMax = maxVal + segMin;
                    newStep = step;
                } else {
                    newMin = minVal + segMin;
                    newMax = maxVal + segMax;
                    newStep = (step == 1 || segStep == 1) ? 1 : 2;
                }

                minVal = newMin;
                maxVal = newMax;
                step = newStep;

                i = j - 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int v = minVal; v <= maxVal; v += step) res.add(v);

        System.out.println(res.size());
        for (int v : res) System.out.println(v);
    }
}
