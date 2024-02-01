//백준
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] A;
	static boolean[][]visited;
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상하좌우
	// static int count;

	static int N,M;
	
	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int T = Integer.parseInt(r.readLine());
		for (int t = 0; t < T; t++) {

			int count = 0;
			st = new StringTokenizer(r.readLine());
			M = Integer.parseInt(st.nextToken());//열
			N = Integer.parseInt(st.nextToken());//행
			int K = Integer.parseInt(st.nextToken());
			A = new int[N][M];
			visited = new boolean[N][M];

			for (int k = 0; k < K; k++) {

				st = new StringTokenizer(r.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				A[y][x] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j]&&A[i][j] == 1) {
						
						DFS(i, j);
						count++;
					}
				}
			}

			w.write(String.valueOf(count + "\n"));
		}
		r.close();
		w.flush();
		w.close();
	}

	static void DFS(int i, int j) {

		
		visited[i][j]=true;
		
		for (int dx = 0; dx < 4; dx++) {

			int x = i + d[dx][0];//행
			int y = j + d[dx][1];//열

			
			if (x < 0 || x >= N || y < 0 || y >= M) {
				
				continue;
			}
				
			
				
			if(A[x][y]==1&&!visited[x][y]) {
				DFS(x,y);
				
			}
				
		}

	}
}