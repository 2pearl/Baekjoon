import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		divide(r, c, (int) Math.pow(2, N));

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void divide(int r, int c, int size) {

		if (size == 1)
			return;

		if (r < size / 2 && c < size / 2)
			divide(r, c, size / 2);
		else if (r < size / 2 && c >= size / 2) {//
			ans += (size * size / 4);
			divide(r, c - size / 2, size / 2);
		} else if (r >= size / 2 && c < size / 2) {
			ans += (size * size / 4) * 2;
			divide(r - size / 2, c, size / 2);
		} else {
			ans += (size * size / 4) * 3;
			divide(r - size / 2, c - size / 2, size / 2);
		}
	}
}
