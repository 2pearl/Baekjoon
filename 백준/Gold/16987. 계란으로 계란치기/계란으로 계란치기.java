import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Egg[] eggs;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        max = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //계란깨기
        dfs(0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int cnt) {

        if (idx == N || cnt == N - 1) {//다 들어봄
            max = Math.max(max, cnt);
            return;
        }

        if (eggs[idx].durability <= 0) {
            dfs(idx + 1, cnt);
        } else {
            for (int i = 0; i < N; i++) {
                if (i == idx) {//지금 든 계란이니까 패스
                    continue;
                }
                if (eggs[i].durability > 0) {
                    eggs[i].durability -= eggs[idx].weight;
                    eggs[idx].durability -= eggs[i].weight;
                    dfs(idx + 1, cnt + (eggs[i].durability <= 0 ? 1 : 0) + (eggs[idx].durability <= 0 ? 1 : 0));
                    eggs[idx].durability += eggs[i].weight;
                    eggs[i].durability += eggs[idx].weight;
                }
            }
        }

    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
