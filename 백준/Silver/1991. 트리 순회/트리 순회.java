import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		char data;
		Node left;
		Node right;

		Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class Tree {
		static Node root;

		Tree() {
			root = new Node('A');
		}

		static void insert(char data, char left, char right) {

			Node node = new Node(data);
			if (left != '.')
				node.left = new Node(left);
			if (right != '.')
				node.right = new Node(right);

			if (root == null) {
				root = node;
			} else {
				Node tmp = root;
				insertTo(tmp, node);
			}
		}

		static void insertTo(Node nowNode, Node newNode) {
			if (nowNode == null)
				return;

			if (nowNode.data == newNode.data) {
				nowNode.left = newNode.left;
				nowNode.right = newNode.right;
				return;
			} else {
				insertTo(nowNode.left, newNode);
				insertTo(nowNode.right, newNode);
			}
		}

		static void pre(Node now) {

			sb.append(now.data);
			if (now.left != null)
				pre(now.left);
			if (now.right != null)
				pre(now.right);
		}

		static void in(Node now) {

			if (now.left != null)
				in(now.left);
			sb.append(now.data);
			if (now.right != null)
				in(now.right);
		}

		static void post(Node now) {

			if (now.left != null)
				post(now.left);
			if (now.right != null)
				post(now.right);
			sb.append(now.data);
		}
	}

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			Tree.insert(data, left, right);
		}

		// 전위
		Tree.pre(Tree.root);
		sb.append("\n");
		// 중위
		Tree.in(Tree.root);
		sb.append("\n");
		// 후위
		Tree.post(Tree.root);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}