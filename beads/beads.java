/*
ID: lurpdad1
LANG: JAVA
TASK: beads
*/

import beads.Status;
import beads.Status;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class beads {
    enum Status {
        LOOK_FOR_FIRST_COLOR,
        LOOK_FOR_SECOND_COLOR
      }
      
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int length = Integer.valueOf(f.readLine());
        char[] singleBeads = f.readLine().toCharArray();
        char[] beads = new char[2*singleBeads.length];
        for (int i = 0 ; i < beads.length ; i++) {
            beads[i] = singleBeads[i % singleBeads.length];
        }

        int maxBeads = 0;
        int sectionBeads = 0;
        
/*

        char firstColor;
        char secondColor;
        for (int i = 0 ; i < beads.length ; i++) {
            int j = 0;
            Status status = Status.LOOK_FOR_FIRST_COLOR;
            while (i + j < beads.length) {
                if (status == Status.LOOK_FOR_FIRST_COLOR) {
                    while (i + j < beads.length && beads[i + j] == 'w') {
                        sectionBeads ++;
                        j ++;
                    }
                     if (i + j >= beads.length) {
                        break;
                     }
                    firstColor = beads[i+j];
                    while (i + j < beads.length && (beads[i + j] == 'w' || beads[i + j] == firstColor)) {
                        sectionBeads ++;
                        j ++;
                    }
                    if (i + j >= beads.length) {
                        break;
                     }
                    status = Status.LOOK_FOR_SECOND_COLOR;
                    secondColor = beads[i+j];
                }
                if (status == Status.LOOK_FOR_SECOND_COLOR) {
                    while (i + j < beads.length && (beads[i + j] == 'w' || beads[i + j] == secondColor)) {
                        sectionBeads ++;
                        j ++;
                    }
                }
            }
            // Process sessionBeads
        }

*/
        for (int i = 0 ; i < beads.length ; i++) {
            Boolean bDone = false;
            Boolean rDone = false;
            int j = 0;
            while (!bDone || !rDone) {

                if (i + j + 1 == beads.length) {
                    break;
                }

                if (beads[i+j] == 'w') {
                    sectionBeads++;
                    if (bDone && !rDone) {
                        if (beads[i+j+1] == 'b') {
                            rDone = true;
                        }
                    }
                    if (rDone && !bDone) {
                        if (beads[i+j+1] == 'r') {
                            bDone = true;
                        }
                    }
                }
                if (beads[i+j] == 'b') {
                    if (beads[i+j+1] == 'r') {
                        bDone = true;
                    }
                    
                    sectionBeads++;
                }
                if (beads[i+j] == 'r') {
                    if (beads[i+j+1] == 'b') {
                        rDone = true;
                    }
                        
                    sectionBeads++;
                }
                
                j++;
            }

            System.out.println(sectionBeads);
            
            if (sectionBeads >= maxBeads) {
                maxBeads = sectionBeads;
            }
            sectionBeads = 0;
        }
        
       
        

    }
} 
