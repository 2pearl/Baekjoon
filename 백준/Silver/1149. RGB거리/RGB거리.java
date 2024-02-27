import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		// n번째 집, 색

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++)
			dp[0][i] = cost[0][i];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				// 0:1,2 1:0,2 2:0,1
				dp[i][j] = cost[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}

		bw.write(String.valueOf(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]))));
		bw.flush();
		bw.close();
		br.close();
	}

}
