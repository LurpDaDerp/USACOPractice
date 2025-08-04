import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("herding.in"));
		PrintWriter out = new PrintWriter(new File("herding.out"));
		int[] cows = new int[3];
		cows[0] = sc.nextInt();
		cows[1] = sc.nextInt();
		cows[2] = sc.nextInt();
		Arrays.sort(cows);

		if (cows[2] == cows[0] + 2) {
			out.println(0);
		} else if (cows[1] == cows[0] + 2 || cows[2] == cows[1] + 2) {
			out.println(1);
		} else {
			out.println(2);
		}

		out.println(Math.max((cows[1] - cows[0]), (cows[2] - cows[1])) - 1);
		out.close();
	}
}