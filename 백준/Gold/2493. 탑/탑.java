import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] top = new int[N];
		// 탑 초기화
		for (int i = 0; i < N; i++)
			top[i] = Integer.parseInt(st.nextToken());

		Stack<Top> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {

			if (stack.isEmpty()) {

				sb.append(0).append(" ");
			} else {

				while (!stack.isEmpty()&&stack.peek().h < top[i]) {

					stack.pop();
				}
				if (stack.isEmpty()) {

					sb.append(0).append(" ");
					
				} else {

					if (stack.peek().h > top[i]) {
						sb.append(stack.peek().idx + 1).append(" ");

					}
				}

			}
			stack.push(new Top(i, top[i]));
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}

class Top {
	int idx;
	int h;

	Top(int idx, int h) {
		this.idx = idx;
		this.h = h;
	}
}
