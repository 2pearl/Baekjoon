import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(r.readLine());

		int c = 0;

		if (N < 100) {

			c = N;
		} else {
			c = 99;
			for (int i = 100; i <= N; i++) {

				int h = i / 100;
				int t = i / 10 % 10;
				int o = i % 10;

				if (h - t == t - o)
					c++;
			}
		}

		w.write(String.valueOf(c));
		w.flush();
		w.close();
	}

}
