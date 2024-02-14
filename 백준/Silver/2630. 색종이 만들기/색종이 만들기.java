import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] input;
	static int white,blue;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//0이면 흰,1이면 파랑
		
		divide(0,0,N);//8
		bw.write(String.valueOf(white)+"\n"+String.valueOf(blue));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void divide(int row,int col,int d) {

		if(check(row,col,d)) {
			
			if(input[row][col]==0)
				white++;
			else blue++;
			
			return;
		}
		
		int next=d/2;
		divide(row,col,next);
		divide(row,col+next,next);
		divide(row+next,col,next);
		divide(row+next,col+next,next);

	}
	public static boolean check(int row,int col,int d) {
		
		int color=input[row][col];
		
		for (int i = row; i < row+d; i++) {
			for (int j = col; j < col+d; j++) {
				
				//다른 색상
				if(input[i][j]!=color) {
					return false;
				}
			}
		}
		return true;
	}
}
