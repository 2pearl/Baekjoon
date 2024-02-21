import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] alpha, res;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpha = new char[C];
		res = new char[L];

		// 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);//알파벳 오름차순 정렬
		

		dfs(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int idx, int depth) {

		if (depth == L) {
			if(check()) {
				for(int i=0;i<L;i++)
					sb.append(res[i]);
				sb.append("\n");
			}
				
			return;
		}

		for (int i = idx; i < C; i++) {
			res[depth] = alpha[i];

			dfs(i + 1, depth + 1);

		}
	}

	public static boolean check() {

		int mo = 0;
		int za = 0;

		for (int i = 0; i < L; i++) {
			if (res[i] == 'a' || res[i] == 'e' || res[i] == 'i' || res[i] == 'o' || res[i] == 'u')
				mo++;
			else
				za++;
		}

		if (mo >= 1 && za >= 2)
			return true;
		else
			return false;
	}
}
