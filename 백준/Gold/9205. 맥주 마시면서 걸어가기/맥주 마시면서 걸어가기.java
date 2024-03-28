import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			List<Point> con = new ArrayList<>();
			n = Integer.parseInt(br.readLine());// 편의점개수

			graph = new ArrayList[n + 2];
			visited = new boolean[n + 2];
			for (int i = 0; i < n+2; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < n + 2; i++) {
				st=new StringTokenizer(br.readLine());
				con.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			// 그래프 잇기
			for (int i = 0; i < con.size() - 1; i++) {
				for (int j = i + 1; j < con.size(); j++) {

					if (getDistance(con.get(i), con.get(j)) <= 1000) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}

			bw.write(bfs() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static String bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(0);
		visited[0] = true;

		// 그래프탐색
		while (!queue.isEmpty()) {

			int now = queue.poll();
			if (now == n + 1) {// 끝
				return "happy";
			}

			for (int v : graph[now]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.offer(v);
				}
			}
		}
		return "sad";
	}

	public static int getDistance(Point s, Point e) {

		return Math.abs(s.row - e.row) + Math.abs(s.col - e.col);
	}

	public static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
}
