import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Point {

	int row;
	int col;

	public Point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}

public class Main {

	static int N, M;
	static int[] res;
	static boolean[] visited;
	static List<Point> home, chicken;
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		chicken = new ArrayList<>();
		res = new int[M];

		min = Integer.MAX_VALUE;

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {// 집
					home.add(new Point(i, j));
				} else if (n == 2) {// 치킨집
					chicken.add(new Point(i, j));
				}
			}
		}

		visited = new boolean[chicken.size()];

		// 조합 구하기
		dfs(0,0);
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int depth,int idx) {

		if (depth == M) {// 치킨 집 다 구함

			min = Math.min(min, getDistance());
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			
			res[depth]=i;
			dfs(depth+1,i+1);
		}
	}

	public static int getDistance() {
		
		int sum=0;
		
		for(int i=0;i<home.size();i++) {
			
			int m=Integer.MAX_VALUE;
			
			for(int j=0;j<M;j++) {
				int dist=Math.abs(home.get(i).row-chicken.get(res[j]).row)+Math.abs(home.get(i).col-chicken.get(res[j]).col);
				m=Math.min(m, dist);
			}
			sum+=m;
		}
		
		return sum;
	}
}
