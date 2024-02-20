import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

class Point {
	int row;
	int col;
	char color;

	public Point(int row, int col, char color) {
		super();
		this.row = row;
		this.col = col;
		this.color = color;
	}
}

public class Main {

	static char[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				arr[i][j] = str.charAt(j);
		}

		// 비 적록색약
		int not = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					not++;
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';// 초록색을 빨강으로 변경하깅
			}
		}

		// 적록색약
		int yes = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					yes++;
					bfs(i, j);
				}
			}
		}

		bw.write(String.valueOf(not) + " " + String.valueOf(yes));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int i, int j) {// 비 적록색약

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(i, j, arr[i][j]));
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nextr = now.row + dr[d];
				int nextc = now.col + dc[d];

				if (nextr > -1 && nextr < N && nextc > -1 && nextc < N && arr[nextr][nextc] == now.color&&!visited[nextr][nextc]) {
					visited[nextr][nextc]=true;
					queue.offer(new Point(nextr,nextc,arr[nextr][nextc]));
				}
			}
		}
	}
}
