import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;
    static int[][] map;
    //4방
    static int[] dr1 = {-1, 0, 1, 0};
    static int[] dc1 = {0, 1, 0, -1};
    //8방
    static int[] dr2 = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc2 = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map=new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력완

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {

        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<int[]> queue = new ArrayDeque<>();

        //r,c,8방횟수,동작수
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];
            int horse = now[2];
            int cnt = now[3];

            if (row == H - 1 && col == W - 1)
                return cnt;

            for (int d = 0; d < 4; d++) {

                int nr = row + dr1[d];
                int nc = col + dc1[d];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W)
                    continue;

                if (visited[nr][nc][horse])
                    continue;

                if (map[nr][nc] != 1) {
                    visited[nr][nc][horse] = true;
                    queue.add(new int[]{nr, nc, horse, cnt + 1});
                }
            }

            if (horse < K) {//8방 가능
                for (int d = 0; d < 8; d++) {
                    int nr=row+dr2[d];
                    int nc=col+dc2[d];


                    if (nr < 0 || nr >= H || nc < 0 || nc >= W)
                        continue;

                    if (visited[nr][nc][horse+1])
                        continue;

                    if (map[nr][nc] != 1) {
                        visited[nr][nc][horse+1] = true;
                        queue.add(new int[]{nr, nc, horse+1, cnt + 1});
                    }

                }
            }
        }

        return -1;
    }
}
