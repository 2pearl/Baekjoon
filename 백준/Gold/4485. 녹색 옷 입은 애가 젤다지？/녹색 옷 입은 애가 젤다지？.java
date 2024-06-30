import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[][] rupee;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {

            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            rupee=new int[N][N];
            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem " + tc + ": " + dijkstra() + "\n");
            tc++;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra() {

        Queue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, map[0][0]));
        for (int i = 0; i < N; i++) {
            Arrays.fill(rupee[i], INF);
        }
        rupee[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (now.row == N - 1 && now.col == N - 1) {
                return now.w;
            }

            for(int d=0;d<4;d++){
                int nr=now.row+dr[d];
                int nc=now.col+dc[d];

                if(nr<0||nr>=N||nc<0||nc>=N)
                    continue;

                if(rupee[nr][nc]>now.w+map[nr][nc]){
                    rupee[nr][nc]=now.w+map[nr][nc];
                    pq.add(new Point(nr,nc,rupee[nr][nc]));
                }
            }

        }
        return 0;
    }

    public static class Point implements Comparable<Point> {
        int row;
        int col;
        int w;

        public Point(int row, int col, int w) {
            this.row = row;
            this.col = col;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w - o.w;
        }
    }
}
