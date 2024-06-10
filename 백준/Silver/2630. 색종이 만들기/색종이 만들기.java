import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr=new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력끝

        dfs(0, 0, N);
        bw.write(white + "\n" + blue);
        bw.flush();
        bw.close();
        br.close();
    }

    //d는 칸
    public static void dfs(int r, int c, int d) {

        if (check(r, c, d)) {
            //흰색은 0,파란색은 1
            if (arr[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        //아니면 더 나눠야함
        int next = d / 2;
        dfs(r, c, next);
        dfs(r, c + next, next);
        dfs(r + next, c, next);
        dfs(r + next, c + next, next);
    }

    //다 같은 색인지 확인하는 메서드
    public static boolean check(int r, int c, int d) {

        int color = arr[r][c];
        for (int i = r; i < r + d; i++) {
            for (int j = c; j < c + d; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
