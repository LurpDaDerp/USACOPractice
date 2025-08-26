/*
ID: lurpdaderp
LANG: JAVA
TASK: bcs
*/

import java.io.*;
import java.util.*;

public class bcs {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("bcs.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));

        String[] line = f.readLine().split(" ");
        final int N = Integer.parseInt(line[0]);
        final int K = Integer.parseInt(line[1]);

        char[][] original = new char[N][N];
        for (int i = 0; i < N; i++) {
            String row = f.readLine();
            for (int j = 0; j < N; j++) {
                original[i][j] = row.charAt(j);
            }
        }
        original = crop(original);

        char[][][] pieces = new char[K][][];
        for (int k = 0; k < K; k++) {
            char[][] piece = new char[N][N];
            for (int i = 0; i < N; i++) {
                String row = f.readLine();
                for (int j = 0; j < N; j++) {
                    piece[i][j] = row.charAt(j);
                }
            }
            pieces[k] = piece;
        }

        int index1 = 0;
        int index2 = 0;
        boolean found = false;
        for (int i = 0; i < K - 1; i++) {
            if (found) break;
            for (int j = i + 1; j < K; j++) {
                if (found) break;
                char[][] piece1 = pieces[i];
                char[][] piece2 = pieces[j];
                int total = 0;

                int rows1 = piece1.length;
                int cols1 = piece1[0].length;
                int rows2 = piece2.length;
                int cols2 = piece2[0].length;
                

                for (int rowOffset = -rows2; rowOffset <= rows1; rowOffset++) {
                    if (found) break;
                    for (int colOffset = -cols2; colOffset <= cols1; colOffset++) {
                        if (found) break;
                        int top = Math.min(0, rowOffset);
                        int left = Math.min(0, colOffset);
                        int bottom = Math.max(rows1, rowOffset + rows2);
                        int right = Math.max(cols1, colOffset + cols2);

                        int combinedRows = bottom - top;
                        int combinedCols = right - left;

                        char[][] combined = new char[combinedRows][combinedCols];
                        for (int r = 0; r < combinedRows; r++) {
                            Arrays.fill(combined[r], '.');
                        }

                        for (int r = 0; r < rows1; r++) {
                            for (int c = 0; c < cols1; c++) {
                                combined[r - top][c - left] = piece1[r][c];
                            }
                        }

                        boolean overlap = false;
                        for (int r = 0; r < rows2; r++) {
                            for (int c = 0; c < cols2; c++) {
                                char ch = piece2[r][c];
                                if (ch == '#') {
                                    if (combined[r + rowOffset - top][c + colOffset - left] == ch) {
                                        overlap = true;
                                        break;
                                    }
                                    combined[r + rowOffset - top][c + colOffset - left] = ch;
                                }
                            }
                        }

                        if (overlap) continue;

                        combined = crop(combined);
                        if (arraysEqual(original, combined)) {
                            index1 = i+1;
                            index2 = j+1;
                            found = true;
                            break;
                        }

                    }
                }
            }
        }



        out.println(index1 + " " + index2);
        out.close();
    }

    public static boolean arraysEqual(char[][] arr1, char[][] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) return false;
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }

    public static char[][] crop(char[][] original) {
        int rows = original.length;
        int cols = original[0].length;

        ArrayList<Integer> emptyRows = new ArrayList<>();
        ArrayList<Integer> emptyCols = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            boolean empty = true;
            for (int j = 0; j < cols; j++) {
                if (original[i][j] == '#') {
                    empty = false;
                    break;
                }
            }
            if (empty) emptyRows.add(i);
        }

        for (int j = 0; j < cols; j++) {
            boolean empty = true;
            for (int i = 0; i < rows; i++) {
                if (original[i][j] == '#') {
                    empty = false;
                    break;
                }
            }
            if (empty) emptyCols.add(j);
        }

        int newRows = rows - emptyRows.size();
        int newCols = cols - emptyCols.size();
        char[][] cropped = new char[newRows][newCols];

        int newRow = 0;
        for (int i = 0; i < rows; i++) {
            if (emptyRows.contains(i)) continue;
            int newCol = 0;
            for (int j = 0; j < cols; j++) {
                if (emptyCols.contains(j)) continue;
                cropped[newRow][newCol] = original[i][j];
                newCol++;
            }
            newRow++;
        }

        return cropped;
    }
}
