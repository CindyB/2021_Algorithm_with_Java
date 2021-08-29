package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17413_단어뒤집기2_방수영 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character>stack = new Stack<>();
		
		boolean flag = true;
		String str = in.readLine();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch=='<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				flag=false;
			}
			else if(ch == '>') {
				flag = true;
				sb.append(ch);
				continue;
			}
			if(flag) {
				if(ch==' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				}else {
					stack.push(ch);
				}
			}else {
				sb.append(ch);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

}
