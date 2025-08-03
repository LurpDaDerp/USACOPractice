import java.util.*;
import java.io.*;

public class Main {

    static Map<String, String> wordTypes = new HashMap<>();
    static int maxLength = 0;
    static ArrayList<String> longestString = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);  

        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            wordTypes.clear();
            maxLength = 0;
            longestString.clear();

            ArrayList<String> sentence = new ArrayList<>();

            final int N = sc.nextInt();
            final int C = sc.nextInt();
            final int P = sc.nextInt();

            ArrayList<String> wordBank = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String word = sc.next();
                String type = sc.next();
                wordTypes.put(word, type);
                wordBank.add(word);
            }

            nextWord(0, N, wordBank, C, P, sentence);

            out.println(maxLength);
            for (String word : longestString) {
                out.print(word);
            }
            out.println();
        }

        sc.close();  
        out.close();
    }

    public static void nextWord(int curWordCount, int wordBankSize, ArrayList<String> availableWords, int commasLeft, int periodsLeft, ArrayList<String> curSentence) {
        if (!valid(curSentence, commasLeft, periodsLeft)) {
            return;
        } 
        
        if (curWordCount == wordBankSize) {
            if (curWordCount > maxLength) {
                maxLength = curWordCount;
                longestString = new ArrayList<>(curSentence); 
            }
            return;
        }
        
        for (int i = 0; i < availableWords.size(); i++) {
            String word = availableWords.get(i);
            curSentence.add(word + " ");

            ArrayList<String> newAvailableWords = new ArrayList<>(availableWords);
            newAvailableWords.remove(i);

            nextWord(curWordCount + 1, wordBankSize, newAvailableWords, commasLeft, periodsLeft, curSentence);

            curSentence.remove(curSentence.size() - 1);  
        }
    }

    public static boolean valid(ArrayList<String> curSentence, int commasLeft, int periodsLeft) {
        return true;
    }
}
