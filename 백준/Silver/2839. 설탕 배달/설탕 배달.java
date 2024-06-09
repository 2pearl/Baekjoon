import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int c = 0;
        while (N > 0) {

            if (N % 5 == 0) {
                c += N / 5;
                break;
            }
            if (N < 3) {
                c = -1;
                break;
            }

            c++;
            N -= 3;
        }

        bw.write(String.valueOf(c));
        bw.flush();
        bw.close();
        br.close();
    }
}
