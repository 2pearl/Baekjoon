import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int[] g;
	static int[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		K = Integer.parseInt(r.readLine());
		g = new int[K];

		int total = 0;
		StringTokenizer st = new StringTokenizer(r.readLine());
		for (int i = 0; i < K; i++) {
			g[i] = Integer.parseInt(st.nextToken());
			total += g[i];
		}
		check = new int[total + 1];
		int count = 0;

		search(0, 0);
		for (int i = 1; i < total + 1; i++) {
			if (check[i] == 0)
				count++;
		}

		w.write(String.valueOf(count));
		w.flush();
		w.close();
	}

	public static void search(int idx, int w) {

		if (idx < K) {
			search(idx + 1, w);
			search(idx + 1, w + g[idx]);
			search(idx + 1, w - g[idx]);
		}

		if (idx == K && w > 0) {

			check[w] = 1;
		}

	}

}
