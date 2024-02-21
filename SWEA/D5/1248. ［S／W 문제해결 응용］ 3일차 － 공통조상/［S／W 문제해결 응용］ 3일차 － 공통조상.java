import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static ArrayList<Integer>[] child;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int Tc = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= Tc; tc++) {

			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			child = new ArrayList[V + 1];// 정점의 자식들이 누가 있는지 관리
			parent = new int[V + 1];// 정점의 부모가 누구인지 관리

			for (int i = 1; i <= V; i++)
				child[i] = new ArrayList<>();

			// 공통조상 찾아야 하는 두 정점
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 간선 입력
			st = new StringTokenizer(br.readLine());
			for (int e = 0; e < E; e++) {

				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				parent[c] = p;
				child[p].add(c);
			}

			int lca = find(x, y);//공통조상
			sb.append(lca+" "+getSub(lca) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x, int y) {

		// 조상 저장
		ArrayList<Integer> xP = new ArrayList<>();
		ArrayList<Integer> yP = new ArrayList<>();

		getP(x, xP);
		getP(y, yP);

		// 조상 거슬러 올라가기. 달라지면 공통 부모 + 다른 조건 필요함
		int xidx = xP.size() - 1;
		int yidx = yP.size() - 1;
		
		while (true) {

			if (xP.get(xidx).equals((yP.get(yidx)))) {
				xidx--;
				yidx--;

				
				if (xidx < 0 || yidx < 0) {
					return xP.get(0);
				}
			}
			else {
				return xP.get(xidx+1);
			}
		}

	}

	public static void getP(int x, ArrayList<Integer> list) {

		// x의 조상 저장
		while (true) {

			list.add(parent[x]);
			x = parent[x];

			if (x == 1)
				break;
		}
		
	}
	
	public static int getSub(int idx) {
	
		//왼쪽자식+오른쪽자식+1
		int sum=1;
		for(int i=0;i<child[idx].size();i++) {
			sum+=getSub(child[idx].get(i));
		}
		return sum;
	}
}
