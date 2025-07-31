import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()); 

        int[] a = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> lastPosition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastPosition.put(a[i], i);
        }

        int totalChanges = 0;
        int i = 0; 

        while (i < n) {
            int l = i;
            int r = lastPosition.get(a[l]); 
            int k = l;
            while (k < r) {
                r = Math.max(r, lastPosition.get(a[k]));
                k++;
            }
            Map<Integer, Integer> frequencyInBlock = new HashMap<>();
            int maxFrequency = 0;
            for (int j = l; j <= r; j++) {
                int currentFreq = frequencyInBlock.getOrDefault(a[j], 0) + 1;
                frequencyInBlock.put(a[j], currentFreq);
                if (currentFreq > maxFrequency) {
                    maxFrequency = currentFreq;
                }
            }

            int blockSize = r - l + 1;
            totalChanges += (blockSize - maxFrequency);

            i = r + 1;
        }

        System.out.println(totalChanges);
    }
}