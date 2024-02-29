import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;
	static int max, min;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<int[]> list;
	static int totalP;

	public static void dfs(int idx, int Core, int len) {

		if (Core + (totalP - idx) < max)// 남은거 해도 max못이김
			return;

		if (idx == totalP) {

			if (max < Core) {
				max = Core;
				min = len;
			} else if (max == Core) {
				min = Math.min(min, len);
			}
			return;
		}

		int[] now = list.get(idx);

		for (int d = 0; d < 4; d++) {

			if (isPossible(now[0], now[1], d)) {

				int l = change(now[0], now[1], d, 2);
				dfs(idx + 1, Core + 1, len + l);
				change(now[0], now[1], d, 0);// 원복
			}

			dfs(idx + 1, Core, len);// 안놓음
		}
	}

	public static boolean isPossible(int r, int c, int d) {// 가능한가
		int nr = r;
		int nc = c;
		while (true) {

			nr += dr[d];
			nc += dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				return true;

			if (map[nr][nc] > 0)
				return false;
		}
	}

	public static int change(int r, int c, int d, int n) {// 전선연결,해제

		int cnt = 0;
		int nr = r;
		int nc = c;
		while (true) {

			nr += dr[d];
			nc += dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;

			map[nr][nc] = n;
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {

			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			list = new ArrayList<>();
			totalP = 0;

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());
					if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalP++;
					}
				}
			}
			// 입력끝

			dfs(0, 0, 0);
			sb.append("#" + tc + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
