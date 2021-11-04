package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_boj_5430_AC_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 0; test_case<T; test_case++) {
			sb = new StringBuilder();
			
			//함수 입력 받기
			String p = in.readLine();
			boolean isReverse = false;	//fasle = 왼쪽이 앞, true = 오른쪽이 앞
			
			//배열 만들기
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			Deque<Integer> deque = new LinkedList<Integer>();
			
			String tmp = in.readLine();
			st = new StringTokenizer(tmp.substring(1, tmp.length()-1),",");
			for(int i=0; i<n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			//함수 분리
			for(int i=0; i<p.length(); i++) {
				char ch = p.charAt(i);
				
				if(ch == 'D') {
					if(deque.isEmpty()) {	//배열이 비어있는 상태
						sb.append("error");
						break;
					}else {
						if(!isReverse) {
							deque.pollFirst();							
						}else {
							
							deque.pollLast();							
						}
					}
					
				}else if(ch == 'R') {
					if(!isReverse) {
						isReverse = true;
					}else {
						isReverse = false;
					}
				}
			}
			//error가 안났다면
			if(sb.length()==0) {				
				sb.append("[");
				int size = deque.size();
				for(int i=0; i<size; i++) {
					if(!isReverse) {
						sb.append(deque.pollFirst());
					}else {
						sb.append(deque.pollLast());
					}
					if(i<size-1) sb.append(",");
				}
				sb.append("]");
			}			
			System.out.println(sb.toString());
		}
	}

}
