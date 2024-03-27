import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[][] map;
	static boolean end;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {

				map[i][j] = s.charAt(j) - '0';
			}
		}
		// 입력끝
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int idx) {

		if (idx == 81) {
			end = true;
			return;
		}

		int r = idx / 9;
		int c = idx % 9;

		if (map[r][c] != 0) {
			dfs(idx + 1);
		}

		else {// 0이니까 숫자 채워야함

			for (int i = 1; i < 10; i++) {

				if (!check(r, c, i))
					continue;

				map[r][c] = i;
				dfs(idx + 1);

				if (end)
					return;

				map[r][c] = 0;// 원복
			}

		}

	}

	public static boolean check(int r, int c, int num) {

		// 가로, 세로줄
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num || map[i][c] == num) {
				return false;
			}
		}

		// 사각형
		int srow = (r / 3) * 3;
		int scol = c - (c % 3);

		for (int i = srow; i < srow + 3; i++) {
			for (int j = scol; j < scol + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}
}
