import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] res;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();
		//int N = Integer.parseInt(br.readLine());

		arr = new int[9];
		res=new int[7];
		for (int i = 0; i < 9; i++)
			arr[i]=Integer.parseInt(br.readLine());
		
		recur(0,0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void recur(int idx, int now) {

		if (idx == 7) {
			int sum = 0;
			for (int n : res) {
				sum += n;
			}
			if (sum == 100) {
				for (int n : res) {
					sb.append(n).append("\n");
				}
			}
			
			return;
		}

		for (int i = now; i < 9; i++) {

			res[idx] = arr[i];
			recur(idx + 1, i + 1);
		}
	}
}
