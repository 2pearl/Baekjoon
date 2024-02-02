import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer>queue=new ArrayDeque<>();
		
		for(int i=1;i<=N;i++)
			queue.offer(i);
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		while(queue.size()>1) {
			
			for(int i=0;i<K-1;i++)
				queue.offer(queue.poll());
			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append(">");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}