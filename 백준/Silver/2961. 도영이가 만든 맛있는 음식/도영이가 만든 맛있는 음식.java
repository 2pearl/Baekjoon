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

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());// 신맛
			arr[i][1] = Integer.parseInt(st.nextToken());// 쓴맛
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << N); i++) {// 모든 부분집합

			int shin = 1;
			int sseun = 0;

			for (int j = 0; j < N; j++) {

				if ((i & (1 << j)) > 0) {

					shin *= arr[j][0];
					sseun += arr[j][1];
				}
			}

			min = Math.min(min, Math.abs(shin - sseun));
		}

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
}