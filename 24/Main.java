import java.util.*;

public class Main {
    static int best = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            List<Integer> cards = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                cards.add(sc.nextInt());
            }

            best = Integer.MIN_VALUE;
            permute(cards, 0);
            System.out.println(best);
        }
    }

    static void permute(List<Integer> nums, int index) {
        if (index == nums.size()) {
            tryAllOrders(nums);
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, i, index);
            permute(nums, index + 1);
            Collections.swap(nums, i, index);
        }
    }

    static void tryAllOrders(List<Integer> nums) {
        char[] ops = {'+', '-', '*', '/'};

        for (char op1 : ops) {
            for (char op2 : ops) {
                for (char op3 : ops) {
                    evaluate(nums.get(0), nums.get(1), nums.get(2), nums.get(3), op1, op2, op3);
                }
            }
        }
    }

    static void evaluate(int a, int b, int c, int d, char op1, char op2, char op3) {
        Integer r1, r2, r3;

        r1 = apply(a, b, op1);
        if (r1 != null) {
            r2 = apply(r1, c, op2);
            if (r2 != null) {
                r3 = apply(r2, d, op3);
                check(r3);
            }
        }

        r1 = apply(b, c, op2);
        if (r1 != null) {
            r2 = apply(a, r1, op1);
            if (r2 != null) {
                r3 = apply(r2, d, op3);
                check(r3);
            }
        }

        r1 = apply(b, c, op2);
        if (r1 != null) {
            r2 = apply(r1, d, op3);
            if (r2 != null) {
                r3 = apply(a, r2, op1);
                check(r3);
            }
        }

        r1 = apply(c, d, op3);
        if (r1 != null) {
            r2 = apply(b, r1, op2);
            if (r2 != null) {
                r3 = apply(a, r2, op1);
                check(r3);
            }
        }

        r1 = apply(a, b, op1);
        r2 = apply(c, d, op3);
        if (r1 != null && r2 != null) {
            r3 = apply(r1, r2, op2);
            check(r3);
        }
    }

    static void check(Integer result) {
        if (result != null && result <= 24) {
            best = Math.max(best, result);
        }
    }

    static Integer apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return (b != 0 && a % b == 0) ? a / b : null;
            default: return null;
        }
    }
}
