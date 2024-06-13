import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<int[]> homes;
    static List<int[]> chickens;
    static int[] pick;
    static int min_dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        pick = new int[M];
        min_dist = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) homes.add(new int[]{i, j});
                else if (n == 2) chickens.add(new int[]{i, j});
            }
        }//입력끝

        dfs(0, 0);
        bw.write(String.valueOf(min_dist));
        bw.flush();
        bw.close();
        br.close();
    }

    //치킨집 고르는 경우의 수
    public static void dfs(int idx, int depth) {

        if (depth == M) {
            min_dist = Math.min(min_dist, getDistance());
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            pick[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public static int getDistance() {
        int sum = 0;
        for (int i = 0; i < homes.size(); i++) {
            int m = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {

                m = Math.min(m, Math.abs(homes.get(i)[0] - chickens.get(pick[j])[0]) + Math.abs(homes.get(i)[1] - chickens.get(pick[j])[1]));
            }
            sum += m;
        }
        return sum;
    }
}
