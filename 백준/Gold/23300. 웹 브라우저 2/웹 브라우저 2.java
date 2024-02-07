import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());
		Deque<Integer> back=new ArrayDeque<>();//<-
		Deque<Integer> front=new ArrayDeque<>();//->
		
		int now=-1;
		for(int q=0;q<Q;q++) {
			
			st=new StringTokenizer(br.readLine());
			char inst=st.nextToken().charAt(0);
			switch(inst) {
			case 'B':
				if(!back.isEmpty()) {
					
					front.offer(now);
					now=back.pollLast();
				}
				break;
			case 'F':
				if(!front.isEmpty()) {
					
					back.offer(now);
					now=front.pollLast();
				}
				break;
			case 'A':
				int i=Integer.parseInt(st.nextToken());
				front.clear();
				
				if(now!=-1)
					back.offer(now);
				
				now=i;
				
				break;
			case 'C':
				int c=back.size();
				for(int b=0;b<c;b++) {
					
					if(b!=0) {
						int web=back.pollFirst();
						if(back.peekLast()==web) {
							back.pollLast();
						}
						back.offer(web);
					}
					else back.offer(back.pollFirst());	
				}
				break;
			}
		}
		
		sb.append(now).append("\n");
		
		if(back.size()==0)
			sb.append(-1);
		while(!back.isEmpty()) {
			sb.append(back.pollLast()).append(" ");
		}
		sb.append("\n");
		
		if(front.size()==0)
			sb.append(-1);
		while(!front.isEmpty()) {
			sb.append(front.pollLast()).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
