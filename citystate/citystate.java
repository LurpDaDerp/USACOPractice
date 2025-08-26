/*
ID: lurpdaderp
LANG: JAVA
TASK: citystate
*/

import java.io.*;
import java.util.*;

public class citystate {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

        final int N = Integer.parseInt(f.readLine());

        Map<String, Integer> places = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] line = f.readLine().split(" ");
            String city = line[0];
            String state = line[1];

            String prefix = city.substring(0, 2);
            String key = prefix + state;

            places.put(key, places.getOrDefault(key, 0) + 1);
        }

        int total = 0;

        for (Map.Entry<String, Integer> entry : places.entrySet()) {
            String place = entry.getKey();
            Integer count = entry.getValue();
            
            if (!(place.substring(0,2).equals(place.substring(2,4)))) {
                if (places.containsKey(place.substring(2,4) + place.substring(0,2))) {
                    total += count * places.get(place.substring(2,4) + place.substring(0,2));
                }
            }
            
        }

        out.println(total/2);
        out.close();
    }
}