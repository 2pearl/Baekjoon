import java.io.*;

public class Main {
    static int N, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        //열만 저장할거야
        arr = new int[N];

        dfs(0);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int row) {

        if (row == N) {//마지막 행까지 온거니까
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[row] = i;//i열에 퀸을 놓아본다

            if (check(row)) {//괜찮으면 다음 행으로 이동
                dfs(row + 1);
            }
        }
    }

    public static boolean check(int row) {

        for (int i = 0; i < row; i++) {
            //이미 그 열에 있거나 대각선이면 false
            if (arr[i] == arr[row] || row - i == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
