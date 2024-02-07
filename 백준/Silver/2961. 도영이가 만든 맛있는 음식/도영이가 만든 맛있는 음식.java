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
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		List<Taste> list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int shin=Integer.parseInt(st.nextToken());
			int sseun=Integer.parseInt(st.nextToken());
			
			list.add(new Taste(shin,sseun));
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=1;i<(1<<N);i++) {//1~15
			
			int sSum=1;
			int ssSum=0;
			for(int j=0;j<N;j++) {
				
				if(((i&(1<<j))!=0)) {
					
					sSum*=list.get(j).shin;
					ssSum+=list.get(j).sseun;
				}
					
			}
			min=Math.min(min, Math.abs(sSum-ssSum));
			
		}
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
class Taste{
	int shin;
	int sseun;
	Taste(int shin,int sseun){
		this.shin=shin;
		this.sseun=sseun;
	}
}
