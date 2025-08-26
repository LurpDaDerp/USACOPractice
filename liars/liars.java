// --- Scanner Input Methods ---
// sc.next()           -> next word (token)
// sc.nextLine()       -> rest of the current line
// sc.nextInt()        -> next int
// sc.nextLong()       -> next long
// sc.nextDouble()     -> next double
// sc.nextFloat()      -> next float
// sc.nextBoolean()    -> next boolean
// sc.nextByte()       -> next byte
// sc.nextShort()      -> next short
// sc.findInLine(regex)-> match pattern in current line

// --- Scanner Check Methods ---
// sc.hasNext()        -> check for next word/token
// sc.hasNextLine()    -> check for next line
// sc.hasNextInt()     -> check if next is an int
// sc.hasNextDouble()  -> check if next is a double
// sc.hasNextLong()    -> check if next is a long
// sc.hasNextBoolean() -> check if next is a boolean

import java.util.*;

public class liars {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> statements = new HashMap<>();
        ArrayList<Integer> positions = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            statements.put(Integer.valueOf(line[1]), line[0]);
            positions.add(Integer.valueOf(line[1])-1);
            positions.add(Integer.valueOf(line[1]));
            positions.add(Integer.valueOf(line[1])+1);
        }
    
        int minLiars = 1000;
        
        for (int pos : positions) {
            int cur = 0;
            for (Map.Entry<Integer, String> cow : statements.entrySet()) {
                if (cow.getValue().equals("G") && cow.getKey() > pos) cur++;
                if (cow.getValue().equals("L") && cow.getKey() < pos) cur++;
            }
            if (cur < minLiars) minLiars = cur;
        }

        System.out.println(minLiars);
    }
}