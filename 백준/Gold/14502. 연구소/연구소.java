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
	static int max;
	static int[][] map;
	static int[][] changed;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void setWall(int depth) {// 벽 생성하는 메소드
		if (depth == 3) {

			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					setWall(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void bfs() {// 바이러스 퍼지는 메소드

		Queue<int[]> queue = new ArrayDeque<>();
		changed = new int[N][M];
		// 먼저 바이러스 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {// 바이러스

					queue.offer(new int[] { i, j });
				}
			}
		}

		for (int i = 0; i < N; i++)
			changed[i] = map[i].clone();

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			for (int d = 0; d < 4; d++) {

				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (changed[nr][nc] == 0) {

					queue.offer(new int[] { nr, nc });
					changed[nr][nc] = 2;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (changed[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		setWall(0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

}
