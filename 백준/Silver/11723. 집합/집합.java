import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer>list=new ArrayList<>();
		
		int M=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int m=0;m<M;m++) {
			
			st=new StringTokenizer(br.readLine());
			String inst=st.nextToken();
			int n;
			switch(inst) {
			case "add":
				n=Integer.parseInt(st.nextToken());
				if(!list.contains(n))
					list.add(n);
				break;
			case "remove":
				n=Integer.parseInt(st.nextToken());
				for(int i=list.size()-1;i>=0;i--) {
					if(list.get(i)==n)
						list.remove(i);
				}
				break;
			case "check":
				n=Integer.parseInt(st.nextToken());
				if(list.contains(n))
					sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				n=Integer.parseInt(st.nextToken());
				if(list.contains(n)) {
					for(int i=list.size()-1;i>=0;i--) {
						if(list.get(i)==n)
							list.remove(i);
					}					
				}
				else {
					list.add(n);
				}
				break;
			case "all":
				list.clear();
				for(int i=1;i<=20;i++)
					list.add(i);
				break;
			case "empty":
				list.clear();
				break;
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
