import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //홈팀, 원정팀
    static int[] home = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] away = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[6][3];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int Tc = 0; Tc < 4; Tc++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    sum += arr[i][j];
                }
            }//예제별 입력완
            if (sum != 30) sb.append("0 ");
            else sb.append(dfs(0) ? "1 " : "0 ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean dfs(int idx) {

        if (idx == 15) return true;

//        홈팀 승리
//        홈팀의 승리횟수가 남아있고, 원정팀의 패배횟수가 남아있다
        if (arr[home[idx]][0] > 0 && arr[away[idx]][2] > 0) {
            arr[home[idx]][0]--;
            arr[away[idx]][2]--;
            if (dfs(idx + 1)) return true;
            arr[home[idx]][0]++;
            arr[away[idx]][2]++;
        }

        //무승부
        if (arr[home[idx]][1] > 0 && arr[away[idx]][1] > 0) {
            arr[home[idx]][1]--;
            arr[away[idx]][1]--;
            if (dfs(idx + 1)) return true;
            arr[home[idx]][1]++;
            arr[away[idx]][1]++;
        }

        //원정팀 승리
        if (arr[home[idx]][2] > 0 && arr[away[idx]][0] > 0) {
            arr[home[idx]][2]--;
            arr[away[idx]][0]--;
            if (dfs(idx + 1)) return true;
            arr[home[idx]][2]++;
            arr[away[idx]][0]++;
        }


        return false;
    }
}
