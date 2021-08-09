package week1;

import java.util.Scanner;

public class Main_1157_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[26]; //26개의 알파벳 
		String str = sc.next().toUpperCase(); //다 대문자로
		int max = Integer.MIN_VALUE;
		char result = '?';
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'A']++;
			if(max <arr[str.charAt(i)-'A']) {
				max =arr[str.charAt(i)-'A'];
				result = str.charAt(i);
			}else if(max == arr[str.charAt(i)-'A']) {
				result='?';
			}
		}
		
		System.out.println(result);
	}

}
