import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static int[][] input;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb=new StringBuilder();
		
		N = Integer.parseInt(br.readLine());

		// 영상배열 입력
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				input[i][j] = str.charAt(j) - '0';
		}

		divide(0, 0, N);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void divide(int row, int col, int d) {

		
		// 압축된다면
		if (check(row, col, d)) {
			sb.append(input[row][col]);
			return;
		}

		int next = d / 2;
		sb.append("(");
		divide(row, col, next);
		divide(row, col + next, next);
		divide(row + next, col, next);
		divide(row + next, col + next, next);
		sb.append(")");
	}

	public static boolean check(int row, int col, int d) {

		int color = input[row][col];
		for (int i = row; i < row + d; i++) {
			for (int j = col; j < col + d; j++) {
				// 다른 색상이 존재
				if (input[i][j] != color)
					return false;
			}
		}
		return true;
	}
}
