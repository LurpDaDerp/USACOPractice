import java.util.*;

public class Main {
    static int[][] rects = new int[3][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            rects[i][0] = sc.nextInt();  
            rects[i][1] = sc.nextInt();  
        }

        for (int[] p : permutations(new int[]{0, 1, 2})) {
            for (int rotA = 0; rotA < 2; rotA++) {
                for (int rotB = 0; rotB < 2; rotB++) {
                    for (int rotC = 0; rotC < 2; rotC++) {
                        int[] A = rotate(rects[p[0]], rotA);
                        int[] B = rotate(rects[p[1]], rotB);
                        int[] C = rotate(rects[p[2]], rotC);

                        if (A[1] == B[1] && B[1] == C[1]) {
                            int side = A[1];
                            if (A[0] + B[0] + C[0] == side) {
                                printSquare(side, new int[][]{A, B, C}, p);
                                return;
                            }
                        }

                        int side = A[1];
                        if (A[1] == side && A[0] < side &&
                            B[0] == C[0] && B[0] + A[0] == side &&
                            B[1] + C[1] == side) {
                            printTopAndTwo(side, A, B, C, p);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static int[] rotate(int[] rect, int rot) {
        return rot == 0 ? rect : new int[]{rect[1], rect[0]};
    }

    static void printSquare(int size, int[][] rects, int[] perm) {
        System.out.println(size);
        for (int i = 0; i < 3; i++) {
            char label = (char)('A' + perm[i]); 
            for (int h = 0; h < rects[i][0]; h++) {
                for (int w = 0; w < size; w++) {
                    System.out.print(label);
                }
                System.out.println();
            }
        }
    }

    static void printTopAndTwo(int size, int[] A, int[] B, int[] C, int[] perm) {
        System.out.println(size);
        char labelA = (char)('A' + perm[0]);
        char labelB = (char)('A' + perm[1]);
        char labelC = (char)('A' + perm[2]);

        for (int i = 0; i < A[0]; i++) {
            for (int j = 0; j < size; j++) System.out.print(labelA);
            System.out.println();
        }

        for (int i = 0; i < B[0]; i++) {
            for (int j = 0; j < B[1]; j++) System.out.print(labelB);
            for (int j = 0; j < C[1]; j++) System.out.print(labelC);
            System.out.println();
        }
    }


    static List<int[]> permutations(int[] arr) {
        List<int[]> result = new ArrayList<>();
        permute(arr, 0, result);
        return result;
    }

    static void permute(int[] arr, int l, List<int[]> result) {
        if (l == arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l + 1, result);
            swap(arr, l, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
