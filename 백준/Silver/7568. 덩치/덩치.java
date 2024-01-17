import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(r.readLine());
		StringTokenizer st;

		int[][] array = new int[n][2];

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(r.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {

				if (i == j)
					continue;

				if ((array[i][0] < array[j][0]) && (array[i][1] < array[j][1]))
					rank++;

			}
			w.write(String.valueOf(rank) + " ");
		}
		w.flush();
		w.close();
	}
}
