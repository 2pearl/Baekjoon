//백준
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

		int N=Integer.parseInt(r.readLine());
		int[][]a=new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(r.readLine());
			a[i][0]=Integer.parseInt(st.nextToken());
			a[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]>o2[1])
					return 1;
				else if(o1[1]<o2[1])
					return -1;
				else {
					if(o1[0]>o2[0])
						return 1;
					else if(o1[0]<o2[0])
						return -1;
					else return 0;
				}
			}
		});
		int count=0;
		int prev=0;
		
		for(int i=0;i<N;i++) {
			
			if(prev<=a[i][0]) {
				prev=a[i][1];
				count++;
			}
		}
		
		w.write(String.valueOf(count));
		w.flush();
		w.close();
	}
}