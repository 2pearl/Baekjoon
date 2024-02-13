import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int[]fruits=new int[N];
		for(int i=0;i<N;i++)
			fruits[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(fruits);
		for(int i=0;i<N;i++) {
			
			if(L>=fruits[i])
				L++;
		}
		bw.write(String.valueOf(L));
		bw.flush();
		bw.close();
		br.close();
	}
}
