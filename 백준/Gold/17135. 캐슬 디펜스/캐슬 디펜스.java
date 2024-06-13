import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, D;
    static int[][] map;
    static int max;

    static int[] archers;
    static List<int[]> targets;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        max = 0;
        map = new int[N][M];
        targets = new ArrayList<>();
        archers = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    targets.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    //궁수는 성이 있는 칸에 배치
    public static void dfs(int idx, int depth) {

        if (depth == 3) {
            attack();
            return;
        }
        for (int i = idx; i < M; i++) {
            archers[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public static void attack() {
        //몬스터 복사
        List<int[]> copiedTargets = new ArrayList<>();
        for (int i = 0; i < targets.size(); i++) {
            int[] target = targets.get(i);
            copiedTargets.add(new int[]{target[0], target[1]});
        }

        //공격시작
        int cnt = 0;
        while (!copiedTargets.isEmpty()) {

            List<Target> selected = new ArrayList<>();
            for (int arch = 0; arch < 3; arch++) {
                PriorityQueue<Target> pq = new PriorityQueue<>();
                for (int[] target : copiedTargets) {
                    int d = Math.abs(target[0] - N) + Math.abs(target[1] - archers[arch]);
                    if (d <= D) {//공격가능
                        pq.offer(new Target(target[0], target[1], d));
                    }
                }

                if (!pq.isEmpty()) {
                    Target target = pq.poll();
                    boolean isSelected = false;
                    for (int i = 0; i < selected.size(); i++) {
                        Target check = selected.get(i);
                        if (check.row == target.row && check.col == target.col) {
                            isSelected = true;
                            break;
                        }
                    }
                    if (!isSelected) {
                        selected.add(target);
                    }
                }
            }//궁수별로 추가 완

            //공격하자
            for (int i = 0; i < selected.size(); i++) {
                for (int j = copiedTargets.size() - 1; j >= 0; j--) {
                    if (selected.get(i).row == copiedTargets.get(j)[0] && selected.get(i).col == copiedTargets.get(j)[1]) {
                        copiedTargets.remove(j);
                        cnt++;
                        break;
                    }
                }
            }

            //남아있는 몬스터 이동
            for (int i = copiedTargets.size() - 1; i >= 0; i--) {
                copiedTargets.get(i)[0]++;
                if (copiedTargets.get(i)[0] == N) {
                    copiedTargets.remove(i);
                }
            }
        }

        max = Math.max(max, cnt);

    }

    static class Target implements Comparable<Target> {

        int row;
        int col;
        int dist;

        public Target(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Target o) {
            //dist 오름차순, col오름차순
            return this.dist == o.dist ? this.col - o.col : this.dist - o.dist;
        }
    }
}
