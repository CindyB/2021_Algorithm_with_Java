package com.ssafy.algo.hw04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_boj_2493_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();

		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++ ) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()){
				//신호 받은 수 없음 => pop
				if(stack.peek() < now) {
					stack.pop();
					result.pop();
				}else {
					System.out.print(result.peek()+" ");
					break;
				}
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(now);
			result.push(i+1);
		}
	}

}

//public class Main_2493_방수영 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//
//		int N = Integer.parseInt(in.readLine());
//		st = new StringTokenizer(in.readLine());
//
//		int[] arr = new int[N + 1];
//		int[] result = new int[N + 1];
//		
//		for (int i = 1; i <= N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		for (int i = N; i > 0; i--) {
//			for (int j = i-1 ; j > 0; j--) {
//				if (arr[i] < arr[j]) {
//					result[i] = j;
//					break;
//				}
//			}
//		}
//		for(int i=1; i<=N; i++) {
//			System.out.print(result[i]+" ");
//		}
//	}
//
//}
