import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] posts = new int[n][2];

        for (int i = 0; i < n; i++) {
            posts[i][0] = sc.nextInt();
            posts[i][1] = sc.nextInt();
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (posts[j][0] == posts[i][0]) {
                    for (int k = 0; k < n; k++) {
                        if (k == i) continue;
                        if (posts[k][1] == posts[i][1]) {
                            int area = Math.abs((posts[k][0]-posts[i][0])*(posts[j][1]-posts[i][1]));
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
                
            }
        }

        System.out.println(maxArea);
    }
}