import java.util.*;

public class Main {

    static Map<String, Integer> animals;
    static String[][] conditions;
    static int totalDif = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        conditions = new String[n][4];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            conditions[i][0] = line[0]; 
            conditions[i][1] = line[3]; 
            conditions[i][2] = line[4]; 
            conditions[i][3] = line[7]; 
        }

        String[] animalNames = {
            "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", 
            "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"
        };
        animals = new HashMap<>();
        for (int i = 0; i < animalNames.length; i++) {
            animals.put(animalNames[i], i);
        }

        Map<String, Integer> birthyears = new HashMap<>();
        birthyears.put("Bessie", 0);

        while (birthyears.size() <= n) {
            for (String[] cond : conditions) {
                String cow1 = cond[0];
                String order = cond[1];
                String zodiac = cond[2];
                String cow2 = cond[3];

                if (birthyears.containsKey(cow1)) continue;
                if (!birthyears.containsKey(cow2)) continue;

                int cow2Year = birthyears.get(cow2);
                int cow2ZodiacIndex = (cow2Year % 12 + 12) % 12;
                int targetZodiacIndex = animals.get(zodiac);

                int diff;
                if (order.equals("next")) {
                    diff = (targetZodiacIndex - cow2ZodiacIndex + 12) % 12;
                    if (diff == 0) diff = 12;
                    birthyears.put(cow1, cow2Year + diff);
                } else {
                    diff = (cow2ZodiacIndex - targetZodiacIndex + 12) % 12;
                    if (diff == 0) diff = 12;
                    birthyears.put(cow1, cow2Year - diff);
                }
            }
        }

        System.out.println(Math.abs(birthyears.get("Elsie")));
    }
}
