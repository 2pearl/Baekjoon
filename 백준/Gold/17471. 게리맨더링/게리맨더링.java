import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] population;
    static int min;
    static boolean[] selected, visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }//입력끝

        min = Integer.MAX_VALUE;
        selected = new boolean[N + 1];

        dfs(1);
        bw.write(min == Integer.MAX_VALUE ? String.valueOf(-1) : String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth) {

        if (depth == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            //인구수
            int acnt = 0;
            int bcnt = 0;

            for (int i = 1; i < N + 1; i++) {
                if (selected[i]) {
                    a.add(i);
                    acnt += population[i];
                } else {
                    b.add(i);
                    bcnt += population[i];
                }
            }

            if (a.size() == 0 || b.size() == 0)//한지역으로 몰빵이니까
                return;

            if (check(a) && check(b)) {
                min = Math.min(min, Math.abs(acnt - bcnt));
            }

            return;
        }

        selected[depth] = true;
        dfs(depth + 1);
        selected[depth] = false;
        dfs(depth + 1);
    }

    public static boolean check(List<Integer> list) {

        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        queue.offer(list.get(0));
        visited[list.get(0)] = true;


        int cnt = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int v : graph[now]) {
                if (list.contains(v) && !visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                    cnt++;
                }
            }
        }

        if (cnt == list.size())
            return true;
        return false;
    }
}
