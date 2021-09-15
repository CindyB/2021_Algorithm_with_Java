//Last in first out
package com.ssafy.algo04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1218_방수영 {
	public static void main(String[] args) throws Exception, IOException {
		System.setIn(new FileInputStream("1218.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		for(int test_case = 1; test_case<=T; test_case++) {
			int result=1;
			int n = Integer.parseInt(in.readLine());
			Stack<Character> stack = new Stack<Character>();
			
			String str = in.readLine();
			for(int i=0; i<str.length(); i++) {
				//열린 괄호일 경우 stack에 넣기
				if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='<') {
					stack.push(str.charAt(i));					
				}
				//닫힌 괄호를 만났을 경우 직전의 괄호와 검사
				else {
					char ch = stack.pop();
					switch(str.charAt(i)) {
					case ')':
						if(ch!='(')	result=0;
						break;
					case '}':
						if(ch!='{')	result=0;
						break;
					case ']':
						if(ch!='[')	result=0;
						break;
					case '>':
						if(ch!='<')	result=0;
						break;
					}
					if(result==0) break;
				}
			}
			//탐색이 끝났을 경우에 stack에 남아있다면 유효 x
			if(!stack.isEmpty()) result=0;
			System.out.println("#"+test_case+" "+result);
		}
		
	}
	
}
