import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] rupee;
	static PriorityQueue<Point> pq;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Point implements Comparable<Point> {
		int row;
		int col;
		int weight;

		public Point(int row, int col, int weight) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			// weight오름차순
			return this.weight - o.weight;
		}
	}

	public static int dijkstra() {

		pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, map[0][0]));

		for (int i = 0; i < N; i++) {
			Arrays.fill(rupee[i], 1_000_000_000);
		}
		rupee[0][0] = map[0][0];

		while (!pq.isEmpty()) {

			Point now = pq.poll();

			if (now.row == N - 1 && now.col == N - 1) {
				return now.weight;
			}
			for (int d = 0; d < 4; d++) {

				int nr = now.row + dr[d];
				int nc = now.col + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (rupee[nr][nc] > now.weight + map[nr][nc]) {

					rupee[nr][nc] = now.weight + map[nr][nc];
					pq.offer(new Point(nr, nc, rupee[nr][nc]));
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {

			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			rupee = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력끝

			// 다익스트라

			sb.append("Problem " + tc + ": " + dijkstra() + "\n");
			tc++;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
