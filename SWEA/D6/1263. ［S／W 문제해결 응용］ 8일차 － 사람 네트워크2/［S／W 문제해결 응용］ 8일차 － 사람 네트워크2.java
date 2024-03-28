import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			// 인접행렬
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0)
						map[i][j] = INF;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {

						if (i == j)
							continue;
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}

			sb.append("#" + tc + " " + min + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
