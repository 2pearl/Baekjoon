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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			queue.offer(Integer.parseInt(st.nextToken()));

		int Time = 0;
		int nowL = 0;

		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.offer(0);
		}

		while (!bridge.isEmpty()) {

			Time++;

			nowL -= bridge.poll();

			if (!queue.isEmpty()) {

				if (nowL + queue.peek() <= L) {
					nowL += queue.peek();
					bridge.offer(queue.poll());
				}

				else
					bridge.offer(0);
			}

		}
		bw.write(String.valueOf(Time));
		bw.flush();
		bw.close();
	}

}
