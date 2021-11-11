package week11;

import java.util.Arrays;
import java.util.Scanner;

public class Main_boj_5052_전화번호목록_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; test_case++) {
			int N = sc.nextInt();	//전화번호 수
			String[] telList = new String[N];
			for(int i=0; i<N; i++) {
				telList[i] = sc.next();
			}
			Arrays.sort(telList);
			boolean flag =false;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N-1; i++) {
				if(telList[i+1].startsWith(telList[i])) {
					flag = true;
				}
			}
			if(flag)System.out.println("NO");
			else System.out.println("YES");
		}
	}

}
