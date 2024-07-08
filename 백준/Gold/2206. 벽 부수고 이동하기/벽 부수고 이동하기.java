import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }//입력완


        //bfs
        // 시작 위치와 목표 위치가 동일한 경우
        if (N == 1 && M == 1) {
            bw.write("1");
        } else {
            bw.write(String.valueOf(bfs()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {

        boolean[][][] visited = new boolean[N][M][2];
        Queue<int[]> queue = new ArrayDeque<>();

        //row,col,부순적이 있는지,cnt
        queue.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (nr == N - 1 && nc == M - 1)
                    return now[3] + 1;

                //벽아님
                if (map[nr][nc] == 0) {

                    if (now[2] == 0 && !visited[nr][nc][0]) {//벽 부순적 없다
                        queue.add(new int[]{nr, nc, 0, now[3] + 1});
                        visited[nr][nc][0] = true;
                    } else if (now[2] == 1 && !visited[nr][nc][1]) {//벽 부순적 있다
                        queue.add(new int[]{nr, nc, 1, now[3] + 1});
                        visited[nr][nc][1] = true;
                    }
                }
                //벽
                else {
                    if (now[2] == 0 && !visited[nr][nc][1]) {//부순적없다
                        queue.add(new int[]{nr, nc, 1, now[3] + 1});
                        visited[nr][nc][1] = true;
                    }
                }

            }

        }
        return -1;
    }
}