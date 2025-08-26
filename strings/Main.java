import java.util.*;

public class Main {

    static char[] characters;
    static boolean[] used;
    static ArrayList<String> combinations;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        characters = input.toCharArray();
        Arrays.sort(characters); 

        used = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            used[i] = false;
        }
        
        combinations = new ArrayList<>();
        char[] cur = new char[input.length()];

        nextCombination(cur, 0);

        System.out.println(combinations.size());
        for (String string : combinations) {
            System.out.println(string);
        }
    }

    public static void nextCombination(char[] curString, int index) {
        if (index == characters.length) {
            combinations.add(new String(curString));
            return;
        }
        for (int i = 0; i < characters.length; i++) {
            if (used[i]) continue;
            if (i > 0 && characters[i] == characters[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            curString[index] = characters[i]; 
            nextCombination(curString, index+1);
            used[i] = false;
        }
    }
}