
//백준
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int[][] A;
	static boolean[][] visited;
	static int N;
	static int count;// 집 개수 세릴때

	static int[] dx = { -1, 1, 0, 0 };// 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(r.readLine());
		ArrayList<Integer> house = new ArrayList<>();// 단지내 집의 수 저장

		A = new int[N][N];
		visited = new boolean[N][N];
		
		
		for (int i = 0; i < N; i++) {
			String s=r.readLine();
			for (int j = 0; j < N; j++) {
				A[i][j] = s.charAt(j)-'0';
			}
		}
		count=0;
		int danzi=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]&&A[i][j] == 1) {
					if(count>0) {
						danzi++;
						house.add(count);
					}
						
					count = 0;
					DFS(i, j);
				}

			}
		}

		if(count>0) {
			danzi++;
			house.add(count);
		}
			
		Collections.sort(house);
		
		w.write(String.valueOf(danzi)+"\n");
		for (int i = 0; i < house.size(); i++)
			w.write(String.valueOf(house.get(i)) + "\n");
		r.close();
		w.flush();
		w.close();
	}

	public static void DFS(int i, int j) {

		visited[i][j] = true;
		count++;

		for (int k = 0; k < 4; k++) {
			int x = i + dy[k];
			int y = j + dx[k];

			if (x < 0 || x >= N || y < 0 || y >= N)
				continue;

			if (A[x][y] == 1 && !visited[x][y])
				DFS(x, y);
			

		}
	}
}