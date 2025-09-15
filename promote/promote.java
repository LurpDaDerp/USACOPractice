import java.io.*;
import java.util.*;

public class promote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ogbronze = Integer.parseInt(st.nextToken());
        int afbronze = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ogsilv = Integer.parseInt(st.nextToken());
        int afsilv = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int oggold = Integer.parseInt(st.nextToken());
        int afgold = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ogplat = Integer.parseInt(st.nextToken());
        int afplat = Integer.parseInt(st.nextToken());

        int goldplat = afplat - ogplat;
        int silvgold = goldplat + afgold - oggold;
        int bronzesilv = silvgold + afsilv - ogsilv;

        pw.println(bronzesilv);
        pw.println(silvgold);
        pw.println(goldplat);

        br.close();
        pw.close();
    }
}
