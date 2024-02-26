import java.io.*;
import java.util.*;

public class Main {

	static class Point{
		int r, c, time;
		Point(int r, int c, int time){
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static int R, C, startR, startC, endR, endC;
	static int[][] village;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException{
		inputData();
		meltIce();
		System.out.print(meet());
	}
	
	public static void inputData() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		village = new int[R][C];
		
		boolean first = true;
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				char ch = input.charAt(c);
				if(ch == 'L') {
					if(first) {
						startR = r;
						startC = c;
						first = false;
					}else {
						endR = r;
						endC = c;
					}
					village[r][c] = 0;
				}else if(ch == '.')
					village[r][c] = 0;
				else if(ch == 'X')
					village[r][c] = -1;
			}
		}
		
		br.close();
	}
	
	public static boolean inRange(int r, int c) {
		if(r>=0 && c>=0 && r<R && c<C)
			return true;
		return false;
	}
	
	public static void meltIce() {
		Queue<Point> q = new LinkedList<>();
		
		// 가장 먼저 녹는 빙하들 큐에 추가
		for(int r=0; r<R; r++)
			for(int c=0; c<C; c++)
				if(village[r][c] == -1)
					for(int d=0; d<4; d++) {
						int dR = r + delta[d][0];
						int dC = c + delta[d][1];
						if(inRange(dR, dC))
							if(village[dR][dC] == 0) {
								q.add(new Point(r, c, 1));
								village[r][c] = 1;
								break;
							}
					}
		
		// 빙하가 녹는 시간 village에 새롭게 할당
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int dR = p.r + delta[d][0];
				int dC = p.c + delta[d][1];
				if(inRange(dR, dC))
					if(village[dR][dC] == -1) {
						village[dR][dC] = p.time+1;
						q.add(new Point(dR, dC, p.time+1));
					}
			}
		}
	}
	
	public static int meet() {
		// 사람 한 명을 출발시켜 다른 사람을 만나기까지 시간 구함
			Queue<Point> q = new LinkedList<>();
			Queue<Point> nextQ = new LinkedList<>();
			q.add(new Point(startR, startC, 0));
			village[startR][startC] = -1;
			
			while(!q.isEmpty()) {
				while(!q.isEmpty()) {
					Point p = q.poll();
					for(int d=0; d<4; d++) {
						int dR = p.r + delta[d][0];
						int dC = p.c + delta[d][1];
						if(inRange(dR, dC)) {
							if(dR == endR && dC == endC) {
								return p.time;
							}
							if(village[dR][dC] == -1) continue;
							if(village[dR][dC] <= p.time) {
								village[dR][dC] = -1;
								q.add(new Point(dR, dC, p.time));
							}else {
								village[dR][dC] = -1;
								nextQ.add(new Point(dR, dC, p.time+1));
							}
						}
					}
				}
				while(!nextQ.isEmpty())
					q.add(nextQ.poll());
			}
			
			return 0;
	}
	
}
