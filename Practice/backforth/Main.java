import java.util.*;

public class Main {

    static Set<Integer> values = new HashSet<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> barn1Buckets = new ArrayList<>();
        ArrayList<Integer> barn2Buckets = new ArrayList<>();

        int tank1 = 1000;
        int tank2 = 1000;

        for (int i = 0; i < 10; i++) {
            barn1Buckets.add(sc.nextInt());
        }
        for (int i = 0; i < 10; i++) {
            barn2Buckets.add(sc.nextInt());
        }

        nextDay(tank1, 1, barn1Buckets, barn2Buckets);

        System.out.println(values.size());
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