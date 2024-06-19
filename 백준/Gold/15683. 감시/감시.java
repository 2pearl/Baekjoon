import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][][] cases = {
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}},
            {{0, 1, 2, 3}}
    };

    static ArrayList<CCTV> cctvs;
    static int[] picked;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvs = new ArrayList<>();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        picked = new int[cctvs.size()];

        ans = Integer.MAX_VALUE;
        dfs(0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    //cctv조합 구하기
    static void dfs(int depth) {

        if (depth == cctvs.size()) {//다 뽑음 감시하러 가자

            //배열 복사
            int[][] copied = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copied[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < cctvs.size(); i++) {
                CCTV cctv = cctvs.get(i);
                int[] selected = cases[cctv.n - 1][picked[i]];
                for (int dir : selected) {
                    watch(cctv.row, cctv.col, dir, copied);
                }
            }

            // 사각지대 세자
            int count = countBlindSpots(copied);
            ans = Math.min(ans, count);
            return;
        }

        int cctv_mode = cctvs.get(depth).n;
        for (int i = 0; i < cases[cctv_mode - 1].length; i++) {

            picked[depth] = i;
            dfs(depth + 1);
        }
    }

    //감시 가보자고
    public static void watch(int row, int col, int dir, int[][] tempMap) {

        int nr = row + dr[dir];
        int nc = col + dc[dir];
        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
            if (tempMap[nr][nc] == 6) break; // 벽을 만나면 종료
            if (tempMap[nr][nc] == 0) tempMap[nr][nc] = -1; // 감시 영역 표시
            nr += dr[dir];
            nc += dc[dir];
        }

    }

    //사각지대 세기
    static int countBlindSpots(int[][] tempMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) count++;
            }
        }
        return count;
    }

    static class CCTV {
        int row;
        int col;
        int n;

        public CCTV(int row, int col, int n) {
            this.row = row;
            this.col = col;
            this.n = n;
        }
    }
}
