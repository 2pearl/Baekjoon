import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] array;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		result = new int[M];
		array = new int[N];

		st = new StringTokenizer(r.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		sb = new StringBuilder("");

		Arrays.sort(array);
		dfs(0);

		w.write(sb.toString());
		w.flush();
		w.close();
	}

	public static void dfs(int idx) {

		if (idx == M) {

			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {

			if (!visited[i]) {

				visited[i] = true;
				result[idx] = array[i];
				dfs(idx + 1);
				visited[i] = false;
			}
		}

	}
}
