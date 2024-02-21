import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int Tc = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= Tc; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			for (int m = 0; m < M; m++) {

				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				union(x, y);
			}

			Set<Integer>set=new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(find(i));
			}
			sb.append(set.size() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int union(int x, int y) {

		x = find(x);
		y = find(y);

		if (x == y)
			return 0;

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;

		return 1;

	}

	public static int find(int x) {

		return parent[x] == x ? x : find(parent[x]);
	}
}
