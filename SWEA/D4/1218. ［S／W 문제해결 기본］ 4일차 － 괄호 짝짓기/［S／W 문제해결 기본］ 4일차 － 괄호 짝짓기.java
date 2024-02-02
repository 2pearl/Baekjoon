import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> stack;

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {

			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			String str = br.readLine();

			int check = 1;
			for (int s = 0; s < str.length(); s++) {

				char c = str.charAt(s);

				switch (c) {
				case '{':
				case '[':
				case '(':
				case '<':
					stack.push(c);
					break;
				case '}':
				case ']':
				case ')':
				case '>':
					if (stack.size() == 0) {
						check = 0;
						break;
					}
					char out = stack.pop();
					// 짝이 맞는지 확인해야함
					if (c == '}' && out != '{') {
						check=0;
						break;
					}
					else if (c == ']' && out != '[') {
						check=0;
						break;
					}
					else if (c == ')' && out != '(') {
						check=0;
						break;
					}
					else if (c == '>' && out != '<') {
						check=0;
						break;
					}
						
				}
			}
			if (stack.size() != 0)
				check = 0;
			sb.append(check).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
