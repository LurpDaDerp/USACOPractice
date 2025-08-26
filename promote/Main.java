import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ogbronze = sc.nextInt();
        int afbronze = sc.nextInt();
        int ogsilv = sc.nextInt();
        int afsilv = sc.nextInt();
        int oggold = sc.nextInt();
        int afgold = sc.nextInt();
        int ogplat = sc.nextInt();
        int afplat = sc.nextInt();

        int goldplat = afplat-ogplat;
        int silvgold = goldplat+afgold-oggold;
        int bronzesilv = silvgold+afsilv-ogsilv;

        System.out.println(bronzesilv);
        System.out.println(silvgold);
        System.out.println(goldplat);
    }
}