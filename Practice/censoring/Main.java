import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String total = sc.nextLine();
        String remove = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        int rLen = remove.length();

        for (int i = 0; i < total.length(); i++) {
            sb.append(total.charAt(i));

            if (sb.length() >= rLen) {
                if (sb.substring(sb.length() - rLen).equals(remove)) {
                    sb.delete(sb.length() - rLen, sb.length());
                }
            }
        }

        System.out.println(sb.toString());
    }
}
