

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            numbers.add(sc.nextInt());
        }
        Collections.sort(numbers);
        System.out.println(numbers.get(0) + " " + numbers.get(1) + " " + (numbers.get(6) - numbers.get(1) - numbers.get(0)));
    }
}