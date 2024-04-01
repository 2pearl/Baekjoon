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
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cnt++;
			}
		}

		int time = 0;
		int precnt = 0;
		while (cnt > 0) {
			precnt = cnt;
			time++;
			bfs();
		}

		bw.write(String.valueOf(time) + "\n");
		bw.write(String.valueOf(precnt));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs() {

		Queue<int[]> queue = new ArrayDeque<>();
		visited = new boolean[R][C];

		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				if (map[nr][nc] == 0) {

					queue.offer(new int[] { nr, nc });
				} else {
					cnt--;
					map[nr][nc] = 0;
				}
			}
		}
	}
}
