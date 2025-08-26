import java.util.*;

public class Main {

    static String inputString;
    static ArrayList<Integer> emptyIndices;
    static int lCount = 0;
    static int total = 0;
    static boolean[] isVowel;
    static boolean inputL = false;
    static boolean inputValid = true;
    static final char EMPTY_CHAR = '_';
    static final char VOWEL_CHAR = 'v';
    static final char CONSONANT_CHAR = 'c';
    static final char L_CHAR = 'l';
    static char[] possibleChars = {VOWEL_CHAR, L_CHAR, CONSONANT_CHAR};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        inputString = "_____"; //sc.nextLine();
        emptyIndices = new ArrayList<>();
        char[] inputChars = inputString.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] == 'A' || inputChars[i] == 'E' || inputChars[i] == 'I' || inputChars[i] == 'O' || inputChars[i] == 'U') {
                inputChars[i] = VOWEL_CHAR;
            } else if (inputChars[i] == 'L') {
                inputChars[i] = L_CHAR;
                inputL = true;
            } else if (inputChars[i] == '_') {
                if (inputString.charAt(i) == '_') emptyIndices.add(i);
                continue;
            } else {
                inputChars[i] = CONSONANT_CHAR; 
            }
        }
        
        if (inputChars.length >= 3) {
            for (int i = 0; i < inputChars.length - 2; i++) {
                if (threeInARow(inputChars[i], inputChars[i+1], inputChars[i + 2])) {
                    System.out.println(0);
                    return;
                }
            }
        }
        

        nextSpace(0, inputChars);

        System.out.println(total);
    }

    public static void nextSpace(int index, char[] curString) {
        if (index == emptyIndices.size()) {
            if (inputL || lCount > 0) {
                int curPossibility = 1;
                for (int i = 0; i < emptyIndices.size(); i++) {
                    if (curString[emptyIndices.get(i)] == L_CHAR) {
                        curPossibility *= 1;
                    } else if (curString[emptyIndices.get(i)] == VOWEL_CHAR) {
                        curPossibility *= 5;
                    } else {
                        curPossibility *= 20; 
                    }
                 }
                 total += curPossibility;
            }
            return;
        }

        int curIndex = emptyIndices.get(index);
        for (int i = 0; i < 3; i++) {
            curString[curIndex] = possibleChars[i];
            if (!isValid(curString, curIndex)) {
                curString[curIndex] = '_';
                continue;
            }
            if (curString[curIndex] == L_CHAR) lCount++;
            nextSpace(index + 1, curString);
            if (curString[curIndex] == L_CHAR) lCount--;
        }
        curString[curIndex] = '_'; 
    }

    public static boolean isValid(char[] curString, int n) {
        for (int i = n-2; i <= n; i++) {
            if (i < 0 || i > curString.length-3) continue;
            if (threeInARow(curString[i], curString[i + 1], curString[i + 2])) return false;
        }
        return true;
    }

    public static boolean threeInARow(char a, char b, char c) {
        if (a == '_' || b == '_' || c == '_') return false;
        return ((a == 'c' || a == L_CHAR) && (b == 'c' || b == L_CHAR) && (c == 'c' || c == L_CHAR)) ||
               (a == VOWEL_CHAR && b == VOWEL_CHAR && c == VOWEL_CHAR);
    }
}