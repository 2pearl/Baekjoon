import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }//입력 끝

        sb = new StringBuilder();
        dfs(0, 0, N);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c, int d) {

        if (check(r, c, d)) {
            sb.append(arr[r][c]);
            return;
        }

        //아니면 더 나눠야함
        int next = d / 2;
        sb.append("(");
        dfs(r, c, next);
        dfs(r, c + next, next);
        dfs(r + next, c, next);
        dfs(r + next, c + next, next);
        sb.append(")");
    }

    //다 같은 숫자인지 확인하는 메서드
    public static boolean check(int r, int c, int d) {

        int fist = arr[r][c];
        for (int i = r; i < r + d; i++) {
            for (int j = c; j < c + d; j++) {
                if (arr[i][j] != fist) {
                    return false;
                }
            }
        }
        return true;
    }
}
