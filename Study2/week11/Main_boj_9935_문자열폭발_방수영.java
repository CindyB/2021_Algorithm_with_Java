package week11;

import java.util.Scanner;
import java.util.Stack;

public class Main_boj_9935_문자열폭발_방수영 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String bomb = sc.next();
		
		Stack<Character> strS = new Stack<>();
		Stack<Character> tmp = new Stack<>();
		Stack<Character> bombS = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			strS.add(str.charAt(i));
		}
		for(int i=0; i<bomb.length(); i++) {
			bombS.add(bomb.charAt(i));
		}
		while(!strS.isEmpty()) {
			char chS = strS.pop();
			char chB = bombS.peek();
			
			if(chS != chB) {
				tmp.add(chS);
			}else {
				
			}
		}
	}

}
