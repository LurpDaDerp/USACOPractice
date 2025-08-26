import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(f.readLine());
        char[] houses = f.readLine().toCharArray();

        int smallestSeg = Integer.MAX_VALUE;
        for (int i = 1; i <= houses.length; i++) {
            int segmentLength = i;
            Set<String> segments = new HashSet<>();
            for (int j = 0; j < houses.length - i + 1; j++) {
                char[] segment = new char[segmentLength];
                for (int k = 0; k < segmentLength; k++) {
                    segment[k] = houses[j + k];
                }
                segments.add(new String(segment));
            }

            if (segments.size() == houses.length - segmentLength + 1) {
                if (segmentLength < smallestSeg) smallestSeg = segmentLength;
            }
        }

        if (smallestSeg != Integer.MAX_VALUE) {
            System.out.println(smallestSeg);
        } else {
            System.out.println(houses.length);
        }
    }
}
