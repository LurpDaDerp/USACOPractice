import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[][] hints = new String[n][];

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            hints[i] = line;
        }
        
        int maxSharedTraits = 0;
        for (int x = 0; x < n; x++) {
            int traits = Integer.parseInt(hints[x][1]);
            
            ArrayList<String> traitsList = new ArrayList<>();
            for (int i = 0; i < traits; i++) {
                traitsList.add(hints[x][2+i]);
            }
            
            for (int j = 0; j < n; j++) {
                if (j == x) continue;
                int sharedTraits = 0;
                int traitsJ = Integer.parseInt(hints[j][1]);
                for (int i = 0; i < traitsJ; i++) {
                    if (traitsList.contains(hints[j][2 + i])) {
                        sharedTraits++;
                    }
                }

                if (sharedTraits > maxSharedTraits) maxSharedTraits = sharedTraits;
            }
            
            traitsList.clear();
        }
        
            

        System.out.println(maxSharedTraits+1);
    }
}
