/*
ID: lurpdaderp
LANG: JAVA
TASK: sleeping
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class sleeping {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int[] arr = new int[n];
            String[] input = sc.nextLine().split(" ");
            int sum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input[j]);
                sum += arr[j];
            }
            ArrayList<Integer> factors = new ArrayList<>();
            for (int j = 1; j <= sum; j++) {
                if (sum % j == 0) {
                    factors.add(j);
                }
            }
            int min = n-1;
            if (sum == 0) {
                min = 0;
                
            }
            for (int j = 0; j < factors.size(); j++) {
                int factor  = factors.get(factors.size()-j-1);
                ArrayList<Integer> newList = new ArrayList<>();
                for (int k = 0 ; k < n ; k++) {
                    newList.add(arr[k]);
                }
                int merges = 0;
                boolean same = true;
                for (int k = 0 ; k < newList.size() - 1 ; k++) {
                    
                    while (newList.get(k) < factor) {
                        newList.set(k, newList.get(k) + newList.get(k+1));
                        newList.remove(k+1);
                        merges++;
                        if (newList.get(k) > factor) {
                            newList.clear();
                            same = false;
                            break;
                        }
                    }
                    
                    
                }
                for (Integer x : newList) {
                    if (x != factor) {
                        newList.clear();
                        same = false;
                        break;
                    }
                }
                if (!same) {
                    continue;
                } else {
                    min = merges;
                }
                
            }
            System.out.println(min);
        }

    }
}