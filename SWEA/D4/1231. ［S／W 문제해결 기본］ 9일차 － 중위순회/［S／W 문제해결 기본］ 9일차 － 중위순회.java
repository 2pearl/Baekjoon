import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static char[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			sb.append("#" + tc + " ");

			N = Integer.parseInt(br.readLine());
			arr = new char[N + 1];
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				arr[idx] = c;
			}
			inorder(1);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void inorder(int idx) {

		if (idx > N)
			return;

		inorder(2 * idx);
		sb.append(arr[idx]);
		inorder(2*idx+1);
	}
}
