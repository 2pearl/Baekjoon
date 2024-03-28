import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static Queue<Point> water;
	static Queue<Point> move;
	static boolean[][] visited;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		water = new ArrayDeque<>();
		move = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					move.offer(new Point(i, j, 0));
				} else if (map[i][j] == '*') {// 물임
					water.offer(new Point(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		bw.write(escape());
		bw.flush();
		bw.close();
		br.close();
	}

	public static String escape() {

		while (!move.isEmpty()) {

			// 물 퍼뜨림
			int n = water.size();
			for (int i = 0; i < n; i++) {

				Point w = water.poll();
				for (int d = 0; d < 4; d++) {
					int nr = w.row + dr[d];
					int nc = w.col + dc[d];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					if (map[nr][nc] == '.') {

						map[nr][nc] = '*';
						water.offer(new Point(nr, nc, 0));
					}
				}
			}

			// 고슴도치 옮기기
			int size = move.size();

			for (int i = 0; i < size; i++) {
				Point now = move.poll();

				for (int d = 0; d < 4; d++) {
					int nr = now.row + dr[d];
					int nc = now.col + dc[d];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])
						continue;

					if (map[nr][nc] == 'D') {// 탈출
						return String.valueOf((now.time + 1));
					}
					if (map[nr][nc] == '.') {

						visited[nr][nc] = true;
						move.offer(new Point(nr, nc, now.time + 1));
					}

				}
			}
		}
		return "KAKTUS";
	}

	static class Point {
		int row;
		int col;
		int time;

		public Point(int row, int col, int time) {
			super();
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
}
