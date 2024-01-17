import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	

	public static void main(String[] args) throws IOException {

		Stack<Character> stack=new Stack<>();
		//Queue<Integer> queue=new LinkedList<>();
		
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T=Integer.parseInt(r.readLine());
		
		for(int i=0;i<T;i++) {
			String str=r.readLine();
			int flag=1;
			stack.clear();
			for(int j=0;j<str.length();j++) {
				char c=str.charAt(j);
				if(c=='(') {
					stack.push(c);
				}
				else {
					if(stack.isEmpty()) {
						w.write("NO"+"\n");
						flag=0;
						break;
					}
						
					else {
						stack.pop();
					}
				}
				
			}
			if(flag==0)
				continue;
			else {
				if(stack.isEmpty())
					w.write("YES"+"\n");
				else
					w.write("NO"+"\n");
			}
			}
		w.flush();
		w.close();
	}
}