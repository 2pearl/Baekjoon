import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static boolean[] swit;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder("");

		N = Integer.parseInt(br.readLine());
		swit = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				swit[i] = false;
			else
				swit[i] = true;
		}

		int St = Integer.parseInt(br.readLine());
		for (int i = 0; i < St; i++) {

			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if (gender == 1)
				boy(n);
			else
				girl(n);
		}

		for (int j = 1; j <= N; j++) {

			sb.append(swit[j] ? 1 : 0).append(" ");
			if (j % 20 == 0)
				sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void boy(int n) {

		for (int i = n; i <= N; i += n)
			turn(i);
	}

	public static void girl(int n) {

		for (int i = 1; i < n; i++) {
			if (n - i > 0 && n + i <= N) {

				if (swit[n - i] == swit[n + i]) {

					turn(n - i);
					turn(n + i);
				}
				else break;
			}

		}
		turn(n);
	}

	public static void turn(int i) {
	
		swit[i]^=true;
		
	}
}
