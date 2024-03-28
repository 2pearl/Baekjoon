import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static Queue<Point> queue;
	static boolean[][][] visited;
	static int[] key;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][64];
		queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					queue.add(new Point(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}

		bw.write(String.valueOf(bfs()));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int bfs() {

		while (!queue.isEmpty()) {

			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {

				int nr = now.row + dr[d];
				int nc = now.col + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (map[nr][nc] == '1') {// 출구

					return now.cnt + 1;
				}

				else if (visited[nr][nc][now.key] || map[nr][nc] == '#')// 못감
					continue;

				// 문
				else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {

					int n = map[nr][nc] - 'A';
					// 현재 키로 열 수 있는가?
					if ((now.key & (1 << n)) > 0) {

						visited[nr][nc][now.key] = true;
						queue.offer(new Point(nr, nc, now.cnt + 1, now.key));
					}
				}

				// 열쇠
				else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {

					int n = map[nr][nc] - 'a';
					int next = now.key | (1 << n);
					visited[nr][nc][next] = true;
					queue.offer(new Point(nr, nc, now.cnt + 1, next));
				} else {
					visited[nr][nc][now.key] = true;
					queue.offer(new Point(nr, nc, now.cnt + 1, now.key));
				}
			}
		}

		return -1;

	}

	static class Point {

		int row;
		int col;
		int cnt;
		int key;

		public Point(int row, int col, int cnt, int key) {
			super();
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			this.key = key;
		}
	}
}
