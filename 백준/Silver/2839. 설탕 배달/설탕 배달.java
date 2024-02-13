import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 최소로
		int cnt = 0;
		while (N > 0) {

			if (N % 5 == 0) {
				cnt += N / 5;
				break;
			}
			if (N < 3) {
				cnt = -1;
				break;
			}

			cnt += 1;
			N -= 3;
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}

}
