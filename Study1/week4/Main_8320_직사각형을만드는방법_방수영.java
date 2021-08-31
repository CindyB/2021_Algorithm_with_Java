package week4;

import java.util.Scanner;

public class Main_8320_직사각형을만드는방법_방수영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt=0;
		for(int i=1; i<=Math.sqrt(N); i++) {
			for(int j=i; j<=N; j++) {
				if(i*j<=N)cnt++;
			}
		}
		System.out.println(cnt);
	}
}
/*
 * ex) N = 6
 * 1x1,1x2,1x3,...1x6
 * 2x2,2x3  <=N
 * => N ==직사각형 최대 넓이 
 * - 정사각형도 직사각형
 */
