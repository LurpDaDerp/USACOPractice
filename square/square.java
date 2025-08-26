import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class square {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        String[] line = f.readLine().split(" ");
        int x1 = Integer.parseInt(line[0]); 
        int y1 = Integer.parseInt(line[1]);
        int x2 = Integer.parseInt(line[2]);
        int y2 = Integer.parseInt(line[3]);
        line = f.readLine().split(" ");
        int x3 = Integer.parseInt(line[0]);
        int y3 = Integer.parseInt(line[1]);
        int x4 = Integer.parseInt(line[2]);
        int y4 = Integer.parseInt(line[3]);

        int minX = Math.min(Math.min(x1, x2), Math.min(x3, x4));
        int minY = Math.min(Math.min(y1, y2), Math.min(y3, y4));
        int maxX = Math.max(Math.max(x1, x2), Math.max(x3, x4));
        int maxY = Math.max(Math.max(y1, y2), Math.max(y3, y4));

        int sideLength = Math.max(maxX - minX, maxY - minY);
        int area = sideLength * sideLength;
        

        out.println(area);
        out.close();
    }
}