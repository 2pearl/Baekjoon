import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] peoples;
    static int p, c;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        peoples = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            peoples[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            peoples[x].add(y);
            peoples[y].add(x);
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{p, 0});
        visited[p] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for (int d : peoples[now[0]]) {
                if (!visited[d]) {
                    if (d == c) {
                        return now[1] + 1;
                    }
                    visited[d] = true;
                    queue.offer(new int[]{d, now[1] + 1});
                }
            }
        }
        return -1;
    }
}
