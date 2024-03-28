import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 이동시키깅
		long cnt = 0;
		dp[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {

				if (map[i][j] == 1)// 벽
					continue;

				// 가로
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				if (i == 0)
					continue;

				// 세로
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

				if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
					continue;

				// 대각선
				dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}

		cnt = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}

}
