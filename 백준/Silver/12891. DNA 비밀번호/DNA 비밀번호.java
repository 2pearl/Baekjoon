import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	// required는 규칙저장한 배열
	// count는 현재 윈도우에서 문자가 몇개인지 세는 배열

	// c는 지금 규칙만족한 문자가 몇개인지 저장하는 변수
	// ans는 결과값 저장하는 변수
	static int[] required, count;
	static int c, ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		char[] str = (br.readLine()).toCharArray();
		st = new StringTokenizer(br.readLine());

		required = new int[4];
		count = new int[4];
		for (int i = 0; i < 4; i++) {
			required[i] = Integer.parseInt(st.nextToken());
			if(required[i]==0)
				c++;
		}

		// 초기화
		for (int i = 0; i < P; i++) {
			add(str[i]);
		}

		if (c == 4)
			ans++;

		// 윈도우 이동하면서 확인하기
		for (int i = P; i < S; i++) {

			add(str[i]);
			remove(str[i-P]);
			if (c == 4)
				ans++;
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void add(char ch) {
		switch (ch) {
		case 'A':
			count[0]++;
			if (count[0] == required[0])
				c++;
			break;
		case 'C':
			count[1]++;
			if (count[1] == required[1])
				c++;
			break;
		case 'G':
			count[2]++;
			if (count[2] == required[2])
				c++;
			break;
		case 'T':
			count[3]++;
			if (count[3] == required[3])
				c++;
			break;
		}
	}

	public static void remove(char ch) {

		switch (ch) {
		case 'A':
			if (count[0] == required[0])
				c--;
			count[0]--;
			break;
		case 'C':
			if (count[1] == required[1])
				c--;
			count[1]--;
			break;
		case 'G':
			if (count[2] == required[2])
				c--;
			count[2]--;
			break;
		case 'T':
			if (count[3] == required[3])
				c--;
			count[3]--;
			break;
		}
	}
}
