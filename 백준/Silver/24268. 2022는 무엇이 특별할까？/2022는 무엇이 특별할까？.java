import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] array;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st;
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		array = new int[d];
		for (int i = 0; i < d; i++)
			array[i] = i;

		int result = 0;
		boolean find=false;
		while (next_permutation(array)) {

			if (array[0] == 0)
				continue;
			result = 0;

			for (int i = 0; i < array.length; i++) {

				result += (array[array.length - i - 1] * Math.pow(d, i));
			}
			if (result > N) {
				find=true;
				break;
			}
		}

		if(find)
			w.write(String.valueOf(result));
		else
			w.write("-1");

		w.flush();
		w.close();
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	static boolean next_permutation(int[] numbers) {

		int n = numbers.length;
		int i = n - 1;

		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;

		if (i == 0)
			return false;

		int j = n - 1;

		while (numbers[i - 1] >= numbers[j])
			j--;

		swap(numbers, i - 1, j);

		int k = n - 1;

		while (i < k)
			swap(numbers, i++, k--);

		return true;
	}
}