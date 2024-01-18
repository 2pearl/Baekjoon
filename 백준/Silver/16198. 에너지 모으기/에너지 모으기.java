import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(r.readLine());

		StringTokenizer st = new StringTokenizer(r.readLine());
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < N; i++)
			array.add(Integer.parseInt(st.nextToken()));

		search(array, 0);
		w.write(String.valueOf(max));
		w.flush();
		w.close();
	}

	static void search(ArrayList<Integer> array, int sum) {

		if (array.size() == 2) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 1; i < array.size() - 1; i++) {

			int n = array.get(i);
			int mul = array.get(i - 1) * array.get(i + 1);
			array.remove(i);
			search(array, sum + mul);
			array.add(i, n);
		}

	}
}
