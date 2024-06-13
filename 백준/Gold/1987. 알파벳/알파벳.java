import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[] alpha;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        alpha = new boolean[26];
        max = 0;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int i, int j, int length) {
        alpha[map[i][j]] = true;
        max = Math.max(max, length);

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (!alpha[map[nr][nc]]) {
                dfs(nr, nc, length + 1);
                alpha[map[nr][nc]] = false;
            }
        }


    }
}
