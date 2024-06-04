import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new int[100][100];
        int T = Integer.parseInt(br.readLine());
        //색종이 색칠
        for (int t = 0; t < T; t++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    arr[x + i][y + j] = 1;
                }
            }
        }
        int cnt = 0;
        //끝인지 확인
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dr[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx>= 100 || ny < 0 || ny >= 100 || arr[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
