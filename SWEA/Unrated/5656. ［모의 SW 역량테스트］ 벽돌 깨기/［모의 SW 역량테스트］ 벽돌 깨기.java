import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H;
	static int[][] map, cmap;
	static int[] pick;
	static int ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			cmap = new int[H][W];
			pick = new int[N];
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());
					cmap[i][j] = map[i][j];
				}
			}
			// 조합
			dfs(0);
			sb.append("#" + tc + " " + ans + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	// 조합만들깅
	public static void dfs(int depth) {

		if (depth == N) {

			// 뿌수자
			destroy();
			// 배열 원복하자
			map = copy();
			return;
		}

		for (int i = 0; i < W; i++) {

			pick[depth] = i;
			dfs(depth + 1);
		}
	}

	public static void destroy() {

		for (int p = 0; p < N; p++) {// 구슬 배열 돌기

			int c = pick[p];
			int row = 0;
			for (int r = 0; r < H; r++) {
				if (map[r][c] != 0) {

					row = r;
					break;
				}
			}
			bfs(row, c);// 부수자
//			for(int i=0;i<H;i++) {
//				for(int j=0;j<W;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			down();// 내리자
			ans = Math.min(ans, getCount());
			
			
		}
	}

	public static void down() {// 다 내리기

		Stack<Integer> stack;
		for (int j = 0; j < W; j++) {

			stack = new Stack<>();
			for (int i = 0; i < H; i++) {
				if (map[i][j] != 0) {
					stack.push(map[i][j]);
				}
			}

			for (int i = H - 1; i >= 0; i--) {
				if (!stack.isEmpty()) {
					map[i][j] = stack.pop();
				} else
					map[i][j] = 0;
			}
		}

	}

	public static void bfs(int r, int c) {// 부수기

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { r, c, map[r][c] });
		map[r][c] = 0;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			int n = now[2];

			for (int i = 1; i < n; i++) {
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + dr[d] * i;
					int nc = now[1] + dc[d] * i;

					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;

					if (map[nr][nc] != 0) {
						queue.offer(new int[] { nr, nc, map[nr][nc] });
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	public static int getCount() {// 남은 벽돌 세기
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static int[][] copy() {// 배열복사

		int[][] tmp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = cmap[i][j];
			}
		}
		return tmp;
	}
}
