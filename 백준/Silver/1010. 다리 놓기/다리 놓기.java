import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int max = 31;
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        dp = new int[max][max];

        for (int i = 1; i < max; i++) {
            dp[i][1]=i;
        }

        for(int i=2;i<max;i++){
            for(int j=2;j<max;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }

        int Tc = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < Tc; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
