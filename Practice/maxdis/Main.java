import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(f.readLine());
        
        int[] xCoords = new int[length];
        int[] yCoords = new int[length];

        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < length; i++) {
            xCoords[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < length; i++) {
            yCoords[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int dx = xCoords[i] - xCoords[j];
                int dy = yCoords[i] - yCoords[j];
                int distSq = dx * dx + dy * dy;
                if (distSq > max) {
                    max = distSq;
                }
            }
        }

        System.out.println(max);
    }
}
