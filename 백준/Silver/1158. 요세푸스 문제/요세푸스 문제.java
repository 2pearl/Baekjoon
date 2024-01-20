import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st;
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < N + 1; i++)
			queue.offer(i);

		StringBuilder sb = new StringBuilder("<");
		while (queue.size() > 1) {

			for (int i = 0; i < K - 1; i++)
				queue.offer(queue.poll());

			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append(">");

		w.write(sb.toString());
		w.flush();
		w.close();
	}
}