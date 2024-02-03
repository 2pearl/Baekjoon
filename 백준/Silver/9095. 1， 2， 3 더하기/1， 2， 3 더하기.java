import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int Tc=Integer.parseInt(st.nextToken());
		int[]dp;
		for(int tc=0;tc<Tc;tc++) {
			
			int n=Integer.parseInt(br.readLine());
			dp=new int[11];//1~10까지 들어오니까
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			
			for(int i=4;i<=n;i++)
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
			
			sb.append(dp[n]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}