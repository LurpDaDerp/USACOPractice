/*
ID: lurpdad1
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        int np = Integer.valueOf(f.readLine());
        String[] names = new String[np];
        Map<String, Integer> balance = new HashMap<>();

        for (int i = 0 ; i < np ; i++) {
            names[i] = f.readLine();
        }
        
        for (int i = 0 ; i < np ; i++) {
            balance.put(names[i], 0);
        }
        
        

        for (int i = 0 ; i < np ; i++) {
            String giver = f.readLine();

            String givings = f.readLine();
            String[] splitted = givings.split(" ");
            int amount = Integer.valueOf(splitted[0]);
            int count = Integer.valueOf(splitted[1]);

            if (count == 0) {
                continue;
            }

            balance.put(giver, balance.get(giver) - amount);

            balance.put(giver, balance.get(giver) + amount % count);

            for (int j = 0 ; j < count ; j++) {
                String recipient = f.readLine();
                balance.put(recipient, balance.get(recipient) + amount/count);
            }

        }

        for (String name : names) {
            out.println(name + " " + balance.get(name));
        }
            

        out.close();
    }
}