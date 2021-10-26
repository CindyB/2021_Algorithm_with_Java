package week12;

import java.util.Scanner;

public class Main_boj_1107_리모컨_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] arr = new boolean[10]; //0~9
		
		for(int i=0; i<M; i++) {
			int tmp = sc.nextInt();
			arr[tmp] = true;
		}
		int result = Math.abs(N-100);	//처음(100)부터 +/-를 이용해서 움직이는 경우로 초기화
		
		for(int i=0; i<=999999; i++) {
			String tmp = String.valueOf(i);
			int len = tmp.length();
			
			boolean flag = false;
			for(int j=0; j<len; j++) {
				if(arr[tmp.charAt(j)-'0']) {	//고장난 버튼이라면
					flag = true;
					break;
				}
			}
			if(!flag) {		//현재 숫자(tmp)를 누를 수 있다면 => 고장난 키가 없다면
				int min = Math.abs(N-i)+len;
				result = Math.min(result, min);
			}
		}
		System.out.println(result);
		
	}
}

