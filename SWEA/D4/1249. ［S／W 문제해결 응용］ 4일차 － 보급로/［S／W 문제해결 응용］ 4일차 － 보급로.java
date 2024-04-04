import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Solution {

	static int N;
	static int[][] map;
	static int ans;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			// 입력끝
			sb.append("#" + tc + " " + bfs()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int bfs() {

		PriorityQueue<Data> queue = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		queue.offer(new Data(0, 0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Data now = queue.poll();
			int dist = now.dist;

			for (int d = 0; d < 4; d++) {
				int nr = now.row + dr[d];
				int nc = now.col + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;

				if (nr == N - 1 && nc == N - 1)// 도착
					return dist;
				
				queue.offer(new Data(nr, nc, dist + map[nr][nc]));
				visited[nr][nc] = true;
			}
		}

		return 1;
	}

	static class Data implements Comparable<Data> {
		int row;
		int col;
		int dist;

		public Data(int row, int col, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public int compareTo(Data o) {
			// 경로 오름차순
			return this.dist - o.dist;
		}
	}
}
