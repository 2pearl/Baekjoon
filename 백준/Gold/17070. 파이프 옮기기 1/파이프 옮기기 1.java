import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int N;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;
		dfs(0, 1, 0);

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int row, int col, int direction) {

		if (row == N - 1 && col == N - 1) {

			count++;
			return;
		}

		switch (direction) {

		case 0:// 가로
			if (col + 1 < N && arr[row][col + 1] == 0)
				dfs(row, col + 1, 0);
			break;

		case 1:// 세로
			if (row + 1 < N && arr[row + 1][col] == 0)
				dfs(row + 1, col, 1);
			break;

		case 2:// 대각선
			if (col + 1 < N && arr[row][col + 1] == 0)
				dfs(row, col + 1, 0);

			if (row + 1 < N && arr[row + 1][col] == 0)
				dfs(row + 1, col, 1);
			break;
		}

		// 대각선은 항상
		if (row + 1 < N && col + 1 < N && arr[row][col + 1] == 0 && arr[row + 1][col] == 0
				&& arr[row + 1][col + 1] == 0)
			dfs(row + 1, col + 1, 2);
	}
}
