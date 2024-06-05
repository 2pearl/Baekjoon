import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    static class Node {
        char data;
        Node lchild;
        Node rchild;

        Node(char data) {
            this.data = data;
            lchild = null;
            rchild = null;
        }
    }

    static class Tree {

        Node root;

        void insert(char data, char lchild, char rchild) {
            Node newNode = new Node(data);
            if (lchild != '.') {
                newNode.lchild = new Node(lchild);
            }
            if (rchild != '.') {
                newNode.rchild = new Node(rchild);
            }

            if (root == null) {
                root = newNode;
            } else {
                Node tmp = root;
                find(tmp, newNode);
            }

        }

        void find(Node now, Node find) {
            if (now == null)
                return;
            if (now.data == find.data) {

                now.lchild = find.lchild;
                now.rchild = find.rchild;
                return;
            } else {
                find(now.lchild, find);
                find(now.rchild, find);
            }
        }

        void preOrder(Node now) {
            sb.append(now.data);
            if (now.lchild != null) {
                preOrder(now.lchild);
            }
            if (now.rchild != null) {
                preOrder(now.rchild);
            }
        }

        void inOrder(Node now) {
            if (now.lchild != null) {
                inOrder(now.lchild);
            }
            sb.append(now.data);
            if (now.rchild != null) {
                inOrder(now.rchild);
            }
        }

        void postOrder(Node now) {
            if (now.lchild != null) {
                postOrder(now.lchild);
            }
            if (now.rchild != null) {
                postOrder(now.rchild);
            }
            sb.append(now.data);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        sb = new StringBuilder();

        Tree tree = new Tree();

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());

            char data = st.nextToken().charAt(0);
            char lchild = st.nextToken().charAt(0);
            char rchild = st.nextToken().charAt(0);
            tree.insert(data, lchild, rchild);
        }

        tree.preOrder(tree.root);
        sb.append("\n");
        tree.inOrder(tree.root);
        sb.append("\n");
        tree.postOrder(tree.root);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
