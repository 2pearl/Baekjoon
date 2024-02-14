import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N, cnt;
	static int[] board;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N];

		dfs(0);
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int depth) {

		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {

			board[depth] = i;
			if(check(depth))
				dfs(depth+1);
		}
	}

	public static boolean check(int depth) {

		
		for(int i=0;i<depth;i++) {
			if(board[depth]==board[i])
				return false;
			if(Math.abs(depth-i)==Math.abs(board[depth]-board[i]))
				return false;
				
		}
		return true;
	}
}
