import java.io.*;
import java.util.*;

public class backforth {

    static Set<Integer> values = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

        ArrayList<Integer> barn1Buckets = new ArrayList<>();
        ArrayList<Integer> barn2Buckets = new ArrayList<>();

        int tank1 = 1000;

        String[] line1 = br.readLine().split(" ");
        for (String s : line1) {
            barn1Buckets.add(Integer.parseInt(s));
        }

        String[] line2 = br.readLine().split(" ");
        for (String s : line2) {
            barn2Buckets.add(Integer.parseInt(s));
        }

        nextDay(tank1, 1, barn1Buckets, barn2Buckets);

        out.println(values.size());

        br.close();
        out.close();
    }

    static void nextDay(int tank1, int day, ArrayList<Integer> buckets1, ArrayList<Integer> buckets2) {
        if (day == 5) {
            values.add(tank1);
            return;
        }

        if (day == 1 || day == 3) { 
            for (int i = 0; i < buckets1.size(); i++) {
                int milk = buckets1.get(i);

                ArrayList<Integer> newBuckets1 = new ArrayList<>(buckets1);
                ArrayList<Integer> newBuckets2 = new ArrayList<>(buckets2);

                newBuckets1.remove(i);
                newBuckets2.add(milk);

                nextDay(tank1 - milk, day + 1, newBuckets1, newBuckets2);
            }
        } else { 
            for (int i = 0; i < buckets2.size(); i++) {
                int milk = buckets2.get(i);

                ArrayList<Integer> newBuckets1 = new ArrayList<>(buckets1);
                ArrayList<Integer> newBuckets2 = new ArrayList<>(buckets2);

                newBuckets2.remove(i);
                newBuckets1.add(milk);

                nextDay(tank1 + milk, day + 1, newBuckets1, newBuckets2);
            }
        }
    }
}
