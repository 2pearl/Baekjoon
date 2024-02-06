import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] result;
	static boolean []visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		visited=new boolean[N+1];
		sb = new StringBuilder();

		dfs(0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int idx) {

		if (idx == M) {
			for (int data : result) {
				sb.append(data).append(" ");
			}
			sb.append("\n");
			
			return;
		}

		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				
				visited[i]=true;
				result[idx]=i;
				dfs(idx+1);
				visited[i]=false;
			}
		}
	}
}
