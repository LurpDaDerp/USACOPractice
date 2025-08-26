/*
ID: lurpdaderp
LANG: JAVA
TASK: lostcow
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class lostcow {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        String line = f.readLine();
        String[] numbers = line.split(" ");
        int x = Integer.parseInt(numbers[0]);
        int y = Integer.parseInt(numbers[1]);
        
        int position = x;
        int temp = position;
        int change = 1;
        int distance = 0;

        while (position != y) {
            temp = position;
            position = x + change;
            if (y < position && y > temp || y > position && y < temp) {
                position = y;
            }
            distance += Math.abs(temp - position);
            change *= -2;
        }


        out.println(distance);
        out.close();

    }
}
