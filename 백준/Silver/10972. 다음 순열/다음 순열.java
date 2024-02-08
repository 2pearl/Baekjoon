import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[]input;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		//M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		input=new int[N];
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		//Arrays.sort(input);
		
		if(next_permutation(input)) {
			
			for(int i=0;i<input.length;i++)
				sb.append(input[i]).append(" ");
		}
		else sb.append(-1);
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
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
