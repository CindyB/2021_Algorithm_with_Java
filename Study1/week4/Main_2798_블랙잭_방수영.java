package week4;

import java.util.Scanner;

public class Main_2798_블랙잭_방수영 {

	static int N,M;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		combi(0,0,0);
		System.out.println(max);
	}
	private static void combi(int cnt, int start, int sum) {
		if(cnt == 3) {
			if(sum<=M) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		for(int i = start; i<N; i++) {
			combi(cnt+1,i+1,sum+arr[i]);
		}
	}
}
