package week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_숫자문자열과영단어_방수영 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		String[] number = {"zero","one", "two","three","four","five","six","seven","eight","nine"};
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0; i<10; i++) {
			map.put(number[i], String.valueOf(i));
		}
		for(int i=0; i<10; i++) {
			if(s.contains(number[i])) {
				s =s.replaceAll(number[i],map.get(number[i]));
			}			
		}
		return Integer.parseInt(s);
	}

}
