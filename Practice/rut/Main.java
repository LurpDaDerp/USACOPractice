import java.util.*;

class Collision {
    public int distance;
    public int eastCowIndex;
    public int northCowIndex;
    public Collision(int distance, int eastCowIndex, int northCowIndex) {
        this.distance = distance;
        this.eastCowIndex = eastCowIndex;
        this.northCowIndex = northCowIndex;
    }
}

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<int[]> eastCow = new ArrayList<>();
        ArrayList<int[]> northCow = new ArrayList<>();
        ArrayList<Integer> stoppedEastCowDistance = new ArrayList<>();
        ArrayList<Integer> stoppedNorthCowDistance = new ArrayList<>();
        ArrayList<String> directions = new ArrayList<>();
        final int INFINITE = -1;

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("E")) {
                int[] coord = {Integer.parseInt(line[1]), Integer.parseInt(line[2])};
                eastCow.add(coord);
                stoppedEastCowDistance.add(INFINITE);
            }
            if (line[0].equals("N")) {
                int[] coord = {Integer.parseInt(line[1]), Integer.parseInt(line[2])};
                northCow.add(coord);
                stoppedNorthCowDistance.add(INFINITE);
            }
            directions.add(line[0]);
        }

        ArrayList<Collision> collisions = new ArrayList<>();
        int[][] collisionDistance = new int[eastCow.size()][northCow.size()];
        for (int i = 0; i < eastCow.size(); i++) {
            for (int j = 0; j < northCow.size(); j++) {
                if (eastCow.get(i)[1] >= northCow.get(j)[1] && eastCow.get(i)[0] <= northCow.get(j)[0]) {
                    int xDist = Math.abs(eastCow.get(i)[0] - northCow.get(j)[0]);
                    int yDist = Math.abs(eastCow.get(i)[1] - northCow.get(j)[1]);
                    
                    if (xDist != yDist) {
                        Collision a = new Collision(Math.max(xDist, yDist), i, j);
                        collisions.add(a);
                    } else {
                        Collision a = new Collision(-1, i, j);
                        collisions.add(a);
                    }

                } else {
                    Collision a = new Collision(-1, i, j);
                    collisions.add(a);
                }
            }
        }
        collisions.sort(Comparator.comparingInt(e -> e.distance));

        for (Collision event : collisions) {
            if (eastCow.get(event.eastCowIndex)[1] >= northCow.get(event.northCowIndex)[1] && eastCow.get(event.eastCowIndex)[0] <= northCow.get(event.northCowIndex)[0]) {
                int xDist = Math.abs(eastCow.get(event.eastCowIndex)[0] - northCow.get(event.northCowIndex)[0]);
                int yDist = Math.abs(eastCow.get(event.eastCowIndex)[1] - northCow.get(event.northCowIndex)[1]);
                
                if (xDist > yDist 
                && (stoppedEastCowDistance.get(event.eastCowIndex) > xDist 
                || stoppedEastCowDistance.get(event.eastCowIndex) == INFINITE)
                && stoppedNorthCowDistance.get(event.northCowIndex) >= yDist) 
                    stoppedEastCowDistance.set(event.eastCowIndex, xDist);

                
                if (xDist < yDist 
                && (stoppedNorthCowDistance.get(event.northCowIndex) > yDist 
                || stoppedNorthCowDistance.get(event.northCowIndex) == INFINITE)
                && stoppedEastCowDistance.get(event.eastCowIndex) >= xDist) 
                    stoppedNorthCowDistance.set(event.northCowIndex, yDist);
            }
        }

        for (int i = 0; i < directions.size(); i++) {
            if (directions.get(i).equals("N")) {
                if (stoppedNorthCowDistance.get(0) == INFINITE) {
                    System.out.println("Infinity");
                } else {
                    System.out.println(stoppedNorthCowDistance.get(0));
                }
                stoppedNorthCowDistance.remove(0);
            }
            if (directions.get(i).equals("E")) {
                if (stoppedEastCowDistance.get(0) == INFINITE) {
                    System.out.println("Infinity");
                } else {
                    System.out.println(stoppedEastCowDistance.get(0));
                }
                stoppedEastCowDistance.remove(0);
            }
        }
    }
}
