import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//퇴사

public class Main {

	static int N;
	static int[] T;
	static int[] P;

	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// dp[i]는 i번째 일까지 최대 이익
		dp = new int[N + 1];
		for (int i = 0; i < N; i++) {

			if (T[i] + i <= N) {
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
			}
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
		}

		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}

}
