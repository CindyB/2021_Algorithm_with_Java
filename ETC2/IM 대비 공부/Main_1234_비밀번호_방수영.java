package forIM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1234_비밀번호_방수영 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = 10;
		for(int test_case = 1; test_case<=T; test_case++) {
			sb = new StringBuilder();
			st = new StringTokenizer(in.readLine());
			Deque<Character>deque = new LinkedList<Character>();
			
			int N = Integer.parseInt(st.nextToken());
			String pwd = st.nextToken();
			
			
			for(int i=0; i<N; i++) {
				char tmp = pwd.charAt(i);
				if(deque.isEmpty()) {
					deque.add(tmp);
				}else {
					if(tmp==deque.getLast()) {
						deque.pollLast();
					}else {
						deque.add(tmp);
					}
				}				
			}
			while(!deque.isEmpty()) {
				sb.append(deque.poll());
			}
			System.out.println("#"+test_case+" "+sb.toString());
		}
	}
}
