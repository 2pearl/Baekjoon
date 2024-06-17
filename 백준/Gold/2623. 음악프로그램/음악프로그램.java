import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] in;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ans = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        in = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int next = 0; next < n - 1; next++) {
                int x=Integer.parseInt(st.nextToken());

                adj[pre].add(x);
                in[x]++;
                pre = x;
            }
        }

        sort();
        if (ans.size() != N) {
            sb.append("0");
        } else {
            for (int i : ans) {
                sb.append(i + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void sort() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            ans.add(v);

            for (int i : adj[v]) {
                in[i]--;
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }
        }
    }
}
