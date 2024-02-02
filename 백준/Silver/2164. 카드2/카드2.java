import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		Queue<Integer> queue=new ArrayDeque<>();
		
		for(int i=1;i<=N;i++)
			queue.offer(i);
		
		while(queue.size()>1) {
			
			queue.poll();
			queue.offer(queue.poll());
		}
		
		bw.write(String.valueOf(queue.poll()));
		bw.flush();
		bw.close();
		br.close();
	}

}
