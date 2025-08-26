/*
ID: lurpdaderp
LANG: JAVA
TASK: notlast
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class notlast {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        final int N = Integer.parseInt(f.readLine());
        HashMap<String, Integer> cows = new HashMap<>();

        String[] names = {"Bessie","Elsie","Daisy","Gertie","Annabelle","Maggie","Henrietta"};
        for (String name : names) {
            cows.put(name, 0);
        }

        for (int i = 0; i < N; i++) {
            String[] line = f.readLine().split(" ");
            String cow = line[0];
            int milk = Integer.parseInt(line[1]);
            if (cows.containsKey(cow)) {
                cows.put(cow, cows.get(cow) + milk);
            } else {
                cows.put(cow, milk);
            }
        }

        Iterator<Integer> valueIterator = cows.values().iterator();
        Integer firstValue = valueIterator.next();

        if (cows.size() == 1) {
            out.println("Tie");
            out.close();
            return;
        }

        int min = Integer.MAX_VALUE;
        
        boolean allEqual = true;
        
        for (Map.Entry<String, Integer> cow : cows.entrySet()) {
            Integer value = cow.getValue();
            min = Math.min(value, min);
            if (value != firstValue) {
                allEqual = false;
            }
        }

        if (allEqual) {
            out.println("Tie");
            out.close();
            return;
        }

        Set<String> minCows = new HashSet<>();
        int secMin = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> cow : cows.entrySet()) {
            String key = cow.getKey();
            Integer value = cow.getValue();
            if (value < secMin && value > min) {
                minCows.clear();
                secMin = value;
                minCows.add(key);
            } else if (value == secMin) {
                minCows.add(key);
            } 
        }

        if (minCows.size() > 1) {
            out.println("Tie");
            out.close();
            return;
        }
        for (String cow : minCows) {
            out.println(cow);
        }

        out.close();
    }
}