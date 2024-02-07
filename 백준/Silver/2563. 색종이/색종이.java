import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] data = new int[100][100];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int k = 0; k < 10; k++) {
				for (int m = 0; m < 10; m++) {

					data[x + k][y + m] = 1;
				}
			}
		}
		
		int sum=0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				if(data[i][j]==1)
					sum+=1;
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}