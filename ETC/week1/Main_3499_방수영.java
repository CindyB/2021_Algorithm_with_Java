package com.ssafy.algo05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3499_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			
			//카드 입력 받기
			int midIndex = (N%2==0) ? N/2-1 : N/2;	//범위 포함
			Deque<String> deck1 = new LinkedList<String>();	//앞부분
			Deque<String> deck2 = new LinkedList<String>();	//뒷부분
			Deque<String> result = new LinkedList<String>();	//결과
			st = new StringTokenizer(in.readLine());
			
			for(int i=0; i<=midIndex; i++) {
				deck1.offer(st.nextToken());
			}
			for(int i=midIndex+1; i<N; i++) {
				deck2.offer(st.nextToken());
			}
			for(int i=0; i<N/2; i++) {
				result.offer(deck1.poll());
				result.offer(deck2.poll());
			}
			if(N%2!=0)result.offer(deck1.poll());
			System.out.print("#"+test_case+" ");
			while(!result.isEmpty()) {
				System.out.print(result.poll()+" ");
			}
			System.out.println();
		}
	}

}
