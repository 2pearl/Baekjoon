import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n/2; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static void DFS(int n, int j) {

		if(j==N) {
			if(isPrime(n))
				System.out.println(n);
			return;
		}
		for(int i=1;i<10;i+=2) {
			if(isPrime(n*10+i))
				DFS(n*10+i,j+1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(r.readLine());

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);

		//w.flush();
		//w.close();
	}
}