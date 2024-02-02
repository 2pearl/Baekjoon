import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Queue<Integer> queue = new ArrayDeque<>();
		for (int tc = 1; tc <= 10; tc++) {

			int t = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++)
				queue.offer(Integer.parseInt(st.nextToken()));

			int i = 1;
			while (true) {

				int num = queue.poll();
				num = (num - i <= 0 ? 0 : num - i);

				queue.offer(num);
				if (num == 0)
					break;
				if (i == 5)
					i = 0;
				i++;
			}

			while (!queue.isEmpty())
				sb.append(queue.poll()).append(" ");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
