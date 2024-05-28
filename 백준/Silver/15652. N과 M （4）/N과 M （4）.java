import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] res;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		res = new int[M];

		recur(0,1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void recur(int idx,int now) {

		if (idx == M) {
			for (int n:res) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

//		for (int s = start; s <= N; s++) {
//			
//			res[idx] = s;
//			recur(idx + 1, s + 1);
//		}
		
		/*
		 * 
		 */
		for(int i=now;i<=N;i++) {
			
			res[idx]=i;
			recur(idx+1,i);
		}
	}
}
