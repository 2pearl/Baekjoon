import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] list;
    static int max;
    static int[]slide;
    static int[]visited;
    

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    list=new int[N];
    visited=new int[3_000_000];
    for (int i = 0; i < N; i++) {
        list[i]=Integer.parseInt(br.readLine());
    }
    
    //초기 설정
    max=1;//쿠폰 일단 추가해놓고 나중에 쿠폰 수 뽑은 경우에 빼자
    visited[c]=1;
    for(int i=0;i<k;i++) {
        
    	if(visited[list[i]]==0)
    		max++;

    	visited[list[i]]++;
    }
    
    check();

    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
}

public static void check() {
    
    int end=k-1;
    int cnt=max;
    for(int i=1;i<N;i++) {
        
        //이전꺼 빼고
        visited[list[i-1]]--;
        if(visited[list[i-1]]==0)
            cnt--;
        
        //다음꺼 넣고
        end=(end+1)%(N);
        if(visited[list[end]]==0)
            cnt++;

        visited[list[end]]++;
        
        max=Math.max(max, cnt);
    }
}
}