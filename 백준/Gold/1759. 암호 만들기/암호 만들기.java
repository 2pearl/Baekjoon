import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] input;
    static char[] picked;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        input = new char[C];
        picked = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        dfs(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        bw.close();

    }

    public static void dfs(int idx, int depth) {
        if (depth == L) {
            if (check()) {
                for (char ch : picked) {
                    sb.append(ch);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            picked[depth] = input[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static boolean check() {
        int m = 0;//모음 1개 이상
        int z = 0;//자음 2개 이상

        for (char ch : picked) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                m++;
            } else z++;
        }
        if (m >= 1 && z >= 2)
            return true;
        return false;
    }
}
