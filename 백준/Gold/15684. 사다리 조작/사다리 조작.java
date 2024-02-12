import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M,H;
	static int[][] ladder;
	static boolean res;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());//열
		M=Integer.parseInt(st.nextToken());//현재 가로선 개수
		H=Integer.parseInt(st.nextToken());//행
		
		ladder=new int[H+1][N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int left=Integer.parseInt(st.nextToken());
			int right=Integer.parseInt(st.nextToken());
			
			ladder[left][right]=1;
			ladder[left][right+1]=-1;
		}
		
		res=false;
		for(int i=0;i<=3;i++) {
			dfs(1,0,i);
			if(res) {
				bw.write(String.valueOf(i));
				break;
			}
		}
		if(!res)
			bw.write(String.valueOf(-1));
		
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dfs(int row,int count,int size) {//현재 행,현재 추가 가로선개수, 최대 개수
		
		if(res)
			return;
		
		if(count==size) {
			if(check())
				res=true;
			return;
		}
		
		for(int i=row;i<=H;i++) {
			for(int j=1;j<N;j++) {
				
				if(ladder[i][j]==0&&ladder[i][j+1]==0) {
					ladder[i][j]=1;
					ladder[i][j+1]=-1;
					
					dfs(i,count+1,size);
					
					ladder[i][j]=0;
					ladder[i][j+1]=0;
				}
			}
		}
	}
	public static boolean check() {
		
		for(int i=1;i<=N;i++) {
			
			int row=1;
			int col=i;
			while(row<=H) {
				if(ladder[row][col]==1)
					col++;
				else if(ladder[row][col]==-1)
					col--;
				row++;
			}
			if(col!=i)
				return false;
		}
		return true;
	}
}
