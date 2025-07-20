import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] data = new int[n][3];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            data[i][1] = Integer.parseInt(line[1]);
            data[i][2] = Integer.parseInt(line[2]);
            if (line[0].equals("none")) {
                data[i][0] = 0;
            }
            if (line[0].equals("off")) {
                data[i][0] = 1;
            }
            if (line[0].equals("on")) {
                data[i][0] = 2;
            }
        }

        int lowerRange = 0;
        int upperRange = 1000;
        for (int i = n - 1; i >= 0; i--) {
            if (data[i][0] == 0) {
                lowerRange = Math.max(lowerRange, data[i][1]);
                upperRange = Math.min(upperRange, data[i][2]);
            }
            if (data[i][0] == 1) { 
                lowerRange += data[i][1];
                upperRange += data[i][2];
            }
            if (data[i][0] == 2) { 
                lowerRange = Math.max(0, lowerRange - data[i][2]);
                upperRange = Math.max(0, upperRange - data[i][1]);
            }
        }
        System.out.println(lowerRange + " " + upperRange);

        lowerRange = 0;
        upperRange = 1000;
        for (int i = 0; i < n; i++) {
            if (data[i][0] == 0) {
                lowerRange = Math.max(lowerRange, data[i][1]);
                upperRange = Math.min(upperRange, data[i][2]);
            }
            if (data[i][0] == 2) {
                lowerRange += data[i][1];
                upperRange += data[i][2];
            }
            if (data[i][0] == 1) {
                lowerRange = Math.max(0, lowerRange - data[i][2]);
                upperRange = Math.max(0, upperRange - data[i][1]);
            }
        }
        System.out.println(lowerRange + " " + upperRange);
    }
}
