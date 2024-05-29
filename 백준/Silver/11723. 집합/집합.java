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

		int M = Integer.parseInt(br.readLine());
		int ans = 0;

		StringTokenizer st;
		
		for (int m = 0; m < M; m++) {

			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int n=0;
			if(op.equals("add")||op.equals("remove")||op.equals("check")||op.equals("toggle"))
				n = Integer.parseInt(st.nextToken());
			
			switch (op) {
			case "add":
				ans |= (1 << n);
				break;
			case "remove":
				ans &= (~(1 << n));
				break;
			case "check":
				if (((1 << n) & ans) > 0)
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
				break;
			case "toggle":
				if(0<((1 << n) & ans))
					ans &= (~(1 << n));
				else
					ans |= (1 << n);
				break;
			case "all":
				ans |= ((1 << 21) - 1);
				break;
			case "empty":
				ans = 0;
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}