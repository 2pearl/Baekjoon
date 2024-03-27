import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int Tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr;
		int[] dp;

		StringTokenizer st;
		for (int tc = 1; tc <= Tc; tc++) {

			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {

				arr[i] = Integer.parseInt(st.nextToken());
			}

			dp[0] = 1;
			for (int i = 1; i < N; i++) {
				int max = 0;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i]) {
						max = Math.max(max, dp[j]);
					}
					dp[i] = max + 1;
				}
			}
			int ans=0;
			for(int i=0;i<N;i++) {
				ans=Math.max(ans, dp[i]);
			}
			sb.append("#" + tc + " "+ ans+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
