/*
ID: lurpdaderp
LANG: JAVA
TASK: cowsignal
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        String startLine = f.readLine();
        String[] startArray = startLine.split("\\s+");
        int height = Integer.parseInt(startArray[0]);
        int width = Integer.parseInt(startArray[1]);
        int factor = Integer.parseInt(startArray[2]); 
        String output = "";

        for (int i = 0 ; i < height ; i++) {
            String line = f.readLine();
            char[] charArray = line.toCharArray();
            char[] newArray = new char[factor*charArray.length];

            

            for (int j = 0 ; j < newArray.length ; j += factor) {
                for (int k = 0 ; k < factor ; k++) {
                    newArray[j+k] = charArray[j/factor];
                }
            }

            for (int l = 0 ; l < factor ; l++) {
                for (int k = 0 ; k < newArray.length ; k++) {
                    output += newArray[k];
                }
                output += "\n";
            }
            
        }

        out.println(output.strip());
        out.close();

    }
}
