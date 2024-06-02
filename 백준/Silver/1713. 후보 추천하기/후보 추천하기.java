import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Student> list;
	static ArrayList<Integer> ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		list = new ArrayList<>();
		ans = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			Collections.sort(list);
			int stud = Integer.parseInt(st.nextToken());

			int check = isRecommended(stud);
			if (check > -1) {
				list.get(check).cnt++;
				continue;
			}

			if (list.size() == N) {
				list.remove(0);
			}
			list.add(new Student(stud, 0, i));
			
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			ans.add(list.get(i).idx);
		}

		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i) + " ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int isRecommended(int n) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).idx == n) {
				return i;
			}
		}
		return -1;
	}

	static class Student implements Comparable<Student> {
		int idx;// 학생idx
		int cnt;// 추천받은 횟수
		int time;// 추천시간

		public Student(int idx, int cnt, int time) {
			super();
			this.idx = idx;
			this.cnt = cnt;
			this.time = time;
		}

		
		@Override
		public String toString() {
			return "Student [idx=" + idx + ", cnt=" + cnt + ", time=" + time + "]";
		}


		@Override
		public int compareTo(Student o) {
			// cnt오름차, 동일시 time오름차순
			return this.cnt == o.cnt ? this.time - o.time : this.cnt - o.cnt;
		}
	}
}
