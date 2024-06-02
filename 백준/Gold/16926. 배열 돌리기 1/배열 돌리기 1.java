import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력끝

        int T = Math.min(N, M)/2;//회전횟수 구하기
        for (int r = 0; r < R; r++) {

            for (int i = 0; i < T; i++) {

                int tmp = arr[i][i];

                for (int j = i + 1; j < M - i; j++) {
                    arr[i][j - 1] = arr[i][j];
                }
                for (int j = i + 1; j < N - i; j++) {
                    arr[j - 1][M - 1 - i] = arr[j][M - 1 - i];
                }
                for (int j = M - 2 - i; j >= i; j--) {
                    arr[N - 1 - i][j + 1] = arr[N - 1 - i][j];
                }
                for (int j = N - 2 - i; j >= i; j--) {
                    arr[j + 1][i] = arr[j][i];
                }

                arr[i + 1][i] = tmp;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}