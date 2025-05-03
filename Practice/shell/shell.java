/*
ID: lurpdaderp
LANG: JAVA
TASK: task
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class shell {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        String a = f.readLine();

        int[] shells = new int[3];
        shells[0] = 1;
        shells[1] = 2;
        shells[2] = 3;

        int points = 0;
        int tempPoints = 0;

        for (int startShell = 1 ; startShell < 4 ; startShell++) {
            BufferedReader g = new BufferedReader(new FileReader("shell.in"));
            g.readLine();
            for (int i = 0; i < Integer.valueOf(a); i++) {
                
                String[] strArray = g.readLine().split(" ");
                int temp = shells[Integer.valueOf(strArray[0])-1];
                shells[Integer.valueOf(strArray[0])-1] = shells[Integer.valueOf(strArray[1])-1];
                shells[Integer.valueOf(strArray[1])-1] = temp;


                for (int k = 0 ; k < shells.length ; k++) {
                    if (shells[k] == startShell) {
                        if (k == Integer.valueOf(strArray[2]) - 1) {
                            tempPoints++;
                        } 
                    }
                }
                
                if (tempPoints > points) {
                    points = tempPoints;
                }
            }

            shells[0] = 1;
            shells[1] = 2;
            shells[2] = 3;

            tempPoints = 0;
            
            
        }

        out.println(points);
        out.close();
        
    }
}
