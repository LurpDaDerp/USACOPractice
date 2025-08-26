import java.util.*;

public class Main {
    public static void main(String[] args) {
        String data = "";
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        int[] breedID = new int[N];

        int evens = 0;
        int odds = 0;

        for (int i = 0; i < N; i++) {
            breedID[i] = sc.nextInt();
            if (breedID[i] % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        
        int groupEvens = evens;
        int groupOdds = odds;

        while (groupOdds - groupEvens > 0) {
            groupOdds -= 2;
            groupEvens++;
        }
        while (groupEvens-groupOdds > 1) {
            groupEvens--;
        }
    
        

        System.out.println(groupEvens + groupOdds);
    }
}
