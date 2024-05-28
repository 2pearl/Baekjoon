import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] input, gugan;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		gugan = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		gugan[0] = 0;
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (i > 1)
				gugan[i] = gugan[i - 1] + input[i];
			else
				gugan[i] = input[i];
		}

		for (int k = 0; k < M; k++) {

			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			bw.write(gugan[j]-gugan[i-1]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
