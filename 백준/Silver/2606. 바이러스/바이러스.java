
//백준
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int count;
	static ArrayList<Integer>[]A;
	static boolean []visited;
	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		int N=Integer.parseInt(r.readLine());
		int M=Integer.parseInt(r.readLine());
		StringTokenizer st;
		
		A=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
			A[i]=new ArrayList<>();
		visited=new boolean[N+1];
		
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(r.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			A[start].add(end);
			A[end].add(start);
		}
		
		count=0;
		dfs(1);
		w.write(String.valueOf(count));
		
		w.flush();
		w.close();
	}

	static public void dfs(int v) {
		if(visited[v])
			return;
		
		visited[v]=true;
		for(int i:A[v])
			if(!visited[i]) {
				count++;
				dfs(i);
			}
	}
}