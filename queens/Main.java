import java.util.*;

public class Main {

    static int dimensions = 8;
    static char[][] board = new char[dimensions][dimensions];
    static String[] input = new String[dimensions];
    static int total = 0;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        for (int i = 0; i < dimensions; i++) {
            input[i] = sc.nextLine();
            for (int j = 0; j < dimensions; j++) {
                board[i][j] = '.';
            }
        }
        
        place(0);
        System.out.println(total);
        
        
    }

    public static void place(int row) {
        for (int col = 0; col < dimensions; col++) {
            if (valid(row, col)) {
                board[row][col] = 'Q';
                if (row == dimensions-1) {
                    output();
                    board[row][col] = '.';
                    return;                    
                }
                place(row+1);
                board[row][col] = '.';
            } 

        }
    }

    public static boolean valid(int row, int col) {
        if (input[row].charAt(col) == '*') return false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (board[i][j] == 'Q') {
                    if (col == j) return false;
                    if (Math.abs(row - i) == Math.abs(col - j)) return false;
                    
                }
            }
        }
        
        return true;
    }

    public static void output() {
        total++;
        /* for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        } */
    }
}