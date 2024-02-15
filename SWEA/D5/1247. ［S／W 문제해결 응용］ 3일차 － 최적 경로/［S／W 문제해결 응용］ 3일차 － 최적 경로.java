import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	static Point com, home;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int Tc = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= Tc; tc++) {

			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			com = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			Point[] clients = new Point[N];
			for (int i = 0; i < N; i++)
				clients[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			int[] combi = new int[N];
			for (int i = 0; i < N; i++)
				combi[i] = i;

			int min = Integer.MAX_VALUE;
			
			do {//경우 하나씩 돌면서 경로 길이 더함
				int sum = 0;
				sum += getDist(com, clients[combi[0]]);
				for (int i = 0; i < N - 1; i++) {
					sum += getDist(clients[combi[i]], clients[combi[i + 1]]);
				}
				sum += getDist(clients[combi[N - 1]], home);

				min = Math.min(min, sum);
				
			} while (next_permutation(combi));

			sb.append("#" + tc + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean next_permutation(int[] numbers) {

		int n = numbers.length;
		int i = n - 1;

		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;

		if (i == 0)
			return false;

		int j = n - 1;

		while (numbers[i - 1] >= numbers[j])
			j--;

		swap(numbers, i - 1, j);

		int k = n - 1;

		while (i < k)
			swap(numbers, i++, k--);

		return true;
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static int getDist(Point start, Point end) {

		return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
	}
}
