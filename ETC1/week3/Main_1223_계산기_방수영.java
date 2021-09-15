package com.ssafy.algo.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1223_계산기_방수영 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int test_case =1; test_case<=T; test_case++) {
			
			int sum=0;
			
			Stack<Character> stack = new Stack<Character>();
			
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(in.readLine());
			String tmp = in.readLine();
			for(int i =0; i<tmp.length(); i++) {
				char ch = tmp.charAt(i);
				
				if(ch>='0'&&ch<='9') {
					sb.append(ch);
				}else {
					if(ch=='+') {
						if(stack.isEmpty()){
							stack.push(ch);
						}else {
							while(!stack.isEmpty()) {
								sb.append(stack.pop());
							}
							stack.push(ch);
						}
					}else if(ch=='*')
						stack.push(ch);
				}
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
//			System.out.println(sb.toString());
			Stack<Integer> stack2 = new Stack<Integer>();
			String result = sb.toString();
			
			for(int i=0; i<result.length(); i++) {
				char ch = result.charAt(i);
				if(ch>='0'&&ch<='9') {
					stack2.push(ch-'0');
				}else if(ch=='+') {
					int num1 = stack2.pop();
					int num2 = stack2.pop();
					stack2.push(num1+num2);
					
				}else if(ch=='*') {
					int num1 = stack2.pop();
					int num2 = stack2.pop();
					stack2.push(num1*num2);
					
				}
			}
			System.out.println("#"+test_case+" "+stack2.pop());
		}
	}

}
