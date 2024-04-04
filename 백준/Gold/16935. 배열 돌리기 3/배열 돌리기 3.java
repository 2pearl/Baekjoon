import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력끝

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int n = Integer.parseInt(st.nextToken());
			// 배열돌리기
			rot(n);
		}

		// 결과
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void rot(int m) {

		switch (m) {
		case 1:
			// 상하반전
			for (int r = 0; r < N / 2; r++) {
				for (int c = 0; c < M; c++) {
					int tmp = map[r][c];
					map[r][c] = map[N - 1 - r][c];
					map[N - 1 - r][c] = tmp;
				}
			}
			break;
		case 2:
			// 좌우반전
			for (int c = 0; c < M / 2; c++) {
				for (int r = 0; r < N; r++) {
					int tmp = map[r][c];
					map[r][c] = map[r][M - 1 - c];
					map[r][M - 1 - c] = tmp;
				}
			}
			break;
		case 3:
			// 오른쪽으로 90도 회전
			int[][] tmp3 = new int[M][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					tmp3[c][N - 1 - r] = map[r][c];
				}
			}

			int swap3 = N;
			N = M;
			M = swap3;
			map = tmp3;
			break;
		case 4:
			// 왼쪽으로 90도 회전
			int[][] tmp4 = new int[M][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					tmp4[M - 1 - c][r] = map[r][c];
				}
			}

			int swap4 = N;
			N = M;
			M = swap4;
			map = tmp4;
			break;
		case 5:
			int[][] tmp5 = new int[N][M];
			// 1->2
			for (int r = 0; r < N / 2; r++) {
				for (int c = 0; c < M / 2; c++) {
					tmp5[r][c + M / 2] = map[r][c];
				}
			}
			// 2->3
			for (int r = 0; r < N / 2; r++) {
				for (int c = M / 2; c < M; c++) {
					tmp5[r + N / 2][c] = map[r][c];
				}
			}
			// 3->4
			for (int r = N / 2; r < N; r++) {
				for (int c = M / 2; c < M; c++) {
					tmp5[r][c - M / 2] = map[r][c];
				}
			}
			// 4->1
			for (int r = N / 2; r < N; r++) {
				for (int c = 0; c < M / 2; c++) {
					tmp5[r - N / 2][c] = map[r][c];
				}
			}
			map = tmp5;
			break;
		case 6:
			int[][] tmp6 = new int[N][M];
			// 1->4
			for (int r = 0; r < N / 2; r++) {
				for (int c = 0; c < M / 2; c++) {
					tmp6[r + N / 2][c] = map[r][c];
				}
			}
			// 4->3
			for (int r = N / 2; r < N; r++) {
				for (int c = 0; c < M / 2; c++) {
					tmp6[r][c + M / 2] = map[r][c];
				}
			}
			// 3->2
			for (int r = N / 2; r < N; r++) {
				for (int c = M / 2; c < M; c++) {
					tmp6[r - N / 2][c] = map[r][c];
				}
			}
			// 2->1
			for (int r = 0; r < N / 2; r++) {
				for (int c = M / 2; c < M; c++) {
					tmp6[r][c - M / 2] = map[r][c];
				}
			}
			map = tmp6;
			break;
		}
	}
}
