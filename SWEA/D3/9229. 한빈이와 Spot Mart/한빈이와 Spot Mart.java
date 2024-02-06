import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] w;
	static int N,M;
	static int max;
	static boolean find;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Tc=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=Tc;tc++) {
			
			sb.append("#").append(tc).append(" ");
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			w=new int[N];
			max=0;
			find=false;
			st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				w[i]=Integer.parseInt(st.nextToken());
			

			dfs(0,0,0);
			
			if(find)
				sb.append(max);
			else
				sb.append(-1);
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int depth,int idx,int sum) {
			
		if(sum>M)
			return;
		
		if(depth==2) {
			max=Math.max(max, sum);
			find=true;
			return;
		}
		
		for(int i=idx;i<N;i++) {
			
			dfs(depth+1,i+1,sum+w[i]);
		}
	}
}
