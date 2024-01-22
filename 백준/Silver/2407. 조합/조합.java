import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		w.write(String.valueOf(fact(n).divide(fact(m)).divide(fact(n - m))));
		w.flush();
		w.close();
	}

	public static BigInteger fact(int n) {

		if (n == 1)
			return new BigInteger("1");

		return new BigInteger(String.valueOf(n)).multiply(fact(n - 1));
	}
}
