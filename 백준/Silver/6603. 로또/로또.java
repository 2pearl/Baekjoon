import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] array;
	static boolean[] visited;
	static int[] result;

	static int k, m;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		m = 6;

		sb = new StringBuilder("");
		while (true) {

			st = new StringTokenizer(r.readLine());
			k = Integer.parseInt(st.nextToken());

			if (k != 0) {

				array = new int[k];
				visited = new boolean[k];
				result = new int[m];

				for (int i = 0; i < k; i++)
					array[i] = Integer.parseInt(st.nextToken());

				dfs(0, 0);
				sb.append("\n");
			} else
				break;

		}
		w.write(sb.toString());
		w.flush();
		w.close();
	}

	public static void dfs(int idx, int now) {

		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = now; i < k; i++) {

			if (!visited[i]) {

				visited[i] = true;
				result[idx] = array[i];
				dfs(idx + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
