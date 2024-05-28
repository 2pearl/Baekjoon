import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int []arr;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr=new int[M];
		
		perm(1,0);

		//w.flush();
		//w.close();
		System.out.print(sb);
	}

	public static void perm(int k,int depth) {

		if (depth == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=k;i<=N;i++) {
			
			arr[depth]=i;
			perm(i+1,depth+1);
		}
		
	}
}
