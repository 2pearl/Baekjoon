import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static ArrayList<Integer> res;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		res = new ArrayList<>();
		int[] cnt = new int[N + 1];// 진입차수 관리
		
		
		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);// 단방향 그래프
			
			cnt[e]++;
		}
		Queue<Integer>queue=new ArrayDeque<>();
		
		// 위상정렬
		
		for (int i = 1; i < N + 1; i++) {
			if(cnt[i]==0)//진입차수0인거 큐에 넣기
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int v=queue.poll();
			res.add(v);
			
			for(int i:list[v]) {
				cnt[i]--;
				if(cnt[i]==0)
					queue.offer(i);
			}
		}
		
		//res.size가 n이 아니면 위상정렬 실패

		// 결과 출력
		for (int i = 0; i < res.size(); i++)
			sb.append(res.get(i)).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
