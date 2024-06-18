import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new LinkedList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (!ans) {
                dfs(i, 1);
            }
        }

        bw.write(ans ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int v, int depth) {

        if (depth == 5 || ans) {
            ans = true;
            return;
        }

        visited[v] = true;
        for (int next : list[v]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[v] = false;
    }
}
