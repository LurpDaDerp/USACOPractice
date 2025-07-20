import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        for (int i = 0; i < testcases; i++) {
            int n = sc.nextInt();
            int c0 = sc.nextInt();
            int c1 = sc.nextInt();
            int h = sc.nextInt();
            int[] digits = new int[n];
            String string = sc.next();  
            for (int j = 0; j < string.length(); j++) {
                digits[j] = string.charAt(j) - '0'; 
            }
            int minPrice = Integer.MAX_VALUE;
            int originalPrice = 0;
            for (int j = 0; j < n; j++) {
                if (digits[j] == 0) {
                    originalPrice += c0;
                } else {
                    originalPrice += c1;
                }
            }
            int price0 = 0;
            for (int j = 0 ; j < n ; j++) {
                if (digits[j] == 0) {
                    price0 += c0;
                } else {
                    price0 += c0 + h;
                }
            }
            int price1 = 0;
            for (int j = 0 ; j < n ; j++) {
                if (digits[j] == 1) {
                    price1 += c1;
                } else {
                    price1 += c1 + h;
                }
            }

            minPrice = Math.min(originalPrice, Math.min(price0, price1));
            System.out.println(minPrice);

        }

        
    }
}