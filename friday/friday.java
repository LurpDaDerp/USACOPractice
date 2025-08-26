/*
ID: lurpdad1
LANG: JAVA
TASK: friday
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        Map <Integer, Integer> monthDays = new HashMap<>();
        monthDays.put(1, 31);
        monthDays.put(2, 28);
        monthDays.put(3, 31);
        monthDays.put(4, 30);
        monthDays.put(5, 31);
        monthDays.put(6, 30);
        monthDays.put(7, 31);
        monthDays.put(8, 31);
        monthDays.put(9, 30);
        monthDays.put(10, 31);
        monthDays.put(11, 30);
        monthDays.put(12, 31);

        int year = 1900;
        int years = Integer.valueOf(f.readLine());
        int month = 1;
        int daysPassed = 0;
        int[] occurences = {0,0,0,0,0,0,0};

        for (int h = 0 ; h < years ; h++) {

            for (int j = 0 ; j < 12 ; j++) {

                month = j+1;
                int days = monthDays.get(month);

                if (month == 2 && isLeapYear(year)) {
                    days = 29;
                }
                
                for (int date = 1 ; date <= days ; date++) {
                
                    if (date == 13) {
                        occurences[(daysPassed+2) % 7]++;
                    }

                    daysPassed++;
                    
                }
            }
            year++;
        }
        for (int o = 0 ; o < occurences.length ; o++) {
            out.printf(String.valueOf(occurences[o]));
            if (o != occurences.length - 1) {
                out.printf(" ");
            } else {
                out.printf("\n");
            }
            
        }
        out.close();
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
