import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int ans1, ans2;//적록색약 아닌사람, 맞는사람(r,g구분 못함)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }//입력끝

        //적록색약아닌사람
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ans1++;
                    bfs(i, j);
                }
            }
        }

        //g를 r로 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }


        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ans2++;
                    bfs(i, j);
                }
            }
        }

        bw.write(ans1 + " " + ans2);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                //같은 색상
                if (map[nr][nc] == map[now[0]][now[1]]&&!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
