import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String data = "1\r\n" + //
                        "3 1 1\r\n" + //
                        "GBW\r\n" + //
                        "WGW\r\n" + //
                        "WWW\r\n" + //
                        "";
        Scanner sc = new Scanner(System.in);

        final int TESTCASES = sc.nextInt();

        for (int t = 0; t < TESTCASES; t++) {
            final int N = sc.nextInt();
            final int A = sc.nextInt();
            final int B = sc.nextInt();
            sc.nextLine();

            int minStars = 0;
            char[][] input = new char[N][N];
            int[][] sky = new int[N][N];
            boolean[][] wasOccupied = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                input[i] = sc.nextLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    if (input[i][j] == 'W') {
                        sky[i][j] = 0;
                    } else if (input[i][j] == 'G') {
                        sky[i][j] = 1;
                        wasOccupied[i][j] = true;
                    } else if (input[i][j] == 'B') {
                        sky[i][j] = 2;
                        wasOccupied[i][j] = true;
                    }
                }
            }

            
                
            boolean impossible = false;

            int originalStars = 0;

            if ((A == 0 && B == 0) || (N <= A || N <= B)) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (sky[i][j] > 0) originalStars += 1;
                    }
                }
                System.out.println(originalStars);
                continue;
            }

            for (int i = 0; i < N-B; i++) {
                if (impossible) break;
                for (int j = 0; j < N-A; j++) {
                    if (sky[i][j] == 2 && (i < B || j < A)) {
                        impossible = true;
                        break;
                    }                    
                    if (sky[i][j] == 2 && i >= B && j >= A && !wasOccupied[i-B][j-A]) {
                        impossible = true;
                        break;
                    }
                    sky[i+B][j+A] -= sky[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                if (impossible) break;
                for (int j = 0; j < N; j++) {
                    if (sky[i][j] > 0) originalStars += sky[i][j];
                    if (sky[i][j] == 2  && i >= B && j >= A && !wasOccupied[i-B][j-A]) {
                        impossible = true;
                        break;
                    } 
                }
            }

            System.out.println(impossible ? -1 : originalStars);
        }
    }
}