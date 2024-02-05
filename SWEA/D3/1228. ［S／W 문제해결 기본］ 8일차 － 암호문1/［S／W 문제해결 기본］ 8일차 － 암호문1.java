import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
	int data;
	Node link;

	Node(int data) {
		this.data = data;
		this.link = null;
	}
}

class LinkedList {

	Node Head = null;
	Node Tail = null;

	Node getNew(int data) {
		return new Node(data);
	}

	void insert(int data) {

		Node node = getNew(data);

		if (Head == null) {
			Head = node;
			Tail = node;
		} else {
			Tail.link = node;
			Tail = node;
		}

	}

	void insert(int idx, LinkedList list) {

		
			if (idx == 0) {
				list.Tail.link = Head;
				Head = list.Head;
				return;
			}
			else {
				
				Node tmp = Head;
				
				for (int i = 0; i < idx - 1; i++)
					tmp = tmp.link;
				
				list.Tail.link = tmp.link;
				tmp.link = list.Head;
			}

		
	}
}

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {

			LinkedList list = new LinkedList();
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				list.insert(Integer.parseInt(st.nextToken()));

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {

				char inst = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				LinkedList l = new LinkedList();
				for (int k = 0; k < y; k++)
					l.insert(Integer.parseInt(st.nextToken()));

				list.insert(x, l);
				
				
			}
			Node tmp = list.Head;

			for (int i = 0; i < 10; i++) {
				sb.append(tmp.data).append(" ");
				tmp = tmp.link;
			}
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
