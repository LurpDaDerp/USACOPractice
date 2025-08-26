import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] normal = new String[n];
        String[] spotty = new String[n];
         
        for (int i = 0; i < n; i++) {
            normal[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            spotty[i] = sc.nextLine();
        }
        int possiblePositions = 0;
        for (int i = 0; i < m-2; i++) {
            for (int j = i+1; j < m-1; j++) {
                for (int k = j+1; k < m; k++) {
                    Set<String> normalSet = new HashSet<>();
                    for (int l = 0; l < n; l++) {
                        String gene = "" + normal[l].charAt(i) + normal[l].charAt(j) + normal[l].charAt(k);
                        normalSet.add(gene);
                    }

                    boolean possible = true;
                    for (int l = 0; l < n; l++) {
                        String gene = "" + spotty[l].charAt(i) + spotty[l].charAt(j) + spotty[l].charAt(k);
                        if (normalSet.contains(gene)) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        possiblePositions++;
                    }
                    
                }
            }
        }

        System.out.println(possiblePositions);
    }
}